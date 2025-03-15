package com.ak.stub.store;


import com.github.tomakehurst.wiremock.common.Json;
import com.ak.stub.common.Type;

import java.util.Map;
import java.util.UUID;


public class DataStore {

    private UUID uuid;
    private Type type;
    private Map<String, String> data;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Json.write(this.data);
    }


    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String uuuid = uuid.toString();

        UUID unid = UUID.fromString(uuuid);
        System.out.println(unid);
    }
}
