package com.ak.stub.handler.dto;

import com.ak.stub.common.Operation;
import com.ak.stub.common.Type;




public class HandlerParam {

    private Type type;
    private Operation operation;


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
