package com.mediscreen.note.repository;

import com.mediscreen.note.model.PatHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatHistoryRepository extends MongoRepository<PatHistory,String> {

    List<PatHistory> findAllByPatId(Long patId);

}
