package carShop;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/cars")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hallo, Spring Boot is running";
    }

    @GetMapping("/json")
    public String getCars() throws IOException {
        Resource resource = new ClassPathResource("static/cars.json");
        return new String(Files.readAllBytes(Paths.get(resource.getURI())));
    }
}
