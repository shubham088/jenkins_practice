def sonarAnalysis(String sonarServerName, String sonarScanner) {
  withSonarQubeEnv(sonarServerName) {
    sh sonarScanner+"/bin/sonar-scanner"
  }
}


def qualityGateAnalysis(int timer, String credential_id, String data){
  echo "$data"
  my_data = data.split(" ")
  echo "$my_data[0]"
   sleep timer
   waitForQualityGate abortPipeline: true, credentialsId: credential_id
}
