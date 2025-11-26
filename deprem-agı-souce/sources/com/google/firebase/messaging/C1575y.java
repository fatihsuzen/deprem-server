package com.google.firebase.messaging;

import com.google.firebase.messaging.V;
import com.google.firebase.messaging.a0;
import k0.C1698l;

/* renamed from: com.google.firebase.messaging.y  reason: case insensitive filesystem */
public final /* synthetic */ class C1575y implements V.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f7478a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7479b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a0.a f7480c;

    public /* synthetic */ C1575y(FirebaseMessaging firebaseMessaging, String str, a0.a aVar) {
        this.f7478a = firebaseMessaging;
        this.f7479b = str;
        this.f7480c = aVar;
    }

    public final C1698l start() {
        return this.f7478a.f7284c.f().o(this.f7478a.f7288g, new C1576z(this.f7478a, this.f7479b, this.f7480c));
    }
}
