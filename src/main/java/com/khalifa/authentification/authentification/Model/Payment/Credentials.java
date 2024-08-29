package com.khalifa.authentification.authentification.Model.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Credentials {
    @Autowired 
    private Environment env;

    String apiKey = env.getProperty("payment.api.key");
    String apiSecret = env.getProperty("payment.api.secret");

    public String getApiKey(){
        return this.apiKey;
    }

    public String getApiSecret(){
        return this.apiSecret;
    }
}
