package com.experiencepolice.service.configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringBootConfiguration;

import java.io.IOException;

@Slf4j
@SpringBootConfiguration
public class ElasticSearchConfiguration {

    private final String HOST = "localhost";
    private final int PORT = 9200;
    private final String SCHEME = "http";
    @Getter
    private final String index = "experiencepolice";
    @Getter
    private final String type = "profile";

    private RestHighLevelClient client;

    public RestHighLevelClient getRestClient() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(HOST, PORT, SCHEME)));

        return client;
    }

    public void closeClient() {
        try {
            client.close();
        } catch (IOException e) {

        }
    }

}
