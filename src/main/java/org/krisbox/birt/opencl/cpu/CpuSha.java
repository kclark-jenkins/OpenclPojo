package org.krisbox.birt.opencl.cpu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CpuSha implements Callable<byte[]> {
    private String word;
    private byte[] hash;

    public CpuSha(String word) {
        this.word = word;
    }

    public byte[] getHash() {
        return hash;
    }

    public void run() {
        computeHash();
    }

    private void computeHash() {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");

            byte[] newHash = null;
            for(int j=1; j<=4096; j++) {
                if(newHash == null) {
                    newHash = digest.digest(word.getBytes());
                }else{
                    newHash = digest.digest(newHash);
                }
            }

            hash = newHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] call() {
        computeHash();

        return hash;
    }
}
