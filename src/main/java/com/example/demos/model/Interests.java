package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is the entity implementation for the table <em>interest</em>
 * from the application database. 
 * This provides hybernate with the ability to return a list of maped id to each
 * string words in a structure like so "String: key", thus allowing the 
 * user in the frontend to access the intressed by only writing the string word back.
 * 
 * @author Netanel Avraham Eklind
 * @version 1.0.0
 * 
 */
@Entity
public class Interests {

    @Id
    private Integer id;
    private String name;

    public void setid(int id){
        this.id = id;
    }

    public void  interest(String interest){
        this.name = interest;
    }

    public Integer getId(){
        return this.id;
    }

    public String getString(){
        return this.name;
    }

    public String toString(){
        return "[\""+this.name + "\" : " + this.id + "]";
    }
    
}