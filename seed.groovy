listView('jenkins-test-jobs') {
  description('Generated jobs from job dsl.')
  recurse()
  jobs {
      regex('jobdsltest.*')
      }
  columns {
    status()
    weather()
    name()
    lastSuccess()
    lastFailure()
    lastDuration()
    buildButton()
  }
}

freeStyleJob('jobdsltest_freestyle_job') {
    description('dummy job for presenting jobdsl')
       logRotator {
           numToKeep(5)
       }
       label('master')
       wrappers {
           preBuildCleanup()
           timestamps()
           colorizeOutput('xterm')
        }
       steps {
           sh 'echo "Hello from freestylejob"'
       }
       publishers {
           wsCleanup()
       }
}

pipelineJob('jobdsltest_pipeline') {
    description(readFileFromWorkspace('messages/tool_mailman.msg'))
    logRotator {
      daysToKeep(7)
    }
    triggers {
      cron('H 17 * * 1-5')
    }
    definition {
        cps {
            script(readFileFromWorkspace('groovy_scripts/tool_mailman.groovy'))
            sandbox()
        }
    }
 }
