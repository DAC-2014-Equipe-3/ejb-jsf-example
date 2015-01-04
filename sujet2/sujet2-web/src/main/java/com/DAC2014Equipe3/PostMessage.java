/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAC2014Equipe3;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean(name = "postMessage")
@RequestScoped
public class PostMessage {

    @Resource(mappedName = "jms/NewMessageFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/NewMessage")
    private Queue queue;

    NewsEntity e;

    /**
     * Creates a new instance of PostMessage
     */
    public PostMessage() {
        e = new NewsEntity();
    }

    public NewsEntity getE() {
        return e;
    }

    public void setE(NewsEntity e) {
        this.e = e;
    }

    public String request() {
        String ret="error";
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);

            ObjectMessage message = session.createObjectMessage();

            message.setObject(e);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();
//            response.sendRedirect("ListNews");
            //TODO Show List News
            ret="page2";
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
        return ret;
    }
}
