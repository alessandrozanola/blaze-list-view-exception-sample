package com.azanola.sample.database;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "suppliers")
public class SupplierEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    private String businessName;

    @OneToMany(mappedBy = "supplier")
    private List<ProductEntity> products;
}
