@file:JsModule("react-bootstrap")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("Button")
external val bsButton: RClass<BsButtonProps>

external interface BsButtonProps : RProps {
  var variant: String
  var size: String
  var type: String
  var onClick: () -> Unit
}

@JsName("Alert")
external val bsAlert: RClass<BsAlertProps>

external interface BsAlertProps : RProps {
  var variant: String
  var closeLabel: String
  var show: Boolean
  var dismissible: Boolean
  var onClose: () -> Unit
}

@JsName("Form")
external val bsForm: RClass<BsFormProps>

external interface BsFormProps : RProps {
  var variant: String
  var closeLabel: String
  var show: Boolean
  var dismissible: Boolean
  var onClose: () -> Unit
}

@JsName("Container")
external val bsContainer: RClass<BsContainerProps>

external interface BsContainerProps : RProps {
  var fluid: dynamic
}

@JsName("Row")
external val bsRow: RClass<RProps>

@JsName("Col")
external val bsCol: RClass<BsColProps>

external interface BsColProps : RProps {
  var xs: Int
}
