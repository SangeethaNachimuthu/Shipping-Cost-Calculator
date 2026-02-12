package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
@PropertySource("classpath:application.properties")
public class AppConfig {

   /* @Bean
    public ShippingCostConfig shippingCostConfig() {
        return new ShippingCostConfig();
    } */
}
