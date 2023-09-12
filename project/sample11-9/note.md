
## @Configuration và @Bean
```@Configuration``` là một Annotation đánh dấu trên một Class cho phép Spring Boot biết được đây là nơi định nghĩa ra các Bean.

```@Bean``` là một Annotation được đánh dấu trên các method cho phép Spring Boot biết được đây là Bean < phương thức có giá trị trả về object / Bean > và sẽ thực hiện đưa Bean này vào Context.

```@Bean``` sẽ nằm trong các class có đánh dấu ```@Configuration.``` <br>
=> Hơi na ná abstract class và abstract method

Nếu một Bean có quá nhiều logic để khởi tạo và cấu hình, thì chúng ta sẽ sử dụng ``@Configuration`` và ``@Bean`` để tự tay tạo ra **Bean**. Việc tự tay tạo ra **Bean** như này có thể hiểu phần nào là chúng ta đang *config* cho chương trình.

## Spring Boot Application Config và @Value

file ```application.properties``` hoạt động như kiểu file ```.env``` vậy 
thay vì sử dụng os.getenv như trong golang thì spring boost sử dụng ```@value``` để assign giá trị 
```
public class AppConfig {
    // Lấy giá trị config từ file application.properties
    @Value("${loda.mysql.url}")
    String mysqlUrl;
}
```