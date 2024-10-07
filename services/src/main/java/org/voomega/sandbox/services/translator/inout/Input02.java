package org.voomega.sandbox.services.translator.inout;

import java.util.Date;

public class Input02 {
    private String [] id;
    private Date date;

    public Input02(String firstName, String lastName) {
        id = new String [] {firstName, lastName};
        date = new Date();
    }

    public String[] getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
