# CI/CD Pipeline Project  

## Project Overview  
This project demonstrates a robust Continuous Integration and Continuous Deployment (CI/CD) pipeline using Jenkins, SonarQube, and other DevOps tools.  

## 🛠 Tools and Technologies  
- Jenkins  
- SonarQube  
- Maven  
- Java  
- JUnit  
- JaCoCo  

## 📋 Pipeline Stages  
1. Source Code Checkout  
2. Compile  
3. Unit Testing  
4. Code Quality Analysis  
5. Security Scanning  
6. Build Artifact Generation  
7. Deployment Preparation  

## 🚀 Setup Instructions  

### Prerequisites  
- AWS EC2 Instance  
- Java 17  
- Maven  
- Jenkins  
- SonarQube  
- Docker (Optional)  

### Jenkins Installation  
```bash  
# Update system  
sudo apt update  
sudo apt upgrade -y  

# Install Java  
sudo apt install openjdk-17-jdk -y  

# Install Jenkins  
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -  
sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'  
sudo apt update  
sudo apt install jenkins -y  

# Start Jenkins  
sudo systemctl start jenkins  
sudo systemctl enable jenkins
```
### Sonarqube Installation  
```bash
# Install PostgreSQL  
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'  
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -  
sudo apt update  
sudo apt install postgresql postgresql-contrib -y  

# Install SonarQube  
wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.0.65466.zip  
unzip sonarqube-9.9.0.65466.zip  
sudo mv sonarqube-9.9.0.65466 /opt/sonarqube
```

