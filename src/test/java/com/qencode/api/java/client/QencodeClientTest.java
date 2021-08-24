package com.qencode.api.java.client;

import com.qencode.api.java.client.classes.*;
import com.qencode.api.java.client.classes.CustomParams.Destination;
import com.qencode.api.java.client.classes.CustomParams.Format;
import com.qencode.api.java.client.classes.CustomParams.Libx264_VideoCodecParameters;
import com.qencode.api.java.client.classes.CustomParams.Stream;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class QencodeClientTest {
    public static final String TEST_API_KEY = "5a2a846a26ace";
    public static final String TEST_VIDEO_URL = "https://nyc3.s3.qencode.com/qencode/bbb_30s.mp4";
    public static final String TEST_DIRECTORY = "/src/test/java/com/qencode/api/java/client";

    private void runJobAndCheckStatus(TranscodingTask task) throws UnsupportedEncodingException, QencodeException, InterruptedException {
        TranscodingTaskStatus response = null;
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
        assertEquals("completed", response.getStatus());
    }

    private TranscodingTask getTask() throws UnsupportedEncodingException, QencodeException {
        final QencodeApiClient client = new QencodeApiClient(TEST_API_KEY);
        final TranscodingTask task = client.CreateTask();
        assertNotNull(task);
        System.out.println("Task Token: " + task.getTaskToken());
        return task;
    }

    @Test
    public void testJSONFromFile() throws QencodeException, IOException, InterruptedException, ParseException {
        TranscodingTask task = this.getTask();
        String queryFilePath = System.getProperty("user.dir") + TEST_DIRECTORY + "/query.json";
        task.startCustomWithJSONFile(queryFilePath);
        this.runJobAndCheckStatus(task);
    }

    @Test
    public void testJSON() throws QencodeException, IOException, InterruptedException, ParseException {
        String queryTemplateFilePath = System.getProperty("user.dir") + TEST_DIRECTORY + "/query_template.json";
        String queryTemplate = new String(Files.readAllBytes(Paths.get(queryTemplateFilePath)));
        String query = queryTemplate.replaceAll("\\{source\\}", TEST_VIDEO_URL);
        TranscodingTask task = this.getTask();
        task.startCustomWithJSON(query);
        this.runJobAndCheckStatus(task);
    }

}