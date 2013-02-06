package springapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: ak
 * Date: 06.02.13
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class PriceIncreaseValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    private int DEFAULT_MIN_PERCENTAGE = 0;
    private int DEFAULT_MAX_PERCENTAGE = 50;
    private int minPercentage = DEFAULT_MIN_PERCENTAGE;
    private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

    @Override
    public boolean supports(Class aClass) {
        return PriceIncrease.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PriceIncrease priceIncrease = (PriceIncrease) o;
        if (priceIncrease == null) {
            errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
        } else {
            logger.info("Validating with " + priceIncrease + ": " + priceIncrease.getPercentage());
            if (priceIncrease.getPercentage() > maxPercentage) {
                errors.rejectValue("percentage", "error.too-high", new Object[]{maxPercentage}, "Value too high");
            }
            if (priceIncrease.getPercentage() <= minPercentage) {
                errors.rejectValue("pecentage", "error.too-low", new Object[]{minPercentage}, "Value too low");
            }
        }
    }

    public int getMinPercentage() {
        return minPercentage;
    }

    public void setMinPercentage(int minPercentage) {
        this.minPercentage = minPercentage;
    }

    public int getMaxPercentage() {
        return maxPercentage;
    }

    public void setMaxPercentage(int maxPercentage) {
        this.maxPercentage = maxPercentage;
    }
}
