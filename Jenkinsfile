pipeline {
    agent any

    stages {
        stage("Preparation") {
            steps {
                echo 'Download updates'
                git 'https://github.com/VitaErm/homework.git'
            }
        }
        stage("Unit tests") {
            steps {
                bat 'mvn clean -DsuiteXmlFile=unit-testng.xml test'
            }
        }
        stage("UI tests") {
            steps {
                bat 'mvn clean -DsuiteXmlFile=chromeLocal-testng.xml test'
            }
        }
        stage("Deploy") {
            steps {
                echo 'Deployed'
            }
        }
    }
}
post{
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])

            }
        }
    }
}