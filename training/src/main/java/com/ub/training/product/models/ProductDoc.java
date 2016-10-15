package com.ub.training.product.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import com.ub.core.base.models.BaseModel;


import javax.persistence.Id;

@Document
public class ProductDoc extends BaseModel {
    @Id
    private ObjectId id;
    private String name;
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
