package com.example.springdatabasicdemo.controllers.storage;

class StorageFindNotFoundException extends RuntimeException {
    StorageFindNotFoundException() {
        super("Could not find storages :(");
    }
}