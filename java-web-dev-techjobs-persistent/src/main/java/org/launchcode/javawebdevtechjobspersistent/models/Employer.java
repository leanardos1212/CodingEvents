package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    public Employer(){}

@OneToMany
@JoinColumn

private List<Job> jobs = new ArrayList<>();



@NotBlank

private String location;

public String getLocation(){
    return location;
}

public void setLocation(String location) {
    this.location = location;
    }



}
