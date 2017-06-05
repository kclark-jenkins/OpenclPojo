import org.krisbox.birt.opencl.cpu.CpuCompute;
import org.krisbox.birt.opencl.cpu.pojo.CpuPojo;
import org.krisbox.birt.opencl.utils.DictionaryReader;
import org.krisbox.birt.opencl.utils.SourceReader;

import java.io.IOException;

public class Test {
    private String       srcFile = "joclPojo.cl";
    private SourceReader src;
    private CpuPojo cpuPojo;

    public Test() throws IOException {
        src = new SourceReader(srcFile);
        cpuPojo = new CpuPojo();
        System.out.println(cpuPojo.size());
    }

    public static void main(String[] args) {
        try {
            new Test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
