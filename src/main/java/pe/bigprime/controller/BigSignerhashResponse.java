package pe.bigprime.controller;

import lombok.Data;

@Data
public class BigSignerhashResponse {
    private String hash;
    private String signedHash;
    private String status;

    public BigSignerhashResponse() {
    }

    public BigSignerhashResponse(String hash, String signedHash, String status) {
        this.hash = hash;
        this.signedHash = signedHash;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" + "hash='" + hash + '\'' + ", signedHash='" + signedHash + '\'' +
                ", status='" + status + '\'' + '}';
    }
}
