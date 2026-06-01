# Phần 1: Phân tích logic

Hiện tại khi truy cập:

```txt
/products
```

người dùng có thể xem danh sách sản phẩm mà không cần đăng nhập vì ứng dụng Spring Boot chưa tích hợp Spring Security.

Trong project hiện tại chưa có dependency:

```groovy
spring-boot-starter-security
```

nên Spring Boot không tự động tạo cơ chế bảo mật cho ứng dụng. Điều đó có nghĩa là request từ client sẽ đi thẳng tới `ProductController`.

Controller hiện tại:

```java
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<String> getAllProducts() {
        return Arrays.asList("Laptop Thinkpad", "Mouse Logitech", "Keyboard Akko");
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to SmartRetail Hub!";
    }
}
```

Vì không có lớp bảo mật nào chặn request trước khi vào controller, nên bất kỳ ai có URL đều có thể truy cập `/products`.

Nguyên nhân gốc rễ:

```txt
Ứng dụng chưa cài Spring Security
Chưa có SecurityFilterChain
Chưa có cơ chế đăng nhập
Chưa có cấu hình yêu cầu xác thực cho /products
```

Vì vậy endpoint `/products` đang là endpoint public.

---