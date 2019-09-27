package com.pik.expenses.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.IdentifiableResourceAssemblerSupport;

import com.pik.expenses.assembler.mapper.ExpensesMapper;
import com.pik.expenses.domain.ExpensesMongoObj;
import com.pik.expenses.rest.api.ExpensesGet;
import com.pik.expenses.rest.api.ExpensesPost;
import com.pik.expenses.rest.controller.ExpensesController;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExpensesAssembler extends IdentifiableResourceAssemblerSupport<ExpensesMongoObj, ExpensesGet> {

    private ModelMapper modelMapper;

    @Autowired
    public ExpensesAssembler(ModelMapper modelMapper) {
        super(ExpensesController.class, ExpensesGet.class);
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new ExpensesMapper());
    }

    @Override
    public ExpensesGet toResource(ExpensesMongoObj expensesMongoObj) {
        return modelMapper.map(expensesMongoObj, ExpensesGet.class);
    }

    public ExpensesMongoObj from(ExpensesGet expensesGet) {
        return modelMapper.map(expensesGet, ExpensesMongoObj.class);
    }

    public ExpensesMongoObj from(ExpensesPost expensesPost) {
        return modelMapper.map(expensesPost, ExpensesMongoObj.class);
    }

}
