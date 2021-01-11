import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.TextAlign
import kotlinx.css.VerticalAlign
import kotlinx.css.marginTop
import kotlinx.css.pct
import kotlinx.css.px
import kotlinx.css.textAlign
import kotlinx.css.verticalAlign
import kotlinx.css.width
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.tbody
import react.dom.thead
import react.dom.tr
import react.setState
import styled.css
import styled.styledTable
import styled.styledTd
import styled.styledTh

suspend fun fetchVideo(id: Int) =
  window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
    .await()
    .json()
    .await()
    .unsafeCast<Video>()

suspend fun fetchVideos() =
  coroutineScope {
    (1..3).map { id ->
      async {
        fetchVideo(id)
      }
    }.awaitAll()
  }

external interface AppState : RState {
  var currentVideo: Video?
  var unwatchedVideos: List<Video>
  var watchedVideos: List<Video>
}

class App : RComponent<RProps, AppState>() {

  override fun AppState.init() {
    unwatchedVideos = listOf()
    watchedVideos = listOf()
    val mainScope = MainScope()
    mainScope.launch {
      val videos = fetchVideos()
      setState {
        unwatchedVideos = videos
      }
    }
  }

  override fun RBuilder.render() {

    h1 { +"Kotlin React Bootstrap Example" }

    state.currentVideo?.let { currentVideo ->
      videoPlayer {
        video = currentVideo
        unwatchedVideo = currentVideo in state.unwatchedVideos
        onWatchedButtonPressed = {
          if (video in state.unwatchedVideos) {
            setState {
              unwatchedVideos -= video
              watchedVideos += video
            }
          } else {
            setState {
              watchedVideos -= video
              unwatchedVideos += video
            }
          }
        }
      }
    }

    styledTable {
      css {
        marginTop = 25.px
        width = 100.pct
        //border = "1px solid black"
      }

      thead {
        tr {
          styledTh {
            css {
              textAlign = TextAlign.left;
            }
            +"Videos to watch"
          }

          styledTh {
            css {
              textAlign = TextAlign.left;
            }
            +"Videos watched"
          }
        }
      }

      tbody {
        tr {
          styledTd {
            css {
              verticalAlign = VerticalAlign.top;
              width = 50.pct
            }

            videoList {
              videos = state.unwatchedVideos
              selectedVideo = state.currentVideo
              onSelectVideo = { video ->
                setState {
                  currentVideo = video
                }
              }
            }
          }

          styledTd {
            css {
              verticalAlign = VerticalAlign.top;
              width = 50.pct
            }

            videoList {
              videos = state.watchedVideos
              selectedVideo = state.currentVideo
              onSelectVideo = { video ->
                setState {
                  currentVideo = video
                }
              }
            }
          }
        }
      }
    }
  }
}