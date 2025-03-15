package com.ak.stub.store;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.tomakehurst.wiremock.store.Store;
import com.ak.stub.common.Type;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class CaffeineStore implements Store<UUID, DataStore> {

    private static final int DEFAULT_EXPIRATION_SECONDS = 60 * 60;

    private final Cache<UUID, DataStore> cache;

    public CaffeineStore() {
        Caffeine<Object, Object> builder = Caffeine.newBuilder();
        builder.expireAfterWrite(Duration.ofSeconds(DEFAULT_EXPIRATION_SECONDS));
        cache = builder.build();
    }

    @Override
    public Stream<UUID> getAllKeys() {
        return cache.asMap().keySet().stream();
    }

    @Override
    public Optional<DataStore> get(UUID key) {
        return Optional.ofNullable(cache.getIfPresent(key));
    }

    @Override
    public void put(UUID key, DataStore content) {
        cache.put(key, content);
    }

    @Override
    public void remove(UUID key) {
        cache.invalidate(key);
    }

    @Override
    public void clear() {
        cache.invalidateAll();
    }

    public Collection<DataStore> getAll() {
        return cache.asMap().values();
    }

    /*public Collection<DataStore> getAll(Type type) {
        return cache.asMap().values();
    }*/

    public DataStore get(String id) {
        return cache.getIfPresent(UUID.fromString(id));
    }

    public void delete(String id) {
        cache.invalidate(UUID.fromString(id));
    }
}
