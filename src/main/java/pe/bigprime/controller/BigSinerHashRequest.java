package pe.bigprime.controller;

public class BigSinerHashRequest {
    private String hash;
    private String signedHash;

    public BigSinerHashRequest() {

    }

    public BigSinerHashRequest(String hash, String signedHash) {
        this.hash = hash;
        this.signedHash = signedHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSignedHash() {
        return signedHash;
    }

    public void setSignedHash(String signedHash) {
        this.signedHash = signedHash;
    }

    @Override
    public String toString() {
        return "{" +
                "hash='" + hash + '\'' +
                ", signedHash='" + signedHash + '\'' +
                '}';
    }
}
