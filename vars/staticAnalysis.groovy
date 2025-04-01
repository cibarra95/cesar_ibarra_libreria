//  Ejercicio 4 checar las ramas main y hotfix
def call(boolean abortPipeline = false) {
    def branch = env.BRANCH_NAME ?: 'unknown'

    timeout(time: 5, unit: 'MINUTES') {
        withEnv(['sonarenv=fake']) {
            sh 'echo "Ejecución de las pruebas de calidad de código con tiempo de espera de 5 minutos"'
        }
    }

    if (abortPipeline) {
        error("Abortando pipeline por abortPipeline = true")
    } else if (branch == 'main') {
        error("Abortando el pipeline de calidad porque es la rama main")
    } else if (branch.contains('hotfix')) {
        error("Abortando el pipeline de calidad porque es la una rama que contiene hotfix")
    } else {
        echo "Corriendo el pipeline de calidad, la rama es ${branch}"
    }
}