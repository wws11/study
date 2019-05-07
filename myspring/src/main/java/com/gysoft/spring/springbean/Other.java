package com.gysoft.spring.springbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description   这个对象没有被spring初始化，测试bean后置处理器是否会作用它
 * @Author DJZ-WWS
 * @Date 2019/5/6 20:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Other {


private   String  name;
private   String  email;
private   int  age;
}
