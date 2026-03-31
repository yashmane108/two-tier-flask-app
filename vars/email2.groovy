def call(String status, String toEmail) {
   if (status == "SUCCESS") {
       emailext(
           from: 'yashmane9872@gmail.com',
           to: "${toEmail}",
           subject: "Build Successful",
           body: "Good News Build Success."
       )
   } else if (status == "FAILURE") {
       emailext(
           from: 'yashmane9872@gmail.com',
           to: "${toEmail}",
           subject: "Build Failed",
           body: "Bad News Build Failed"
       )
   }
}
