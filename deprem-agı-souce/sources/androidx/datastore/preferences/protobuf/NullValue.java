package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;

public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static final Internal.EnumLiteMap<NullValue> internalValueMap = null;
    private final int value;

    private static final class NullValueVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new NullValueVerifier();
        }

        private NullValueVerifier() {
        }

        public boolean isInRange(int i5) {
            if (NullValue.forNumber(i5) != null) {
                return true;
            }
            return false;
        }
    }

    static {
        internalValueMap = new Internal.EnumLiteMap<NullValue>() {
            public NullValue findValueByNumber(int i5) {
                return NullValue.forNumber(i5);
            }
        };
    }

    private NullValue(int i5) {
        this.value = i5;
    }

    public static NullValue forNumber(int i5) {
        if (i5 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NullValueVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i5) {
        return forNumber(i5);
    }
}
