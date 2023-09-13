## Quy tắc đặt tên method trong Spring JPA
Trong Spring JPA, cơ chế xây dựng truy vấn thông qua tên của method được quy định bởi các tiền tố sau:

```find…By``` ,``` read…By```,``` query…By```,``` count…By```, và ```get…By.```

phần còn lại sẽ được parse theo tên của thuộc tính (viết hoa chữ cái đầu). Nếu chúng ta có nhiều điều kiện, thì các thuộc tính có thể kết hợp với nhau bằng chữ And hoặc Or.


### @Query 
> Khi được gắn @Query, thì tên của method không còn tác dụng nữa

Sử dụng 
```
<!-- method 1: using ?1 -->
@Query("select u from User u where u.emailAddress = ?1")
User myCustomQuery(String emailAddress);

<!-- method 2: using name assign -->
@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByNamedParams(@Param("status") Integer status, @Param("name") String name);
```

