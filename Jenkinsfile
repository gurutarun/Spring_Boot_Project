pipeline {
    agent any
    parameters {
        booleanParam(name: 'executeTests', defaultValue: false, description: 'boolean value to execute tests or not')
    }
    stages {

        stage("build") {
            steps {
                echo 'building the application...!'
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'testing the application...!'
            }
        }
        stage("deploy") {
            steps {
                echo 'deploying the application...!'
            }
        }
    }
}