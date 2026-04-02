def call(Map config) {
   def status = config.status
   def toEmail = config.to
   def jobName = env.JOB_NAME
   def buildNumber = env.BUILD_NUMBER
   def buildUrl = env.BUILD_URL
