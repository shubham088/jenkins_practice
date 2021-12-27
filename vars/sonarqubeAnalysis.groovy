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

// def artifactoryUpload(int build, String serverID, String artifactoryFolderName, String pat, String tar){
//   String[] pattern = pat.split(" ")
//   String[] target  = tar.split(" ")
//   println(target[0])
//   println(target[1])
// //   rtUpload (
// //   serverId: serverID,
// //   spec: '''{
// //         "files": [
// //           {
// //             "pattern": pattern[0],
// //             "target":  artifactoryFolderName+target[0]+build.toString()
// //           },
// //           {
// //             "pattern": pattern[1],
// //             "target" : artifactoryFolderName+target[1]+build.toString(),
// //             "recursive":true
// //           }
// //        ]
// //       }''',

// //   )
  
//  echo "done uploading artifacts using shared lib"

// }

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
  String path2= artifactoryFolderName+target[0]+build.toString()
  println(path2)
  rtUpload (
  serverId: serverID,
  spec: '''{
        "files": [
          {
            "pattern": "${pattern[0]}",
            "target":  "${artifactoryFolderName}${target[0]}${build.toString()}"
          },
          {
            "pattern": "${pattern[1]}",
            "target" : "${artifactoryFolderName}${target[1]}${build.toString()}",
            "recursive":true
          }
       ]
      }''',

  )
  
 echo "done uploading artifacts using shared lib"

}
