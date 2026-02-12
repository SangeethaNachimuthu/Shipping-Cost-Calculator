package se.lexicon.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
@PropertySource("classpath:application.properties")
public class AppConfig {

   /* @Bean
    public ShippingCostConfig shippingCostConfig() {
        return new ShippingCostConfig();
    } */
}
