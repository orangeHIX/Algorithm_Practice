package com.creaty.javaclass.student_managment.message;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hyx on 2016/1/16.
 */
public class MessageSender {

    // 发送次数
    public static final int SEND_NUM = 1;
    // tcp 地址
    public static final String BROKER_URL = "tcp://localhost:61616";
    // 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
    public static final String DESTINATION = "hyx";

    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 0; i < SEND_NUM; i++) {
            String message = "发送消息第" + (i + 1) + "条";
            TextMessage text = session.createTextMessage(message);

            System.out.println(message);
            producer.send(text);
        }
    }

    public static void send(String message) throws Exception {

        Connection connection = null;
        Session session = null;
        try {
            // 创建链接工厂
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createConnection();
            // 启动连接
            connection.start();
            // 创建一个session会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            Destination destination = session.createQueue(DESTINATION);
            // 创建消息制作者
            MessageProducer producer = session.createProducer(destination);
            // 设置持久化模式
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //sendMessage(session, producer);
            TextMessage textMessage = session.createTextMessage(message);
            producer.send(textMessage);
            // 提交会话
            session.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //MessageSender.send();
    }
}