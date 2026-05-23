pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }

    // CRITICAL: You must wrap your stages in a "stages" block
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/KeerthanaAR123/Maven-Demo.git',
                    credentialsId: 'github-token'
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

        stage('Run Application') {
            steps {
                sh 'mvn exec:java -Dexec.mainClass="com.example.app.App"'
            }
        }
    } // End of stages

    post {
        always {
            cleanWs()
        }
        success {
            emailext (
                subject: "SUCCESS: ${JOB_NAME} - Build #${BUILD_NUMBER}",
                body: "Build was successful! View details here: ${BUILD_URL}",
                to: "kk9741463496@gmail.com"
            )
        }
        failure {
            emailext (
                subject: "FAILED: ${JOB_NAME} - Build #${BUILD_NUMBER}",
                body: "Build failed. Please check the console output: ${BUILD_URL}",
                to: "kk9741463496@gmail.com"
            )
        }
    }
}
