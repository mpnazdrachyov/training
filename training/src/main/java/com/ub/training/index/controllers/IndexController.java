package com.ub.training.index.controllers;

import com.ub.training.base.views.LayoutView;
import com.ub.training.index.routes.IndexRoutes;
import com.ub.training.index.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired private IndexService indexService;

    @RequestMapping(value = IndexRoutes.INDEX, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute(LayoutView.MODEL_KEY, indexService.index());
        return "com.ub.training.client.index";
    }
}
