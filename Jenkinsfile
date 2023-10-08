    pipeline {
    agent any
    tools {
        maven "MAVEN3"
        jdk "OracleJDK17"
    }

    environment {
        registryCredential = 'ecr:ap-south-1:JENKINS_IAM_USER_CREDENTIAL'
        appRegistry = "832806402466.dkr.ecr.ap-south-1.amazonaws.com/spring-api"
        springProfileRegistry = "https://832806402466.dkr.ecr.ap-south-1.amazonaws.com"
    }
    stages {

        // stage('Fetch code'){
        //     steps {
        //     git branch: 'main', url: 'https://github.com/Kuppusamy-R/hospital-api.git'
        //     }
        // }

        // stage('Test'){
        //   steps {
        //     sh 'mvn test'
        //   }
        // }

        // stage ('CODE ANALYSIS WITH CHECKSTYLE'){
        //     steps {
        //         sh 'mvn checkstyle:checkstyle'
        //     }
        //     post {
        //         success {
        //             echo 'Generated Analysis Result'
        //         }
        //     }
        // }

        // stage('build && SonarQube analysis') {
        //     environment {
        //      scannerHome = tool 'sonar4.7'
        //   }
        //     steps {
        //         withSonarQubeEnv('sonar') {
        //          sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=vprofile \
        //            -Dsonar.projectName=vprofile-repo \
        //            -Dsonar.projectVersion=1.0 \
        //            -Dsonar.sources=src/ \
        //            -Dsonar.java.binaries=target/test-classes/com/visualpathit/account/controllerTest/ \
        //            -Dsonar.junit.reportsPath=target/surefire-reports/ \
        //            -Dsonar.jacoco.reportsPath=target/jacoco.exec \
        //            -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml'''
        //         }
        //     }
        // }

        // stage("Quality Gate") { 
        //     steps {
        //         timeout(time: 1, unit: 'HOURS') {
        //             // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
        //             // true = set pipeline to UNSTABLE, false = don't
        //             waitForQualityGate abortPipeline: true
        //         }
        //     }
        // }

        stage('Build App Image') {
            steps {
                sh "pwd"
                sh "ls"
                sh "echo '${appRegistry}:${BUILD_NUMBER}'"
                // script {
                //     dockerImage = docker.build( appRegistry + ":$BUILD_NUMBER", ".")
                //     }

            }

        }

        stage('Upload App Image') {
            // steps{
            // script {
            //     // docker.withRegistry( springProfileRegistry, registryCredential ) {
            //     // dockerImage.push("$BUILD_NUMBER")
            //     // dockerImage.push('latest')
            //     // }
            // }
            // }
        }

    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }

    }