plugins {
  id("org.jetbrains.kotlin.js") version "1.4.30-M1"
  id("com.github.ben-manes.versions") version "0.36.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
  maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
  mavenCentral()
  jcenter()
}

kotlin {
  js {
    browser {}
    binaries.executable()
  }
}

dependencies {
  implementation(kotlin("stdlib-js"))

  implementation("org.jetbrains:kotlin-react:17.0.1-pre.136-kotlin-1.4.21")
  implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.136-kotlin-1.4.21")
  implementation("org.jetbrains:kotlin-styled:5.2.0-pre.136-kotlin-1.4.21")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

  implementation(npm("react", "16.13.1"))
  implementation(npm("react-dom", "16.13.1"))
  implementation(npm("styled-components", "~5.2.1"))
  implementation(npm("inline-style-prefixer", "~6.0.0"))
  implementation(npm("react-player", "~2.7.2"))
  implementation(npm("react-share", "~4.3.1"))
  implementation(npm("react-bootstrap", "~1.4.3"))
  implementation(npm("bootstrap", "~4.5.3"))
}