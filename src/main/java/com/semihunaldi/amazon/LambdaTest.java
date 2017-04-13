package com.semihunaldi.amazon;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.semihunaldi.amazon.model.SampleResponse;

import java.util.Map;

/**
 * Created by semih on 13.04.2017.
 * AWS Lambda handler testing class
 */
public class LambdaTest
{
    public SampleResponse lambdaTestHandler(Map<String,String> inputKeyValue, Context context) throws JsonProcessingException
    {
        String test = inputKeyValue.get("test");
        SampleResponse sampleResponse = new SampleResponse();
        if(context != null)
        {
            context.getLogger().log("Context logger test");
            sampleResponse.setAwsRequestId(context.getAwsRequestId());
            sampleResponse.setFunctionVersion(context.getFunctionVersion());
            sampleResponse.setMemoryLimitInMB(context.getMemoryLimitInMB());
            sampleResponse.setRemainingTimeInMillis(context.getRemainingTimeInMillis());
            sampleResponse.setFunctionName(context.getFunctionName());
            sampleResponse.setTest(test != null ? test : "failed");
            if(context.getClientContext() != null && context.getClientContext().getClient() != null)
            {
                sampleResponse.setAppTitle(context.getClientContext().getClient().getAppTitle());
            }
            if(context.getIdentity() != null)
            {
                sampleResponse.setIdentityId(context.getIdentity().getIdentityId());
            }
            context.getLogger().log("Success");
        }
        return sampleResponse;
    }
}
