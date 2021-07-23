package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Message;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMessageRepository extends MongoRepository<Message, String> {
    Message findBy_id(String _id);
}
