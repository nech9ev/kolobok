package com.itmo.kolobok.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("/application.properties")
public class BotConfig {

    @Value("${bot.username}")
    public String botUserName;

    @Value("${bot.token}")
    public String token;
}
