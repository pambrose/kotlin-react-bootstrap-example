@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("Button")
external val bootstrapButton: RClass<BootstrapButtonProps>

external interface BootstrapButtonProps : RProps {
  var variant: String
  var size: String
  var onClick: () -> Unit
}

@JsName("Alert")
external val bootstrapAlert: RClass<BootstrapAlertProps>

external interface BootstrapAlertProps : RProps {
  var variant: String
  var closeLabel: String
  var show: Boolean
  var dismissible: Boolean
  var onClose: () -> Unit
}

