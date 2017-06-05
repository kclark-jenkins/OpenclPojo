package org.krisbox.birt.opencl.cpu.pojo;

public class CpuHashes {
    private String word;
    private String hash;

    public CpuHashes() {
        word = new String();
        hash = new String();
    }

    public String getWord() {
        return word;
    }

    public String getHash() {
        return hash;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
