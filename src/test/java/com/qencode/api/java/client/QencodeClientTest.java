package com.qencode.api.java.client;

import com.qencode.api.java.client.classes.*;
import com.qencode.api.java.client.classes.CustomParams.Destination;
import com.qencode.api.java.client.classes.CustomParams.Format;
import com.qencode.api.java.client.classes.CustomParams.Libx264_VideoCodecParameters;
import com.qencode.api.java.client.classes.CustomParams.Stream;
import org.junit.Test;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class QencodeClientTest {
    public static final String TEST_API_KEY = "5a2a846a26ace";
    public static final String TEST_TRANSCODING_PROFILE_ID = "your_profile_id";
    public static final String TEST_VIDEO_URL = "https://nyc3.s3.qencode.com/qencode/bbb_30s.mp4";
    public static final String TEST_VIDEO_URL2 = "https://qa.qencode.com/static/1.mp4";
    public static final String TEST_TRANSFER_METHOD_ID = "your_transfer_method_id";

    // @Test
    public void testSimpleTranscode() throws QencodeException, IOException, InterruptedException {
        System.out.println("Starting job using transcoding profile and transfer method...");
        // QencodeApiClient client = new QencodeApiClient(TEST_API_KEY,
        // "https://api-qa.qencode.com/v1");
        QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        assertNotNull(client.getAccessToken());
        System.out.println("Access Token: " + client.getAccessToken());

        TranscodingTask task = client.CreateTask();
        assertNotNull(task);
        System.out.println("Task Token: " + task.getTaskToken());
        task.setUri(TEST_VIDEO_URL);
        task.setTranscodingProfiles(TEST_TRANSCODING_PROFILE_ID);
        task.setTransferMethod(TEST_TRANSFER_METHOD_ID);
        HashMap<String, String> vars = new HashMap<String, String>();
        vars.put("filename", "mytestfilename.mp4");
        task.setOutputPathVariables(vars);
        task.setStartTime(30.0175);
        task.setDuration(60.245);
        task.start();
        assertNotNull(task.getStatusUrl());
        System.out.println("Status URL: " + task.getStatusUrl());
        TranscodingTaskStatus response = null;
        NumberFormat formatter = new DecimalFormat("#0.00");
        do {
            TimeUnit.SECONDS.sleep(5);
            System.out.print("Checking status... ");
            response = task.getStatus();
            double percent = response.getPercent() == null ? 0 : response.getPercent();
            System.out.println(response.getStatus() + " - " + formatter.format(percent));
        } while (!response.getStatus().equals("completed") && response.getError() != 1);

        if (response.getError() == 1) {
            System.out.println(response.getErrorDescription());
        }

        assertEquals("completed", response.getStatus());

        for (VideoStatus video : response.getVideos()) {
            System.out.println(video.getUserTag() + ": " + video.getUrl());
        }
        System.out.println("Job done!");
    }

    // @Test
    public void testStitchTranscode() throws QencodeException, IOException, InterruptedException {
        System.out.println("Starting job using transcoding profile and transfer method...");
        // QencodeApiClient client = new QencodeApiClient(TEST_API_KEY,
        // "https://api-qa.qencode.com/v1");
        QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        assertNotNull(client.getAccessToken());
        System.out.println("Access Token: " + client.getAccessToken());

        TranscodingTask task = client.CreateTask();
        assertNotNull(task);
        System.out.println("Task Token: " + task.getTaskToken());

        StitchVideoItem part1 = task.addStitchVideoItem(TEST_VIDEO_URL);
        part1.setStartTime(60);
        part1.setDuration(10);
        task.addStitchVideoItem(TEST_VIDEO_URL2);

        task.setTranscodingProfiles(TEST_TRANSCODING_PROFILE_ID);
        task.setTransferMethod(TEST_TRANSFER_METHOD_ID);
        HashMap<String, String> vars = new HashMap<String, String>();
        vars.put("filename", "mytestfilename.mp4");
        task.setOutputPathVariables(vars);
        task.start();
        assertNotNull(task.getStatusUrl());
        System.out.println("Status URL: " + task.getStatusUrl());
        TranscodingTaskStatus response = null;
        NumberFormat formatter = new DecimalFormat("#0.00");
        do {
            TimeUnit.SECONDS.sleep(5);
            System.out.print("Checking status... ");
            response = task.getStatus();
            double percent = response.getPercent() == null ? 0 : response.getPercent();
            System.out.println(response.getStatus() + " - " + formatter.format(percent));
        } while (!response.getStatus().equals("completed") && response.getError() != 1);

        if (response.getError() == 1) {
            System.out.println(response.getErrorDescription());
        }

        assertEquals("completed", response.getStatus());

        for (VideoStatus video : response.getVideos()) {
            System.out.println(video.getUserTag() + ": " + video.getUrl());
        }
        System.out.println("Job done!");
    }

    public static final String TEST_S3_PATH = "s3://s3-eu-west-2.amazonaws.com/qencode-test";
    public static final String TEST_S3_KEY = "AKIAIKZIPSJ7SDAIWK4A";
    public static final String TEST_S3_SECRET = "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";

    @Test
    public void testAVForce() throws QencodeException, IOException, InterruptedException {
        QencodeApiClient client = new QencodeApiClient("5a2a846a26ace");
        TranscodingTask task = client.CreateTask();
        System.out.println("Task Token: " + task.getTaskToken());

        CustomTranscodingParams transcodingParams = new CustomTranscodingParams();
        transcodingParams.setSource(TEST_VIDEO_URL);
        transcodingParams.setCallbackUrl("https://video-transcoder.online/test_callback.php");
        Destination destination = new Destination();
        Format format = new Format();
        destination.setUrl(TEST_S3_PATH);
        destination.setKey(TEST_S3_KEY);
        destination.setSecret(TEST_S3_SECRET);
        format.setDestination(destination);
        format.setOutput("mp4");
        format.setHeight(720);
        format.setOptimizeBitrate(1);
        transcodingParams.getFormat().add(format);
        task.startCustom(transcodingParams);

        TranscodingTaskStatus response = null;
        String statusUrl = null;
        do {
            response = task.getStatus();
            statusUrl = response.getStatusUrl();
            if (statusUrl != null) {
                System.out.println("status url: " + statusUrl);
            } else {
                TimeUnit.SECONDS.sleep(5);
            }
        } while (statusUrl == null);
        System.out.println(
                "Use status url shown above to check status of your job as described at https://docs.qencode.com/#010_060");

        String status = null;
        do {
            System.out.print("Checking job status... ");
            response = task.getStatus();
            status = response.getStatus();
            System.out.print(status);
            if (status.equals("encoding")) {
                Float percent = response.getPercent();
                System.out.println(" " + percent.toString() + "%");
            } else {
                System.out.println();
            }
            TimeUnit.SECONDS.sleep(5);
        } while (!status.equals("completed") && response.getError() != 1);
        if (response.getError() == 1) {
            System.out.println(response.getErrorDescription());
        }
    }

    // @Test
    public void testCustomTranscode() throws QencodeException, IOException, InterruptedException {
        System.out.println("Starting job using custom params...");
        QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        assertNotNull(client.getAccessToken());
        System.out.println("Access Token: " + client.getAccessToken());

        TranscodingTask task = client.CreateTask();
        assertNotNull(task);
        System.out.println("Task Token: " + task.getTaskToken());

        CustomTranscodingParams transcodingParams = new CustomTranscodingParams();
        transcodingParams.setSource(TEST_VIDEO_URL);
        Destination destination = new Destination();
        Format format = new Format();
        destination.setUrl(TEST_S3_PATH);
        destination.setKey(TEST_S3_KEY);
        destination.setSecret(TEST_S3_SECRET);
        format.setDestination(destination);
        format.setOutput("advanced_hls");

        Stream stream = new Stream();
        stream.setSize("1920x1080");
        stream.setAudioBitrate(128);
        stream.setOptimizeBitrate(1);

        Libx264_VideoCodecParameters vcodecParams = new Libx264_VideoCodecParameters();
        vcodecParams.setVprofile("baseline");
        vcodecParams.setLevel(31);
        vcodecParams.setCoder(0);
        vcodecParams.setFlags2("-bpyramid+fastpskip-dct8x8");
        vcodecParams.setPartitions("+parti8x8+parti4x4+partp8x8+partb8x8");
        vcodecParams.setDirectpred(2);
        stream.setVideoCodecParameters(vcodecParams);
        format.getStream().add(stream);

        transcodingParams.getFormat().add(format);

        task.startCustom(transcodingParams);
        assertNotNull(task.getStatusUrl());
        System.out.println("Status URL: " + task.getStatusUrl());
        TranscodingTaskStatus response = null;
        NumberFormat formatter = new DecimalFormat("#0.00");
        do {
            TimeUnit.SECONDS.sleep(5);
            System.out.print("Checking status... ");
            response = task.getStatus();
            System.out.println(response.getStatus() + " - " + formatter.format(response.getPercent()));
        } while (!response.getStatus().equals("completed"));

        assertEquals(response.getStatus(), "completed");

        for (VideoStatus video : response.getVideos()) {
            System.out.println(video.getUserTag() + ": " + video.getUrl());
        }

        System.out.println("Job done!");
    }


    @Test
    public void testContsr() throws QencodeException, IOException, InterruptedException {
        final QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        
        final TranscodingTask task_old = client.CreateTask();


        final CustomTranscodingParams transcodingParams = new CustomTranscodingParams();
        transcodingParams.setSource(TEST_VIDEO_URL);
        final Format format = new Format();
        format.setOutput("mp4");
        format.setHeight(320);
        format.setOptimizeBitrate(1);
        transcodingParams.getFormat().add(format);
        task_old.startCustom(transcodingParams);
        final String uploadUrl = task_old.getUploadUrl();
        final String taskToken = task_old.getTaskToken();
        final String statusUrl = task_old.getStatusUrl();
        final TranscodingTask task = new TranscodingTask(client, taskToken, statusUrl, uploadUrl);

        System.out.println("Task Token: " + task.getTaskToken());

        TranscodingTaskStatus response = null;
        String newStatusUrl = null;
        do
        {
            response = task.getStatus();
            newStatusUrl = response.getStatusUrl();
            if (statusUrl != null) {
                System.out.println("status url: " + newStatusUrl);
            }
            else {
                TimeUnit.SECONDS.sleep(5);
            }
        } while (newStatusUrl == null);
        System.out.println("Use status url shown above to check status of your job as described at https://docs.qencode.com/#010_060");

        String status = null;
        do {
            System.out.print("Checking job status... ");
            response = task.getStatus();
            status = response.getStatus();
            System.out.print(status);
            if (status.equals("encoding")) {
                final Float percent = response.getPercent();
                System.out.println(" " + percent.toString() + "%");
            }
            else {
                System.out.println();
            }
            TimeUnit.SECONDS.sleep(5);
        } while (!status.equals("completed") && response.getError() != 1);
        if (response.getError() == 1) {
            System.out.println(response.getErrorDescription());
        }
    }

}