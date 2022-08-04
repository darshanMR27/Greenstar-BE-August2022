package com.outreach.greenstar.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @Column
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    private int id;
    
    @Column(nullable=false, unique=true)
    private int rollNumber;
    
    @Column(nullable=false)
    private String name;
    
    @Column
    private String caste;
    
    @Column
    private String religion;
    
    @Column
    private String gender;
    
    @Column
    private Date joiningDate;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private School school;
    
    @ManyToOne(cascade=CascadeType.ALL)
    private Cls cls;
    
    @ManyToOne(optional=true, cascade=CascadeType.ALL)
    private Section section;
    
    @ManyToOne(optional=true, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Group group;
    
    @Column
    private String city;
    
    @Column
    private int pincode;
    
    @Column
    private String address;
    
}
