package com.google.gson;

import j$.util.Objects;
import java.lang.reflect.Field;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Field f7564a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f7564a = field;
    }

    public String toString() {
        return this.f7564a.toString();
    }
}
