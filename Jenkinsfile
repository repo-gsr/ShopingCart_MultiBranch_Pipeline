pipeline {
  agent any
  stages {
    stage('Application Checkout From Git') {
      steps {
        git(url: 'https://github.com/repo-gsr/ShopingCart_MultiBranch_Pipeline.git', branch: 'master', changelog: true)
      }
    }
    stage('Application Build') {
      steps {
        bat 'mvn clean install -Dversion=1.0 -Dverbose=true -Dmaven.test.skip=true'
      }
    }
    stage('Application Junit Test') {
      steps {
        bat 'mvn test -Dversion=1.0 -Dverbose=true'
      }
    }
  }
}