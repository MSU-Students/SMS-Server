package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Recipients;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRecipientRepository extends MongoRepository<Recipients, String> {
  Recipients findBy_id(ObjectId _id);
}
