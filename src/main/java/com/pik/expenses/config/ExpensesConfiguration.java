package com.pik.expenses.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.pik.expenses.assembler.ExpensesAssembler;
import com.pik.expenses.assembler.mapper.ExpensesMapper;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.pik")
public class ExpensesConfiguration {

    @Bean
    public ExpensesMapper expensesMapper() {
        return new ExpensesMapper();
    }

    @Bean
    @ConditionalOnMissingBean(ExpensesAssembler.class)
    public ExpensesAssembler expensesAssembler(ModelMapper modelMapper) {
        return new ExpensesAssembler(modelMapper);
    }

    @Bean
    @ConditionalOnMissingBean(ModelMapper.class)
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
