def call (String fCredID, String sCredID) {
    withCredentials([
        file(credentialsId: 'fCredID', variable: 'COSIGN_KEY'),
        string(credentialsId: 'sCredID', variable: 'COSIGN_PASSWORD')
    ]) {
        sh """
            export COSIGN_PASSWORD="$COSIGN_PASSWORD"
                        
            cosign sign --key "$COSIGN_KEY" yashmane108/simple-app:${env.Tag}
            """
    }
}
