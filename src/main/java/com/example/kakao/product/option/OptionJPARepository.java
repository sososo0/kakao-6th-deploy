package com.example.kakao.product.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface OptionJPARepository extends JpaRepository<Option, Integer> {

    @Query("select o from Option o where o.product.id = :productId")
    List<Option> findByProductId(@Param("productId") int productId);
    Optional<Option> findById(int id);

    // findById_select_product_lazy_error_fix_test
//    @Query("select o from Option o join fetch o.product where o.product.id = :productId")
//    List<Option> mFindByProductId(@Param("productId") int productId);
    
    //@Query(value = "select o from Option o inner join Product p on o.product.id = p.id where o.product.id = :productId", nativeQuery = true)
    @Query("select o from Option o join fetch o.product where o.product.id = :productId")
    List<Option> findByProductIdJoinProduct(@Param("productId") int productId);
}
