# Anotation in mvc
Về bản chất thì bạn có thể sử dụng thay thế 3 Annotation ```@Component```, ```@Service``` và ```@Repository```cho nhau mà không ảnh hưởng gì tới code của bạn cả. Nó vẫn sẽ hoạt động.

Tuy nhiên từ góc độ thiết kế thì chúng ta cần phân rõ 3 Annotation này cho các Class đảm nhiệm đúng nhiệm vụ của nó.

- > @Service gắn cho các Bean đảm nhiệm xử lý logic
- > @Repository gắn cho các Bean đảm nhiệm giao tiếp với DB
- > @Component gắn cho các Bean khác.