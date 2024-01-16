package com.email.send.Entity;

import com.email.send.Entity.Mail;

public class MailRequest {
    private String to;
    private Mail structure;

    // Getters et setters

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Mail getStructure() {
        return structure;
    }

    public void setStructure(Mail structure) {
        this.structure = structure;
    }
}

