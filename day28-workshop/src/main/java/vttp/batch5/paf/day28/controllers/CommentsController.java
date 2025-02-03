package vttp.batch5.paf.day28.controllers;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vttp.batch5.paf.day28.repositories.CommentsRepository;

@Controller
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentsController {

   @Autowired
   private CommentsRepository commentsRepo;

   @GetMapping(path="/comments/{user}")
   @ResponseBody
   public ResponseEntity<String> getCommentsByUser(@PathVariable String user) {

      List<Document> results = commentsRepo.searchCommentsByUser(user);
      if (results.size() <= 0)
         return ResponseEntity.status(404).body("Not found: %s".formatted(user));

      return ResponseEntity.ok(results.get(0).toJson());
   }
   
}
