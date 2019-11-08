package hadoop.ch05.v17124080205;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class DMapper extends Mapper< LongWritable, Text, NullWritable,  DDA> {
    @Override
    protected void map(LongWritable k1, Text v1,
                       Context context)
            throws IOException, InterruptedException {
        String data = v1.toString();
        String[] words = data.split(",");
        DDA emp = new DDA();
        //14:12:59,8627889269710522,小游戏,4,11,www.game.com.cn/
        emp.setDate(words[0]);
        emp.setA(words[1]);
        emp.setName(words[2]);
        emp.setURL(Integer.parseInt(words[3]));
        emp.setDian(Integer.parseInt(words[4]));
        emp.setB(words[5]);
        NullWritable k2 = NullWritable.get();
        context.write(k2, emp);
    }
}
