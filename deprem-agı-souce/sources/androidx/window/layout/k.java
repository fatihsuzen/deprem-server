package androidx.window.layout;

import androidx.core.util.Consumer;
import y3.C2934g;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2934g f497a;

    public /* synthetic */ k(C2934g gVar) {
        this.f497a = gVar;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m205invokeSuspend$lambda0(this.f497a, (WindowLayoutInfo) obj);
    }
}
