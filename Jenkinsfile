pipeline {
    agent any
    parameters {
        string(name: 'AS_LAUNCH_ID', defaultValue: '', description: '')
        string(name: 'AS_EXECUTION_ID', defaultValue: '', description: '')
    }
    stages {
        stage('Build') {
          steps {
            withAllureUpload(serverId: 'local_home', projectId: '5', results: [[path: 'target/allure-results']]) {
                 sh "./mvnw -Dmaven.test.failure.ignore clean test"
            }
          }
       }
    }
}
