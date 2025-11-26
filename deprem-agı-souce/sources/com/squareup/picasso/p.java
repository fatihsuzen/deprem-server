package com.squareup.picasso;

public enum p {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: a  reason: collision with root package name */
    final int f13348a;

    private p(int i5) {
        this.f13348a = i5;
    }

    public static boolean a(int i5) {
        if ((i5 & OFFLINE.f13348a) != 0) {
            return true;
        }
        return false;
    }

    public static boolean b(int i5) {
        if ((i5 & NO_CACHE.f13348a) == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(int i5) {
        if ((i5 & NO_STORE.f13348a) == 0) {
            return true;
        }
        return false;
    }
}
