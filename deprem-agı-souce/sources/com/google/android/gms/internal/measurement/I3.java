package com.google.android.gms.internal.measurement;

public final class I3 extends Exception {
    public I3(String str) {
        super(str);
    }

    public I3(String str, Throwable th) {
        super("ContentProvider query failed", th);
    }
}
