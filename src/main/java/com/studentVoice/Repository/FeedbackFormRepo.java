package com.studentVoice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentVoice.Entity.FeedbackForm;



public interface FeedbackFormRepo extends JpaRepository<FeedbackForm, Long> {

}
