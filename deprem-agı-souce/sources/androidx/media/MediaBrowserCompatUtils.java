package androidx.media;

import android.os.Bundle;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (bundle == null) {
            i5 = -1;
        } else {
            i5 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle2 == null) {
            i6 = -1;
        } else {
            i6 = bundle2.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle == null) {
            i7 = -1;
        } else {
            i7 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        if (bundle2 == null) {
            i8 = -1;
        } else {
            i8 = bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        int i12 = Integer.MAX_VALUE;
        if (i5 == -1 || i7 == -1) {
            i9 = Integer.MAX_VALUE;
            i10 = 0;
        } else {
            i10 = i5 * i7;
            i9 = (i7 + i10) - 1;
        }
        if (i6 == -1 || i8 == -1) {
            i11 = 0;
        } else {
            i11 = i6 * i8;
            i12 = (i8 + i11) - 1;
        }
        if (i9 < i11 || i12 < i10) {
            return false;
        }
        return true;
    }
}
