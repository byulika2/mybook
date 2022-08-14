package com.chirs.mybook.domain.product.repository;

import com.chirs.mybook.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
