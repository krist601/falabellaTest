pipeline {
    agent any
    stages {
        stage('Kill all the demons before compilation') {
            steps {
                sh "./app/gradlew --stop"
            }
        }
        stage('Build Release bundle') {
            steps {
                sh "./app/gradlew clean bundleRelease --stacktrace"
            }
        }
        stage('Upload to Play Store') {
            steps {
                script {
                    def foldersList = []
                    def output = sh returnStdout: true, script: "ls -l app/build/outputs/bundle | grep ^d | awk '{print \$9}'"
                    foldersList = output.tokenize('\n').collect() { it }
                    for (int i = 0; i < foldersList.size(); ++i) {
                        androidApkUpload googleCredentialsId: 'GooglePlayKey', apkFilesPattern: "app/build/outputs/bundle/${foldersList[i]}/*.aab", trackName: 'production', rolloutPercentage: "100.0"
                    }
                }
            }
        }
        stage('Kill all the demons after compilation') {
            steps {
                sh "./app/gradlew --stop"
            }
        }
        stage('Delete all the build files') {
            steps {
                sh "rm -R app/build"
            }
        }
    }
}