//  Ejercicio de pruebas de calidad de código
def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        withEnv(['sonarenv=fake']) {
            sh 'echo "Ejecución de las pruebas de calidad de código con tiempo de espera de 5 minutos"'
        }
    }

    if (abortPipeline) {
        error("Abortado por configuración de abortPipeline = true")
    }
}