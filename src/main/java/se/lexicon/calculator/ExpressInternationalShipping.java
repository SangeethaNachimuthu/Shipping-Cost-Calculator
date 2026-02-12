package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.config.ShippingCostConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class ExpressInternationalShipping implements ShippingCostCalculator {

    private final ShippingCostConfig costConfig;

    public ExpressInternationalShipping(ShippingCostConfig costConfig) {
        this.costConfig = costConfig;
    }

    @PostConstruct
    public void run() {
        IO.println("ExpressInternationalShipping been created.");
    }

    public boolean supports(ShippingRequest r) {

        if (r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.EXPRESS) {
            return true;
        }
        else {
            return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.STANDARD;
        }
    }

    public double calculate(ShippingRequest r) {
       // return 25 + 4.5 * r.weightKg();
        return (costConfig.getExpressDestination() + costConfig.getExpressSpeed() * r.weightKg());
    }
}
