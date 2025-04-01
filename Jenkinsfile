@Library('threepoints-sharedlib') _

pipeline {
    agent any

// Correr el pipeline de calidad de código
    stages {
        stage('Static Analysis with Quality Gate') {
            steps {
                script {
                    staticAnalysis(abortPipeline = true, waitForGate = true)
                }
            }
        }
    }
}
