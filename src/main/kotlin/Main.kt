import kotlinx.browser.document
import org.w3c.dom.url.URL
import react.dom.render

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

fun main() {
  render(document.getElementById("root")) {
    val params = URL(document.URL).searchParams
    if (params.get("video") != null)
      child(VideoPlayerApp::class) {}
    else
      child(App::class) {}
  }
}