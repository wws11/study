package com.gysoft.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 21:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

private  String  unitName;
private  String  userNmae;
private   String  password;
private   Integer unitUserCount;

}
