package hadoop.ch05.v17124080205;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SoldReduce extends Reducer<Text, Sold, Text, Text> {
    protected void reduce(Text k3, Iterable<Sold> v3, Context context) throws IOException, InterruptedException {
        int total1 = 0;
        float total2 = 0;
        for (Sold sold : v3) {
            total1 = total1 + sold.getQuantity_sold();
            total2 = total2 + sold.getAmount_sold();
        }
        String total = "销售笔数:" + Integer.toString(total1) + "," + "销售总额:" + Float.toString(total2);
        context.write(k3, new Text(total));
    }
}