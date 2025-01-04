pipeline {
    agent any
    environment {
        SONARQUBE = 'SonarQube' // Configure SonarQube server in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kaushal-hirani/jenkins-cicd.git'
            }
        }
        stage('Code Quality Analysis') {
            steps {
                script {
                    // Run SonarQube analysis
                    def scannerHome = tool name: 'sonar-scanner', type: 'ToolType'
                    withSonarQubeEnv('SonarQube_Server_Name') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
        stage('Code Coverage') {
            steps {
                script {
                    // Assuming you're using a Java project with JaCoCo
                    sh 'mvn clean test jacoco:report'
                    junit '**/target/test-*.xml' // JUnit test results
                    jacoco()
                }
            }
        }
        stage('Cyclomatic Complexity') {
            steps {
                script {
                    // Run Lizard or other tool for cyclomatic complexity
                    sh 'lizard --output=complexity_report.txt src/'
                    publishText reports: [textReport('complexity_report.txt')]
                }
            }
        }
        stage('Security Scan') {
            steps {
                script {
                    // Run OWASP Dependency-Check
                    sh 'dependency-check --project my_project --scan ./'
                    publishHTML(target: [
                        reportName: 'Dependency Check Report',
                        reportDir: './dependency-check-report',
                        reportFiles: 'index.html'
                    ])
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
    post {
        success {
            emailext(
                subject: "Build Successful: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "The build was successful. Check Jenkins for more details.\n\n${env.BUILD_URL}",
                to: 'kaushalhirani007@gmail.com'
            )
        }
        failure {
            emailext(
                subject: "Build Failed: ${env.JOB_NAME} ${env.BUILD_NUMBER}",
                body: "The build failed. Please check the build logs for details.\n\n${env.BUILD_URL}",
                to: 'kaushalhirani007@gmail.com'
            )
        }
    }
}
