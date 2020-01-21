pipeline {
  agent any
  parameters {
        string(defaultValue: '1.0', description: 'releaseversion', name: 'ReleaseVersion')
    }
  stages {
    stage('Application Checkout From Git') {
      steps {
        git(url: 'https://github.com/repo-gsr/ShopingCart_MultiBranch_Pipeline.git', branch: 'master', changelog: true)
      }
    }
    stage('Application Build') {
      steps {
        bat 'mvn clean install -Dreversion=1.0 -Dverbose=true -Dmaven.test.skip=true'
      }
    }
    stage('Application Junit Test') {
      steps {
        bat 'mvn test -Dreversion=1.0 -Dverbose=true'
      }
    }
    stage('Application Code Coverage') {
      steps {
          step([$class: 'JacocoPublisher', 
          execPattern: 'target/*.exec',
          classPattern: 'target/classes',
          sourcePattern: 'src/main/java',
          exclusionPattern: 'src/test*'
        ])
      }
    }
  }
}
