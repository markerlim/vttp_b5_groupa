package vttp.batch5.paf.day27;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.batch5.paf.day27.repositories.TaskRepository;

@SpringBootApplication
public class Day27Application implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day27Application.class, args);
	}

	@Override
	public void run(String... args) {

		//taskRepo.insertTask2();
		// taskRepo.update();
		taskRepo.searchComments("enjoyable", "fun times");

	}

}
