package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class RoomOpenDelegate implements RoomOpenDelegateMarker {
    private final String identityHash;
    private final String legacyIdentityHash;
    private final int version;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z4, String str) {
            this.isValid = z4;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenDelegate(int i5, String str, String str2) {
        t.e(str, "identityHash");
        t.e(str2, "legacyIdentityHash");
        this.version = i5;
        this.identityHash = str;
        this.legacyIdentityHash = str2;
    }

    public abstract void createAllTables(SQLiteConnection sQLiteConnection);

    public abstract void dropAllTables(SQLiteConnection sQLiteConnection);

    public final String getIdentityHash() {
        return this.identityHash;
    }

    public final String getLegacyIdentityHash() {
        return this.legacyIdentityHash;
    }

    public final int getVersion() {
        return this.version;
    }

    public abstract void onCreate(SQLiteConnection sQLiteConnection);

    public abstract void onOpen(SQLiteConnection sQLiteConnection);

    public abstract void onPostMigrate(SQLiteConnection sQLiteConnection);

    public abstract void onPreMigrate(SQLiteConnection sQLiteConnection);

    public abstract ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection);
}
