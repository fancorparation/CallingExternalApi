package fan.company.callingexternalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "fan.company.callingexternalapi.services")
public class CallingExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallingExternalApiApplication.class, args);
    }

}
