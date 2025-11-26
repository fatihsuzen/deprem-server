package androidx.preference;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, C2677a {
    final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.getPreferenceCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i5 = this.index - 1;
        this.index = i5;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i5));
    }

    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i5 = this.index;
        this.index = i5 + 1;
        Preference preference = preferenceGroup.getPreference(i5);
        t.d(preference, "getPreference(index++)");
        return preference;
    }
}
