package z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

final class W extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private static final String f17118c = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");

    /* renamed from: d  reason: collision with root package name */
    static int f17119d = 7;

    /* renamed from: e  reason: collision with root package name */
    private static final a f17120e;

    /* renamed from: f  reason: collision with root package name */
    private static final a f17121f;

    /* renamed from: g  reason: collision with root package name */
    private static final a f17122g;

    /* renamed from: h  reason: collision with root package name */
    private static final a f17123h;

    /* renamed from: i  reason: collision with root package name */
    private static final a f17124i;

    /* renamed from: j  reason: collision with root package name */
    private static final a f17125j;

    /* renamed from: k  reason: collision with root package name */
    private static final a f17126k;

    /* renamed from: l  reason: collision with root package name */
    private static final List f17127l;

    /* renamed from: a  reason: collision with root package name */
    private final int f17128a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17129b = false;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        O o5 = new O();
        f17120e = o5;
        P p5 = new P();
        f17121f = p5;
        Q q5 = new Q();
        f17122g = q5;
        S s5 = new S();
        f17123h = s5;
        T t5 = new T();
        f17124i = t5;
        U u5 = new U();
        f17125j = u5;
        V v5 = new V();
        f17126k = v5;
        f17127l = Arrays.asList(new a[]{o5, p5, q5, s5, t5, u5, v5});
    }

    W(Context context, String str, int i5) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i5);
        this.f17128a = i5;
    }

    public static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void m(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f17118c);
    }

    public static /* synthetic */ void o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void p(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    private void q(SQLiteDatabase sQLiteDatabase) {
        if (!this.f17129b) {
            onConfigure(sQLiteDatabase);
        }
    }

    private void s(SQLiteDatabase sQLiteDatabase, int i5) {
        q(sQLiteDatabase);
        t(sQLiteDatabase, 0, i5);
    }

    private void t(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        List list = f17127l;
        if (i6 <= list.size()) {
            while (i5 < i6) {
                ((a) f17127l.get(i5)).a(sQLiteDatabase);
                i5++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i5 + " to " + i6 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f17129b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        s(sQLiteDatabase, this.f17128a);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        s(sQLiteDatabase, i6);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        q(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        q(sQLiteDatabase);
        t(sQLiteDatabase, i5, i6);
    }
}
