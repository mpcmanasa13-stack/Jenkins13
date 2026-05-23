pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mpcmanasa13-stack/Jenkins13.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            slackSend channel: '#aiml',
                      message: 'BUILD SUCCESS: Maven Quiz App built successfully.'
        }

        failure {
            slackSend channel: '#aiml',
                      message: 'BUILD FAILED: Maven Quiz App failed.'
        }
    }
}
