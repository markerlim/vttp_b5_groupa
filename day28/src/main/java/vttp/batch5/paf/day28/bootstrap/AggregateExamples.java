package vttp.batch5.paf.day28.bootstrap;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vttp.batch5.paf.day28.respositories.BGGRepository;
import vttp.batch5.paf.day28.respositories.SeriesRepository;

@Component
public class AggregateExamples implements CommandLineRunner {

   @Autowired
   private BGGRepository bggRepo;

   @Autowired
   private SeriesRepository seriesRepo;

   @Override
   public void run(String... args) {

      //List<Document> results = bggRepo.findGamesByName("carcassonne");
      List<Document> results = bggRepo.groupCommentsByUser();
      //List<Document> results = seriesRepo.listSeriesByGenres();
      System.out.printf(">>> count: %d\n", results.size());

      for (Document d: results)
         System.out.printf(">>>> %s\n\n", d);

   }
}
