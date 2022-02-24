package com.mediscreen.assessment.util;

public enum NoteTerms {

    HEMOGLOBINE_A1C("Hémoglobine A1C"),
    MICROALBUMINE("Microalbumine"),
    TAILLE("Taille"),
    POIDS("Poids"),
    FUMEUR("Fumeur"),
    ANORMAL("Anormal"),
    CHOLESTEROL("Cholestérol"),
    VERTIGE("Vertige"),
    RECHUTE("Rechute"),
    REACTION("Réaction"),
    ANTI_CORPS("Anticorps");
    private final String termsValue;

    NoteTerms(String termsValue) {
        this.termsValue=termsValue;
    }

    public String getTermsValue() {
        return termsValue;
    }
}
