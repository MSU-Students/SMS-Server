package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Messages;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMessageRepository extends MongoRepository<Messages, String> {
  Messages findBy_id(ObjectId _id);
}
