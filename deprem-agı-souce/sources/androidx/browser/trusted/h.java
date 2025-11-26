package androidx.browser.trusted;

import java.util.Comparator;

public final /* synthetic */ class h implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return TokenContents.compareByteArrays((byte[]) obj, (byte[]) obj2);
    }
}
