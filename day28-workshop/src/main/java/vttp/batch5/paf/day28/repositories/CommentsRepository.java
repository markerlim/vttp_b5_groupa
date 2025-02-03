package vttp.batch5.paf.day28.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;

@Repository
public class CommentsRepository {

   @Autowired
   private MongoTemplate template;

   /*
    * db.comments.aggregate([
    *    {
    *       $match: { 'user': { $regex: 'paydirt', $options: 'i' } }
    *    },
    *    {
    *      $lookup: {
    *       from: 'games',
    *       foreignField: 'gid',
    *       localField: 'gid',
    *       as: 'games'
      *    }
    *    },
    *    {
    *       $group: {
    *          _id: '$user',
    *          comments: {
    *             $push: {
    *                gid: '$gid',
    *                name: '$games.name',
    *                rating: '$rating',
    *                text: '$c_text'
    *             }
    *          }
    *       }
    *    }
    * ])
    */
   public List<Document> searchCommentsByUser(String user) {

      // Match user
      Criteria criterial = Criteria.where("user")
            .regex(user, "i");
      MatchOperation findUserByName = Aggregation.match(criterial);

      // Join comment with the game
      LookupOperation joinComments = Aggregation.lookup("games", "gid", "gid", "games");

      // Group the results by user
      GroupOperation groupByUser = Aggregation.group("user")
            .push(
               new BasicDBObject()
                  .append("gid", "$gid")
                  .append("name", "$games.name")
                  .append("rating", "$rating")
                  .append("text", "$c_text")
            ).as("comments");

      // Create pipeline
      Aggregation pipeline = Aggregation.newAggregation(
         findUserByName, joinComments, groupByUser);

      return template.aggregate(pipeline, "comments", Document.class).getMappedResults();
   }
   
}
