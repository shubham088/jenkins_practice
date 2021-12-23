pipeline {
    agent {
         docker {
         image 'python_cus'
         }
        
    }
    stages {
        stage('checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '4b23312a-bba3-4465-8756-fa731bb16779', url: 'https://github.com/shubham088/jenkins_practice.git']]])
                echo 'Hello , we have checked out the code from git.'
            }
        }
        
        stage('build'){
            steps{
                echo "running test and coverage"
                sh "python3 -m coverage run test_code.py"
                sh "python3 -m coverage xml"
                sh "python3 -m coverage html"
                sleep 2
                sh "ls"
                sh "pwd"
            }
        }
        
        stage('sonarqube analysis'){
            
            steps{
                withSonarQubeEnv('SonarqubeServer2') {
                sh "${tool("SonarqubeScanner")}/bin/sonar-scanner"
                }
        }
    }
    
    stage('Quality_check'){
        
            steps{
            sleep 10
            waitForQualityGate abortPipeline: true, credentialsId: 'sonarqube-token2'
        }
        
    }
    
    stage('artifactory'){
          steps{
              echo "artifactory....."
              rtUpload (
                serverId: 'jfrog_artifactory_1',
                spec: '''{
                      "files": [
                        {
                          "pattern": "coverage.xml",
                          "target": "sample/coverage${BUILD_NUMBER}/"
                        },
                        {
                          "pattern": "htmlcov/*",
                          "target" : "sample/htmlcov${BUILD_NUMBER}/",
                          "recursive":true
                        }
                     ]
                    }''',
                    
                )
                
                
            }
    }
    
       
}
}
