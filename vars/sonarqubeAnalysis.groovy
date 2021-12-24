def sonarAnalysis(String sonarServerName, String sonarScanner) {
  echo "${sonarServerName}"
  echo "${sonarScanner}"
//   withSonarQubeEnv(${sonarServerName}) {
//      sh this.env.scanner+"/bin/sonar-scanner"
//   }

}
