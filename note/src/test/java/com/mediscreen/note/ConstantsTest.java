package com.mediscreen.note;

import com.mediscreen.note.model.PatHistory;

import java.util.List;


public class ConstantsTest {

    public static final List<PatHistory> notes = List.of(new PatHistory().patId(1L).patient("patient")
            .note("Anormal"));

    public static final PatHistory note = new PatHistory().patId(1L).patient("patient")
            .note("Anormal");
}