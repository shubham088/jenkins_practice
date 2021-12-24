def sonarAnalysis(String sonarServerName) {
  withSonarQubeEnv(${sonarServerName}) {
     sh this.env.scanner+"/bin/sonar-scanner"
  }

}
