**Spring Boot** sẽ lắng nghe các request từ phía người dùng. và tùy theo đường dẫn path là gì, nó sẽ mapping tới hàm xử lý tương ứng trong ``@Controller``.

Như ví dụ trên, tôi sử dụng GET vào địa chỉ ```localhost:8080/``` ( đường dẫn là /). **Spring Boot** sẽ gọi tới hàm có gắn ```@GetMapping("/")``` và yêu cầu hàm này xử lý request này.

Trong ví dụ trên, tôi chỉ trả về một file index.html là xong, không cần nghiệp vụ gì khác.