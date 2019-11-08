package hadoop.ch05.v17124080205;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class DDA implements Writable{
    private String date;
    private String a;
    private String name;
    private int URL;
    private int Dian;
    private String b;
    @Override
    public String toString() {
        return date+","+ a+","+name+","+URL+","+Dian+","+b;
    }
    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.date);
        out.writeUTF(this.a);
        out.writeUTF(this.name);
        out.writeInt(this.URL);
        out.writeInt(this.Dian);
        out.writeUTF(this.b);

    }
    public void readFields(DataInput in) throws IOException {
        this.date = in.readUTF();
        this.a = in.readUTF();
        this.name = in.readUTF();
        this.URL = in.readInt();
        this.Dian = in.readInt();
        this.b = in.readUTF();
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {

        this.date= date;
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getURL() {
        return URL;
    }
    public void setURL(int URL) {
        this.URL = URL;
    }

    public int getDian() {
        return Dian;
    }
    public void setDian(int Dian) {
        this.Dian= Dian;
    }
}
