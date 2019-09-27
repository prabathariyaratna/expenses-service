package com.pik.expenses.assembler.mapper;

import com.pik.expenses.domain.ExpensesMongoObj;
import com.pik.expenses.rest.api.ExpensesGet;

import org.modelmapper.PropertyMap;

public class ExpensesMapper extends PropertyMap<ExpensesMongoObj, ExpensesGet> {

    @Override
    protected void configure() {
        map().setProject(source.getProject());
        map().setAmount(source.getAmount());
        map().setAttachmentUrl(source.getAttachmentUrl());
        map().setBillable(source.isBillable());
        map().setCategory(source.getCategory());
        map().setDate(source.getDate());
        map().setNote(source.getNote());

    }
}
