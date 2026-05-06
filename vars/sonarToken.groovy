// This block fetches the secret 'sonar-token' and stores it in the variable SONAR_TOKEN
def call(String SQtoken){
  withCredentials([string(
   credentialsId: "${SQtoken}", 
   variable: 'SONAR_TOKEN'
   )]) {
   sh """
   docker run --rm \
   -e SONAR_HOST_URL="http://3.82.111.130:9000" \
   -e SONAR_SCANNER_OPTS="-Dsonar.projectKey=visitor-book" \
   -e SONAR_TOKEN="${env.SONAR_TOKEN}" \
   -v "\$(pwd):/usr/src" \
   sonarsource/sonar-scanner-cli
   """
   }
}
