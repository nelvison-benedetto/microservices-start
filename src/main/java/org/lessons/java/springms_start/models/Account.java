package org.lessons.java.springms_start.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accounts")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "customer")  //@tostring NEVER apply x relation fields!!
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)  //callSuper di default is false, and in superclass i don't have a accountId, but lombock wants always details how manage it
public class Account extends BaseEntity implements Serializable{  //use as base BaseEntity
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    @EqualsAndHashCode.Include
    private Integer accountId;


    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;


    //RELATIONS

    @ManyToOne(fetch = FetchType.LAZY)  //many account possono essere associati ad 1 account. no limits of number of accounts 
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;  //il father a cui appartiene this child Account

}
