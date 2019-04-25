package com.zxy.utils;

import java.util.UUID;

public class IdUtils {

    public static String nextId(){
        return UUID.randomUUID().toString();
    }
}
