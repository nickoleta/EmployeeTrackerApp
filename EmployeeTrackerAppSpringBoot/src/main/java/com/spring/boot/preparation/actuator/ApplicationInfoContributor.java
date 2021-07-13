package com.spring.boot.preparation.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ApplicationInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        final HashMap<String, Object> info = new HashMap<>();
        info.put("status", "ready");
        info.put("project_name", "Spring Certified Professional Preparation");
        info.put("author", "Nikoleta Yankova");
        builder.withDetails(info);
    }
}
