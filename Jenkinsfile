pipeline {
   agent any
   parameters {
        string(defaultValue: '1.0', description: 'releaseversion', name: 'ReleaseVersion')
        choice(choices: ['Checkout', 'Build','Junit Test', 'Code Coverage'], description: 'Stages to be executed', name: 'Stage')
    }
   environment {
     selected_stage = "${Stage}"
   }
   stages {
	   switch(selected_stage) {
	      case "Checkout":   
		   stage('Application Checkout From Git') {
		      steps {
		        git(url: 'https://github.com/repo-gsr/ShopingCart_MultiBranch_Pipeline.git', branch: 'master', changelog: true)
		      }
		    }
		    break
		  case "Build":
		    stage('Application Build') {
		      steps {
		        bat 'mvn clean install -Dreversion=1.0 -Dverbose=true -Dmaven.test.skip=true'
		      }
		    }
		    break
		  case "Junit Test":
		    stage('Application Junit Test') {
		      steps {
		        bat 'mvn test -Dreversion=1.0 -Dverbose=true'
		      }
		    }
		    break
		  case "Code Coverage":
		   stage('Application Code Coverage') {
		      steps {     
		        publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: '.\target\\site\\jacoco\\jacoco.xml', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
		      }
	       }
	       break
	       default:
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
			        publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: '.\target\\site\\jacoco\\jacoco.xml', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
			      }
			    }
    		    break
		  }
     }
}
