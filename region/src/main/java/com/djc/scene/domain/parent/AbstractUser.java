package com.djc.scene.domain.parent;

import java.util.UUID;

public class AbstractUser {
    public int id;
    public String guid = UUID.randomUUID().toString();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
