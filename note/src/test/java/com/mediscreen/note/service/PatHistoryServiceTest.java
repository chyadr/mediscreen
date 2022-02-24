package com.mediscreen.note.service;

import com.mediscreen.note.ConstantsTest;
import com.mediscreen.note.model.PatHistory;
import com.mediscreen.note.repository.PatHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class PatHistoryServiceTest {


    @InjectMocks
    private PatHistoryService patHistoryService;
    @Mock
    private PatHistoryRepository patHistoryRepository;


    @Test
    public void givenNothing_whenFindAllNotes_thenReturnList() {
        when(patHistoryRepository.findAllByPatId(anyLong())).thenReturn(ConstantsTest.notes);
        List<PatHistory> notes =patHistoryService.findAllByPatId(1L);
        assertNotNull(notes);
        assertEquals(1, notes.size());
    }

    @Test
    public void givenPatientId_whenFindNote_thenReturnNote() {
        when(patHistoryRepository.findById(anyString())).thenReturn(Optional.of(ConstantsTest.note));
        PatHistory note =patHistoryService.findById("id");
        assertNotNull(note);
    }


    @Test
    public void givenPatient_whenCreateNote_thenReturnCreatedNote() {
        when(patHistoryRepository.save(any())).thenReturn(ConstantsTest.note);
        PatHistory note = patHistoryService.createPatHistory(ConstantsTest.note);
        assertNotNull(note);
    }

    @Test
    public void givenPatient_whenUpdateNote_thenReturnUpdatedNote() {
        when(patHistoryRepository.save(any())).thenReturn(ConstantsTest.note);
        PatHistory note = patHistoryService.updatePatHistory(ConstantsTest.note);
        assertNotNull(note);
    }

    @Test
    public void givenPatientId_whenDeletePatient_thenVerify() {
       when(patHistoryRepository.findById(anyString())).thenReturn(Optional.of(ConstantsTest.note));
        patHistoryService.deletePatHistory("id");
        verify(patHistoryRepository,times(1)).delete(ConstantsTest.note);
    }

}
