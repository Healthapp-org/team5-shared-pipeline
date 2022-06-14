pipeline{
  agent any
  stages{
  	stage('version-control'){
  		steps{
  			checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'f7c765a1-e95f-44ad-9f53-7b9fc6ad20ec', url: 'https://github.com/Healthapp-org/team5-shared-pipeline.git']]])
  		}
  	}
    stage('parallel-job'){
      parallel{
        stage('sub-job1'){
          steps{
            echo 'simpletest.sh'
          }
        }
        stage('sub-job2'){
          steps{
            sh 'lscpu'
          }
        }
        stage('sub-job3'){
          steps{
            sh 'uptime'
          }
        }
        stage('sub-job4'){
          steps{
            sh 'ps -ef'
          }
        }
        stage('sub-job5'){
          steps{
            sh 'lsblk'
          }
        }
      }
    }
    stage('codebuild'){
    	steps{
    		sh 'cat /etc/passwd'
        sh 'ls -l'
    	}
    }
  }
}