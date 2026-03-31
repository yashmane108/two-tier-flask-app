def call(String status) {
   if (status == "SUCCESS") {
       emailext(
           from: 'yashmane9872@gmail.com',
           to: 'awslearning781@gmail.com',
           subject: "Build Successful",
           body: "Good News Build Success."
       )
   } else if (status == "FAILURE") {
       emailext(
           from: 'yashmane9872@gmail.com',
           to: 'awslearning781@gmail.com',
           subject: "Build Failed",
           body: "Bad News Build Failed"
       )
   }
}
