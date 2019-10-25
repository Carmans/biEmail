package com.huishang.resultToEmail;

import java.io.Serializable;

/**
 * 邮件发送信息
 * @author zhang_fei
 * @create 2019-10-22 15:01
 */

public class MailInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    // 收件人
    private String[] tos;
    // 抄送人
    private String[] copyto;
    // 附件地址
    private String fileAddress;
    // 附件名称
    private String fileName;
    // 主题
    private String subject;
    // 正文
    private String context;
}
