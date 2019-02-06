package org.sos.dao;

import java.util.List;

import org.sos.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
 public List<Produit> findByDesignation(String des);
 public Page<Produit> findByDesignation(String des,Pageable pageable);
 @Query("select p from Produit p where p.designation like :x")
 public Page<Produit> chercherProduit(@Param("x")String mc,Pageable pageable);
}
