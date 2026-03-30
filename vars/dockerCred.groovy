def call(String CredID, String ImageID){
  withCredentials([usernamePassword(
   credentialsId:"${CredID}",
   passwordVariable: "dockerHubPass",
   usernameVariable: "dockerHubUser"
   )]){
   sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
   sh "docker image tag "${ImageID}" ${env.dockerHubUser}/"${ImageID}""
   sh "docker push ${env.dockerHubUser}/${ImageID}:${BUILD_NUMBER}"
   }
}
