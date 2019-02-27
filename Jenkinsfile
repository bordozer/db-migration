pipeline {
	agent any
	environment {
	    WAR_NAME = 'dbmigration.war'
        WAR_PATH = 'build/libs'
        DEPLOYMENT_PATH='/opt/oraclebase/deployments'
        BRANCH_TO_DEPLOY = 'master' 
        DEV_SERVER_1 = 'fsawildflyd1'
        WILDFLY_SERVER_GROUP = 'Liquibase'
    }
	options {
		gitLabConnection('njros1lz539')
	}
	parameters {
        booleanParam(name: 'DB_MIGRATION', defaultValue: false, description: 'Please choose ENABLED if you want to run DB migration by pipeline')
    }
	triggers {
		gitlab(
			triggerOnPush: true,
			triggerOnMergeRequest: false,
			triggerOnNoteRequest: false,
			noteRegex: ".*[Jj]enkins rebuild.*",
			setBuildDescription: true,
			addNoteOnMergeRequest: false,
			addCiMessage: true,
			branchFilterType: 'All'
		)
	}
	stages {
		stage("build") {
			steps {
				script {
					echo "-----------------------------------------------------------------------------------------------"
					echo "Build"
					sh "bash ./gradlew --version"
					sh "bash ./gradlew clean build -x check"
					}

			}
		}
		stage("SCA") {
			steps {
				script {
					echo "-----------------------------------------------------------------------------------------------"
					sh "bash ./gradlew checkstyleMain checkstyleTest pmdMain pmdTest spotbugsMain spotbugsTest"
					}

			}
		}
		stage("Unit tests") {
			steps {
				script {
					echo "-----------------------------------------------------------------------------------------------"
					sh "bash ./gradlew test"
					}

			}
		}
		stage("DB Migration") {
            when {
                expression { DB_MIGRATION == "true" }
            }
            steps {
                echo "-----------------------------------------------------------------------------------------------"
                echo "Executing DB Migration"
                script {
                    echo "bash ./gradlew dbMigration update"
                    sh "bash ./gradlew dbMigration update"
                }
            }
        }
		stage("deploy to dev1") {
		    when { branch "$BRANCH_TO_DEPLOY" }
			steps {
					sh "scp $WAR_PATH/$WAR_NAME oracle@$DEV_SERVER_1:/opt/oraclebase/deployments"
					sh '''
                    ssh oracle@$DEV_SERVER_1 "export JAVA_HOME=/usr/jdk1.8.0_144/ && /opt/oraclebase/wildfly/wildfly-12.0.0.Final/bin/jboss-cli.sh <<EOF
                    connect
                    if (outcome==\\"success\\") of /deployment=$WAR_NAME:query
                        deploy /opt/oraclebase/deployments/$WAR_NAME --force
                    else
                        deploy /opt/oraclebase/deployments/$WAR_NAME --server-groups=$WILDFLY_SERVER_GROUP
                    end-if
                    EOF"
					'''
			}
		}
	}
	post {
		failure {
			updateGitlabCommitStatus name: 'build', state: 'failed'
		}
		success {
			updateGitlabCommitStatus name: 'build', state: 'success'
		}
		always {
			junit 'build/test-results/test/*.xml'
		}
	}
}
