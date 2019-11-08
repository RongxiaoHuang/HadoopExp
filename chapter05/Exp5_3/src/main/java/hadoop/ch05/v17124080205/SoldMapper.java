package hadoop.ch05.v17124080205;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SoldMapper extends Mapper<LongWritable, Text, Text, Sold> {
    @Override
    protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
//字段名 prod_id,cust_id,time,channel_id,promo_id,quantity_sold,amount_sold
//数据类型：Int，Int，Date， Int，Int ，Int ,float(10,2),
//数据: 13,987,1998-01-10,3,999,1,1232.16
        String data = v1.toString();
        String[] words = data.split(",");
//数据: t1=987,1998-01-10,3,999,1,1232.16
        String t1 = StringUtils.substringAfter(data, ",");
//数据: t2=1998-01-10,3,999,1,1232.16 
        String t2 = StringUtils.substringAfter(t1, ",");
//取年份为偏移量，数据: words2[0]=1998，words2[1]=01，words2[2]=10,3,999,1,1232.16
        String[] words2 = t2.split("-");
//        StringUtils.substringAfter("dskeabcedeh", "e");
//        /*结果是：abcedeh*/
        Sold sold = new Sold();
        sold.setTime(words[2]);//数组word[]
        sold.setQuantity_sold(Integer.parseInt(words[5]));
        sold.setAmount_sold(Float.valueOf(words[6]));
        context.write(new Text(words2[0]), sold);//数组word2[],word2[0]代表年份作为k2
    }
}
