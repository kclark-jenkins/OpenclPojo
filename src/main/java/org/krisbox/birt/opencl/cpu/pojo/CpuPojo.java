package org.krisbox.birt.opencl.cpu.pojo;

import org.krisbox.birt.opencl.cpu.CpuCompute;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CpuPojo {
    private CpuCompute      cpu    = new CpuCompute();
    private List<CpuHashes> hashes = new ArrayList<CpuHashes>();

    public CpuPojo() {
        cpu.computeHashes();

        List<Future<byte[]>> allHashes = cpu.getHashes();
        List<String>         allWords  = cpu.getDictionary();

        for(int i=0; i<cpu.getHashes().size(); i++) {
            CpuHashes currentHash = new CpuHashes();
            try {
                currentHash.setHash(allHashes.get(i).get().toString());
                currentHash.setWord(allWords.get(i));
                hashes.add(currentHash);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public int size() {
        return hashes.size();
    }
}
