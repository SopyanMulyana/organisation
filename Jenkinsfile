pipeline {
    agent any

    stages {
        stage('Sonar Analysis') {
            steps {
                bat 'mvn sonar:sonar -Dsonar.login=squ_013d9f365c447270bc7ec8749a82e49cef9ba64f'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn spring-boot:build-image'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker run -p 9090:8080 -t organisation:0.0.1-SNAPSHOT'
            }
        }
    }
}
s