package com.rabbitmq.log.demo;


import org.apache.log4j.Logger;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 10:09
 */
public class DemoTest {


    private static Logger logger = (Logger) Logger.getLogger(DemoTest.class);


    public static void main(String[] args) {
        int  a=1;

        try {
            if(a==1){
                throw new  IllegalStateException("异常异常了");
            }
        } catch (Exception e) {
            logger.error("测试异常链的捕获 error", e);

        }

        logger.error("Demoe Test  ----error");

        logger.info("DemoTest----info");

        logger.info("DemoTest----debugger");
        logger.warn("Demotest -----warn");
        logger.trace("DemoTest----trace");
        logger.fatal("DemoTest -----fatal");

        /**     日志的级别
         *      ALL 所有日志的级别都包括。
         *      DEBUG  指定的信息事件的粒度是DEBUG，在调试应用的时候会有帮助。
         *      ERROR  指定错误事件，并且这些事件还会保证应用继续运行。
         *      FATAL  指定严重的错误事件，该事件会导致应用暂停。
         *      INFO  指定信息消息，强调应用粗粒度的运行情况。
         *      OFF  最高等级，相当于关闭了日志。
         *      TRACE  指定比DEBUG更粗粒度的调试日志。
         *      WARN  输出具有潜在风险的信息。
         */
    }
}
