@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.algomate)
    alias(libs.plugins.javafxplugin)
}

exercise {
    assignmentId.set("h13")
}

submission {
    // ACHTUNG!
    // Setzen Sie im folgenden Bereich Ihre TU-ID (NICHT Ihre Matrikelnummer!), Ihren Nachnamen und Ihren Vornamen
    // in Anführungszeichen (z.B. "ab12cdef" für Ihre TU-ID) ein!
    studentId = null
    firstName = null
    lastName = null

    // Optionally require own tests for mainBuildSubmission task. Default is false
    requireTests = false
    // Optionally require public grader for mainBuildSubmission task. Default is false
    requireGraderPublic = false
}

javafx {
    version = "17.0.1"
    modules("javafx.controls", "javafx.fxml", "javafx.swing", "javafx.graphics", "javafx.base")
}

application {
    mainClass.set("h13.SpaceInvaders")
}

jagr {
    graders["graderPublic"].configureDependencies {
        implementation(libs.algoutils.tutor)
        implementation(libs.mockito.inline)
        implementation(libs.testfx.core)
        implementation(libs.testfx.junit5)
        implementation(libs.mockito.junit.jupiter)
        implementation(libs.junit.pioneer)
        implementation(libs.jackson.databind)
        compileOnly(libs.openjfx.monocle)
    }
}
