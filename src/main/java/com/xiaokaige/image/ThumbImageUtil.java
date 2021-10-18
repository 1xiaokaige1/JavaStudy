package com.xiaokaige.image;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;

/**
 * @author: zk
 * Date: 2021/10/18
 * Time: 14:01
 * 按原图比例将图片压缩至指定的大小，得到缩略图
 */
public class ThumbImageUtil {
    public static byte[] compressPicCycle(byte[] bytes, long desFileSize, double accuracy) throws IOException {
        // 获取目标图片
        /*File imgFile = new File(desPath);
        long fileSize = imgFile.length();*/
        long fileSize = bytes.length;
        System.out.println("=====fileSize======== " + fileSize);
        // 判断图片大小是否小于指定图片大小
        if (fileSize <= desFileSize * 1024) {
            return bytes;
        }
        //计算宽高
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int imgWidth = bim.getWidth();
        System.out.println(imgWidth + "====imgWidth=====");
        int imgHeight = bim.getHeight();
        int desWidth = new BigDecimal(imgWidth).multiply(new BigDecimal(accuracy)).intValue();
        System.out.println(desWidth + "====desWidth=====");
        int desHeight = new BigDecimal(imgHeight).multiply(new BigDecimal(accuracy)).intValue();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
        Thumbnails.of(new ByteArrayInputStream(bytes)).size(desWidth, desHeight).outputQuality(accuracy).toOutputStream(baos);
        //如果不满足要求,递归直至满足要求
        return compressPicCycle(baos.toByteArray(), desFileSize, accuracy);
    }

    public static byte[] getImageStream(String imageUrl) {
        byte[] buffer = null;
        File file = new File(imageUrl);
        FileInputStream fis;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }


    public static void readBin2Image(byte[] byteArray, String targetPath) {
        InputStream in = new ByteArrayInputStream(byteArray);
        File file = new File(targetPath);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
