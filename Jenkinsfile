@Library('threepoints-sharedlib') _

pipeline {
    agent any

// Correr el pipeline de calidad de código
    stages {
        stage('Static Analysis') {
            steps {
                script {
                    staticAnalysis(true)
                }
            }
        }
    }
}
