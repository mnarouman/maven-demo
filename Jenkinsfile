node {
   def mvnHome
   stage('Preparation') { // for display purposes
	  // Properties
	  properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5'))])
	  
      // Get some code from a GitHub repository
      git 'w:/maven/multi/'
   
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${env.MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore -DtestType=ALL -DfailIfNoTests=false -U -Dsonar.skipPackageDesign=true clean install checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs sonar:sonar -Dproject.build.sourceEncoding="ISO-8859-1""
      } else {
         bat(/"${env.MAVEN_HOME}\bin\mvn" -Dmaven.test.failure.ignore -DtestType=ALL -DfailIfNoTests=false -U -Dsonar.skipPackageDesign=true clean install checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs sonar:sonar -Dproject.build.sourceEncoding="UTF-8"/)
      }
   }
   stage('Tests') {
      junit '**/target/surefire-reports/TEST-*.xml'
   }
   
   stage('archiveArtifacts') {
        archiveArtifacts '**/target/*.jar'
   }
   
    stage('Quality') {
        // Junit publisher
        junit '**/target/**/TEST-*.xml'
                
        // Checkstyle publisher            
        checkstyle 	pattern: '**/checkstyle-result.xml', 
					canComputeNew: false, 
					defaultEncoding: '', 
					healthy: '', 
					unHealthy: ''
        
        // PMD publisher
        pmd pattern: '**/pmd.xml', 
			canComputeNew: false, 
			defaultEncoding: '', 
			healthy: '', 
			unHealthy: ''
        
        // CPD publisher
		dry pattern: '**/cpd.xml', 
			canComputeNew: false, 
			defaultEncoding: '', 
			healthy: '', 
			unHealthy: ''
		
		// Findbugs publisher
        findbugs pattern: '**/findbugsXml.xml', 
				canComputeNew: false, 
				defaultEncoding: '', 
				excludePattern: '', 
				healthy: '', 
				includePattern: '', 
				unHealthy: ''
        
        // Open tasks publisher
		openTasks high: 'FIXME', 
					low: '@Deprecated', 
					normal: 'TODO', 
					pattern: '**/*.java', 
					excludePattern: '', 
					canComputeNew: false, 
					defaultEncoding: '', 
					healthy: '', 
					unHealthy: ''
		
		// Check dependencies publisher
		dependencyCheckPublisher pattern: '**/dependency-check-report.xml',
								canComputeNew: false, 
								defaultEncoding: '', 
								healthy: '', 
								unHealthy: ''
		      
		// Analysis Publisher
        step([$class: 'AnalysisPublisher', 
                isCheckStyleDeactivated: false,
                isDryDeactivated: false,
                isFindBugsDeactivated: false,
                isPmdDeactivated: false,
                isOpenTasksDeactivated: false,
                isWarningsDeactivated: true,
                isAndroidLintDeactivated: true])
                
    }
	
	stage('Code Coverage') {
		jacoco classPattern: '**/classes',
				execPattern: '**/**.exec',
				sourcePattern: '**/src/main/java',
				exclusionPattern: '',
				inclusionPattern: ''
	}
	
	stage('SonarQube analysis') {
		// requires SonarQube Scanner 2.8+
		// Name in 'SonarQube Scanner' Jenkins global tools configuration
		def scannerHome = tool 'SonarScan';
		// Name in 'SonarQube servers' Jenkins configuration
		withSonarQubeEnv('SonarQube') {
			if (isUnix()) {
				sh "'${scannerHome}/bin/sonar-scanner'"
			} else {
				bat(/"${scannerHome}\bin\sonar-scanner"/)
			}
		}
	}
	
//	stage('Container Scan'){
//		aquaMicroscanner imageName: 'registry.gitlab.com/linguangrun/spring-boot-docker:latest', notCompliesCmd: '', onDisallowed: 'ignore'
//	}

}