package com.mbridge.msdk.dycreator.bus;

final class Subscription {

    /* renamed from: a  reason: collision with root package name */
    final Object f8681a;

    /* renamed from: b  reason: collision with root package name */
    final SubscriberMethod f8682b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f8681a = obj;
        this.f8682b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            Subscription subscription = (Subscription) obj;
            if (this.f8681a != subscription.f8681a || !this.f8682b.equals(subscription.f8682b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f8681a.hashCode() + this.f8682b.f8678d.hashCode();
    }
}
