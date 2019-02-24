package com.threewater.template.background.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//@Configuration
public class ErrorCodeConfig {

    private final Logger log = LoggerFactory.getLogger(ErrorCodeConfig.class);

    public Map<String, String> ErrorCodeMap = new HashMap<String, String>();

    public void init(String name) {

        try {
            Properties properties = new Properties();

            InputStream in = ErrorCodeConfig.class.getClassLoader().getResourceAsStream("message/"+name + ".properties");

            properties.load(new InputStreamReader(in));

            log.info("加载{}.properties参数",name);

            for (String keyName : properties.stringPropertyNames()) {
                String value = properties.getProperty(keyName);

                ErrorCodeMap.put(keyName, value);

                log.info("{}.properties---------key:{},value:{}",name, keyName, value);
            }
            log.info("{}.properties参数加载完毕",name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Bean(name="errMap")
    public Map<String, String> errMap(){
        init("err_zh");
        return ErrorCodeMap;
    }

}
