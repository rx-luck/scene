package com.djc.scene.domain.parent;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AbstractUserTest {

    @Test
    public void test(){
        UUID uuid = UUID.randomUUID();
        System.out.println("{"+uuid.toString()+"}");
    }
}