package com.enigma.api.inventory.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity<ID> {

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createDate;

    @JsonIgnore
    @Column(name = "modified_date")
    private LocalDate modifiedDate;

    public LocalDate getCreateDate() {
        return createDate;
    }

    public abstract ID getId();
    public abstract void setId(ID id);

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    public void prePresist() {
        this.createDate = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDate.now();
    }


}
