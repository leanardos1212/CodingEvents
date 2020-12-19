package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    public Skill(){}

    @ManyToMany(mappedBy = "skills")

    private  List<Job> jobs = new ArrayList<>();

    @NotBlank

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Job> getJobs(){
        return jobs;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }
}