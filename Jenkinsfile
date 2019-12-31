pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/repo-gsr/ShopingCart_MultiBranch_Pipeline.git', branch: 'master', changelog: true)
      }
    }
    stage('Build Application') {
      steps {
        bat 'mvn clean install'
      }
    }
  }
}