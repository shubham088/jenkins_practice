def sonarAnalysis(String sonarServerName, String sonarScanner) {
  echo "${sonarServerName}"
  echo "${sonarScanner}"
  withSonarQubeEnv(${sonarServerName}) {
    sh ${sonarScanner}+"/bin/sonar-scanner"
  }

}
