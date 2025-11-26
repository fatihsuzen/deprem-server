package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;

public final /* synthetic */ class h implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f562a;

    public /* synthetic */ h(Context context) {
        this.f562a = context;
    }

    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0(this.f562a, configuration);
    }
}
