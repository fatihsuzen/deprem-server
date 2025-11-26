package com.google.firebase.messaging;

import N.C0720n;
import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

final class c0 {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f7392d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private final String f7393a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7394b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7395c;

    private c0(String str, String str2) {
        this.f7393a = d(str2, str);
        this.f7394b = str;
        this.f7395c = str + "!" + str2;
    }

    static c0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new c0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str != null && f7392d.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, "[a-zA-Z0-9-_.~%]{1,900}"}));
    }

    public String b() {
        return this.f7394b;
    }

    public String c() {
        return this.f7393a;
    }

    public String e() {
        return this.f7395c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (!this.f7393a.equals(c0Var.f7393a) || !this.f7394b.equals(c0Var.f7394b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0720n.b(this.f7394b, this.f7393a);
    }
}
