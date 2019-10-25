package com.huishang.resultToEmail;/*
package com.huishang.resultToEmail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
*/
/**
 * 通过javaMail发送邮件
 * @author zhang_fei
 * @create 2019-10-22 15:06
 *//*

public class SendMailUtil {
    */
/*
     * 发送邮件到指定邮箱
     * 收件人，抄送人 ，附件地址，附件名称
     *//*

    public static void send(MailSetEntity mailSet, MailInfoEntity mailInfo) throws Exception {
        // 1.创建Session，包含邮件服务器网络连接信息
        Properties props = new Properties();
        // 指定邮件的传输协议，smtp;同时通过验证
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", mailSet.getAuth());
        Session session = Session.getDefaultInstance(props);
        // 开启调试模式
        session.setDebug(mailSet.getDebug());

        // 2.编辑邮件内容
        Message message = new MimeMessage(session);
        // 设置邮件消息头
        message.setFrom(new InternetAddress(mailSet.getFromAddress()));
        // 创建邮件接收者地址
        String[] tos = mailInfo.getTos();
        if (tos != null && tos.length != 0) {
            InternetAddress[] to = new InternetAddress[tos.length];
            // 设置邮件消息的发送者
            for (int i = 0; i < tos.length; i++) {
                to[i] = new InternetAddress(tos[i]);
            }
            message.setRecipients(Message.RecipientType.TO, to);
        }
        // 设置邮件抄送者地址
        String[] copyto = mailInfo.getCopyto();
        if (copyto != null && copyto.length != 0) {
            InternetAddress[] toCC = new InternetAddress[copyto.length];
            // 设置邮件消息的发送者
            for (int i = 0; i < copyto.length; i++) {
                toCC[i] = new InternetAddress(copyto[i]);
            }
            message.addRecipients(Message.RecipientType.CC, toCC);
        }

        // 设置主题
        message.setSubject(mailInfo.getSubject());
        // 设置邮件消息内容、包含附件
        Multipart msgPart = new MimeMultipart();
        message.setContent(msgPart);

        MimeBodyPart body = new MimeBodyPart();   // 正文
        MimeBodyPart attach = new MimeBodyPart(); // 附件

        msgPart.addBodyPart(body);
        msgPart.addBodyPart(attach);

        // 设置正文内容
        body.setContent(mailInfo.getContext(), "text/html;charset=utf-8");
        // 设置附件内容
        attach.setDataHandler(new DataHandler(new FileDataSource(mailInfo.getFileAddress())));
        attach.setFileName((MimeUtility.encodeText(mailInfo.getFileName())));

        message.saveChanges();

        // 3.发送邮件
        Transport trans = session.getTransport();
        trans.connect(mailSet.getSmtp(), mailSet.getFromAddress(), mailSet.getFromAddressPwd());
        trans.sendMessage(message, message.getAllRecipients());
    }
}
*/
