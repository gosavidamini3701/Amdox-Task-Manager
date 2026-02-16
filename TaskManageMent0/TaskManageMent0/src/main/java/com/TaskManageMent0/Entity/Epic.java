package com.TaskManageMent0.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name = "epics")
public class Epic {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String title ;
    private String summery ;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummery() {
        return summery;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }
}
