pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package sonar:sonar'
            }
        }
        stage('Deploy') {
            steps {
                sh 'cp target/*.jar app.jar'
                sh 'java -jar app.jar'
            }
        }
    }
}
s