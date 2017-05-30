pipeline {
    agent { label 'java' }
    stages {
        stage("Build") {
            steps {
                sh './mvnw -Dmaven.test.failure.ignore=true clean verify'
            }
        }
        stage("Reports") {
            steps {
                allure([results: [[path: 'target/allure-results']], includeProperties: false, jdk: '',
                        properties: [], reportBuildPolicy: 'ALWAYS'])
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}