import react.RClass
import react.RProps

val bsAlertHeading: RClass<RProps> = bsAlert.asDynamic().Heading

val bsAlertLink: RClass<BsAlertLinkProps> = bsAlert.asDynamic().Link

interface BsAlertLinkProps : RProps {
  var href: String
}

val bsFormGroup: RClass<BsFormGroupProps> = bsForm.asDynamic().Group

interface BsFormGroupProps : RProps {
  var controlId: String
}

val bsFormLabel: RClass<BsFormLabelProps> = bsForm.asDynamic().Label

interface BsFormLabelProps : RProps {
  var controlId: String
  var column: dynamic
  var htmlFor: String
  var srOnly: Boolean
  var bsPrefix: String
}

val bsFormControl: RClass<BsFormControlProps> = bsForm.asDynamic().Control

interface BsFormControlProps : RProps {
  var id: String
  var name: String
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

val bsFormText: RClass<BsFormTextProps> = bsForm.asDynamic().Text

interface BsFormTextProps : RProps {
  var className: String
  var muted: Boolean
}

val bsFormCheck: RClass<BsFormCheckProps> = bsForm.asDynamic().Check

interface BsFormCheckProps : RProps {
  var id: String
  var type: String
  var label: String
  var disabled: Boolean
}

val bsFormSwitch: RClass<BsFormSwitchProps> = bsForm.asDynamic().Switch

interface BsFormSwitchProps : RProps {
  var id: String
  var label: String
  var disabled: Boolean
}

