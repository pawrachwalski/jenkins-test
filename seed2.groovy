def names = [ "number1, number2, number3"]

names.each{jobname->
pipelineJob("jobdsltest_pipeline_$jobname") {
    description('BLABLA')
    logRotator {
      daysToKeep(7)
    }
    triggers {
      cron('@daily')
    }
    definition {
        cps {
            script(readFileFromWorkspace('groovy_jobs/tool_mailman.groovy'))
            sandbox()
        }
    }
 }
}
