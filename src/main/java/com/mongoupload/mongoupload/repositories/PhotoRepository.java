package com.mongoupload.mongoupload.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoupload.mongoupload.documents.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> { }