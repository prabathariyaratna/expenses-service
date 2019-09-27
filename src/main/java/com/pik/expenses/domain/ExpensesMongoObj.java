package com.pik.expenses.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import com.pik.expenses.rest.api.Category;
import com.pik.expenses.rest.api.Project;

@Document(collection = "expenses")
public class ExpensesMongoObj implements Identifiable<ObjectId> {
    @Id
    @Indexed()
    private ObjectId expensesId;
    @NotNull
    @CreatedBy
    private String createdBy = null;

    @NotNull
    @CreatedDate
    private LocalDateTime createdOn;

    @NotNull
    @LastModifiedDate
    private LocalDateTime lastModifiedDate = null;

    @NotNull
    @LastModifiedBy
    private String lastModifiedBy = null;
    private Project project;
    private Category category;
    private LocalDateTime date;
    private String note;
    private String attachmentUrl;
    private BigDecimal amount;
    private boolean billable;

    @Override
    public ObjectId getId() {
        return expensesId;
    }

    public ObjectId getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(ObjectId expensesId) {
        this.expensesId = expensesId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ExpensesMongoObj setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public ExpensesMongoObj setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public ExpensesMongoObj setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public ExpensesMongoObj setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }
}
