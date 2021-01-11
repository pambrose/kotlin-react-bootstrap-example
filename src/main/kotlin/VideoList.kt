import kotlinx.css.marginBottom
import kotlinx.css.px
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import styled.css
import styled.styledDiv

external interface VideoListProps : RProps {
  var videos: List<Video>
  var selectedVideo: Video?
  var onSelectVideo: (Video) -> Unit
}

class VideoList : RComponent<VideoListProps, RState>() {

  override fun RBuilder.render() {
    styledDiv {

      for (video in props.videos) {
        styledDiv {
          css {
            marginBottom = 10.px
            //backgroundColor = Color.lightGreen
            //color = Color.lightGreen
          }

          key = video.id.toString()

          attrs {
            onClickFunction = {
              props.onSelectVideo(video)
            }
          }

          if (video == props.selectedVideo)
            +"▶ "

          +"${video.speaker}: ${video.title}"
        }
      }
    }
  }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
  return child(VideoList::class) {
    attrs(handler)
  }
}