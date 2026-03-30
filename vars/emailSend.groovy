def call(){
  success {
            emailext from: 'yashmane98721@gmail.com',
                     to: 'awslearning781@gmail.com',
                     subject: "Build Successful",
                     body: "Good News Build Success. "
        }
    
        failure {
            emailext from: 'yashmane9872@gmail.com',
                     to: "awslearning781@gmail.com",
                     subject: "Build Failed",
                     body: "Bad News Build Failed"
        }
}
