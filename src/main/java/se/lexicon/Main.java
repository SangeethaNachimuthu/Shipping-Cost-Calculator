package se.lexicon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingService;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Manual object creation (composition root)
       /* List<ShippingCostCalculator> calculators = List.of(
                new StandardDomesticShipping(),
                new ExpressInternationalShipping()
        );

        ShippingCalculatorFactory factory = new ShippingCalculatorFactory(calculators);
        
        ShippingService shippingService = new ShippingService(factory);*/

        //ShippingCalculatorFactory factory = context.getBean(ShippingCalculatorFactory.class);

        ShippingService shippingService = context.getBean(ShippingService.class);

        ShippingRequest domesticStandardRequest = new ShippingRequest(
                Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost of Domestic Standard: " +
                shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(
                Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost of International Express: " +
                shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(
                Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost of Light Domestic: " +
                shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(
                Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost of Heavy International Express: " +
                shippingService.quote(heavyInternationalExpressRequest));

        ShippingRequest domesticExpressRequest = new ShippingRequest(
                Destination.DOMESTIC, Speed.EXPRESS, 12.0);
        System.out.println("Shipping cost of Domestic Express: " +
                shippingService.quote(domesticExpressRequest));

        ShippingRequest internationalStandardRequest = new ShippingRequest(
                Destination.INTERNATIONAL, Speed.STANDARD, 14.0);
        System.out.println("Shipping cost of International Standard: " +
                shippingService.quote(internationalStandardRequest));
    }
}
