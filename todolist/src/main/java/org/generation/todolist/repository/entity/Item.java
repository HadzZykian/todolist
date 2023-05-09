package org.generation.todolist.repository.entity;

//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.ItemDTO;

@Entity
public class Item {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by Springboot framework)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //retrieve product item by ID - has to be an object
    private String title;
    private String description;
    private String date;

    //Item Class is used to map with the Database table
    //Any CRUD operation, JPA will make use of this Item Class to map
    //For Read of Delete operation, the JPA requires an empty constructor to
    // populate all the records from the database as the Item instances

    //Constructor Overloading
    public Item() {}

    /*  - DTO : Data Transfer Object */
    public Item(ItemDTO itemDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.date = itemDTO.getDate();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String name )
    {
        this.title = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate( String imageUrl )
    {
        this.date = imageUrl;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description + '\'' + ", date='" + date + '}';
    }
}
