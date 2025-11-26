package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {

    /* renamed from: d  reason: collision with root package name */
    private static final List<PendingPost> f8669d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f8670a;

    /* renamed from: b  reason: collision with root package name */
    Subscription f8671b;

    /* renamed from: c  reason: collision with root package name */
    PendingPost f8672c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f8670a = obj;
        this.f8671b = subscription;
    }

    static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = f8669d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost remove = list.remove(size - 1);
                remove.f8670a = obj;
                remove.f8671b = subscription;
                remove.f8672c = null;
                return remove;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    static void a(PendingPost pendingPost) {
        pendingPost.f8670a = null;
        pendingPost.f8671b = null;
        pendingPost.f8672c = null;
        List<PendingPost> list = f8669d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
