package com.xiaokaige.generateverifycode;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: zk
 * Date: 2021/10/20
 * Time: 15:26
 */
public class GenerateVerifyCode {
    public static void main(String[] args) {

        CaptchaConfig captchaConfig = new CaptchaConfig();
        DefaultKaptcha captchaProducer = captchaConfig.getKaptchaBean();
        DefaultKaptcha captchaProducerMath = captchaConfig.getKaptchaBeanMath();

        //String type = "math";
        String type = "char";
        String capStr;
        String code = null;
        BufferedImage bi = null;
        if ("math".equals(type)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf('@'));
            code = capText.substring(capText.lastIndexOf('@') + 1);
            bi = captchaProducerMath.createImage(capStr);
        } else if ("char".equals(type)) {
            capStr = code = captchaProducer.createText();
            bi = captchaProducer.createImage(capStr);
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Admin\\Desktop\\abc.jpg"));
            ImageIO.write(bi, "jpg", out);
            System.out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
