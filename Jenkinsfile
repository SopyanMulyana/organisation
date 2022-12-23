pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvnw clean package'
            }
        }
        stage('Sonar Analysis') {
            steps {
                sh 'mvnw sonar:sonar -Dsonar.login=squ_013d9f365c447270bc7ec8749a82e49cef9ba64f'
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