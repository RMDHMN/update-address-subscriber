package org.canal.updateaddress;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

@Slf4j
@org.springframework.boot.autoconfigure.SpringBootApplication
public class UpdateAddressApplication {


    public static void main(String[] args) {
        log.info("-----------------     Starting update address application context...");
        SpringApplication.run(UpdateAddressApplication.class, args);

    }
}
