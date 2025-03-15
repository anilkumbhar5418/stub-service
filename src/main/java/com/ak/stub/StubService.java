package com.ak.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;



public class StubService {

    private static final WireMockServer wireMockServer;

    static {
        wireMockServer = new WireMockServer(WireMockConfiguration.options()
                .port(8011)
                .usingFilesUnderDirectory(System.getProperty("user.dir") + "/src/main/resources")
                .extensions(new DataStubExtension())
        );
    }


    public static void main(String[] args) {
        wireMockServer.start();
    }
}
