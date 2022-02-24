package com.mediscreen.note.service;

import com.mediscreen.note.model.PatHistory;

import java.util.List;

public interface IPatHistoryService {
    /**
     * find all note by patient id.
     * @param patId the patient id.
     * @return List of all notes.
     */
    List<PatHistory> findAllByPatId(Long patId);

    /**
     * find a note by patient id.
     * @param id the note id.
     * @return the note found.
     */
    PatHistory findById(String id);

    /**
     * create a new note.
     * @param patHistory the note to be created.
     * @return created note.
     */
    PatHistory createPatHistory(PatHistory patHistory);

    /**
     * update an existing note.
     * @param patHistory the note to be updated.
     * @return the note updated.
     */
    PatHistory updatePatHistory(PatHistory patHistory);

    /**
     * delete a note by id.
     * @param id the note id to be deleted.
     */
    void deletePatHistory(String id);
}
