package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

final class SubscriberMethod {

    /* renamed from: a  reason: collision with root package name */
    final Method f8675a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f8676b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f8677c;

    /* renamed from: d  reason: collision with root package name */
    String f8678d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f8675a = method;
        this.f8676b = threadMode;
        this.f8677c = cls;
    }

    private synchronized void a() {
        if (this.f8678d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f8675a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f8675a.getName());
            sb.append('(');
            sb.append(this.f8677c.getName());
            this.f8678d = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.f8678d.equals(((SubscriberMethod) obj).f8678d);
    }

    public final int hashCode() {
        return this.f8675a.hashCode();
    }
}
