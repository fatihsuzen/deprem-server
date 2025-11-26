package com.squareup.picasso;

public enum o {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: a  reason: collision with root package name */
    final int f13343a;

    private o(int i5) {
        this.f13343a = i5;
    }

    static boolean a(int i5) {
        if ((i5 & NO_CACHE.f13343a) == 0) {
            return true;
        }
        return false;
    }

    static boolean b(int i5) {
        if ((i5 & NO_STORE.f13343a) == 0) {
            return true;
        }
        return false;
    }
}
