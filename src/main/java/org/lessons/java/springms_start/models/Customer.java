package org.lessons.java.springms_start.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "accounts")  //@tostring NEVER apply x relation fields!!
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)  //callSuper di default is false, and in superclass i don't have a customerId, but lombock wants always details how manage it
public class Customer extends BaseEntity implements Serializable{   //use as base BaseEntity

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @EqualsAndHashCode.Include
    private Integer customerId;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;
    

    //RELATIONS

    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();

}
