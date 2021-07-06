package pe.bigprime.utils;


import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class AwsServices {

    static final String ACCESS_KEY = System.getenv("ID");//AWS_ACCESS_ID
    static final String ACCESS_SECRET = System.getenv("PASS");

    public static AwsCredentialsProvider connectAwsProvider(){
        AwsCredentialsProvider credentialsProvider = new AwsCredentialsProvider() {
            @Override
            public AwsCredentials resolveCredentials() {
                return new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return ACCESS_KEY;
                    }

                    @Override
                    public String secretAccessKey() {
                        return ACCESS_SECRET;
                    }
                };
            }
        };
        return credentialsProvider;
    }
}
