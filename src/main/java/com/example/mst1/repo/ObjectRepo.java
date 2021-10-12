
package com.example.mst1.repo;
import com.example.mst1.model.RandomObject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepo extends MongoRepository<RandomObject, ObjectId>{


}
