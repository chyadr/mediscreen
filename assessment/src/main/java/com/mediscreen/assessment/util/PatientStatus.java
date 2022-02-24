package com.mediscreen.assessment.util;

public enum PatientStatus {
    NONE("None"),BORDER_LINE("BorderLine"),IN_DANGER("In Danger"),EARLY_ONSET("Early Onset");

    private final String statusValue;

    PatientStatus(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusValue() {
        return statusValue;
    }
}
