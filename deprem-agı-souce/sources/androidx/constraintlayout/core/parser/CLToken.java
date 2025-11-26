package androidx.constraintlayout.core.parser;

public class CLToken extends CLElement {
    int mIndex = 0;
    char[] mTokenFalse = "false".toCharArray();
    char[] mTokenNull = "null".toCharArray();
    char[] mTokenTrue = "true".toCharArray();
    Type mType = Type.UNKNOWN;

    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i5);
        sb.append(content());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c5, long j5) {
        int ordinal = this.mType.ordinal();
        boolean z4 = false;
        if (ordinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i5 = this.mIndex;
            if (cArr[i5] == c5) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i5] == c5) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i5] == c5) {
                this.mType = Type.NULL;
            }
            z4 = true;
        } else if (ordinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i6 = this.mIndex;
            if (cArr2[i6] == c5) {
                z4 = true;
            }
            if (z4 && i6 + 1 == cArr2.length) {
                setEnd(j5);
            }
        } else if (ordinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i7 = this.mIndex;
            if (cArr3[i7] == c5) {
                z4 = true;
            }
            if (z4 && i7 + 1 == cArr3.length) {
                setEnd(j5);
            }
        } else if (ordinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i8 = this.mIndex;
            if (cArr4[i8] == c5) {
                z4 = true;
            }
            if (z4 && i8 + 1 == cArr4.length) {
                setEnd(j5);
            }
        }
        this.mIndex++;
        return z4;
    }
}
