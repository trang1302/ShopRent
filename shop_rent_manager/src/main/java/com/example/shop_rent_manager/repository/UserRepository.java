package com.example.shop_rent_manager.repository;


import com.example.shop_rent_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="select * from users u \n" +
            "join user_shop us on u.id = us.user_id \n" +
            "join shops s on us.id= s.id \n" +
            "where s.name LIKE %:keyword%", nativeQuery = true)

    List<User> searchUserByShop(@Param("keyword") String keyword);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users(email, name, password) VALUES (:email, :name, :password)", nativeQuery = true)
    void addNewUser(@Param("email") String email,
                    @Param("name") String name,
                    @Param("password") String password);
    @Query(value = "select * from users ", nativeQuery = true )
    User getUser(
            @Param("name") String name
    );
}
