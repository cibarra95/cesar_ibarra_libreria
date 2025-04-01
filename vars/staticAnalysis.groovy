//  Ejercicio Opcional
def call(boolean abortPipeline = false, boolean waitForGate = false) {
    def branch = env.BRANCH_NAME ?: 'unknown'

    if (abortPipeline) {
            error("Abortando pipeline por abortPipeline = true")
        }

    // Ejecuta el scanner de sonarqube
    withSonarQubeEnv('SonarQube') {
        withSonarScannerInstallation('SonarQube') {
            sh 'sonar-scanner'
        }
    }

    // Esperando el waitForGate
    if (waitForGate) {
        timeout(time: 5, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: false
        }
    }

     if (branch == 'main') {
        error("Abortando el pipeline de calidad porque es la rama main")
    } else if (branch.contains('hotfix')) {
        error("Abortando el pipeline de calidad porque es la rama que contiene hotfix")
    } else {
        echo "Corriendo el pipeline de calidad, la rama es ${branch}"
    }
}