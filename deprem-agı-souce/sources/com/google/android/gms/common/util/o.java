package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f4886a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean a(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
