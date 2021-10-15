package com.genspark.app.partRest.Entity;
import javax.persistence.*;

//PArt Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "part") //This is for the actual name of the database table we are mapping to the class.
public class Part {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "name") //This will map the name field to the column named job_title in the table.
    private String name;



    //default constructor
    public Part() {
    }

    //para constructor
    public Part(String toname) {
        this.name = toname;
    }

    //getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    //ToString Method
    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
