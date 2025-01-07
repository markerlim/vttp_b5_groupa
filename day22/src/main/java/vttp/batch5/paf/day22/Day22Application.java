package vttp.batch5.paf.day22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.batch5.paf.day22.repositories.KindleRepository;

@SpringBootApplication
public class Day22Application implements CommandLineRunner {

    @Autowired
    private KindleRepository kindleRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day22Application.class, args);
	}

	@Override
	public void run(String... args) {
	   kindleRepo.getAuthorAverageRating(100, 10);
	}

}
