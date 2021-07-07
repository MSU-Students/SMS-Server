package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Officers;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOfficerRepository extends MongoRepository<Officers, String> {
  Officers findBy_id(ObjectId _id);
}
