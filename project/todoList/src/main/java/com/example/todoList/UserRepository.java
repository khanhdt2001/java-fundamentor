package com.example.todoList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findAllByAtk(int atk); // sử dụng hàm tự động build của Spring JPA dựa theo cách đặt tên
    List<User> findAllByAgiBetween(int start, int end);

    /*
     Đang hơi khó hiểu đoạn này vì sao lại không ăn code vì dính lỗi 
     Reason: Validation failed for query for method public abstract
     @Query("SELECT u FROM users u WHERE u.def = :def")
     User findUserByDefQuery(@Param("def") Integer def);
     */

     @Query(value =  "SELECT u.* FROM users u WHERE u.def = :def", nativeQuery = true)
     User findUserByDefQuery(@Param("def") Integer def);


    @Query(value ="SELECT * FROM Users u WHERE u.def = ?1", nativeQuery = true)
    User findUserByDefSQLQuery(Integer def);

    // List<User> findAllByAgiGreaterThan(int agiThreshold);

}
