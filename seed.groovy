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
        }
       steps {
           shell('echo "Hello from freestylejob"')
       }
       publishers {
           wsCleanup()
       }
}

pipelineJob('jobdsltest_pipeline') {
    description('BLABLA')
    logRotator {
      daysToKeep(7)
    }
    triggers {
      cron('@daily')
    }
    definition {
        cps {
            script(readFileFromWorkspace('groovy_jobs/pipeline.groovy'))
            sandbox()
        }
    }
 }
