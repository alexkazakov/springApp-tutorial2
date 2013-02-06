package springapp.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import springapp.domain.SimpleProductManager;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Copyright (c) 2012 Saritasa LLC. All rights reserved.
 *
 * @author ak
 */
public class InventoryControllerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHandleRequest() throws Exception {
        InventoryController controller = new InventoryController();
        controller.setProductManager(new SimpleProductManager());
        final ModelAndView modelAndView = controller.handleRequest(null, null);

        assertEquals("hello", modelAndView.getViewName());

        assertNotNull(modelAndView.getModel());

        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");

        assertNotNull(nowValue);
    }
}
