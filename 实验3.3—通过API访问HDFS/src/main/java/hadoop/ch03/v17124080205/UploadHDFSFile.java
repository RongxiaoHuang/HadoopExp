package hadoop.ch03.v17124080205;

import com.google.inject.internal.util.$Lists;
import com.google.inject.internal.util.$ToStringBuilder;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.lang.reflect.Type;
import java.net.URI;

public class UploadHDFSFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        //配置 NameNode 地址，具体根据你的 NameNode IP 配置
        URI uri = new URI("hdfs://192.168.30.130:8020");
        //指定用户名，获取FileSystem对象
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        //定义本地路径
        Path srcPath =new Path("D:/hr.txt");
        //定义hdfs路径
        Path dfs = new Path("/17124080205");
        //从本地上传到hdfs
        fs.copyFromLocalFile(srcPath,dfs);

    }
}