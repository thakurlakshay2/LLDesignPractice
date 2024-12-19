package RestaurantManagementSystem.Config;

import java.util.HashMap;
import java.util.Map;

public class RestaurantConfig {
    private static RestaurantConfig instance;
    private int numberOfTables;
    private double taxRate;
    private Map<String, Double> additionalCharges;

    private RestaurantConfig() {
        additionalCharges = new HashMap<>();
    }

    public static synchronized RestaurantConfig getInstance() {
        if (instance == null) {
            instance = new RestaurantConfig();
        }
        return instance;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Map<String, Double> getAdditionalCharges() {
        return additionalCharges;
    }


    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void setAdditionalCharges(Map<String, Double> additionalCharges) {
        this.additionalCharges = additionalCharges;
    }
}
