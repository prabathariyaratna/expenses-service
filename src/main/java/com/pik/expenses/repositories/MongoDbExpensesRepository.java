package com.pik.expenses.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pik.expenses.domain.ExpensesMongoObj;

@Repository
public interface MongoDbExpensesRepository extends MongoRepository<ExpensesMongoObj, ObjectId> {

    ExpensesMongoObj findOneByExpensesId(ObjectId objectId);
}
