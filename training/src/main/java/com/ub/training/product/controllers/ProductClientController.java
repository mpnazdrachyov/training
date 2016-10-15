package com.ub.training.product.controllers;

import com.ub.training.base.views.LayoutView;
import com.ub.training.product.routes.ProductRoutes;
import com.ub.training.product.services.ProductService;
import com.ub.training.product.services.ProductViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductClientController {

    @Autowired private ProductViewService productViewService;
    @Autowired private ProductService productService;

    @RequestMapping(value = ProductRoutes.PRODUCT, method = RequestMethod.GET)
    public String product(Model model) {
        model.addAttribute(LayoutView.MODEL_KEY, productViewService.productView());
        return "com.ub.training.client.product";
    }

}
