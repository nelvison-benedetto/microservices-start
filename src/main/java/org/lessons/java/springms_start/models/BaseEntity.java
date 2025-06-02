package org.lessons.java.springms_start.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    
    @Column(updatable = false)   //this field cannot be in query UPDATE
    private LocalDateTime createdAt;

    @Column(updatable = false)  //this field cannot be in query UPDATE
    private String createdBy;


    @Column(insertable = true)  //this field cannot be in query INSERT 
    private LocalDateTime updatedAt;

    @Column(insertable = false)  //this field cannot be in query INSERT 
    private String updatedBy;

    //PREs
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
