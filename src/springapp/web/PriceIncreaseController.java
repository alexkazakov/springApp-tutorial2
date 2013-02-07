package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import springapp.domain.ProductManager;
import springapp.service.PriceIncrease;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("priceIncrease.htm")
@SessionAttributes("priceIncrease")
@Controller
public class PriceIncreaseController {

    /**
     * Logger for this class and subclasses
     */
    protected final Log logger = LogFactory.getLog(getClass());

    //    @Autowired
//    private PriceIncreaseValidator validator;
    @Autowired
    private ProductManager productManager;

    //    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        logger.info("initBinder with validator " + validator);
//        binder.setValidator(validator);
//    }
    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPriceIncreaseForm(ModelMap model) {
        model.addAttribute("priceIncrease", new PriceIncrease());
        return "priceincrease";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String increasePrice(@Valid @ModelAttribute("priceIncrease") PriceIncrease priceIncrease, BindingResult bindingResult, Map model) {
        if (bindingResult.hasErrors()) {
            return "priceincrease";
        }
        int increase = priceIncrease.getPercentage();
        productManager.increasePrice(increase);

        return "redirect:hello.htm";
    }
}
