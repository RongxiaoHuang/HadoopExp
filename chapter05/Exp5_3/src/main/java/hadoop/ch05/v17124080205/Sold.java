package hadoop.ch05.v17124080205;
import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
public class Sold implements Writable {
    //字段名 prod_id,cust_id,time,channel_id,promo_id,quantity_sold,amount_sold
// 数据类型：Int，Int，Date， Int，Int ，Int ,float(10,2),
    //数据: 13, 987, 1998/1/10, 3, 999,1, 1232.16
//由以上定义变量
    private int prod_id;
    private int cust_id;
    private String time;
    private int channel_id;
    private int promo_id;
    private int quantity_sold;
    private float amount_sold;//奖金


    //序列化方法：将java对象转化为可跨机器传输数据流（二进制串/字节）的一种技术
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.prod_id);
        out.writeInt(this.cust_id);
        out.writeUTF(this.time);
        out.writeInt(this.channel_id);
        out.writeInt(this.promo_id);
        out.writeInt(this.quantity_sold);
        out.writeFloat(this.amount_sold);

    }
    //反序列化方法：将可跨机器传输数据流（二进制串）转化为java对象的一种技术
    public void readFields(DataInput in) throws IOException {
        this.prod_id = in.readInt();
        this.cust_id = in.readInt();
        this.time = in.readUTF();
        this.channel_id = in.readInt();
        this.promo_id = in.readInt();
        this.quantity_sold = in.readInt();
        this.amount_sold = in.readFloat();
    }

    public int getProd_id() {
        return prod_id;
    }
    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
    public int getCust_id() {
        return cust_id;
    }
    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getChannel_id() {
        return channel_id;
    }
    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }
    public int getPromo_id() {
        return promo_id;
    }
    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }
    public int getQuantity_sold() {
        return quantity_sold;
    }
    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }
    public float getAmount_sold() {
        return amount_sold;
    }
    public void setAmount_sold(float amount_sold) {
        this.amount_sold = amount_sold;
    }

}