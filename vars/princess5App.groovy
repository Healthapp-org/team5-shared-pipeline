def call(String repoUrl){
pipeline {
       agent any
       tools {
           maven 'mymaven'
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
        stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
      }
    }
}
}
