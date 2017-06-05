package org.krisbox.birt.opencl.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DictionaryReader {
    private final String       dictionaryFile;
    private final List<String> dictionary;
    public  final int          size;

    public DictionaryReader() throws IOException {
        dictionaryFile = new String("rockyou.txt");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(dictionaryFile).getFile());
        dictionary     = FileUtils.readLines(file);
        size           = dictionary.size();
    }

    public List<String> getDictionary() {

        return dictionary;
    }

    public String get(int index) {
        return dictionary.get(index);
    }

    public int size() {
        return dictionary.size();
    }
}