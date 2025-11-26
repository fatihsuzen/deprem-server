package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    SYNTAX_EDITIONS(2),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_EDITIONS_VALUE = 2;
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = null;
    private final int value;

    private static final class SyntaxVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new SyntaxVerifier();
        }

        private SyntaxVerifier() {
        }

        public boolean isInRange(int i5) {
            if (Syntax.forNumber(i5) != null) {
                return true;
            }
            return false;
        }
    }

    static {
        internalValueMap = new Internal.EnumLiteMap<Syntax>() {
            public Syntax findValueByNumber(int i5) {
                return Syntax.forNumber(i5);
            }
        };
    }

    private Syntax(int i5) {
        this.value = i5;
    }

    public static Syntax forNumber(int i5) {
        if (i5 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i5 == 1) {
            return SYNTAX_PROTO3;
        }
        if (i5 != 2) {
            return null;
        }
        return SYNTAX_EDITIONS;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Syntax valueOf(int i5) {
        return forNumber(i5);
    }
}
