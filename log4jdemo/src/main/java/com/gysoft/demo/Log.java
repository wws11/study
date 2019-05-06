package com.gysoft.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description  记录的信息
 * @Author DJZ-WWS
 * @Date 2019/5/6 14:17
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {


  private String className;

  private  String  fileName;

  private  String lineNumber;

  private   String  methodName;
  private   String serverIp;
  private  String  logName;
  private   String  logLevel;
  private   String  logThread;
   /**
    * 日志时间
    */
  private Date  logMills;

  private String  logMessage;
  private  String  throwMessage;
  private  String   throwDetailMessage;
  private  String  throwStackTrace;


   /*
   异常日志的基本信息
  .field("fileName", locationInfo.getFileName())
  .field("lineNumber", locationInfo.getLineNumber())
  .field("methodName", locationInfo.getMethodName())
  .field("serverIp", getIp())
  .field("logName", event.getLogger().getName())
  .field("logLevel", event.getLevel())
  .field("logThread", event.getThreadName())
  .field("logMills", new Date(event.getTimeStamp()))
  .field("logMessage", event.getMessage().toString())
  .field("throwMessage", throwable.getMessage())
  .field("throwDetailMessage", throwable.toString())
  .field("throwStackTrace", throwable.getStackTrace())*/

}
