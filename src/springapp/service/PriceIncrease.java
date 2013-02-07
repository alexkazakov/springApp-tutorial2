package springapp.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PriceIncrease {

    /**
     * Logger for this class and subclasses
     */
    protected final Log logger = LogFactory.getLog(getClass());

    @Min(value = 2, message = "{error.too-low}")
    @Max(value = 50, message = "{error.too-high}")
    @NotNull(message = "{error.not-specified}")
    private Integer percentage;

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer i) {
        percentage = i;
        logger.info("Percentage set to " + i);
    }

}