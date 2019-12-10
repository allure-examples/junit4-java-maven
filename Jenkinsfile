pipeline {
    agent any
    parameters {
        string(name: 'AS_LAUNCH_ID', defaultValue: '', description: '')
        string(name: 'AS_EXECUTION_ID', defaultValue: '', description: '')
    }
    stages {
        stage('Build') {
          steps {
            withAllureUpload(serverId: 'qameta-local',
                             projectId: '5',
                             name: '${JOB_NAME} - #${BUILD_NUMBER}',
                             tags: '${JOB_NAME}+JU any; windows; pile;;pipe',
                             results: [[path: 'target/allure-results']]) {
                 sh "./mvnw -Dmaven.test.failure.ignore clean test"
            }
          }
       }
    }
}
