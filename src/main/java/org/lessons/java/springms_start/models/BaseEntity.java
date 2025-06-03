package org.lessons.java.springms_start.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  //AuditingEntityListener link the auditing system activated to this entity (so now can listen teh fields, poplate them ect)
@Getter @Setter @ToString
public class BaseEntity {
    
    @CreatedDate  //x auditing
    @Column(updatable = false)   //this field cannot be in query UPDATE
    private LocalDateTime createdAt;

    @CreatedBy  //x auditing
    @Column(updatable = false)  //this field cannot be in query UPDATE
    private String createdBy;

    @LastModifiedDate  //x auditing
    @Column(insertable = true)  //this field cannot be in query INSERT 
    private LocalDateTime updatedAt;

    @LastModifiedBy  //x auditing
    @Column(insertable = false)  //this field cannot be in query INSERT 
    private String updatedBy;

    //PREs  vengono eseguiti prima dell'auditing, quindi nei campi target VENGONO SOVRASCRITTI da auditing results, cmnq its ok x fallback
    @PrePersist  //called before obj Customer/Account saved on db for the first time, then set cols createdAt & updatedAt
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now; 
    }
    @PreUpdate  //called before save the updates on db
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
        //this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
