package com.ub.training.product.services;

import com.ub.training.product.models.ProductDoc;
import com.ub.training.product.events.IProductEvent;
import com.ub.training.product.views.all.SearchProductAdminRequest;
import com.ub.training.product.views.all.SearchProductAdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductService {
    private static Map<String, IProductEvent> productEvents = new HashMap<String, IProductEvent>();

    @Autowired private MongoTemplate mongoTemplate;

    public static void addProductEvent(IProductEvent iProductEvent) {
        productEvents.put(iProductEvent.getClass().getCanonicalName(), iProductEvent);
    }

    public ProductDoc save(ProductDoc productDoc) {
        mongoTemplate.save(productDoc);
        callAfterSave(productDoc);
        return productDoc;
    }

    public ProductDoc findById(ObjectId id) {
        return mongoTemplate.findById(id, ProductDoc.class);
    }

    public ProductDoc findOneProduct() {
        return mongoTemplate.findOne(new Query(), ProductDoc.class);
    }

    public void remove(ObjectId id) {
        ProductDoc productDoc = findById(id);
        if (productDoc == null) return;
        mongoTemplate.remove(productDoc);
        callAfterDelete(productDoc);
    }

    public SearchProductAdminResponse findAll(SearchProductAdminRequest searchProductAdminRequest) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(
                searchProductAdminRequest.getCurrentPage(),
                searchProductAdminRequest.getPageSize(),
                sort);

        Criteria criteria = new Criteria();
        //Criteria.where("title").regex(searchProductAdminRequest.getQuery(), "i");

        Query query = new Query(criteria);
        Long count = mongoTemplate.count(query, ProductDoc.class);
        query = query.with(pageable);

        List<ProductDoc> result = mongoTemplate.find(query, ProductDoc.class);
        SearchProductAdminResponse searchProductAdminResponse = new SearchProductAdminResponse(
                searchProductAdminRequest.getCurrentPage(),
                searchProductAdminRequest.getPageSize(),
                result);
        searchProductAdminResponse.setAll(count);
        searchProductAdminResponse.setQuery(searchProductAdminRequest.getQuery());
        return searchProductAdminResponse;
    }

    private void callAfterSave(ProductDoc productDoc) {
        for (IProductEvent iProductEvent : productEvents.values()) {
            iProductEvent.afterSave(productDoc);
        }
    }

    private void callAfterDelete(ProductDoc productDoc) {
        for (IProductEvent iProductEvent : productEvents.values()) {
            iProductEvent.afterDelete(productDoc);
        }
    }
}
