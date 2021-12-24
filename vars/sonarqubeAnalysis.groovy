def sonarAnalysis(String sonarServerName, String sonarScanner) {
  withSonarQubeEnv(${sonarServerName}) {
     sh "${sonarScanner}/bin/sonar-scanner"
  }

}
