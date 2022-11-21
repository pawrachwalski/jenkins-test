pipeline {
    agent {
        label 'master'
        }
    stages {
        stage('STAGE 1') {
            steps {
               script {
               echo "Hello from $STAGE_NAME"
               }
            }
        }
        stage('STAGE 2'){
            steps {
                script {
                    echo "Hello from $STAGE_NAME"
		}    
            }
        }
        
        stage('STAGE 3'){
            steps {
                script {
                    echo "Hello from $STAGE_NAME"    
                }
            }
        }
        stage('STAGE 4'){
            steps {
                script {
                    echo "Hello from $STAGE_NAME"
                }
            }
        }
        stage('CLEAN WS'){
            steps {
                cleanWs()
            }
        }
    }
}
