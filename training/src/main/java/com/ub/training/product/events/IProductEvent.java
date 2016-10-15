package com.ub.training.product.events;

import com.ub.training.product.models.ProductDoc;

public interface IProductEvent {
    public void preSave(ProductDoc productDoc);
    public void afterSave(ProductDoc productDoc);

    public Boolean preDelete(ProductDoc productDoc);
    public void afterDelete(ProductDoc productDoc);
}
