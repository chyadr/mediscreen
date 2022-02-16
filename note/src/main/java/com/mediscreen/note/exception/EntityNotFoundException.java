package com.mediscreen.note.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String id) {

            super(String.format("Entity with Id %d not found", id));
        }
}
