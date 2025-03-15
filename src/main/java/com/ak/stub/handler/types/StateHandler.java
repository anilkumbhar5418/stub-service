package com.ak.stub.handler.types;

import com.ak.stub.store.DataStore;
import com.github.tomakehurst.wiremock.extension.responsetemplating.RequestTemplateModel;

import java.util.Collection;


public interface StateHandler {

    String create(RequestTemplateModel request);
    String get(RequestTemplateModel request);
    String delete(RequestTemplateModel request);
    String getAll(RequestTemplateModel request);
}
