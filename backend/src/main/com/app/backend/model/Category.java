package com.app.backend.model;

import jakarta.persistence.*;
import Lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.list;

@Data
@Entity
@Table(name="categorias")
public class Category{
    @Id
    @GeneratedValue(strategy = GeneratioType.IDENTITY)

    private Long id;

    @Column(nullable= false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;   

    @Column (nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "category", cascade = cascadeType.ALL)
    @JsonIgnore
    private list <Subcategory> subcategory

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getname(){
        this.name;
    }

    public void setname(String name){
        this.name = name;
    }
    
    public void setId(){
        this.name name;
    }

    public String getDescription(){
        return description
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Boolean getActive(){
        return active;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public List<Subcategory> getSubcategories(){
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories){
        this.subcategories = subcategories;
    }
}