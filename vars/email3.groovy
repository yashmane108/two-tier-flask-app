def call(Map config) {
   def status = config.status
   def toEmail = config.to
   def jobName = env.JOB_NAME
   def buildNumber = env.BUILD_NUMBER
   def buildUrl = env.BUILD_URL

   if (status == "SUCCESS") {
       emailext(
           to: toEmail,
           subject: "SUCCESS: ${jobName} #${buildNumber}",
           body: """
           Build Success ✅
           Job: ${jobName}
           Build: ${buildNumber}
           URL: ${buildUrl}
           """
       )
   } else {
       emailext(
           to: toEmail,
           subject: "FAILED: ${jobName} #${buildNumber}",
           body: """
           Build Failed ❌
           Job: ${jobName}
           Build: ${buildNumber}
           URL: ${buildUrl}
           """
       )
   }
}
