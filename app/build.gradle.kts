import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.apply as apply

plugins {

    application
    jacoco
    id ("checkstyle")

}


group = "hexlet.code"
version = "1.0-SNAPSHOT"
application {mainClass = "hexlet.code.App" }
repositories {
    mavenCentral()
}

dependencies {

    implementation ("info.picocli:picocli:4.7.5")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation ( "com.fasterxml.jackson.dataformat", "jackson-dataformat-yaml", "2.13.4")
    testImplementation("junit:junit:4.13.1")
    annotationProcessor ("info.picocli:picocli-codegen:4.7.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
jacoco {
    toolVersion = "0.8.11"
}


tasks.test {

    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true


    }

}
tasks.jacocoTestReport {
    reports {

       xml.required.set(true)


   }
}