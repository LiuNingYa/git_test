package com.liuning.testrabbitmq;

import com.liuning.utils.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class TopicProducer {
    public static final String EXCHANGE_NAME = "topic_exchange(主题)";
    public static final String QUEUE_NAME1 = "topic_queue1(队列1)";
    public static final String QUEUE_NAME2 = "topic_queue2(队列2)";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueDeclare(QUEUE_NAME1,true,false,false,null);
        channel.queueDeclare(QUEUE_NAME2,true,false,false,null);

        channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,"#.321.*");
        channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME,"#.123.*");
        channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME,"321.*");
//        channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,"321.*");

        String massge = "该消息发往第?个队列";
//        channel.basicPublish(EXCHANGE_NAME,"123.321.1",null,massge.getBytes());
//        channel.basicPublish(EXCHANGE_NAME,"123.1",null,"该消息发往第二个队列".getBytes());
//        channel.basicPublish(EXCHANGE_NAME,"111.123.1",null,"该消息发往第二个队列".getBytes());

        channel.basicPublish(EXCHANGE_NAME,"321.0",null,massge.getBytes());
        connection.close();
    }

}
