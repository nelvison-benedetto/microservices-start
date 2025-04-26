package org.lessons.java.springms_start.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;


    //RELATIONS

    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Account> accounts = new ArrayList<>();

}
