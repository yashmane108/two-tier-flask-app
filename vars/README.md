# Jenkins Shared Library – For My YouTube CI/CD Tutorial Series

This repository contains the **Jenkins Shared Libraries** used in my YouTube tutorial series.  
It is designed to help beginners understand how to reuse Groovy functions, clean up Jenkinsfiles, and build scalable CI/CD pipelines.
---

# 📘 What This Repo Contains
Reusable Groovy scripts stored in `vars/`, used across Jenkins pipelines.

---

# 📂 Folder Structure

```
github-shared-lib-jenkins
│
└── vars/
    ├── hello.groovy
    ├── hello2.groovy
    ├── customLog.groovy
    └── dockerBuildPush.groovy
```

---

# 🧩 Included Shared Library Functions

### **1. hello.groovy**
Basic hello world.

```groovy
def call() {
    echo "Hello, World!"
}
```

---

### **2. hello2.groovy**
Personalized greeting.

```groovy
def call(String name = "User") {
    echo "Hello, ${name}! Welcome to Jenkins Shared Library."
}
```

---

### **3. customLog.groovy**
Formatted log blocks.

```groovy
def call(String msg) {
    echo "===================="
    echo "   ${msg}"
    echo "===================="
}
```

---

### **4. dockerBuildPush.groovy**
Reusable Docker build & push logic.

```groovy
def call(String imageName) {
    stage('Docker Build & Push') {
        withCredentials([usernamePassword(credentialsId: 'DockerHub',
                                           usernameVariable: 'USER',
                                           passwordVariable: 'PASS')]) {
            sh '''
               echo "$PASS" | docker login -u "$USER" --password-stdin
               docker build -t ${imageName} .
               docker push ${imageName}
            '''
        }
    }
}
```

---

# 🧪 Examples Section

### **Example 1: Using all functions in a Jenkinsfile**
```groovy
@Library('github-shared-lib-jenkins') _

pipeline {
    agent any

    stages {
        stage('Demo') {
            steps {
                hello()
                hello2("Shubham")
                customLog("Starting Build Pipeline")
                dockerBuildPush("theshubhamgour/demo-app:latest")
            }
        }
    }
}
```

---

### **Example 2: Only Docker Build + Push**
```groovy
@Library('github-shared-lib-jenkins') _

pipeline {
    agent any

    stages {
        stage("Build & Push") {
            steps {
                dockerBuildPush("theshubhamgour/app:1.0")
            }
        }
    }
}
```

---

# 🎥 YouTube Series
This repo is part of my full Jenkins tutorial series:

📺 **Watch here:**  
https://www.youtube.com/watch?v=4FS4s2PBqMI&list=PLBr8obKbpkYvJEaPmrzhHhwx8uPj8WYbg  

---

# ⭐ Support the Channel
If this repo helped you, please ⭐ **star the repo** and subscribe to the channel! 🙌
