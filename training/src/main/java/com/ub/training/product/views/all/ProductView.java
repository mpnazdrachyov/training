package com.ub.training.product.views.all;

import com.ub.training.base.views.LayoutView;
import com.ub.training.product.models.ProductDoc;

public class ProductView extends LayoutView {
    private ProductDoc productDoc;

    public ProductDoc getProductDoc() {
        return productDoc;
    }

    public void setProductDoc(ProductDoc productDoc) {
        this.productDoc = productDoc;
    }
}
