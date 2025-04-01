@Library('threepoints-sharedlib') _

pipeline {
    agent any

    stages {
        stage('Static Analysis') {
            steps {
                script {
                    staticAnalysis(false)
                }
            }
        }
    }
}
