package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity
public final class Preference {
    @ColumnInfo(name = "key")
    @PrimaryKey
    private final String key;
    @ColumnInfo(name = "long_value")
    private final Long value;

    public Preference(String str, Long l5) {
        t.e(str, "key");
        this.key = str;
        this.value = l5;
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = preference.key;
        }
        if ((i5 & 2) != 0) {
            l5 = preference.value;
        }
        return preference.copy(str, l5);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String str, Long l5) {
        t.e(str, "key");
        return new Preference(str, l5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return t.a(this.key, preference.key) && t.a(this.value, preference.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l5 = this.value;
        return hashCode + (l5 == null ? 0 : l5.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z4) {
        this(str, Long.valueOf(z4 ? 1 : 0));
        t.e(str, "key");
    }
}
