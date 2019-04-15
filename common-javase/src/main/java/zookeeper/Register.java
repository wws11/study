package zookeeper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/12 14:47
 */
public class Register {


    private static String hosts = "192.168.3.227";
    private static String groupName = "zoo";
    private CreateGroup createGroup = null;


    //https://www.cnblogs.com/leocook/p/zk_0.html
    @Before
    public void init() throws Exception {
        createGroup = new CreateGroup();
        createGroup.connect(hosts);
    }

    @Test
    public void testCreateCroup() throws Exception {
        createGroup.create(groupName);
    }

    /**
     * 销毁资源
     */
    @After
    public  void  destory(){
        try {
            createGroup.close();
            createGroup = null;
            System.gc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
