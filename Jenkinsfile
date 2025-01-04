pipeline {
    agent any  
    
    tools {  
        jdk 'JDK17'  
        maven 'Maven3'  
    }  
    
    stages {  
        stage('Git Checkout') {  
            steps {  
                git branch: 'main',   
                    credentialsId: 'github-credentials',   
                    url: 'https://github.com/kaushal-hirani/jenkins-cicd.git'  
            }  
        }  
        
        stage('Build') {  
            steps {  
                sh 'mvn clean install'  // Use install instead of compile for build & test  
            }  
        }  
        
        stage('Test') {  
            steps {  
                sh 'mvn test'  
            }  
            post {  
                always {  
                    junit '**/target/surefire-reports/*.xml'  // Ensure the path matches test report location  
                }  
            }  
        }  
        
        stage('SonarQube Analysis') {  
            steps {  
                withSonarQubeEnv('SonarServer') {  
                    sh 'mvn sonar:sonar'  
                }  
            }  
        }  
        
        stage('JaCoCo Coverage') {  
            steps {  
                jacoco execPattern: '**/target/jacoco.exec'  // Ensure the path matches generated coverage file  
            }  
        }  
        
        stage('Package') {  
            steps {  
                sh 'mvn package'  
            }  
        }  
    }  
    
    post {  
        success {  
            emailext (  
                subject: "Build Successful: ${currentBuild.fullDisplayName}",  
                body: "Great job! Build completed successfully.",  
                to: "kaushalhirani007@gmail.com"  
            )  
        }  
        failure {  
            emailext (  
                subject: "Build Failed: ${currentBuild.fullDisplayName}",  
                body: "Build failed. Please check the Jenkins console for details.",  
                to: "kaushalhirani007@gmail.com"  
            )  
        }  
    }  
}
