package com.ub.training.product.services;

import com.ub.training.base.services.LayoutService;
import com.ub.training.product.models.ProductDoc;
import com.ub.training.product.views.all.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductViewService extends LayoutService {
    @Autowired private ProductService productService;

    public ProductView productView() {
        ProductView productView = new ProductView();
        this.fillLayout(productView);
        ProductDoc productDoc = productService.findOneProduct();
        productView.setProductDoc(productDoc);
        productView.getSeoTags().setTitle("Продукт");
        return productView;
    }
}
