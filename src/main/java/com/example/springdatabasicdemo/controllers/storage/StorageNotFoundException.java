package com.example.springdatabasicdemo.controllers.storage;

class StorageNotFoundException extends RuntimeException {
    StorageNotFoundException(Integer id) {
        super("Could not find storage" + id);
    }
    StorageNotFoundException() {
        super("Could not find storages :(");
    }
}