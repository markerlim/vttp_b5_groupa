package vttp.batch5.paf.day28.respositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.stereotype.Repository;

@Repository
public class SeriesRepository {

   @Autowired
   private MongoTemplate template;

   /*
    * db.series.aggregate([
         { $unwind: '$genres'},
         {
            $group: {
               _id: '$genres',
               count: { $sum: 1 }
            }
         },
         { $sort: { _id: 1 }}
      ])
    */

   public List<Document> listSeriesByGenres() {

      UnwindOperation unwindGenres = Aggregation.unwind("genres");

      GroupOperation groupAndCountGenres = Aggregation.group("genres")
            .count().as("count");

      SortOperation sortGeneres = Aggregation.sort(Sort.Direction.ASC, "_id");

      Aggregation pipeline = Aggregation.newAggregation(
            unwindGenres, groupAndCountGenres, sortGeneres);

      return template.aggregate(pipeline, "series", Document.class).getMappedResults();
   }
   
}
