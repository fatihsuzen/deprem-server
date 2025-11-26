package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

@RequiresApi(24)
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i5 = 0; i5 < localeListCompat.size() + localeListCompat2.size(); i5++) {
            if (i5 < localeListCompat.size()) {
                locale = localeListCompat.get(i5);
            } else {
                locale = localeListCompat2.get(i5 - localeListCompat.size());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.isEmpty()) {
            return LocaleListCompat.getEmptyLocaleList();
        }
        return combineLocales(localeListCompat, localeListCompat2);
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleList localeList, LocaleList localeList2) {
        if (localeList == null || localeList.isEmpty()) {
            return LocaleListCompat.getEmptyLocaleList();
        }
        return combineLocales(LocaleListCompat.wrap(localeList), LocaleListCompat.wrap(localeList2));
    }
}
