package androidx.lifecycle;

import y3.v;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v f380a;

    public /* synthetic */ h(v vVar) {
        this.f380a = vVar;
    }

    public final void onChanged(Object obj) {
        FlowLiveDataConversions$asFlow$1.invokeSuspend$lambda$0(this.f380a, obj);
    }
}
