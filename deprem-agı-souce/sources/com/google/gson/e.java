package com.google.gson;

import j$.util.Objects;

public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final e f7573d = new e("", "", false);

    /* renamed from: e  reason: collision with root package name */
    public static final e f7574e = new e("\n", "  ", true);

    /* renamed from: a  reason: collision with root package name */
    private final String f7575a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7576b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7577c;

    private e(String str, String str2, boolean z4) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        } else if (str2.matches("[ \t]*")) {
            this.f7575a = str;
            this.f7576b = str2;
            this.f7577c = z4;
        } else {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
    }

    public String a() {
        return this.f7576b;
    }

    public String b() {
        return this.f7575a;
    }

    public boolean c() {
        return this.f7577c;
    }
}
