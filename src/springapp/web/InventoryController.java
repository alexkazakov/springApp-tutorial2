package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import springapp.domain.ProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2012 Saritasa LLC. All rights reserved.
 *
 * @author ak
 */
public class InventoryController implements Controller {

    private final Log logger = LogFactory.getLog(getClass());
    private ProductManager productManager;

    @Override
    public ModelAndView handleRequest(final HttpServletRequest aHttpServletRequest,
                                      final HttpServletResponse aHttpServletResponse) throws Exception {

        String now = new Date().toString();

        logger.info("Returning hello view with " + now);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("now", now);
        model.put("products", productManager.getProducts());

        return new ModelAndView("hello", "model", model);
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
