package tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/13 11:35
 */
public class TreeTest {


    public static void main(String[] args) {
    //test("C:\\Users\\DELL\\Desktop\\2.1");
        String helloWord = getLowCaseName("HelloWord");
        System.out.println(helloWord);
    }


    private static void test(String fileDir) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
     // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                test(f.getAbsolutePath());
            }
        }
        for (File f1 : fileList) {
            System.out.println(f1.getName());
        }
    }

    //解析Class文件
    private   static  void resoverClass(String  path){
        File file = new File(path);
        File[] files = file.listFiles();

        for (File f: files) {
            if(f.isFile()){
                //是个文件
                //获取类名，将其转为小写
            }else{

                //是个文件夹
            }
        }
    }


    private static String   getLowCaseName(String name){
      if(Character.isLowerCase(name.charAt(0))){
          return name;
      }
      else{
        return   new StringBuilder().append(Character.toLowerCase(name.charAt(0))).append(name.substring(1)).toString();
      }

    }
}
