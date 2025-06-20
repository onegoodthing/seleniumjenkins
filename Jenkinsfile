pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the project'
                sh 'echo "Simulating build step"'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests'
                sh 'echo "Simulating test step"'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application'
                sh 'echo "Simulating deploy step"'
            }
        }
    }
}
