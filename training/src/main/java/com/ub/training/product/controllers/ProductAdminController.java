package com.ub.training.product.controllers;

import com.mongodb.gridfs.GridFSDBFile;
import com.ub.training.product.models.ProductDoc;
import com.ub.training.product.routes.ProductAdminRoutes;
import com.ub.training.product.services.ProductService;
import com.ub.training.product.views.all.SearchProductAdminRequest;
import com.ub.training.product.views.all.SearchProductAdminResponse;
import com.ub.core.base.utils.RouteUtils;
import com.ub.core.file.services.FileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ub.core.base.views.breadcrumbs.BreadcrumbsLink;
import com.ub.core.base.views.pageHeader.PageHeader;

@Controller
public class ProductAdminController {
    @Autowired private ProductService productService;

    private PageHeader defaultPageHeader(String current) {
        PageHeader pageHeader = PageHeader.defaultPageHeader();
        pageHeader.setLinkAdd(ProductAdminRoutes.ADD);
        pageHeader.getBreadcrumbs().getLinks().add(new BreadcrumbsLink(ProductAdminRoutes.ALL, "Все Продукт"));
        pageHeader.getBreadcrumbs().setCurrentPageTitle(current);
        return pageHeader;
    }

    @RequestMapping(value = ProductAdminRoutes.ADD, method = RequestMethod.GET)
    public String create(Model model) {
        ProductDoc productDoc = new ProductDoc();
        productDoc.setId(new ObjectId());
        model.addAttribute("productDoc", productDoc);
        model.addAttribute("pageHeader", defaultPageHeader("Добавление"));
        return "com.ub.training.admin.product.add";
    }

    @RequestMapping(value = ProductAdminRoutes.ADD, method = RequestMethod.POST)
    public String create(@ModelAttribute ProductDoc productDoc,
                         RedirectAttributes redirectAttributes) {
        productService.save(productDoc);
        redirectAttributes.addAttribute("id", productDoc.getId());
        return RouteUtils.redirectTo(ProductAdminRoutes.EDIT);
    }

    @RequestMapping(value = ProductAdminRoutes.EDIT, method = RequestMethod.GET)
    public String update(@RequestParam ObjectId id, Model model) {
        ProductDoc productDoc = productService.findById(id);
        model.addAttribute("productDoc", productDoc);
        model.addAttribute("pageHeader", defaultPageHeader("Редактирование"));
        return "com.ub.training.admin.product.edit";
    }

    @RequestMapping(value = ProductAdminRoutes.EDIT, method = RequestMethod.POST)
    public String update(@ModelAttribute ProductDoc productDoc,
                         RedirectAttributes redirectAttributes) {
        productService.save(productDoc);
        redirectAttributes.addAttribute("id", productDoc.getId());
        return RouteUtils.redirectTo(ProductAdminRoutes.EDIT);
    }

    @RequestMapping(value = ProductAdminRoutes.ALL, method = RequestMethod.GET)
    public String all(@RequestParam(required = false, defaultValue = "0") Integer currentPage,
                      @RequestParam(required = false, defaultValue = "") String query,
                      Model model) {
        SearchProductAdminRequest searchProductAdminRequest = new SearchProductAdminRequest(currentPage);
        searchProductAdminRequest.setQuery(query);
        model.addAttribute("searchProductAdminResponse", productService.findAll(searchProductAdminRequest));
        model.addAttribute("pageHeader", defaultPageHeader("Все"));
        return "com.ub.training.admin.product.all";
    }

    @RequestMapping(value = ProductAdminRoutes.MODAL_PARENT, method = RequestMethod.GET)
    public String modalResponse(@RequestParam(required = false, defaultValue = "0") Integer currentPage,
                                @RequestParam(required = false, defaultValue = "") String query,
                                Model model) {
        SearchProductAdminRequest searchProductAdminRequest = new SearchProductAdminRequest(currentPage);
        searchProductAdminRequest.setQuery(query);
        model.addAttribute("searchProductAdminResponse", productService.findAll(searchProductAdminRequest));
        return "com.ub.training.admin.product.modal.parent";
    }

    @RequestMapping(value = ProductAdminRoutes.DELETE, method = RequestMethod.GET)
    public String delete(@RequestParam ObjectId id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("pageHeader", defaultPageHeader("Удаление"));
        return "com.ub.training.admin.product.delete";
    }

    @RequestMapping(value = ProductAdminRoutes.DELETE, method = RequestMethod.POST)
    public String delete(@RequestParam ObjectId id) {
        productService.remove(id);
        return RouteUtils.redirectTo(ProductAdminRoutes.ALL);
    }
}
