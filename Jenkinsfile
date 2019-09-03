pipeline {
    agent any
    stages {
        stage('Build') {
          withAllureUpload(serverId: 'local_home', projectId: 5, results: [[path: 'target/allure-results']]) {
             sh "./mvnw -Dmaven.test.failure.ignore clean test"
          }
       }
    }
}
