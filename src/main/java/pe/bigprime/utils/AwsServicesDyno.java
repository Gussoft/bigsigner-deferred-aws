package pe.bigprime.utils;

import com.amazonaws.auth.AWSCredentials;

public class AwsServicesDyno {

    static final String ACCESS_KEY = System.getenv("AWS_ACCESS_KEY2");
    static final String ACCESS_SECRET = System.getenv("AWS_SECRET_KEY2");


    public static AWSCredentials connectAws() {
        return new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return ACCESS_KEY;
            }

            @Override
            public String getAWSSecretKey() {
                return ACCESS_SECRET;
            }
        };
    }
}