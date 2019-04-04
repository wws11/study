package tools;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/4 11:58
 */
public class StringUtils {


    public static void main(String[] args) {


        String str = appendStr("hello", "dddd", "hah");
        System.out.println(str);
    }
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    private static  String getFileSuffix(String fileName) {
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(splitIndex + 1);
    }
    /**
     * 字符串拼接
     *
     */

    public static   String  appendStr(String ...strs){
        StringBuilder builder = new StringBuilder();

        for(int i=0;i<strs.length;i++){
            builder.append(strs[i]);
}

        return  builder.toString();
    }



}
