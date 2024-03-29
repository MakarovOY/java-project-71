plugins {

    application
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
    annotationProcessor ("info.picocli:picocli-codegen:4.7.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}