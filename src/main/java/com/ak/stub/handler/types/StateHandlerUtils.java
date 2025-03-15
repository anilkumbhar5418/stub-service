package com.ak.stub.handler.types;

import com.github.tomakehurst.wiremock.common.Json;
import com.github.tomakehurst.wiremock.extension.responsetemplating.RequestTemplateModel;
import com.github.tomakehurst.wiremock.extension.responsetemplating.TemplateEngine;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import com.ak.stub.store.TransactionManager;
import com.ak.stub.common.Operation;
import com.ak.stub.common.Type;
import com.ak.stub.handler.dto.HandlerParam;
import com.ak.stub.handler.types.impl.EntityStateHandler;



public class StateHandlerUtils {

    private final EntityStateHandler entityStateHandler;
    private final TemplateEngine templateEngine;

    public StateHandlerUtils(TemplateEngine templateEngine) {
        TransactionManager transactionManager = new TransactionManager();
        this.templateEngine = templateEngine;
        entityStateHandler = new EntityStateHandler(transactionManager);
    }

    public String invoke(ServeEvent serveEvent) {
        HandlerParam handlerParam = Json.mapToObject(serveEvent.getTransformerParameters(), HandlerParam.class);
        RequestTemplateModel request = (RequestTemplateModel) templateEngine.buildModelForRequest(serveEvent).get("request");
        StateHandler stateHandler = getStateHandler(handlerParam.getType());
        return performOperation(stateHandler, handlerParam.getOperation(), request);
    }



    private StateHandler getStateHandler(Type type) {
        StateHandler stateHandler = null;
        switch (type) {
            case ENTITY -> stateHandler = entityStateHandler;

            default -> throw new IllegalStateException("StateHandler impl is missing for type " + type);
        }
        return stateHandler;
    }

    private String performOperation(StateHandler stateHandler, Operation operation, RequestTemplateModel request) {
        String response = null;
        switch (operation) {
            case CREATE -> response = stateHandler.create(request);
            case GET -> response = stateHandler.get(request);
            case DELETE -> response = stateHandler.delete(request);
            case GETALL -> response = stateHandler.getAll(request);
        }
        return response;
    }


}
