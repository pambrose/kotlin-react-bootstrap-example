@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("Button")
external val bsButton: RClass<BootstrapButtonProps>
external interface BootstrapButtonProps : RProps {
  var variant: String
  var size: String
  var type: String
  var onClick: () -> Unit
}

@JsName("Alert")
external val bsAlert: RClass<BootstrapAlertProps>

external interface BootstrapAlertProps : RProps {
  var variant: String
  var closeLabel: String
  var show: Boolean
  var dismissible: Boolean
  var onClose: () -> Unit
}

@JsName("Form")
external val bsForm: RClass<BootstrapFormProps>

external interface BootstrapFormProps : RProps {
  var variant: String
  var closeLabel: String
  var show: Boolean
  var dismissible: Boolean
  var onClose: () -> Unit
}

@JsName("Container")
external val bsContainer: RClass<BootstrapContainerProps>

external interface BootstrapContainerProps : RProps {
  var fluid: dynamic
}

@JsName("Row")
external val bsRow: RClass<RProps>

@JsName("Col")
external val bsCol: RClass<BootstrapColProps>

external interface BootstrapColProps : RProps {
  var xs: Int
}
