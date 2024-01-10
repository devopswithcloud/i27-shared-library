import com.i27academy.builds.Calculator

def call(Map pipelineParams){
    library("com.i27academy.slb")
    Calculator calculator = new Calculator(this)
    pipeline {
        agent any 
        environment {
            APP_NAME = "${pipelineParams.appName}"
        }
        stages {
            stage ('AdditionStage') {
                steps {
                    script {
                        echo "Printing Sum of 2 numbers"
                        println calculator.add(3,4)
                        //sub(10,9) // 10-9 = 1
                        //sub(9,10) //9-10 = -1
                        echo "Microservice Name is: ${APP_NAME}"
                    }
                }
            }
            stage ('Nothing') {
                steps {
                    echo "Printing text not from groovy files"
                }
            }
        }
    }
}

