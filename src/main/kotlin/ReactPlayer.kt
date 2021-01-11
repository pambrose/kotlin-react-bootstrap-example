@file:JsModule("react-player")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("default")
external val reactPlayer: RClass<ReactBootstrapProps>

external interface ReactBootstrapProps : RProps {
  var url: String
}