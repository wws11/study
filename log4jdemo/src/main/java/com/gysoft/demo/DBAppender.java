package com.gysoft.demo;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 14:22
 */
public class DBAppender  extends AppenderSkeleton {


    LogService  logService=new LogService();
    @Override
    protected void append(LoggingEvent loggingEvent) {
        Log log=null;
        ThrowableInformation throwableInformation = loggingEvent.getThrowableInformation();
        if (throwableInformation != null) {
            LocationInfo locationInfo = loggingEvent.getLocationInformation();
            Throwable throwable = throwableInformation.getThrowable();
        System.out.println(loggingEvent.toString());
        //记录日志的基本信息

     try {
       log= new Log();
         log.setClassName(loggingEvent.getLocationInformation().getClassName());
         log.setFileName(loggingEvent.getLocationInformation().getFileName());
         log.setLineNumber(loggingEvent.getLocationInformation().getLineNumber());
         log.setMethodName(loggingEvent.getLocationInformation().getMethodName());
         log.setServerIp(getIp());
         log.setLogName(loggingEvent.getLoggerName());
         log.setLogLevel(loggingEvent.getLogger().getLevel().toString());
         log.setLogThread(loggingEvent.getThreadName());
         log.setLogMills(new Date(loggingEvent.getTimeStamp()));
         log.setLogMessage(loggingEvent.getMessage().toString());
         log.setThrowMessage(throwable.getMessage());
         log.setThrowDetailMessage(throwable.toString());
         log.setThrowStackTrace(throwable.getStackTrace().toString());
     }catch (Exception e){
         errorHandler.error("日志信息封装异常");
     }
        System.out.println(log.toString());
        logService.saveLog(log);
    }
    }


    public void close() {

    }

    public boolean requiresLayout() {
        return false;
    }

    private String getIp() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr.getHostAddress();
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress.getHostAddress();
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress.getHostAddress();
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException(
                    "Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
