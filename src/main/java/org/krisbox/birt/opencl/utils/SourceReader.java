package org.krisbox.birt.opencl.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SourceReader {
    private String src;

    public SourceReader() {
        src = new String();
    }

    public SourceReader(String src) {
        this.src = src;
    }

    public String readSource() {
        return readFile(src);
    }

    public String readSource(String src) {
        return readFile(src);
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String readFile(String filename) {
        try {
            return FileUtils.readFileToString(new File(getClass().getClassLoader().getResource(filename).getFile()), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
