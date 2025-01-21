package vttp.batch5.paf.day26;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.batch5.paf.day26.repositories.SeriesRepository;

@SpringBootApplication
public class Day26Application implements CommandLineRunner {

	@Autowired
	private SeriesRepository seriesRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day26Application.class, args);
	}

	@Override
	public void run(String... args) {

		// Execute the query
		//List<Document> results = seriesRepo.findSeriesByName("love");
		// List<Document> results = seriesRepo.findSeriesByRating(7.5f);
		List<String> results = seriesRepo.findTypeOfSeries();

		System.out.printf(">>> type of series: %s\n ", results);

		// results.stream()
		// 	.limit(3)
		// 	.forEach(d -> {
		// 		System.out.printf(">>>>> %s\n", d.toJson());
		// 	});


	}

}
