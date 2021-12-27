def sonarAnalysis(String sonarServerName, String sonarScanner) {
//   echo "${sonarServerName}"
//   echo "${sonarScanner}"
  println(this.env.BUILD)
  println(env.BUILD)
  withSonarQubeEnv(sonarServerName) {
    sh sonarScanner+"/bin/sonar-scanner"
  }
}


def qualityGateAnalysis(int timer, String credential_id){
   sleep timer
   waitForQualityGate abortPipeline: true, credentialsId: credential_id
}
