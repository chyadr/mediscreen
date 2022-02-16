package com.mediscreen.note.service;

import com.mediscreen.note.exception.EntityNotFoundException;
import com.mediscreen.note.model.PatHistory;
import com.mediscreen.note.repository.PatHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatHistoryService implements IPatHistoryService{

    private final PatHistoryRepository patHistoryRepository;

    public PatHistoryService(PatHistoryRepository patHistoryRepository) {
        this.patHistoryRepository = patHistoryRepository;
    }

    @Override
    public List<PatHistory> findAllByPatId(Long patId) {
        return patHistoryRepository.findAllByPatId(patId);
    }

    @Override
    public PatHistory findById(String id) {
        return patHistoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public PatHistory createPatHistory(PatHistory patHistory) {
        return patHistoryRepository.save(patHistory);
    }

    @Override
    public PatHistory updatePatHistory(PatHistory patHistory) {
        return patHistoryRepository.save(patHistory);
    }

    @Override
    public void deletePatHistory(String id) {
        PatHistory patHistory = patHistoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(id));
        patHistoryRepository.delete(patHistory);
    }
}
