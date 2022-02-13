package com.azanola.sample.database;

import com.azanola.sample.shared.views.SupplierWithProductsView;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface SupplierQueryRepository extends Repository<SupplierEntity, Integer> {

    List<SupplierWithProductsView> findAllWithPaniereProductsProjectedBy();

}
