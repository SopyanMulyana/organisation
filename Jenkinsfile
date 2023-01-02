pipeline {
    agent any

    stages {
        stage('Sonar Analysis') {
            steps {
                bat 'mvn sonar:sonar -Dsonar.login=squ_013d9f365c447270bc7ec8749a82e49cef9ba64f'
            }
        }

        stage('Verify') {
            steps {
                bat 'mvn verify -Dmaven.test.skip'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'mvn compile jib:dockerBuild'
            }
        }
    }
}
