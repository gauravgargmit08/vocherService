package com.gg.voucher.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gg.voucher.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}