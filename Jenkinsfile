pipeline {
agent any

```
environment {
    JAVA_HOME = tool 'JDK21'
    PATH = "${JAVA_HOME}\\bin;${env.PATH}"
}

stages {

    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Build Order Service') {
        steps {
            dir('order-service') {
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }
    }

    stage('Test Order Service') {
        steps {
            dir('order-service') {
                bat 'mvnw.cmd test'
            }
        }
    }

    stage('Build Inventory Service') {
        steps {
            dir('inventory-service') {
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }
    }

    stage('Test Inventory Service') {
        steps {
            dir('inventory-service') {
                bat 'mvnw.cmd test'
            }
        }
    }

    stage('Docker Build') {
        steps {
            bat 'docker compose build'
        }
    }
}

post {
    success {
        echo 'CI Pipeline completed successfully.'
    }

    failure {
        echo 'CI Pipeline failed. Check the stage logs.'
    }

    always {
        echo 'Pipeline execution completed.'
    }
}
```

}
