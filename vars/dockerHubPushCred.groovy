def call(String CredID, String ImageID){
  withCredentials([usernamePassword(
   credentialsId:"${CredID}",
   passwordVariable: "dockerHubPass",
   usernameVariable: "dockerHubUser"
   )]){
   sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
 //  sh "docker image tag ${ImageID} ${env.dockerHubUser}/${ImageID}"
   sh "docker image tag ${ImageID}:v1 ${env.dockerHubUser}/${ImageID}:v1"
   sh "docker push ${env.dockerHubUser}/${ImageID}:v1"
   }
}
