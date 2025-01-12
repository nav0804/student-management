pipeline{
    agent any
    tools{
        maven 'maven 3.9'
    }
    stages{
        stage('Build maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/nav0804/student-management']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                sh 'docker build -t nav010/student-management .'
            }
        }
        stage('Push docker image'){
            steps{
                withCredentials([string(credentialsId: 'dock-pwd', variable: 'dockPwd')]) {
                    sh 'docker login -u nav010 -p ${dockPwd}'
                }
                sh 'docker push nav010/student-management'
            }
        }
    }
}