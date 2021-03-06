import groovy.json.*


def sonarAnalysis(String sonarServerName, String sonarScanner) {
  withSonarQubeEnv(sonarServerName) {
    sh sonarScanner+"/bin/sonar-scanner"
  }
}


def qualityGateAnalysis(int timer, String credential_id){
   sleep timer
   waitForQualityGate abortPipeline: true, credentialsId: credential_id
}

def artifactoryUpload(String[] data){
  String build = data[0]
  String serverID = data[1]
  String artifactoryFolderName = data[2]
  String pat = data[3]
  String tar = data[4]
  String[] pattern = pat.split(" ")
  String[] target  = tar.split(" ")
  
  String target_path1= artifactoryFolderName+target[0]+build.toString()
  def spec_data = readJSON file: 'artifactory.json'
  spec_data['files'][0].put('pattern', pattern[0])
  spec_data['files'][1].put('pattern', pattern[1])
  spec_data['files'][0].put('target', artifactoryFolderName+target[0]+build.toString()+"/")
  spec_data['files'][1].put('target', artifactoryFolderName+target[1]+build.toString()+"/")
  println(spec_data)
  rtUpload (
    serverId: serverID,
    spec : groovy.json.JsonOutput.toJson(spec_data),
  )
  
 echo "done uploading artifacts using shared lib"

}
