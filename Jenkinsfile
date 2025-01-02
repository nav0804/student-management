pipeline {
    agent any

    tools {
        // Use Maven tool configured in Jenkins (you need to set up Maven in Jenkins)
        maven 'maven 3.9'
    }

    stages {
        stage('checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nav0804/student-management.git'
            }
        }

        stage('build') {
            steps {
                // Run Maven build (clean and install or package)
                sh 'mvn clean install'  // or 'mvn clean package' if you just want to build the artifact
            }
        }

    }

    post {
        always {
            cleanWs()  // Clean up workspace
        }

        success {
            echo 'Build successful!'
        }

        unstable {
            echo 'Build unstable.'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
