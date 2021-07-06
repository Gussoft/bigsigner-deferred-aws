package pe.bigprime.utils;

import pe.bigprime.utils.provider.KmsProvider;
import pe.bigprime.utils.provider.rsa.KmsRSAKeyFactory;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;

public class SignatureOperations {


    public String signHashKms(byte[] hash) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, InvalidKeyException, SignatureException {
        AwsCredentialsProvider awsCredentials = AwsServices.connectAwsProvider();
        KmsClient kmsClient = KmsClient.builder().region(Region.US_EAST_1).credentialsProvider(awsCredentials).build();

        KmsProvider kmsProvider = new KmsProvider(kmsClient);
        Security.addProvider(kmsProvider);

        KeyStore keyStore = KeyStore.getInstance("KMS", kmsProvider);
        keyStore.load(null, null);

        KeyPair keyPair = KmsRSAKeyFactory.getKeyPair(kmsClient, System.getenv("KEY_ID")); // ConfigFactory.load().getString("KEY_ID")

        Signature kmsSignature = Signature.getInstance("SHA256withRSA", kmsProvider);
        kmsSignature.initSign(keyPair.getPrivate());
        kmsSignature.update(hash);
        byte[] signatureBytes = kmsSignature.sign();
        String encoded = Base64.getEncoder().encodeToString(signatureBytes);
//        byte[] data = new byte[256];
//        Signature sig = Signature.getInstance("SHA256withRSA");
//        sig.initSign(keyPair.getPrivate());
//        sig.update(message.getBytes());
//        data = sig.sign();
//        String encoded = Base64.getEncoder().encodeToString(data);
//
//        System.out.println(String.format("Signature: %s", encoded));
//
//        Signature defaultSignature = Signature.getInstance("SHA256withRSA");
//        AlgorithmParameterSpec algorithmParameterSpec = null;
//        if (algorithmParameterSpec != null) {
//            defaultSignature.setParameter(algorithmParameterSpec);
//        }
//        defaultSignature.initVerify(((KmsPublicKey) keyPair.getPublic()).getPublicKey());
//        defaultSignature.update(message.getBytes());
//        valid = defaultSignature.verify(signatureBytes);
//
//        System.out.println(String.format("Verification via Default Provider: %s", valid));

        return encoded;
    }

}
