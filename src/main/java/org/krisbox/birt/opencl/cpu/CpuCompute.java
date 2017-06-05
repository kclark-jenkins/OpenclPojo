package org.krisbox.birt.opencl.cpu;

import org.krisbox.birt.opencl.utils.DictionaryReader;
import org.krisbox.birt.opencl.utils.ExecTimer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CpuCompute {
    private DictionaryReader dictionary;
    private List<Future<byte[]>> hashes;
    private ExecTimer timer;

    public CpuCompute() {
        try {
            timer = new ExecTimer();
            hashes = new ArrayList<Future<byte[]>>();
            dictionary = new DictionaryReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void computeHashes() {
        timer.startTimer();

        ExecutorService executor = Executors.newFixedThreadPool(2000);

        for(int i=0; i<dictionary.size; i++) {
            CpuSha worker = new CpuSha(dictionary.get(i));
            Future<byte[]> currentHash = executor.submit(worker);
            hashes.add(currentHash);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        timer.endTimer();
        timer.printExecTime();
        timer.clearTimer();
    }

    public List<Future<byte[]>> getHashes() {
        return hashes;
    }

    public List<String> getDictionary() {
        return dictionary.getDictionary();
    }
}
