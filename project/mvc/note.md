## Anotation in mvc
Về bản chất thì bạn có thể sử dụng thay thế 3 Annotation ```@Component```, ```@Service``` và ```@Repository```cho nhau mà không ảnh hưởng gì tới code của bạn cả. Nó vẫn sẽ hoạt động.

Tuy nhiên từ góc độ thiết kế thì chúng ta cần phân rõ 3 Annotation này cho các Class đảm nhiệm đúng nhiệm vụ của nó.

- > @Service gắn cho các Bean đảm nhiệm xử lý logic
- > @Repository gắn cho các Bean đảm nhiệm giao tiếp với DB
- > @Component gắn cho các Bean khác.

## Component Scan
> Spring Boot đã đi tìm các Bean bên cạnh class ```App``` và những package con bên cạnh ```App```
Trong trường hợp bạn muốn tuỳ chỉnh cấu hình cho Spring Boot chỉ tìm kiếm các bean trong một package nhất định thì có các cách sau đây:
1. Sử dụng @ComponentScan
```
@ComponentScan("com.example.mvc.model")
// package name want to select bean 
@SpringBootApplication
public class App {
    <!-- some code -->
}
```
2. Sử dụng scanBasePackages tromg @SpringBootApplication.
```
@SpringBootApplication(scanBasePackages = "com.example.mvc.model")
public class App {
    <!-- some code -->
}
```


