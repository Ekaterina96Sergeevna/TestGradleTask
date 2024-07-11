pipeline {
    agent any

    stages {
        stage('Run Kotlin Script') {
            steps {
                script {
                    sh "./gradlew runBinarySearch -PscriptArgs='$env.BUILD_NUMBER'"
                }
            }
        }
    }
}