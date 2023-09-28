package com.example.shop_rent_manager.repository;


import com.example.shop_rent_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="select * from users u \n" +
            "join user_shop us on u.id = us.user_id \n" +
            "join shops s on us.id= s.id \n" +
            "where s.name LIKE %:keyword%", nativeQuery = true)

    List<User> searchUserByShop(@Param("keyword") String keyword);

}
