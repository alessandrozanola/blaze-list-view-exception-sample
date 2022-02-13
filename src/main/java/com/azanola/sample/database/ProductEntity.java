package com.azanola.sample.database;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity extends BaseEntity {
	@Column(nullable = false, length = 128)
	private String name;
	@Column(nullable = false)
	private Integer price;

	@ManyToOne
	private SupplierEntity supplier;
}
