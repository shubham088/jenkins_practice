def sonarAnalysis(String sonarServerName, String sonarScanner) {
  withSonarQubeEnv(sonarServerName) {
    sh sonarScanner+"/bin/sonar-scanner"
  }
}


def qualityGateAnalysis(int timer, String credential_id){
//   echo "$data"
//   String[] my_data = data.split(" ")
//   echo "$my_data"
//   println(my_data[0])
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
  println("target for pattern 0")
  String path = "${artifactoryFolderName}${target[0]}${build.toString()}"
  String target_path1= artifactoryFolderName+target[0]+build.toString()
  def spec_data = readJSON file: 'artifactory.json'
  spec_data['files'][0].put('target', artifactoryFolderName+target[0]+build.toString()+"/")
  spec_data['files'][1].put('target', artifactoryFolderName+target[1]+build.toString()+"/")
  println(spec_data)
  println(spec_data.getClass())
  rtUpload (
  serverId: serverID,
//   spec: '''{
//         "files": [
//           {
//             "pattern": ${pattern[0]},
//             "target":  ${artifactoryFolderName}+${target[0]}+${build.toString()}
//           },
//           {
//             "pattern": ${pattern[1]},
//             "target" : ${artifactoryFolderName}+${target[1]}+${build.toString()},
//             "recursive":true
//           }
//        ]
//       }''',
    spec : spec_data,

  )
  
 echo "done uploading artifacts using shared lib"

}
