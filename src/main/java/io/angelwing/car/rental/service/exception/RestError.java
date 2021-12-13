package io.angelwing.car.rental.service.exception;

import java.util.Collection;

public class RestError {
    private final ErrorCode code;
    private final Collection<String> messages;

    public RestError(final ErrorCode code, final Collection<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public ErrorCode getCode() {
        return code;
    }

    public Collection<String> getMessages() {
        return messages;
    }
}
