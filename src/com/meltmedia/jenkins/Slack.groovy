package com.meltmedia.jenkins;

class Slack {
    def script
    Slack(script) {this.script = script}
    def slackNotifyBuild(String url, String buildStatus = 'STARTED', String slackChannel = '#build-alerts') {

        // Default values
        def colorName = 'RED'
        def colorCode = '#FF0000'
        def summary = "${buildStatus}: ${url}"

        // Override default values based on build status
        if (buildStatus == 'STARTED') {
            // color = 'YELLOW'
            colorCode = '#FFFF00'
        } else if (buildStatus == 'SUCCESS') {
            // color = 'GREEN'
            colorCode = '#00FF00'
        } else {
            // color = 'RED'
            colorCode = '#FF0000'
        }

        // Send notifications
        script.slackSend (color: colorCode, message: summary, channel: slackChannel)
    }


}