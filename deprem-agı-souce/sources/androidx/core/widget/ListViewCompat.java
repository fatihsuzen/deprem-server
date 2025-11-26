package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(@NonNull ListView listView, int i5) {
        return listView.canScrollList(i5);
    }

    @Deprecated
    public static void scrollListBy(@NonNull ListView listView, int i5) {
        listView.scrollListBy(i5);
    }
}
