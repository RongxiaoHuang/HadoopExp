package hadoop.ch09.v17124080205;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class zkAPI {

    public static void main(String[] args) throws Exception {
        listener();
        operate();
        Thread.sleep(2000);
    }
    public static void listener() throws Exception{
        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper(ZookeeperConstant.URL, 2000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了2" + event.getType() + "事件！" + event);
            }
        });
        zk.exists("/stu17124080205", new Watcher(){
            public void process(WatchedEvent event) {
                System.out.println("已经触发了3" + event.getType() + "事件！" + event);
            }
        });
        zk.exists("/stu17124080205", true);
    }
    private static void operate() throws Exception {
        ZooKeeper zk = new ZooKeeper(ZookeeperConstant.URL, 2000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });
        if(zk.exists("/stu17124080205", false) != null){
            zk.delete("/stu17124080205", -1);/*-1表示任何版本*/
        }
        // 创建一个目录节点
        zk.create("/stu17124080205", "abcd".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
/*

	    // 创建一个子目录节点
	    zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	    System.out.println(new String(zk.getData("/testRootPath", false, null)));

		// 取出子目录节点列表
	    System.out.println(zk.getChildren("/testRootPath", true));

*/
        byte[] data1 = zk.getData("/stu17124080205",true,null);/*null表示最新版本*/
        System.out.println(new String(data1));
        // 修改目录节点数据
        zk.setData("/stu17124080205", "1234".getBytes(), -1);
        System.out.println("目录节点状态：[" + zk.exists("/stu17124080205", true) + "]");

        byte[] data = zk.getData("/stu17124080205", true, null);
        System.out.println(new String(data));
/*
		// 创建另外一个子目录节点
		zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));

		// 创建另外一个子目录节点
		zk.create("/testRootPath/testChildPathThree", "testChildDataThree".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

		System.out.println(new String(zk.getData("/testRootPath/testChildPathThree", true, null)));

		// 删除子目录节点
		zk.delete("/testRootPath/testChildPathTwo", -1);
		zk.delete("/testRootPath/testChildPathOne", -1);
*/
        // 关闭连接
        zk.close();
    }

}
