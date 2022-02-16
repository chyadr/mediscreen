package com.mediscreen.note.service;

import com.mediscreen.note.model.PatHistory;

import java.util.List;

public interface IPatHistoryService {

    List<PatHistory> findAllByPatId(Long patId);
    PatHistory findById(String id);
    PatHistory createPatHistory(PatHistory patHistory);
    PatHistory updatePatHistory(PatHistory patHistory);
    void deletePatHistory(String id);
}
