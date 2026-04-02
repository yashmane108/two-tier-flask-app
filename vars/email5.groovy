def call(Map config = [:]) {

   def status = config.status ?: "SUCCESS"
   def to = config.to ?: "darkcyprus101@gmail.com"
   def subject = config.subject ?: "${env.JOB_NAME} #${env.BUILD_NUMBER}"

   def body = """
   Status: ${status}
   Job: ${env.JOB_NAME}
   Build: ${env.BUILD_NUMBER}
   URL: ${env.BUILD_URL}
   """

   emailext(
       to: to,
       subject: subject,
       body: body,
       attachLog: true
   )
}
