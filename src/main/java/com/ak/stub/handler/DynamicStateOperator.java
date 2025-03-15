package com.ak.stub.handler;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformerV2;
import com.github.tomakehurst.wiremock.extension.WireMockServices;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import com.ak.stub.handler.types.StateHandlerUtils;

public class DynamicStateOperator implements ResponseDefinitionTransformerV2 {

    private final StateHandlerUtils stateHandlerUtils;

    public DynamicStateOperator(WireMockServices wireMockServices) {
        this.stateHandlerUtils = new StateHandlerUtils(wireMockServices.getTemplateEngine());
    }


    @Override
    public ResponseDefinition transform(ServeEvent serveEvent) {

        return new ResponseDefinitionBuilder()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)
                .withBody(stateHandlerUtils.invoke(serveEvent))
                .build();
    }



    @Override
    public String getName() {
        return "crud-response";
    }

    @Override
    public boolean applyGlobally() {
        return false;
    }
}
