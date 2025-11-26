package androidx.work.impl.model;

import kotlin.jvm.internal.t;

/* renamed from: androidx.work.impl.model.n  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0440n {
    public static SystemIdInfo a(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
        t.e(workGenerationalId, "id");
        return systemIdInfoDao.getSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }

    public static void b(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
        t.e(workGenerationalId, "id");
        systemIdInfoDao.removeSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }
}
