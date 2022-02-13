package com.azanola.sample.z_controllers;

import com.azanola.sample.database.SupplierQueryRepository;
import com.azanola.sample.shared.views.SupplierWithProductsView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("suppliers")
public class SupplierController {
	private final SupplierQueryRepository supplierQueryRepository;

	public SupplierController(SupplierQueryRepository supplierQueryRepository) {
		this.supplierQueryRepository = supplierQueryRepository;
	}

	@GetMapping
	public List<SupplierWithProductsView> getPaniereProductsByPaniereId() {
		return supplierQueryRepository.findAllWithPaniereProductsProjectedBy();
	}
}
