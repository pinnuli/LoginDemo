package com.pinnuli.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @description: 邮件发工具类
 * @author: pinnuli
 * @date: 2018-4-25
 */

public class MailUtil implements Runnable {

    /**
     * 收件人邮箱
     */
    private String email;

    /**
     * 激活码
     */
    private String code;

    public MailUtil(String email, String code) {
        this.email = email;
        this.code = code;
    }

    @Override
    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件

        // 发件人电子邮箱
        String from = "1192161354@qq.com";
        // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
        String host = "smtp.qq.com";

        // 获取系统属性,设置邮件服务器,打开认证
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);


            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1192161354@qq.com", "fyvpyxyrurxjhjge");
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/loginDemo/active?code="
                    + code + "'>http://localhost:8080/loginDemo/active?code=" + code
                    + "</href></h3></body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
