package com.semihunaldi.amazon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * Created by Semih on 13.04.2017.
 * SampleResponse Class
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class SampleResponse
{
    private String awsRequestId;
    private String functionVersion;
    private int memoryLimitInMB;
    private int remainingTimeInMillis;
    private String functionName;
    private String appTitle;
    private String identityId;

    private String test;
}
