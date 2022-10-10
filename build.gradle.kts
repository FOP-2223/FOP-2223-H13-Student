plugins {
    java
    application
    id("org.sourcegrade.submitter") version "0.5.1"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

submit {
    assignmentId = "h13" // do not change assignmentId
    studentId = null // TU-ID  z.B. "ab12cdef"
    firstName = null
    lastName = null
    // Optionally require tests for prepareSubmission task. Default is true
    requireTests = true
    // Optionally require public tests for prepareSubmission task. Default is false
    requirePublicTests = false
}

// !! Achtung !!
// Die studentId (TU-ID) ist keine Matrikelnummer
// Richtig z.B. ab12cdef
// Falsch z.B. 1234567

repositories {
    mavenLocal()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    mavenCentral()
}

javafx {
    version = "17.0.1"
    modules("javafx.controls", "javafx.fxml")
}

val publicTest: SourceSet by sourceSets.creating {
    val test = sourceSets.test.get()
    compileClasspath += test.output + test.compileClasspath
    runtimeClasspath += output + test.runtimeClasspath
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.tudalgo:algoutils-student:0.1.0-SNAPSHOT")
    // JUnit only available in "test" source set (./src/test)
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

application {
    mainClass.set("h13.SpaceInvaders")
}

tasks {
    val runDir = File("build/run")
    named<JavaExec>("run") {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
    }
    test {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
        useJUnitPlatform()
    }
    val publicTest by creating(Test::class) {
        group = "verification"
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
        testClassesDirs = publicTest.output.classesDirs
        classpath = publicTest.compileClasspath + publicTest.runtimeClasspath
        useJUnitPlatform()
    }
    named("check") {
        dependsOn(publicTest)
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}
