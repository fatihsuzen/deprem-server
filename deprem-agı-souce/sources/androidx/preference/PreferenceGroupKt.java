package androidx.preference;

import java.util.Iterator;
import k3.l;
import k3.p;
import kotlin.jvm.internal.t;
import s3.C2751e;

public final class PreferenceGroupKt {
    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        t.e(preferenceGroup, "<this>");
        t.e(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i5 = 0;
        while (i5 < preferenceCount) {
            int i6 = i5 + 1;
            if (t.a(preferenceGroup.getPreference(i5), preference)) {
                return true;
            }
            i5 = i6;
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, l lVar) {
        t.e(preferenceGroup, "<this>");
        t.e(lVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i5 = 0; i5 < preferenceCount; i5++) {
            lVar.invoke(get(preferenceGroup, i5));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, p pVar) {
        t.e(preferenceGroup, "<this>");
        t.e(pVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i5 = 0; i5 < preferenceCount; i5++) {
            pVar.invoke(Integer.valueOf(i5), get(preferenceGroup, i5));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        t.e(preferenceGroup, "<this>");
        t.e(charSequence, "key");
        return preferenceGroup.findPreference(charSequence);
    }

    public static final C2751e getChildren(PreferenceGroup preferenceGroup) {
        t.e(preferenceGroup, "<this>");
        return new PreferenceGroupKt$children$1(preferenceGroup);
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        t.e(preferenceGroup, "<this>");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        t.e(preferenceGroup, "<this>");
        if (preferenceGroup.getPreferenceCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        t.e(preferenceGroup, "<this>");
        if (preferenceGroup.getPreferenceCount() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        t.e(preferenceGroup, "<this>");
        return new PreferenceGroupKt$iterator$1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        t.e(preferenceGroup, "<this>");
        t.e(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        t.e(preferenceGroup, "<this>");
        t.e(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i5) {
        t.e(preferenceGroup, "<this>");
        Preference preference = preferenceGroup.getPreference(i5);
        t.d(preference, "getPreference(index)");
        return preference;
    }
}
