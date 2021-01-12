import react.RClass
import react.RProps

val bsAlertHeading: RClass<RProps> = bsAlert.asDynamic().Heading

val bsAlertLink: RClass<BootstrapAlertLinkProps> = bsAlert.asDynamic().Link

interface BootstrapAlertLinkProps : RProps {
  var href: String
}

val bsFormGroup: RClass<BootstrapFormGroupProps> = bsForm.asDynamic().Group

interface BootstrapFormGroupProps : RProps {
  var controlId: String
}

val bsFormLabel: RClass<BootstrapFormLabelProps> = bsForm.asDynamic().Label

interface BootstrapFormLabelProps : RProps {
  var controlId: String
  var column: dynamic
  var htmlFor: String
  var srOnly: Boolean
  var bsPrefix: String
}

val bsFormControl: RClass<BootstrapFormControlProps> = bsForm.asDynamic().Control

interface BootstrapFormControlProps : RProps {
  var id: String
  var type: String
  var placeholder: String
  var size: String
  var readOnly: Boolean
  var plaintext: Boolean
  var custom: Boolean
  var disabled: Boolean
  var htmlSize: Int
  var `as`: String
  var isInvalid: Boolean
  var isValid: Boolean
  var onChange: () -> Unit
  var defaultValue: dynamic
  var value: dynamic
}

val bsFormText: RClass<BootstrapFormTextProps> = bsForm.asDynamic().Text

interface BootstrapFormTextProps : RProps {
  var className: String
  var muted: Boolean
}

val bsFormCheck: RClass<BootstrapFormCheckProps> = bsForm.asDynamic().Check

interface BootstrapFormCheckProps : RProps {
  var id: String
  var type: String
  var label: String
  var disabled: Boolean
}

val bsFormSwitch: RClass<BootstrapFormSwitchProps> = bsForm.asDynamic().Switch

interface BootstrapFormSwitchProps : RProps {
  var id: String
  var label: String
  var disabled: Boolean
}

