package com.qencode.api.java.client;

import com.qencode.api.java.client.classes.TranscodingTask;
import com.qencode.api.java.client.classes.TranscodingTaskStatus;
import com.qencode.api.java.client.classes.VideoStatus;
import com.qencode.api.java.client.response.StartEncodeResponse;
import org.junit.Test;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QencodeClientTest {

    public static final String TEST_API_KEY = "5a2a846a26ace";
    public static final String TEST_TRANSCODING_PROFILE_ID = "5a2a846a26e88";
    public static final String TEST_VIDEO_URL = "https://qa.qencode.com/static/1.mp4";
    //public static final String TEST_TRANSFER_METHOD_ID = "5a2a846a26ace";

    @Test
    public void testSimpleTranscode() throws QencodeException, UnsupportedEncodingException, InterruptedException {
        //QencodeApiClient client = new QencodeApiClient(TEST_API_KEY, "https://api-qa.qencode.com/v1");
        QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        assertNotNull(client.getAccessToken());
        System.out.println("Access Token: " + client.getAccessToken());

        TranscodingTask task = client.CreateTask();
        assertNotNull(task);
        System.out.println("Task Token: " + task.getTaskToken());
        task.setUri(TEST_VIDEO_URL);
        task.setTranscodingProfiles(TEST_TRANSCODING_PROFILE_ID);
        task.start();
        assertNotNull(task.getStatusUrl());
        System.out.println("Status URL: " + task.getStatusUrl());
        TranscodingTaskStatus response = null;
        NumberFormat formatter = new DecimalFormat("#0.00");
        do
        {
            TimeUnit.SECONDS.sleep(5);
            System.out.print("Checking status... ");
            response = task.getStatus();
            System.out.println(response.getStatus() + " - " + formatter.format(response.getPercent()));
        } while (!response.getStatus().equals("completed"));

        assertEquals(response.getStatus(), "completed");

        for (VideoStatus video: response.getVideos()) {
            System.out.println(video.getUserTag() + ": " + video.getUrl());
        }


    }
}
