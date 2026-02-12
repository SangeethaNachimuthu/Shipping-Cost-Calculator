package se.lexicon.config;

import org.springframework.beans.factory.annotation.Value;

public class ShippingCostConfig {

    @Value( "${standard.destination}")
    private int standardDestination;

    @Value("${express.destination}")
    private int expressDestination;

    @Value("${standard.speed}")
    private double standardSpeed;

    @Value("${express.speed}")
    private double expressSpeed;

    public int getStandardDestination() {
        return standardDestination;
    }

    public int getExpressDestination() {
        return expressDestination;
    }

    public double getStandardSpeed() {
        return standardSpeed;
    }

    public double getExpressSpeed() {
        return expressSpeed;
    }
}
