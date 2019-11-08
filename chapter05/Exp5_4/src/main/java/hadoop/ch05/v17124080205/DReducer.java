package hadoop.ch05.v17124080205;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DReducer extends Reducer<NullWritable,DDA,NullWritable,Text> {

    @Override
    protected void reduce(NullWritable k3, Iterable<DDA> v3,
                          Context context) throws IOException, InterruptedException {
        String line=null;
        for (DDA v : v3) {
            line = v.toString();
            context.write(k3, new Text(line));
        }
    }
}