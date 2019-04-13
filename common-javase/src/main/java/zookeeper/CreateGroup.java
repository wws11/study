package zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/12 14:50
 */
public class CreateGroup implements Watcher {
    //会话超时
    private static int SESSION_TIMEOUT = 1000;
    private ZooKeeper zk = null;

    //同步计数器
    private CountDownLatch countDownLatch = new CountDownLatch(1);


    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            //计数器减一
            countDownLatch.countDown();
            /**
             * 补充：每次调用这个方法在构造函数中初始化的count就会减一，所以当n个线程都调用了这个方法，count的值等于0.然后主线程就能通过await方法
             * ，恢复执行自己的任务
             */
        }
    }

    /**
     * 创建zk对象
     * 当客户端；连接上zookeeper时会执行process（event）里面的countDownLatch.countDown().计数器的值变为零，则
     * countdownLatch.await()方法返回
     *
     * @param hosts
     * @throws Exception
     */

    public void connect(String hosts) throws Exception {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        //阻止程序继续执行
        countDownLatch.await();
        /**
         * 补充：使用了同步计数器CountDownLatch，在connect方法中创建执行了
         * zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);之后，下边
         * 接着调用了CountDownLatch对象的await方法阻塞，因为这是zk客户端不
         * 一定已经完成了与服务端的连接，在客户端连接到服务端时会触发观察者调
         * 用process()方法，我们在方法里边判断一下触发事件的类型，完成连接后
         * 计数器减一，connect方法中解除阻塞。
         *
         * 还有两个地方需要注意：这里创建的znode的访问权限是open的，且该znode是持久化存储的。
         */
    }


    /**
     * 创建 group
     *
     * @param groupName
     * @throws Exception
     */
    public void create(String groupName) throws Exception {
        String path = "/" + groupName;
        String createPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE/*允许任何客户端对该znode进行读写*/,
                CreateMode.PERSISTENT/*持久化的znode*/);
        System.out.println("Created " + createPath);
    }

    /**
     * 关闭zk
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {

        if (zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                throw e;
            } finally {
                zk = null;
                System.gc();
            }
        }

    }

}
