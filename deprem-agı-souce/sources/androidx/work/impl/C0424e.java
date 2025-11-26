package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;

/* renamed from: androidx.work.impl.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0424e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f557a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f558b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Configuration f559c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f560d;

    public /* synthetic */ C0424e(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        this.f557a = list;
        this.f558b = workGenerationalId;
        this.f559c = configuration;
        this.f560d = workDatabase;
    }

    public final void run() {
        Schedulers.b(this.f557a, this.f558b, this.f559c, this.f560d);
    }
}
