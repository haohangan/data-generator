package com.github.evacode.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    private static final Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    private JsonUtil() {
    }

    /**
     * convert an object to json string
     *
     * @param obj src obj
     * @return json string
     */
    public static String toJsonString(Object obj) {
        return gson.toJson(obj);
    }

}
