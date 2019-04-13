package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/12 10:16
 */
public class TimeTools {


    //[{"date":"2018-03-26","count":0,"id":null},
    // {"date":"2018-03-29","count":0,"id":null},
    // {"date":"2018-03-30","count":1,"id":null},
    // {"date":"2018-03-31","count":2,"id":null}]
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Map<Date,Integer>  map=new HashMap<>();
      //需要转换的数据
        map.put(format.parse("2018-03-26 "),1);
        map.put(format.parse("2018-03-29 "),3);
        map.put(format.parse("2018-03-30 "),6);
        map.put(format.parse("2018-03-31 "),9);
        //需要转换的日期
        List<String>  dateList=new ArrayList<>();
        dateList.add("2018-03-26");
        dateList.add("2018-03-29");
        dateList.add("2018-03-30");
        dateList.add("2018-03-31");
        List<String> completionDate = completionDate(dateList, "2018-03-26", 6);
        completionDate.forEach(e-> System.out.println(e));
        for(String str:completionDate){
            //从根据日期从map去取，没有的话置零
            if ( map.get(format.parse(str))==null ){
                map.put(format.parse(str),0);
            }
        }
        //至此，数据转换完毕得到的map就是需要的数据
        //map结果输出
        for(Map.Entry<Date,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    /**
     *
     * @param list 日期list
     * @param begin 开始的日期
     * @param daySub 为开始到结束日期之间的总天数，
     * @return 返回的是补全后的日期
     */
    public static List<String> completionDate(List<String> list , String begin , int daySub){
        ArrayList<String> dateResult = new ArrayList<String>();
        //时间增加一天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, 1);
        String dateStr = sdf.format(yesterday.getTime());

        //日期比较(求差多少天)，时间也可以比较
        Calendar now = Calendar.getInstance();

        //字符串转化为时间
        Calendar calendar10 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        //循环处理日期数据，把缺失的日期补全。10是时间段内的天数,5是要处理的日期集合的天数
        try {
            Date date = sdf.parse(begin);
            calendar10.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(int curr = 0 ; curr < daySub ; curr++){

            boolean dbDataExist = false;
            int index = 0;
            for(int i  = 0 ; i < list.size() ; i++){
                try {
                    Date date2 = sdf.parse(list.get(i));
                    calendar5.setTime(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(calendar10.compareTo(calendar5) == 0){
                    dbDataExist  = true;
                    index = i;
                    break;
                }
            }
            if(dbDataExist){
                dateResult.add(list.get(index));
            }else{
                dateResult.add(sdf.format(calendar10.getTime()));
            }
            //还原calendar10
            calendar10.add(Calendar.DAY_OF_MONTH, 1 );
        }

        return dateResult;
    }


}
