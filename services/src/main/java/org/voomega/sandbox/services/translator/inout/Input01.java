package org.voomega.sandbox.services.translator.inout;


import java.sql.Timestamp;

public class Input01 {
    private Timestamp timestamp;
    private String firstName;
    private String lastName;

    public Input01(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
