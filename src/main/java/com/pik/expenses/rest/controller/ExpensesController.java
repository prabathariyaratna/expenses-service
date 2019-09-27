package com.pik.expenses.rest.controller;

import com.pik.expenses.domain.ExpensesMongoObj;
import com.pik.expenses.rest.api.Category;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.created;

import com.pik.expenses.rest.api.ExpensesGet;
import com.pik.expenses.rest.api.ExpensesPost;
import com.pik.expenses.service.ExpensesService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/**/")
@Api(value = "**")
public class ExpensesController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ExpensesController.class);

    private final ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }
    @ApiOperation(value = "Get a file.", notes = "Get a single file given the full URL path and filename with extension.", response = Resource.class, tags={ "file-service-api", })

    @RequestMapping(value = "/{test}.{txt}",
            consumes = { "application/json" },
            method = RequestMethod.POST
    )
    public ResponseEntity<String> createExpenses(@RequestBody ExpensesPost expenses) {
        return created(this.expensesService.createExpenses(expenses)).build();
    }

    @RequestMapping(
            value = "/",
            consumes = { "application/json" },
            method = RequestMethod.PUT
    )
    public void editExpenses(@ApiParam(value = "ExpensesPost id to be updated.", required = true)
    @PathVariable("projectId") String expensesId) {

    }

    @RequestMapping(
            value = "/expenses/{expensesId}",
            method = RequestMethod.DELETE
    )
    public void deleteExpenses(@ApiParam(value = "ExpensesPost id to be deleted.", required = true)
    @PathVariable("expensesId") String projectId) {

    }

    @RequestMapping(
            value = "/expenses/{expensesId}",
            produces = { "application/json" },
            method = RequestMethod.GET
    )
    public ExpensesGet getExpenses(@PathVariable("expensesId") String expensesId) {
        ExpensesGet expensesGet = this.expensesService.getExpenses(expensesId);
        expensesGet.add(linkTo(methodOn(ExpensesController.class).getExpenses(expensesId)).withSelfRel());
        return expensesGet;
    }

    @RequestMapping(
            value = "/expenses",
            produces = { "application/json" },
            method = RequestMethod.GET
    )
    public List<ExpensesGet> getExpenses() {
        List<ExpensesGet> expList = new ArrayList<>();
        expList.add(newExpenses());
        expList.add(newExpenses());
        return expList;
    }

    private ExpensesGet newExpenses() {
        ExpensesGet exp = new ExpensesGet();
        exp.setNote("Note1");
        exp.setAmount(new BigDecimal(1234.22));

        return exp;
    }

}
