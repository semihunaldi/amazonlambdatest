on root dir:
    mvn package shade:shade

and upload generated jar to AWS Lambda
handler as : com.semihunaldi.amazon.LambdaTest::lambdaTestHandler