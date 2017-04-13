import com.amazonaws.services.lambda.runtime.Client;
import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.common.collect.Maps;
import com.semihunaldi.amazon.LambdaTest;
import com.semihunaldi.amazon.model.SampleResponse;
import org.junit.Test;

import java.util.Map;

/**
 * Created by semih on 14.04.2017.
 * AWS Lambda Context testing
 */
public class LambdaTestTest
{
    @Test
    public void test()
    {
        LambdaTest lambdaTest = new LambdaTest();
        Map<String,String> inputKeyValue = Maps.newHashMap();
        inputKeyValue.put("test","Hello AWS Lambda");
        SampleResponse sampleResponse = lambdaTest.lambdaTestHandler(inputKeyValue,getAWSContext());
        System.out.println(sampleResponse.toString());
    }

    private Context getAWSContext()
    {
        return new Context()
        {
            public String getAwsRequestId()
            {
                return "AwsRequestId";
            }

            public String getLogGroupName()
            {
                return "LogGroupName";
            }

            public String getLogStreamName()
            {
                return "LogStreamName";
            }

            public String getFunctionName()
            {
                return "FunctionName";
            }

            public String getFunctionVersion()
            {
                return "FunctionVersion";
            }

            public String getInvokedFunctionArn()
            {
                return "InvokedFunctionArn";
            }

            public CognitoIdentity getIdentity()
            {
                return new CognitoIdentity()
                {
                    public String getIdentityId()
                    {
                        return "IdentityId";
                    }

                    public String getIdentityPoolId()
                    {
                        return "IdentityPoolId";
                    }
                };
            }

            public ClientContext getClientContext()
            {
                return new ClientContext()
                {
                    public Client getClient()
                    {
                        return new Client()
                        {
                            public String getInstallationId()
                            {
                                return "InstallationId";
                            }

                            public String getAppTitle()
                            {
                                return "AppTitle";
                            }

                            public String getAppVersionName()
                            {
                                return "AppVersionName";
                            }

                            public String getAppVersionCode()
                            {
                                return "AppVersionCode";
                            }

                            public String getAppPackageName()
                            {
                                return "AppPackageName";
                            }
                        };
                    }

                    public Map<String, String> getCustom()
                    {
                        return Maps.newHashMap();
                    }

                    public Map<String, String> getEnvironment()
                    {
                        return Maps.newHashMap();
                    }
                };
            }

            public int getRemainingTimeInMillis()
            {
                return 300;
            }

            public int getMemoryLimitInMB()
            {
                return 34;
            }

            public LambdaLogger getLogger()
            {
                return System.out::println;
            }
        };
    }
}
