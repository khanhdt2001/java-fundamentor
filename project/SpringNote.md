# Spring Boost 

## Bean Life Cycle

**Spring Boot** từ thời điểm chạy lần đầu tới khi shutdown thì các Bean nó quản lý sẽ có một vòng đời được biểu diễn

1. Khi IoC Container (ApplicationContext) tìm thấy một Bean cần quản lý, nó sẽ khởi tạo bằng Constructor
2. inject dependencies vào Bean bằng Setter, và thực hiện các quá trình cài đặt khác vào Bean như setBeanName, setBeanClassLoader, v.v..
3. Hàm đánh dấu @PostConstruct được gọi
4. Tiền xử lý sau khi @PostConstruct được gọi.
5. Bean sẵn sàng để hoạt động
6. Nếu IoC Container không quản lý bean nữa hoặc bị shutdown nó sẽ gọi hàm @PreDestroy trong Bean
7. Xóa Bean.


```@PostConstruct``` và ```@PreDestroy``` là 2 Annotation cực kỳ ý nghĩa, nếu bạn nắm được vòng đời của một Bean, bạn có thể tận dụng nó để làm các nhiệm vụ riêng như setting, thêm giá trị mặc định trong thuộc tính sau khi tạo, xóa dữ liệu trước khi xóa, v.v.. Rất nhiều chức năng khác tùy theo nhu cầu.

## @SpringBootApplication 
Spring cần biết nơi để khởi chạy ngay trên hàm gọi 
> SpringApplication.run(App.class, args);

spring đặt tên cho container chứa các bean (dependance) là ```ApplicationContext```


```
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        // Lấy Bean ra bằng cách
        Outfit outfit = context.getBean(Outfit.class);

        // In ra để xem thử nó là gì
        System.out.println("Out Instance: " + outfit);
        // xài hàm wear()
        outfit.wear();

        Girl girl = context.getBean(Girl.class);

        System.out.println("Girl Instance: " + girl);

        System.out.println("Girl Outfit: " + girl.outfit);

        girl.outfit.wear();

    }
}
```

##  @Autowired
Thuộc tính Outfit của Girl bởi Annotation @Autowired. Spring Boot tự động inject một instance của Outfit vào thuộc tính này khi khởi tạo Girl.
```
@Component
public class Girl {

    @Autowired
    Outfit outfit;

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    // GET
    // SET
}
```

> Tất cả những Bean được quản lý trong ApplicationContext đều chỉ được tạo ra một lần duy nhất và khi có Class yêu cầu @Autowired thì nó sẽ lấy đối tượng có sẵn trong ApplicationContext để inject vào.

Trong trường hợp bạn muốn mỗi lần sử dụng là một instance hoàn toàn mới. Thì hãy đánh dấu @Component đó bằng @Scope("prototype")

```
@Component
@Scope("prototype")
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Mặc bikini");
    }
}
```


Sau khi tìm thấy một class đánh dấu @Component. thì quá trình inject Bean xảy ra theo cách như sau:
1. Nếu Class không có hàm Constructor hay Setter. Thì sẽ sử dụng Java Reflection để đưa đối tượng vào thuộc tính có đánh dấu @Autowired.
2. Nếu có hàm Constructor thì sẽ inject Bean vào bởi tham số của hàm
3. Nếu có hàm Setter thì sẽ inject Bean vào bởi tham số của hàm
```
@Component
public class Girl {

    // Đánh dấu để Spring inject một đối tượng Outfit vào đây
    @Autowired
    Outfit outfit;

    // Spring sẽ inject outfit thông qua Constructor trước
    public Girl() { }


    // Nếu không tìm thấy Constructor thoả mãn, nó sẽ thông qua setter
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    // GET
    // SET
}

@Component
public class Girl {

    // Đánh dấu để Spring inject một đối tượng Outfit vào đây
    Outfit outfit;

    // Spring sẽ inject outfit thông qua Constructor trước
    public Girl() { }


    @Autowired
    // Nếu không tìm thấy Constructor thoả mãn, nó sẽ thông qua setter
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    // GET
    // SET
}
```

Khi có nhiều hơn 1 dữ liệu có thể autowired thì cần gán cho 1 cái là ```@Primary``` lúc này sẽ gán auto là primary class, nhưng nếu ở component gọi autowired gán ```@Qualifier()``` thì sẽ chọn cái được gán

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

## @Controller
**Spring Boot** sẽ lắng nghe các request từ phía người dùng. và tùy theo đường dẫn path là gì, nó sẽ mapping tới hàm xử lý tương ứng trong ``@Controller``.

Như ví dụ trên, tôi sử dụng GET vào địa chỉ ```localhost:8080/``` ( đường dẫn là /). **Spring Boot** sẽ gọi tới hàm có gắn ```@GetMapping("/")``` và yêu cầu hàm này xử lý request này.

Trong ví dụ trên, tôi chỉ trả về một file index.html là xong, không cần nghiệp vụ gì khác.


## Quy tắc đặt tên method trong Spring JPA
Trong Spring JPA, cơ chế xây dựng truy vấn thông qua tên của method được quy định bởi các tiền tố sau:

```find…By``` ,``` read…By```,``` query…By```,``` count…By```, và ```get…By.```

