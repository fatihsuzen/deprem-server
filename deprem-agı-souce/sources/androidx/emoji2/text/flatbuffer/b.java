package androidx.emoji2.text.flatbuffer;

import java.util.function.Supplier;

public final /* synthetic */ class b extends ThreadLocal {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f353a;

    public /* synthetic */ b(Supplier supplier) {
        this.f353a = supplier;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Object initialValue() {
        return this.f353a.get();
    }
}
