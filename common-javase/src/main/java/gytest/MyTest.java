package gytest;

import com.gysoft.bean.utils.Pair;
import com.gysoft.utils.jdbc.bean.Criteria;
import com.gysoft.utils.jdbc.sqlhelp.SqlMakeTools;
import com.gysoft.utils.util.date.MillUnit;
import com.gysoft.utils.util.proper.PropertiesReader;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 周宁
 * @Date 2018-06-15 17:22
 */
public class MyTest {

    public static void main(String[] args) {

        Criteria criteria = new Criteria();
        List<String> list = new ArrayList<>();
        list.add("hello");
        criteria.where("field0","第一个").gteIfAbsent("field1","").gt("field2","ss").inIfAbsent("3",new ArrayList<>()).notInIfAbsent("4",list).andIfAbsent("5","hahahah");
        Pair<String, Object[]> stringPair = SqlMakeTools.doCriteria(criteria, new StringBuilder("SELECT * FROM test "));

        IdName idName = IdName.builder().id("1").name("第一个").build();
        IdName idName2 = IdName.builder().id("1").name("第二个").build();
        IdName idName3 = IdName.builder().id("1").name("第三个").build();
        IdName idName4 = IdName.builder().id("3").name("第三个").build();
        IdName idName5 = IdName.builder().id("4").name("第四个").build();
        List<IdName> idNames = Arrays.asList(idName,idName2,idName3,idName4,idName5);
        Map<String,IdName> idNameMap = idNames.stream().collect(Collectors.toMap(IdName::getId,Function.identity(),(entity1, entity2) -> entity1));
        System.out.println(idNameMap);
        System.out.println(PropertiesReader.getInstance().getProperty("test.properties","test"));
        System.out.println(ArrayList.class.isAssignableFrom(Object.class));
        System.out.println(Object.class.isAssignableFrom(ArrayList.class));
        System.out.println(ArrayList.class.isAssignableFrom(ArrayList.class));

        System.out.println(MillUnit.DAY.getMills());
    }
   @Data
   @Builder
   static class IdName{

        private String id;

        private String name;
   }



}
