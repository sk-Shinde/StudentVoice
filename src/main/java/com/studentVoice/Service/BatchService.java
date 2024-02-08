package com.studentVoice.Service;

import java.util.List;

import com.studentVoice.Entity.Batch;



public interface BatchService {
	
	List<Batch> getAllBatches();

	void save(Batch batch);

	Batch getById(Long id);

	void deleteViaId(long id);

}
