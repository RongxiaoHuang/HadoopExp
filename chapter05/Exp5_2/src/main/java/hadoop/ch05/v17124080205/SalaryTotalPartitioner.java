package hadoop.ch05.v17124080205;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;
//                                    map-outputs:k2,v2-->NullWritable, Employee
public class SalaryTotalPartitioner extends Partitioner<NullWritable, Employe>{

    @Override
    public int getPartition(NullWritable k2, Employe v2, int numPatition) {

        //如何分区: 每个部门放在一个分区
        if(v2.getSal() < 1500) {
            //放入1号分区中
            return 1%numPatition;// 1%3=1
        }else if(v2.getSal() >=1500 && v2.getSal() < 3000){
            //放入2号分区中
            return 2%numPatition;// 2%3=2
        }else {
            //放入3号分区中
            return 3%numPatition;// 3%3=0
        }
    }
}
