package com.codewithmosh.springboot_exercises.exercises.entities.services;

import com.codewithmosh.springboot_exercises.exercises.entities.data.Address;
import com.codewithmosh.springboot_exercises.exercises.entities.data.Category;
import com.codewithmosh.springboot_exercises.exercises.entities.data.Product;
import com.codewithmosh.springboot_exercises.exercises.entities.data.User;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.AddressRepository;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.CategoryRepository;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.ProductRepository;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("taylor")
                .email("taylor@gmail.com")
                .password("yoda123")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities(){
        var user = userRepository.findById(2L).orElseThrow();
        System.out.println(user.getEmail());
    }

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address);
    }

    public void persistRelated(){
        var user = User.builder()
                .name("mr cool")
                .email("mc.ool@mail.com")
                .password("thecoolest")
                .build();

        var address = Address.builder()
                .street("cool lane")
                .city("vapor city")
                .state("gas")
                .zip("123456")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    public void deleteRelated(){
        userRepository.deleteById(2L);
    }

    @Transactional
    public void deleteChildRow(){
        var user = userRepository.findById(1L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void SaveProduct(){
        var product = Product.builder()
                .name("cool thing")
                .price(new BigDecimal(1000))
                .build();

        var category = Category.builder()
                .name("Technology")
                .build();

        category.addProduct(product);

        productRepository.save(product);
    }

    @Transactional
    public void addProductToExistingCategory(){
        var category = categoryRepository.findById(1L).orElseThrow();

        var product = Product.builder()
                .name("a new cool thing")
                .price(new BigDecimal(200) )
                .build();

        category.addProduct(product);

        productRepository.save(product);
    }

    @Transactional
    public void addToWishlist(){
        var user = userRepository.findById(1L).orElseThrow();
        var allProducts = productRepository.findAll();

        allProducts.forEach(user::addToWishlist);

        userRepository.save(user);
    }

    public void deleteProduct(){
        productRepository.deleteById(2L);
    }
}
