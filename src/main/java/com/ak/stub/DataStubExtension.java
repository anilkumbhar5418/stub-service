package com.ak.stub;

import com.github.tomakehurst.wiremock.extension.Extension;
import com.github.tomakehurst.wiremock.extension.ExtensionFactory;
import com.github.tomakehurst.wiremock.extension.WireMockServices;
import com.ak.stub.handler.DynamicStateOperator;


import java.util.List;

public class DataStubExtension implements ExtensionFactory {


    @Override
    public List<Extension> create(WireMockServices wireMockServices) {
        return List.of(
                new DynamicStateOperator(wireMockServices)
        );
    }
}