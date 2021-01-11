import react.RClass
import react.RProps

val bootstrapAlertHeading: RClass<RProps> = bootstrapAlert.asDynamic().Heading

val bootstrapAlertLink: RClass<BootstrapAlertLinkProps> = bootstrapAlert.asDynamic().Link

interface BootstrapAlertLinkProps : RProps {
  var href: String
}
