package com.usingjwttokens.example.tokenbased.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MegaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MCategoryId")
    private Long MCategoryId;
    private String mcategoryName;


    @OneToMany(mappedBy = "megaCategory",cascade = CascadeType.ALL)
    private Set<Category> categories =new HashSet<>();

    public Long getMCategoryId() {
        return MCategoryId;
    }

    public void setMCategoryId(Long McategoryId) {
        MCategoryId = McategoryId;
    }

    public String getmCategoryName() {
        return mcategoryName;
    }

    public void setMCategoryName(String mcategoryName) {
        this.mcategoryName = mcategoryName;
    }
   @JsonManagedReference
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
        for(Category c:categories)
        {
            c.setMegaCategory(this);
        }
    }
}