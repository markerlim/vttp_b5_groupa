package vttp.batch5.paf.day28.startup;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vttp.batch5.paf.day28.repositories.CommentsRepository;

//@Component
public class TestQuery implements CommandLineRunner {

   @Autowired
   private CommentsRepository commentsRepo;

   @Override
   public void run(String... args) {

      List<Document> results = commentsRepo.searchCommentsByUser("paydirt");

      for (Document d: results) {
         System.out.printf(">>> %s\n\n", d);
         List<Document> comments = d.getList("comments", Document.class);
         for (Document c: comments)
            System.out.printf("\t%s\n", c);
      }
   }
   
}
