def call(){
  sh "trivy fs . -o nothing.json"
}
