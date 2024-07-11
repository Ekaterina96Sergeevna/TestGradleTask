plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

fun registerJavaExecTask(taskName: String, mainClass: String, hasArgs: Boolean = false) {
    tasks.register<JavaExec>(taskName) {
        classpath = sourceSets.main.get().runtimeClasspath
        this.mainClass.set(mainClass)
        if (hasArgs) {
            args = listOf(project.findProperty("scriptArgs")?.toString() ?: "")
        }
        systemProperty("rootDir", project.rootDir.absolutePath)
    }
}

registerJavaExecTask("runBinarySearch", "MainKt", hasArgs = true)