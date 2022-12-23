pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvnw clean package'
            }
        }
        stage('Sonar Analysis') {
            steps {
                bat 'mvnw sonar:sonar -Dsonar.login=squ_013d9f365c447270bc7ec8749a82e49cef9ba64f'
            }
        }
        stage('Deploy') {
            steps {
                bat 'cp target/*.jar app.jar'
                bat 'java -jar app.jar'
            }
        }
    }
}
s