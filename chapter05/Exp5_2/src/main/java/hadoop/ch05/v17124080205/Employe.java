package hadoop.ch05.v17124080205;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

//定义Employee类实现序列化接口
public class Employe implements Writable{

    //字段名 EMPNO, ENAME,    JOB,   MGR,   HIREDATE,  SAL, COMM, DEPTNO
    //数据类型：Int，Char，          Char  ， Int，     Date  ，       Int   Int，  Int
    //数据: 7654, MARTIN, SALESMAN, 7698, 1981/9/28, 1250, 1400, 30

    //由以上定义变量
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;//奖金
    private int deptno;



    @Override
    public String toString() {
//		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + "]";
        return empno+","+ename+","+job+","+mgr+","+hiredate+","+sal+","+comm+","+deptno;
    }
    //序列化方法：将java对象转化为可跨机器传输数据流（二进制串/字节）的一种技术
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.empno);
        out.writeUTF(this.ename);
        out.writeUTF(this.job);
        out.writeInt(this.mgr);
        out.writeUTF(this.hiredate);
        out.writeInt(this.sal);
        out.writeInt(this.comm);
        out.writeInt(this.deptno);

    }
    //反序列化方法：将可跨机器传输数据流（二进制串）转化为java对象的一种技术
    public void readFields(DataInput in) throws IOException {
        this.empno = in.readInt();
        this.ename = in.readUTF();
        this.job = in.readUTF();
        this.mgr = in.readInt();
        this.hiredate = in.readUTF();
        this.sal = in.readInt();
        this.comm = in.readInt();
        this.deptno = in.readInt();
    }
    //其他类通过set/get方法操作变量：Source-->Generator Getters and Setters
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getMgr() {
        return mgr;
    }
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    public String getHiredate() {
        return hiredate;
    }
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    public int getSal() {
        return sal;
    }
    public void setSal(int sal) {
        this.sal = sal;
    }
    public int getComm() {
        return comm;
    }
    public void setComm(int comm) {
        this.comm = comm;
    }
    public int getDeptno() {
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}

