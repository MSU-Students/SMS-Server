package com.smscaster.SMS.Caster.repositories;

import java.util.Optional;

import com.smscaster.SMS.Caster.models.Documents;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDocumentRepository extends MongoRepository<Documents, String> {
  Documents findBy_id(ObjectId _id);
}
