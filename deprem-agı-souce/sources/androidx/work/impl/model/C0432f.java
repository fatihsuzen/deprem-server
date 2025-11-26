package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0432f implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferenceDao_Impl f640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preference f641b;

    public /* synthetic */ C0432f(PreferenceDao_Impl preferenceDao_Impl, Preference preference) {
        this.f640a = preferenceDao_Impl;
        this.f641b = preference;
    }

    public final Object invoke(Object obj) {
        return PreferenceDao_Impl.insertPreference$lambda$0(this.f640a, this.f641b, (SQLiteConnection) obj);
    }
}
