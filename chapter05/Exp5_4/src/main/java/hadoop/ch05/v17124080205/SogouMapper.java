package hadoop.ch05.v17124080205;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
public class SogouMapper extends Mapper<LongWritable,Text,Text,NullWritable> {
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        super.setup(context);
    }
    @Override
    protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
        String data = new String(v1.getBytes(), 0, v1.getLength(), "GBK");
        String words[] = data.split("\\s+");
        if (words.length != 6) {
            return;
        }
        String strs = "[·`……*_=+【\\[\\]】｛{}｝\\\\|、\\\\\\\\;‘'“”\\\"，《<。》>、?,]";
        String newData1 = data.replaceAll(strs, "");
        String newData = newData1.replaceAll("\\s+", ",");

        context.write(new Text(newData), NullWritable.get());
    }
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
    }
}