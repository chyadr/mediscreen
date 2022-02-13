package com.mediscreen.patient.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {

            super(String.format("Entity with Id %d not found", id));
        }
}
