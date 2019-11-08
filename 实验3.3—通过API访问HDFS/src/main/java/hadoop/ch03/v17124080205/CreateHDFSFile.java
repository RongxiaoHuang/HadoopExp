package hadoop.ch03.v17124080205;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import java.net.URI;
public class CreateHDFSFile {
    public static void main(String[]args) throws Exception{
        Configuration conf = new Configuration();
        //配置NameNode地址
        URI uri = new URI("hdfs://192.168.30.130:8020");
        //制定用户名，获取FileSystem对象
        FileSystem fs = FileSystem.get(uri,conf,"hadoop");
        //定义文件路径
        Path dfs = new Path("/17124080205/test2.txt");
        //根据文件路径创建文件
        FSDataOutputStream os = fs.create(dfs,true);
        //往文件写入信息
        os.writeBytes("hello,hdfs!");
        //关闭流
        os.close();
        //关闭FileSystem
        fs.close();
    }
}
