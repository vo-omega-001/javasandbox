package org.voomega.sandbox.services.translator.inout;

import java.util.UUID;

public class Output {
    private String id;
    private String uuid;
    private Long timestamp;

    public Output() {
        uuid = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
