package com.studentVoice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentVoice.Entity.Batch;
import com.studentVoice.Repository.BatchRepository;


@Service
public class BatchServiceImpl implements BatchService{

	
	@Autowired
	private BatchRepository batchRepo;

	@Override
	public List<Batch> getAllBatches() {
		return batchRepo.findAll();
	}

	@Override
	public void save(Batch batch) {
		batchRepo.save(batch);
	}

	@Override
	public Batch getById(Long id) {
		Optional<Batch> optional = batchRepo.findById(id);
		Batch batch = null;
		if (optional.isPresent())
			batch = optional.get();
		else
			throw new RuntimeException("Batch not found for id : " + id);
		return batch;
	}

	@Override
	public void deleteViaId(long id) {
		batchRepo.deleteById(id);
	}
}
