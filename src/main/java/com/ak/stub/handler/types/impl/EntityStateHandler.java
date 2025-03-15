package com.ak.stub.handler.types.impl;

import com.ak.stub.common.Type;
import com.github.tomakehurst.wiremock.common.Json;
import com.github.tomakehurst.wiremock.common.ListOrSingle;
import com.github.tomakehurst.wiremock.extension.responsetemplating.RequestTemplateModel;
import com.ak.stub.store.DataStore;
import com.ak.stub.store.TransactionManager;
import com.ak.stub.handler.types.StateHandler;

import java.util.*;

public class EntityStateHandler implements StateHandler {

    private static final String CREATE_RES = "{ \"version_number\": \"%s\" }";

    private final TransactionManager transactionManager;

    public EntityStateHandler(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    @Override
    public String create(RequestTemplateModel request) {
        System.out.println(request.getBody());
        Map<String, String> data = Json.read(request.getBody(), Map.class);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        DataStore dataStore = new DataStore();
        dataStore.setUuid(uuid);
        dataStore.setType(Type.ENTITY);
        dataStore.setData(data);
        transactionManager.add(uuid, dataStore);
        return dataStore.toString();
    }

    @Override
    public String get(RequestTemplateModel request) {
        Map<String, ListOrSingle<String>> query = request.getQuery();
        //String key = request.getHeaders().get("key").get(0);
        DataStore dataStore = transactionManager.getById(query.get("id").get(0));
        return dataStore.toString();
    }

    @Override
    public String delete(RequestTemplateModel request) {
        Map<String, ListOrSingle<String>> query = request.getQuery();
        return transactionManager.delete(query.get("id").get(0));
    }

    @Override
    public String getAll(RequestTemplateModel request) {
        return transactionManager.getAll().toString();
    }
}
