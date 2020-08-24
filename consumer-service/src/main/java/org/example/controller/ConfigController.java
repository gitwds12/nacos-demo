package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${project.name:}")
    private String projectName;

    @Value("${project.org:}")
    private String projectOrg;
    @Value("${redis.host:}")
    private String redisHost;
    @Value("${redis.key.prefix.authCode:}")
    private String redisKey;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> configMap = new HashMap();
        configMap.put("projectName", projectName);
        configMap.put("projectOrg", projectOrg);
        return configMap;
    }

    @GetMapping("/config2")
    public Map<String, Object> getConfig2() {
        Map<String, Object> configMap = new HashMap();
        configMap.put("redisHost", redisHost);
        configMap.put("redisKey", redisKey);
        return configMap;
    }
}
