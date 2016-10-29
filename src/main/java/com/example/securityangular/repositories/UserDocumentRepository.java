package com.example.securityangular.repositories;

import com.example.securityangular.models.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDocumentRepository extends MongoRepository<UserDocument, String> {

    Optional<UserDocument> findByName(String name);
}
