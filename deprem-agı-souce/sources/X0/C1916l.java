package x0;

import java.io.File;
import java.util.Comparator;

/* renamed from: x0.l  reason: case insensitive filesystem */
public final /* synthetic */ class C1916l implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
    }
}
