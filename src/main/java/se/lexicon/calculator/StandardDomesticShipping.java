package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.config.ShippingCostConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class StandardDomesticShipping implements ShippingCostCalculator {

    private final ShippingCostConfig costConfig;

    public StandardDomesticShipping(ShippingCostConfig costConfig) {
        this.costConfig = costConfig;
    }

    @PostConstruct
    public void run() {
        IO.println("StandardDomesticShipping been created.");
    }

    public boolean supports(ShippingRequest r) {
        if (r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD) {
            return true;
        } else {
            return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
        }
    }

    public double calculate(ShippingRequest r) {

        //return 5 + 1.2 * r.weightKg();
        return (costConfig.getStandardDestination() + costConfig.getStandardSpeed() * r.weightKg());
    }
}