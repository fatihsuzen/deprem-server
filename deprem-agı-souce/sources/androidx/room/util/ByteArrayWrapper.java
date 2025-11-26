package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ByteArrayWrapper {
    public final byte[] array;

    public ByteArrayWrapper(byte[] bArr) {
        t.e(bArr, "array");
        this.array = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ByteArrayWrapper)) {
            return false;
        }
        return Arrays.equals(this.array, ((ByteArrayWrapper) obj).array);
    }

    public int hashCode() {
        return Arrays.hashCode(this.array);
    }
}
