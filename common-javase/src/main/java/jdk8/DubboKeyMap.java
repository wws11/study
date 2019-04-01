package jdk8;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/30 16:17
 */
public class DubboKeyMap {


    @Test
    public  void  test(){
   Book book=new Book();

//解决空指针问题
        book=null;
        Optional.ofNullable(book).orElseGet(Book::new).getId();
      book.getId();
    }
}
