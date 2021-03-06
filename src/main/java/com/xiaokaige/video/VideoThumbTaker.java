package com.xiaokaige.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author reyo
 * FFMPEG homepage http://ffmpeg.org/about.html
 * By Google Get first and last thumb of a video using Java and FFMpeg
 * From http://www.codereye.com/2010/05/get-first-and-last-thumb-of-video-using.html
 */

public class VideoThumbTaker
{
    protected String ffmpegApp;

    public VideoThumbTaker(String ffmpegApp)
    {
        this.ffmpegApp = ffmpegApp;
    }

    @SuppressWarnings("unused")
    /****
     * 获取指定时间内的图片
     * @param videoFilename:视频路径
     * @param thumbFilename:图片保存路径
     * @param width:图片长
     * @param height:图片宽
     * @param hour:指定时
     * @param min:指定分
     * @param sec:指定秒
     * @throws IOException
     * @throws InterruptedException
     */
    public void getThumb(String videoFilename, String thumbFilename, int width,
            int height, int hour, int min, float sec) throws IOException,
            InterruptedException
    {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegApp, "-y",
                "-i", videoFilename, "-vframes", "1", "-ss", hour + ":" + min
                        + ":" + sec, "-f", "mjpeg", "-s", width + "*" + height,
                "-an", thumbFilename);

        Process process = processBuilder.start();

        InputStream stderr = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
            ;
        process.waitFor();
        
        if(br != null)
            br.close();
        if(isr != null)
            isr.close();
        if(stderr != null)
            stderr.close();
    }

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        VideoThumbTaker videoThumbTaker = new VideoThumbTaker("D:\\ideaProject\\teststst\\src\\main\\java\\com\\im\\ffmpeg.plugin");
        try
        {
            videoThumbTaker.getThumb("C:\\Users\\Admin\\Desktop\\20211018_sight_3891456.mp4", "C:\\Users\\Admin\\Desktop\\videoFirst.jpg",800, 600, 0, 0, 3f);
            System.out.println("over");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}