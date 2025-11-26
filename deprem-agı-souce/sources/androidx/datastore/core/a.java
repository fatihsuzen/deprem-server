package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import k3.l;
import w3.C2869e0;

public final /* synthetic */ class a implements C2869e0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f339b;

    public /* synthetic */ a(String str, l lVar) {
        this.f338a = str;
        this.f339b = lVar;
    }

    public final void dispose() {
        MulticastFileObserver.Companion.observe$lambda$4(this.f338a, this.f339b);
    }
}
