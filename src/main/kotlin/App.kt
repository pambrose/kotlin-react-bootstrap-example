import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import org.w3c.dom.HTMLTextAreaElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.option
import styled.css
import styled.styledDiv

external interface AppState : RState {
}

class App : RComponent<RProps, AppState>() {

  override fun AppState.init() {
  }

  override fun RBuilder.render() {

    h1 { +"Kotlin React Bootstrap Example" }

    styledDiv {
      css {
        width = 60.pct
        border = "3px solid grey;"
        marginLeft = 20.px
      }

      styledDiv {
        css {
          marginTop = 20.px
          marginBottom = 20.px
          marginLeft = 20.px
          marginRight = 20.px
        }

        bsForm {
          attrs {
            validated = false
            action = "http://0.0.0.0:8090"
            onSubmit = {
              val e = document.getElementById("email1") as HTMLTextAreaElement
              validated = false
              window.alert("Submit clicked ${e.value}")
            }

            bsFormGroup {
              attrs.controlId = "formBasicEmail"

              bsFormLabel { +"This is a form label" }

              bsFormControl {
                attrs {
                  //type = "email"
                  id = "email1"
                  `as` = "textarea"
                  name = "email2"
                  placeholder = "Enter email"
                  //defaultValue = "Enter email default"

                  onChange = {
                    println("I am here")
                  }
                }
              }

              bsFormText {
                //attrs.className = "text-muted"
                //attrs.muted = true
                +"We'll never share your email with anyone else."
              }
            }

            bsFormGroup {
              attrs.controlId = "formBasicPassword"

              bsFormLabel { +"Password" }

              bsFormControl {
                attrs {
                  type = "password"
                  placeholder = "Password"
                }
              }
            }

            bsFormGroup {
              attrs.controlId = "formBasicCheckbox"

              bsFormCheck {
                attrs {
                  type = "checkbox"
                  label = "Check me out"
                }
              }
            }

            bsFormGroup {
              attrs.controlId = "formBasicRange"

              bsFormLabel { +"Range" }

              bsFormControl {
                attrs {
                  type = "range"
                }
              }
            }

            bsFormGroup {
              attrs.controlId = "formSwitches"

              bsFormSwitch {
                attrs {
                  //type = "switch"
                  id = "custom-switch"
                  label = "Check this switch"
                }
              }

              bsFormCheck {
                attrs {
                  disabled = true
                  type = "switch"
                  label = "disabled switch"
                  id = "disabled-custom-switch"
                }
              }

              bsFormLabel {
                +"Custom select"
              }

              bsFormControl {
                attrs {
                  `as` = "select"
                  custom = true
                  htmlSize = 5
                }

                (1..10).map { option { +"$it" } }
              }
            }

            bsButton {
              attrs {
                variant = "primary"
                type = "submit"
              }
              +"Submit"
            }
          }
        }
      }
    }

    styledDiv {
      bsContainer {
        attrs.fluid = true

        bsRow {
          bsCol {
            +"1 of 1"
            +"1 of 1"
          }
        }
      }
    }

    styledDiv {
      bsContainer {
        attrs.fluid = "sm"

        bsRow {
          bsCol {
            +"1 of 1"
            +"1 of 1"
          }
        }
      }
    }
  }
}