import kotlinx.css.TextAlign
import kotlinx.css.margin
import kotlinx.css.marginLeft
import kotlinx.css.marginRight
import kotlinx.css.marginTop
import kotlinx.css.pct
import kotlinx.css.px
import kotlinx.css.textAlign
import kotlinx.css.width
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h3
import styled.css
import styled.styledDiv
import styled.styledSpan

external interface VideoPlayerProps : RProps {
  var video: Video
  var onWatchedButtonPressed: (Video) -> Unit
  var unwatchedVideo: Boolean
}

external interface VideoPlayerState : RState {
  var opened: Boolean?
}

class VideoPlayer(props: VideoPlayerProps) : RComponent<VideoPlayerProps, VideoPlayerState>(props) {

  override fun VideoPlayerState.init(props: VideoPlayerProps) {
    opened = false
  }

  override fun RBuilder.render() {

    styledDiv {
      css {
        textAlign = TextAlign.center
        //border = "3px solid green;"
      }

      h3 { +"${props.video.speaker}: ${props.video.title}" }

      styledSpan {

        css {
          textAlign = TextAlign.center
          //border = "3px solid red;"

          // Centers the player
          width = 50.pct
          margin = "0 auto"
        }

        styledSpan {
          css {
            marginLeft = 5.px
            marginRight = 5.px
          }

          bsButton {
            attrs {
              variant = if (props.unwatchedVideo) "success" else "danger"
              size = "lg"
              onClick = {
                props.onWatchedButtonPressed(props.video)
              }
            }
            +"Mark as ${if (props.unwatchedVideo) "" else "un"}watched"
          }
        }

//          styledButton {
//            css {
//              display = Display.block
//              backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
//            }
//
//            attrs {
//              onClickFunction = {
//                props.onWatchedButtonPressed(props.video)
//              }
//            }
//
//            +"Mark as ${if (props.unwatchedVideo) "" else "un"}watched"
//          }

//          styledSpan {
//            css {
//              display = Display.flex
//              marginBottom = 10.px
//            }
//
//            bootstrapAlert {
//              attrs {
//                variant = "primary"
//                closeLabel = "close label"
//                show = state.opened!!
//                dismissible = true
//                onClose = {
//                  setState {
//                    opened = false
//                  }
//                }
//              }
//
//              bootstrapAlertHeading {
//                +"Alert Heading Text"
//              }
//
//              bootstrapAlertLink {
//                attrs {
//                  href = "http://www.abc.com"
//                }
//                +"www.abc.com"
//              }
//              +"This is the text inside the Alert"
//            }
//          }
//
//          styledButton {
//            +"Open Alert"
//            attrs {
//              onClickFunction = {
//                setState {
//                  opened = true
//                }
//              }
//            }
//          }

        emailShareButton {
          attrs {
            url = props.video.videoUrl
            subject = "This is a test subject"
          }

          emailIcon {
            attrs {
              size = 32
              round = true
            }
          }
        }

        telegramShareButton {
          attrs {
            url = props.video.videoUrl
          }

          telegramIcon {
            attrs {
              size = 32
              round = true
            }
          }
        }
      }

      styledDiv {
        css {
          // Center the player
          width = 50.pct
          margin = "0 auto"
          marginTop = 20.px
        }

        reactPlayer {
          attrs {
            url = props.video.videoUrl
          }
        }
      }
    }
  }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit) =
  child(VideoPlayer::class) {
    attrs(handler)
  }