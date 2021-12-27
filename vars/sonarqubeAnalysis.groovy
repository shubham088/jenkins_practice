def sonarAnalysis(String sonarServerName, String sonarScanner, String[] data) {
  echo data[0]
  echo "$data[0]"
  withSonarQubeEnv(sonarServerName) {
    sh sonarScanner+"/bin/sonar-scanner"
  }
}


def qualityGateAnalysis(int timer, String credential_id){
   sleep timer
   waitForQualityGate abortPipeline: true, credentialsId: credential_id
}
