package test.threadtest;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/15 15:20
 */
public class Demo {


    public static void main(String[] args) {


        ExecutorService service = Executors.newCachedThreadPool();

        int arrs[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CopyOnWriteArraySet<AtomicInteger> nUb = getNUb();
        Runnable runnable0 = new Runnable() {
            //设置一把锁轮流去写
            @Override
            public void run() {
                    //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }

            };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable4 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable5 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };

        Runnable runnable6 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable7 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable8 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };
        Runnable runnable9 = new Runnable() {
            @Override
            public void run() { //每次随机从数组里获取值，并删除，保证唯一
                    nUb.forEach(random->{
                        //写完以后将集合中的数据删除
                        //文件的写入
                        try {
                            FileOutputStream fis=new FileOutputStream("C:\\Users\\DELL\\Desktop\\新建文件夹\\filewrite\\" +random+".txt");
                            DataOutputStream out=new DataOutputStream(fis);
                            int i = random.intValue();
                            out.write((byte)i);
                            out.close();
                            System.out.println(random + "号文件写入成功");
                            nUb.remove(random);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }
        };

        service.execute(runnable0);
        service.execute(runnable1);
        service.execute(runnable2);
        service.execute(runnable3);
        service.execute(runnable4);
        service.execute(runnable5);
        service.execute(runnable6);
        service.execute(runnable7);
        service.execute(runnable8);
        service.execute(runnable9);


    }

    public static void byte2file(String path,byte[] data) throws IOException {
        /*FileWriter writer=new FileWriter(path,true);
        riter.write("\n\t"+time);
                                writer.close();*/
        /*try {
            FileOutputStream outputStream  =new FileOutputStream(new File(path));
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static int[] remove(int[] arr, int num) {
        int[] tmp = new int[arr.length - 1];
        int idx = 0;
        boolean hasRemove = false;
        for (int i = 0; i < arr.length; i++) {
            if (!hasRemove && arr[i] == num) {
                hasRemove = true;
                continue;
            }
            tmp[idx++] = arr[i];
        }

        return tmp;
    }

    public static CopyOnWriteArraySet   getNUb(){
       Random ran=new Random();
//方法一：
        CopyOnWriteArraySet<AtomicInteger> set=new CopyOnWriteArraySet<AtomicInteger>();//set中的元素是不能重复的
        while(set.size() <10)
        {
            int n=ran.nextInt(10);//产生0-9之间的随机数
            AtomicInteger atomicInteger = new AtomicInteger(n);
            set.add(atomicInteger);//添加到set中。set中元素不能重复，因此重复的元素添加不进去
        }

        return set;
    }




    }
