package com.mathopia.elbmpe.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_topic")
public class TopicEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicID;
	private String title;
	private String learningG;
	private String vidSource;
	
	public TopicEntity() {}
	public TopicEntity(int topicID, String title, String learningG, String vidSource) {
		super();
		this.topicID = topicID;
		this.title = title;
		this.learningG = learningG;
		this.vidSource = vidSource;
	}

	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLearningG() {
		return learningG;
	}

	public void setLearningG(String learningG) {
		this.learningG = learningG;
	}

	public String getVidSource() {
		return vidSource;
	}

	public void setVidSource(String vidSource) {
		this.vidSource = vidSource;
	}
	
	
	

}
