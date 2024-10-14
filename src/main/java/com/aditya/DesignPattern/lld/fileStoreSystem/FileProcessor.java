package com.aditya.DesignPattern.lld.fileStoreSystem;

import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Map;

public class FileProcessor {

    private static final String PAYLOAD_FILE_PATH = "/Users/adityaj/personal/DesignPattern/src/main/resources/payload.json";
    private static final RestTemplate restTemplate = new RestTemplate();

    public void parseFile(File file) throws FileNotFoundException {
        Map<String, Object> payloads = PayloadService.loadPayloads(PAYLOAD_FILE_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String apiUrl;
            while ((apiUrl = br.readLine()) != null) {
                Object payload = payloads.get(apiUrl);
                if (payload != null) {
                    String response = callApi(apiUrl, payload);
                    FileStoreSystem.saveResponseToFile(apiUrl, response);
                }

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private static String callApi(String apiUrl, Object payload) {
        //return restTemplate.postForObject(apiUrl, payload, String.class);
        return "Abc";
    }

}
