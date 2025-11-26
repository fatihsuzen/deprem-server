package androidx.datastore.preferences.protobuf;

@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private static final int IS_EDITION_BIT = 4;
    private static final int IS_PROTO2_BIT = 1;
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.defaultInstance = messageLite;
        this.info = str;
        this.objects = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c5 = charAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 55296) {
                c5 |= (charAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            } else {
                this.flags = c5 | (charAt2 << i5);
                return;
            }
        }
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    /* access modifiers changed from: package-private */
    public Object[] getObjects() {
        return this.objects;
    }

    /* access modifiers changed from: package-private */
    public String getStringInfo() {
        return this.info;
    }

    public ProtoSyntax getSyntax() {
        int i5 = this.flags;
        if ((i5 & 1) != 0) {
            return ProtoSyntax.PROTO2;
        }
        if ((i5 & 4) == 4) {
            return ProtoSyntax.EDITIONS;
        }
        return ProtoSyntax.PROTO3;
    }

    public boolean isMessageSetWireFormat() {
        if ((this.flags & 2) == 2) {
            return true;
        }
        return false;
    }
}
