package hadoop.ch05.v17124080205;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalaryTotalMapper extends Mapper< LongWritable, Text, NullWritable,  Employe> {

    @Override
    protected void map(LongWritable k1, Text v1,
                       Context context)
            throws IOException, InterruptedException {
        //数据：7499,ALLEN,SALESMAN,7698,1981/2/20,1600,300,30
        String data = v1.toString();
        String[] words = data.split(",");

        //创建员工对象
        Employe emp = new Employe();
        //设置员工属性
        emp.setEmpno(Integer.parseInt(words[0]));

        emp.setEname(words[1]);

        emp.setJob(words[2]);

        try {
            emp.setMgr(Integer.parseInt(words[3]));//可能为空,加try...catch包围
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        emp.setHiredate(words[4]);

        emp.setSal(Integer.parseInt(words[5]));

        try {
            emp.setComm(Integer.parseInt(words[6]));//可能为空
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        emp.setDeptno(Integer.parseInt(words[7]));

        //取出部门号words[7]，将String转换为Int，Int转换为IntWritable对象，赋值为k2
        NullWritable k2 = NullWritable.get();
        //取出工资words[5]，将String转换为Int，Int转换为IntWritable对象，赋值为v2
        Employe v2 = emp;
        //输出k2, v2
        context.write(k2, v2);
    }
}
