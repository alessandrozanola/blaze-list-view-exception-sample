package com.azanola.sample.shared.views;

import com.azanola.sample.database.ProductEntity;
import com.blazebit.persistence.view.EntityView;

@EntityView(ProductEntity.class)
public interface ProductView {

    Integer getId();
    String getName();
    Integer getPrice();

}
