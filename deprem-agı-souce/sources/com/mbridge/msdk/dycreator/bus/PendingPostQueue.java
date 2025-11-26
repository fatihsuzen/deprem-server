package com.mbridge.msdk.dycreator.bus;

final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    private PendingPost f8673a;

    /* renamed from: b  reason: collision with root package name */
    private PendingPost f8674b;

    PendingPostQueue() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(PendingPost pendingPost) {
        if (pendingPost != null) {
            try {
                PendingPost pendingPost2 = this.f8674b;
                if (pendingPost2 != null) {
                    pendingPost2.f8672c = pendingPost;
                    this.f8674b = pendingPost;
                } else if (this.f8673a == null) {
                    this.f8674b = pendingPost;
                    this.f8673a = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f8673a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.f8672c;
            this.f8673a = pendingPost2;
            if (pendingPost2 == null) {
                this.f8674b = null;
            }
        }
        return pendingPost;
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a(int i5) throws InterruptedException {
        try {
            if (this.f8673a == null) {
                wait((long) i5);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a();
    }
}
