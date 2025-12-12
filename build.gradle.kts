plugins {
    id("java")
    id("application") // Required to run JavaFX
    id("org.openjfx.javafxplugin") version "0.1.0"// The standard JavaFX plugin
}
javafx {
    version = "21"
    modules("javafx.controls") // Adds the GUI components
}
application {
    // CHANGE THIS to your package + class name
    mainClass.set("org.Main.Main")
}
group = "org.example"
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