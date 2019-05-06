package com.rabbitmq.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/29 10:21
 */

@Configuration
public class MqConfig {

	/*<rabbit:queue id="queue" name="SpringRabbit-Topics-Queue" durable="true" auto-delete="false" exclusive="false"/>

 	<!--
    绑定队列
    rabbitmq的exchangeType常用的三种模式：direct，fanout，topic三种,此处为direct模式，即rabbit:direct-exchange标签，
    Direct交换器很简单，如果是Direct类型，就会将消息中的RoutingKey与该Exchange关联的所有Binding中的BindingKey进行比较，如果相等，
    则发送到该Binding对应的Queue中。有一个需要注意的地方：如果找不到指定的exchange，就会报错。
    但routing key找不到的话，不会报错，这条消息会直接丢失，所以此处要小心,
    auto-delete:自动删除，如果为Yes，则该交换机所有队列queue删除后，自动删除交换机，默认为false
 	-->
 	<rabbit:topic-exchange name="SpringRabbit-Topic-Exchange" auto-declare="true" auto-delete="false">
 		<rabbit:bindings>
 			<!--
    符号“#”匹配一个或多个词，符号“*”仅匹配一个词
    如：因此“china.#”能够匹配到“china.news.info”，但是“china.*”只会匹配到“china.news”
            -->
 			<rabbit:binding queue="queue" pattern="china.#"></rabbit:binding>
 		</rabbit:bindings>
 	</rabbit:topic-exchange>

 	<!-- spring template声明 -->
 	<rabbit:template id="rabbitTemplate" connection-factory="connectionFactory" exchange="SpringRabbit-Topic-Exchange"/>

	<!-- 生产者 -->
	<bean id="producter" class="com.rabbitmq.producter.Producter">
		<constructor-arg name="rabbitTemplate" ref="rabbitTemplate"/>
		<constructor-arg name="routekey" value="china.news"/>
	</bean>

	<!-- 消费者  -->
 	<bean id="consumer" class="com.rabbitmq.consumer.Consumer"/>*/


	 	/*<rabbit:connection-factory id="connectionFactory" host="${rmq.host}" port="${rmq.port}"
    username="${rmq.user}" password="${rmq.password}" virtual-host="${rmq.virtual}"
    channel-cache-size="${rmq.channelCacheSize}" cache-mode="CHANNEL"/>
 	<rabbit:admin connection-factory="connectionFactory"/>
*//*
    @Bean
    public ConnectionFactory connectionFactory() {
        com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();

        // 配置连接信息
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        // 网络异常自动连接恢复
        connectionFactory.setAutomaticRecoveryEnabled(true);
        // 每10秒尝试重试连接一次
        connectionFactory.setNetworkRecoveryInterval(10000);

        // 设置ConnectionFactory属性信息
        Map<String, Object> connectionFactoryPropertiesMap = new HashMap();
        connectionFactoryPropertiesMap.put("principal", "RobertoHuang");
        connectionFactoryPropertiesMap.put("description", "RGP订单系统V2.0");
        connectionFactoryPropertiesMap.put("emailAddress", "RobertoHuang@foxmail.com");
        connectionFactory.setClientProperties(connectionFactoryPropertiesMap);

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

*/

}
