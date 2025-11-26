package androidx.work.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* renamed from: androidx.work.impl.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0421b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f534b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f535c;

    public /* synthetic */ C0421b(Processor processor, ArrayList arrayList, String str) {
        this.f533a = processor;
        this.f534b = arrayList;
        this.f535c = str;
    }

    public final Object call() {
        return this.f534b.addAll(this.f533a.mWorkDatabase.workTagDao().getTagsForWorkSpecId(this.f535c));
    }
}
