package com.codewithmosh.springboot_exercises.exercises.entities.repositories;

import com.codewithmosh.springboot_exercises.exercises.entities.data.Category;
import com.codewithmosh.springboot_exercises.exercises.entities.data.Product;
import com.codewithmosh.springboot_exercises.exercises.entities.data.dtos.ProductSummary;
import com.codewithmosh.springboot_exercises.exercises.entities.data.dtos.ProductSummaryDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    // numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // null - if col nullable
    List<Product> findByNameNull();
    List<Product> findByNameNotNull();

    // many conditions
    List<Product> findByNameNullAndPriceNull();

    // Sort ( order by )
    List<Product> findByNameOrderByPriceDesc(String name);

    // limits ( top / first ) - can't have dynamic top 'number' in derived query methods
    List<Product> findTop5ByNameOrderByPriceDesc(String name);
    List<Product> findFirst5ByNameOrderByPriceDesc(String name);

    // find all products in a price range and sort by name
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findPreferredProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    // name is really long, here's how to shorten it.
    // @Query takes either SQL or JPQL ( java persistence query language - portable across db eingines, but more limited )
    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);

    // aggregate ex
    @Query("select count(p) from Product p where p.price between :min and :max")
    int countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    // udpate ex
    // when calling, always wrap in @Transactional
    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Long categoryId);

    // projections ( returning a DTO instead of full entity )
    @Query("select new com.codewithmosh.springboot_exercises.exercises.entities.data.dtos.ProductSummaryDto(p.id, p.name) from Product p where p.category = :category")
    List<ProductSummaryDto> findByCategory(@Param("category") Category category);
}
