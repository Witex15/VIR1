package ch.cpnves.payroll.Repositories;

import ch.cpnves.payroll.Entities.MacBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MacBookRepository repository){
        return args->{
            log.info("Preloading " + repository.save(new MacBook("Pro 16\"", "1 To")));
            log.info("Preloading " + repository.save(new MacBook("Air 14\"", "256 Go")));
        };
    }
}
