package pe.bigprime.utils.provider;

import java.security.PublicKey;

public interface KmsPublicKey extends KmsKey {

    PublicKey getPublicKey();

}
