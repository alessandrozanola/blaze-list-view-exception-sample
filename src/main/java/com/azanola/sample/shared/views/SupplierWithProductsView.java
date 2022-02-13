package com.azanola.sample.shared.views;

import com.azanola.sample.database.SupplierEntity;
import com.blazebit.persistence.view.*;

import java.util.List;

@EntityView(SupplierEntity.class)
public interface SupplierWithProductsView {

    Integer getId();
    String getBusinessName();

//    @MappingIndex
    List<ProductView> getProducts();

}
