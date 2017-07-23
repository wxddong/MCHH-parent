package com.threefiveninetong.mchh.core.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtils {
    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);

    private static PropertiesConfiguration config = new PropertiesConfiguration();

    private static Map<String, String> properties = new HashMap<String, String>();

    static {
        try {
            config.load("system.properties");
        } catch (Exception e) {
            log.error("ConfiUtils", e);
        }
    }

    public static String getStringByKey(String key) {
        String result = properties.get(key);
        if (result == null) {
            result = config.getString(key);
            properties.put(key, result);
        }
        return result;
    }
}
