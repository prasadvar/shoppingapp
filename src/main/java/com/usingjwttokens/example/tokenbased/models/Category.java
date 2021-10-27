package com.usingjwttokens.example.tokenbased.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    private Long CategoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Productlist> products =new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MCategoryId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MegaCategory megaCategory;
    public Long getCategoryId() {
        return CategoryId;
    }
    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @JsonManagedReference
    public Set<Productlist> getProducts() {
        return products;
    }
    public void setProducts(Set<Productlist> products) {
        this.products = products;
        for(Productlist p:products)
        {
              p.setCategory(this);
        }
    }
    @JsonBackReference
    public MegaCategory getMegaCategory() {
        return megaCategory;
    }
    public void setMegaCategory(MegaCategory megaCategory) {
        this.megaCategory = megaCategory;
    }
}
