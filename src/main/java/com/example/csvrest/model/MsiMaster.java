package com.example.csvrest.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "msimaster")
public class MsiMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Institution Type")
    private String institutionType;

    @CsvBindByName(column = "Phone Number")
    private String phoneNumber;

    @CsvBindByName(column = "Website")
    private String website;
}
