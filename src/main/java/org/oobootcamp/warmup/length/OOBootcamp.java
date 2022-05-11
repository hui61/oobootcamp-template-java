package org.oobootcamp.warmup.length;

import java.util.Objects;

public final class OOBootcamp {
    private final String message;

    public OOBootcamp(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OOBootcamp) obj;
        return Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "OOBootcamp[" +
                "message=" + message + ']';
    }

}