phần còn lại sẽ được parse theo tên của thuộc tính (viết hoa chữ cái đầu). Nếu chúng ta có nhiều điều kiện, thì các thuộc tính có thể kết hợp với nhau bằng chữ And hoặc Or.


## @Query 
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

## @ConfigurationProperties
hơi giống  @Value nhưng mà nhìn thuận tiện hơn
```
@Data // Lombok
@Component // Là 1 spring bean
// @PropertySource("classpath:loda.yml") // Đánh dấu để lấy config từ trong file loda.yml
@ConfigurationProperties(prefix = "loda") // Chỉ lấy các config có tiền tố là "loda"
public class LodaAppProperties {
    private String email;
    private String googleAnalyticsId;

    // standard getters and setters
}


@SpringBootApplication
@EnableConfigurationProperties
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

<!-- file  -->
loda:
  email: khanhdtdz@gmail.com
  googleAnalyticsId: U-xxxxx
```


# set up config

set up config cho từng cấu hình riếng ví dự như môi trường dev và local, aws, ...
ngoài ra còn có thể set up cho từng bean chỉ đượng chạy ở những môi trường cố định 

```
<!-- application-aws.yml -->
server:
  port: 9001

spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:postgresql://localhost:54321/todoList


<!-- application.yml  -->
---
spring.config.activate.on-profile: local
spring.config.activate.on-profile.include: local, common
---
spring.config.activate.on-profile: aws
spring.config.activate.on-profile.include: aws, common
---

<!-- setup bean config -->

@Component
@Profile("local") // > this bean only run in env local
public class LocalDatasourceConfig{}
```

Chọn config hay env có 2 cách đang chạy được trên repo này <br>
1. set up trong file ```@SpringBootApplication```
```
    SpringApplication application = new SpringApplication(App.class);
    ConfigurableEnvironment environment = new StandardEnvironment();
    environment.setActiveProfiles("aws");
    application.setEnvironment(environment);
    ApplicationContext context = application.run(args);
```
2. set up trong file ```application.yml```
```
spring.profiles.active=aws
```

## @Conditional
Bean chỉ được load lên hoặc khởi tạo theo một điều kiện nào đó. Ví dụ như tạo một Bean trong môi trường Test, còn môi trường thật sẽ không cần nữa.
> **Spring Boot** hỗ trợ chúng ta làm điều này với Annotation ```@Conditional```.

- ```@ConditionalOnBean``` sử dụng khi chúng ta muốn tạo ra một Bean, chỉ khi có một Bean khác đang tồn tại
- ```@ConditionalOnProperty``` khi bạn muốn quyết định sự tồn tại Bean thông qua cấu hình property.
    ```
    @ConditionalOnProperty(
                value="loda.bean2.enabled",
                havingValue = "true", // Nếu giá trị loda.bean2.enabled  = true thì Bean mới được khởi tạo
                matchIfMissing = false) // matchIFMissing là giá trị mặc định nếu không tìm thấy property loda.bean2.enabled
        ABeanWithCondition2 aBeanWithCondition2(){
            return new ABeanWithCondition2();
        }
    ```
- ```@ConditionalOnExpression``` thỏa mãn điều kiện trọng property
- ```@ConditionalOnMissingBean``` Nếu trong Context chưa tồn tại bất kỳ Bean nào tương tự, thì ```@ConditionalOnMissingBean``` sẽ thỏa mãn điều kiện và tạo ra một Bean như thế.
- ```@ConditionalOnResource``` thỏa mãn khi có một resources nào đó do bạn chỉ định tồn tại
- ```@ConditionalOnClass``` thỏa mãn khi trong classpath có tồn tại class mà bạn yêu cầu
- ``` @ConditionalOnMissingClass ``` 
- ``` @ConditionalOnJava ``` thỏa mãn nếu môi trường chạy version Java đúng với điều kiện

Ngoài ra có thể tạo được **Custom conditional**

```
<!-- Cách 1 -->
/*
Một điều kiện, phải kế thừa lớp Condition của Spring Boot cung cấp
 */
public class WindowRequired implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // Nếu OS ra window trả ra true.
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}

<!-- Cách 2 -->
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
// Đánh dấu annotation này bởi @Conditional(WindowRequired.class)
@Conditional(WindowRequired.class)
public @interface ConditionalOnWindow {
    /*
    Trong trường hợp bạn muốn viết ngắn gọn,
    hay tạo ra 1 Annotation mới và gắn @Conditional(WindowRequired.class)
    trên nó

    Như vậy khi cần sử dụng chỉ cần gọi @ConditionalOnWindow là được
     */
}


<!-- Sử dụng của cách 1  -->
@Configuration
public class AppConfiguration {
    public static class SomeBean{
    }

    /*
    SomeBean chỉ được tạo ra khi
    thỏa mãn điều kiện
     */
    @Conditional(WindowRequired.class)
    @Bean
    SomeBean someBean(){
        return new SomeBean();
    }
}

<!-- Sử dụng của cách 2 -->
@Configuration
public class AppConfiguration {
    public static class SomeBean{
    }

    /*
    SomeBean chỉ được tạo ra khi
    thỏa mãn điều kiện
     */
    @ConditionalOnWindow
    @Bean
    SomeBean someBean(){
        return new SomeBean();
    }
}
```

