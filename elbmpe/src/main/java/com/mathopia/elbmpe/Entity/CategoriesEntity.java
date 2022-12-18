package com.mathopia.elbmpe.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_categories")
public class CategoriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int categoryid;
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<TopicEntity> topic;
	
	public CategoriesEntity() {}
	public CategoriesEntity(int categoryid, String categoryName, Set<TopicEntity> topic) {
		super();
		this.categoryid = categoryid;
		this.categoryName = categoryName;
		this.topic = topic;
	}
	
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Set<TopicEntity> getTopic() {
		return topic;
	}
	
	public void setTopic(Set<TopicEntity> topic) {
		this.topic = topic;
	}
	
	
}
