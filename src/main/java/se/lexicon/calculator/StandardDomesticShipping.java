package se.lexicon.calculator;

import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class StandardDomesticShipping implements ShippingCostCalculator {
    public boolean supports(ShippingRequest r) {
        if (r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD) {
            return true;
        } else {
            return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
        }
    }

    public double calculate(ShippingRequest r) {
        return 5 + 1.2 * r.weightKg();
    }
}