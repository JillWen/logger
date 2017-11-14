package com.jill.logger.LogProducer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jill.logger.LogProducer.RandomDataGenerator.*;

/**
 *  具体内容-登录信息
 */
@Component
@Scope("prototype")
public class LoginInfoLog implements LogContent{
    /**
     * 登录ID
     */
    private String loginId;

    /**
     *  登录IP
     */
    private String loginIP;

    /**
     *  登录设备
     */
    private String loginDevice;

    /**
     *  登录时间
     */
    private String loginTime;

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }


    @Override
    public String getContent() {
        this.setLoginId("id" + getRandomInt(1000000,2000000));
        this.setLoginIP(getRandomIp());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setLoginTime(dateFormat.format(date));
        this.setLoginDevice(getRandomDevice());
        String content = String.join(",",loginId,loginIP, loginDevice, loginTime);
        return content;
    }
}
