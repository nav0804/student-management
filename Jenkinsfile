pipeline{
	agent any

	tools{
		maven 'maven 3.9'
	}

	environment{
		DOCKER_IMAGE = 'students'
		DOCKER_TAG = "latest"
		DOCKER_REGISTRY = 'nav010/students-library:latest'
		DOCKER_USERNAME = credentials('nav010')
		DOCKER_PASSWORD = credentials('!Wk5NxRi;_Vxuf@')
	}

	stages{
		stage('Checkout'){
			steps{
				git branch : 'main', url : ''https://github.com/nav0804/student-management.git''
			}
		}

		stage('Build'){
			steps{
				sh 'mvn clean install'
			}
		}

		stage('Build Docker Image'){
			steps{
				script{
					sh "docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE}:${DOCKER_TAG} ."
				}
			}
		}

		stage('Push image'){
			steps{
				script{
					sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} ${DOCKER_REGISTRY}"
					sh "docker push ${DOCKER_REGISTRY}/{DOCKER_IMAGE}:${DOCKER_TAG}"
				}
			}
		}


	}

	post {
		always{
			cleanWs()
		}

		success{
			echo 'Build and Docker image pushed successfully'
		}

		unstable{
			echo 'Build unstable'
		}

		failure{
			echo 'Build failure'
		}
	}


}