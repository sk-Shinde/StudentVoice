package com.studentVoice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="FeedBackForm")
public class FeedbackForm {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stdid;
	private String name;
	private String email;
	private String course;
	private String batch;
	private String trainerName;
	private String feedback;







	public long getStdid() {
		return stdid;
	}

	public void setStdid(long stdid) {
		this.stdid = stdid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	
	
//	public FeedbackForm() {
//		super();
//	}
//
//
//	
//	public FeedbackForm(long id, String name, String email, String course, String batch, String trainerName,
//			String feedback) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.course = course;
//		this.batch = batch;
//		this.trainerName = trainerName;
//		this.feedback = feedback;
//	}

}
