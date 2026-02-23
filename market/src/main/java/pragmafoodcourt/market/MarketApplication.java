package pragmafoodcourt.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "file:../.env", ignoreResourceNotFound = true)
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(pragmafoodcourt.market.MarketApplication.class, args);
    }

}
