package com.ak.stub.store;

import com.ak.stub.common.Type;

import java.util.*;



public class TransactionManager {

    private final CaffeineStore store;

    public TransactionManager() {
        this.store = new CaffeineStore();
    }

    public void add(UUID id, DataStore dataStore) {
        synchronized (store) {
            store.put(id, dataStore);
        }
    }

    /*public List<DataStore> get(Type type) {
        return store.get(type);
    }*/

    public Collection<DataStore> getAll() {
        return store.getAll();
    }

    public DataStore getById(String id) {
        return store.get(id);
    }

    public String delete(String id) {
        store.delete(id);
        return "Deleted " + id;
    }
}
