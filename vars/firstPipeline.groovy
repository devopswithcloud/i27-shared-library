import com.i27academy.builds.Calculator
Calculator calculator = new Calculator(this)
pipeline {
    agent any 
    stages {
        stage ('AdditionStage') {
            steps {
                script {
                    echo "Printing Sum of 2 numbers"
                    println calculator.add(3,4)
                    //sub(10,9) // 10-9 = 1
                    //sub(9,10) //9-10 = -1
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