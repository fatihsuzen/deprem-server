package androidx.preference;

import java.util.Iterator;
import s3.C2751e;

public final class PreferenceGroupKt$children$1 implements C2751e {
    final /* synthetic */ PreferenceGroup $this_children;

    PreferenceGroupKt$children$1(PreferenceGroup preferenceGroup) {
        this.$this_children = preferenceGroup;
    }

    public Iterator<Preference> iterator() {
        return PreferenceGroupKt.iterator(this.$this_children);
    }
}
