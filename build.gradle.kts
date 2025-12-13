plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.13"
}

application {
    mainClass.set("org.Main.Main")
}
javafx {
    version = "21.0.5" // Use 21 (LTS) or 23 to match your JDK
    modules = listOf("javafx.controls", "javafx.fxml")
}
group = "org.Main"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Core POI library
    implementation("org.apache.poi:poi:5.2.3")

    // OOXML schemas (Required for XSSFWorkbook)
    implementation("org.apache.poi:poi-ooxml:5.2.3")

    // Log4j (Required to avoid runtime errors)
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
}

tasks.test {
    useJUnitPlatform()
}