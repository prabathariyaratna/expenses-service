package com.pik.expenses.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pik.expenses.assembler.ExpensesAssembler;
import com.pik.expenses.domain.ExpensesMongoObj;
import com.pik.expenses.repositories.MongoDbExpensesRepository;
import com.pik.expenses.rest.api.ExpensesPost;
import com.pik.expenses.rest.api.ExpensesGet;
import com.pik.expenses.rest.controller.ExpensesController;

@Service
public class ExpensesService {
    private final MongoDbExpensesRepository mongoDbExpensesRepository;
    private final ExpensesAssembler expensesAssembler;

    @Autowired
    public ExpensesService(MongoDbExpensesRepository mongoDbExpensesRepository, ExpensesAssembler expensesAssembler) {
        this.mongoDbExpensesRepository = mongoDbExpensesRepository;
        this.expensesAssembler = expensesAssembler;
    }

    public URI createExpenses(ExpensesPost expenses) {
        ExpensesMongoObj expensesMongoObj = mongoDbExpensesRepository.save(expensesAssembler.from(expenses));
        return linkTo(ExpensesController.class).slash(expensesMongoObj).toUri();
    }

    public ExpensesGet getExpenses(String expensesId) {
        ExpensesMongoObj expensesMongoObj = this.mongoDbExpensesRepository
                .findOneByExpensesId(new ObjectId(expensesId));

        if (expensesMongoObj == null) {
            return null;
        }

        return this.expensesAssembler.toResource(expensesMongoObj);
    }

    public void updateExpenses(ExpensesPost expenses) {

    }
}
