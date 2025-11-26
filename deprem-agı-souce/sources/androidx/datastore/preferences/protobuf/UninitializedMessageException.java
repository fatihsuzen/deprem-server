package androidx.datastore.preferences.protobuf;

import j$.util.DesugarCollections;
import java.util.List;

public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    private static String buildDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z4 = true;
        for (String next : list) {
            if (z4) {
                z4 = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> getMissingFields() {
        return DesugarCollections.unmodifiableList(this.missingFields);
    }

    public UninitializedMessageException(List<String> list) {
        super(buildDescription(list));
        this.missingFields = list;
    }
}
