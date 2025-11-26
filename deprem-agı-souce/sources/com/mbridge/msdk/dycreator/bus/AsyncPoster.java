package com.mbridge.msdk.dycreator.bus;

class AsyncPoster implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f8640a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private final EventBus f8641b;

    AsyncPoster(EventBus eventBus) {
        this.f8641b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f8640a.a(PendingPost.a(subscription, obj));
        EventBus.f8645a.execute(this);
    }

    public void run() {
        PendingPost a5 = this.f8640a.a();
        if (a5 != null) {
            this.f8641b.a(a5);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
