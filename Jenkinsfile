pipeline{
    
    agent any;
    
    stages{
        stage("Code Clone"){
            steps{
                git url: "https://github.com/yashmane108/two-tier-flask-app.git", branch: "master"
            }
        }
        stage("Build"){
            steps{
                sh "docker build --no-cache -t my-flask ."
            }
        }
        stage("Test"){
            steps{
                echo "developer/tester likh kar dega"
            }
        }
        stage("push to docker hub"){
            steps{
                withCredentials([usernamePassword(
                credentialsId:"dockerhubcred",
                passwordVariable: "dockerHubPass",
                usernameVariable: "dockerHubUser"
                )]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag my-flask ${env.dockerHubUser}/my-flask-hub"
                sh "docker push ${env.dockerHubUser}/my-flask-hub:latest"
                }
            }
        }
        stage("Deploy"){
            steps{
                // sh "docker compose down"
                sh "docker compose up -d --build"
            }
        }
    }
}
