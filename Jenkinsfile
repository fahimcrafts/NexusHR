pipeline {
    agent any
    tools {
        maven 'Maven-3.9.16'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn test'
            }

            post{
            always {
                archiveArtifacts artifacts: 'target/extent-report.html'
            }
        }
    }
}