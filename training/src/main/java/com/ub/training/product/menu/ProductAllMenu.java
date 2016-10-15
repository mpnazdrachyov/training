package com.ub.training.product.menu;

import com.ub.training.product.routes.ProductAdminRoutes;
import com.ub.core.base.menu.CoreMenu;

public class ProductAllMenu extends CoreMenu {
    public ProductAllMenu() {
        this.name = "Все";
        this.parent = new ProductMenu();
        this.url = ProductAdminRoutes.ALL;
    }
}
