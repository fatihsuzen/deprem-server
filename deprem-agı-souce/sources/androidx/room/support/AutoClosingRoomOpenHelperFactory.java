package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.t;

public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser autoCloser;
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, AutoCloser autoCloser2) {
        t.e(factory, "delegate");
        t.e(autoCloser2, "autoCloser");
        this.delegate = factory;
        this.autoCloser = autoCloser2;
    }

    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        t.e(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}
