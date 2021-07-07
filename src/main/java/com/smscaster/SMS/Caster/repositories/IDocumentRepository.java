package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDocumentRepository extends MongoRepository<Documents, String> {
  Documents findBy_id(String _id);
}
