pipeline {
   agent any
   environment {
      browser = ''
   }
   stages {
      stage('Checkout') {
         steps {
            checkout scm
         }
      }
      stage('Build') {
         steps {
            bat 'mvn clean compile'
         }
      }
      stage('Test') {
         parallel {
            stage('Test on Chrome') {
               environment {
                  browser = 'chrome'
               }
               steps {
                  bat 'mvn test -Dbrowser=chrome'
               }
               
            }
            stage('Test on Firefox') {
               environment {
                  browser = 'firefox'
               }
               steps {
                  bat 'mvn test -Dbrowser=firefox'
               }
               
            }
            stage('Test on Edge') {
               environment {
                  browser = 'edge'
               }
               steps {
                  bat 'mvn test -Dbrowser=edge'
               }
               
            }
            
            
         }
         post {
              always {
               script {
                  archiveArtifacts artifacts: "target/Spark.html", allowEmptyArchive: true
               }
               publishHTML([
                  allowMissing: false, 
                  alwaysLinkToLastBuild: false, 
                  keepAll: true, 
                  reportDir: "target", 
                  reportFiles: 'Spark.html', 
                  reportName: "Spark"
               ])
            }
            failure {
               echo 'Build failed. Check the test reports for details.'
            }
         }
      }
   }
}