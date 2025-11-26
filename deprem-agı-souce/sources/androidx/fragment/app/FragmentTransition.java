package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.List;

class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    private FragmentTransition() {
    }

    static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z4, ArrayMap<String, View> arrayMap, boolean z5) {
        SharedElementCallback sharedElementCallback;
        int i5;
        if (z4) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i5 = 0;
            } else {
                i5 = arrayMap.size();
            }
            for (int i6 = 0; i6 < i5; i6++) {
                arrayList2.add(arrayMap.keyAt(i6));
                arrayList.add(arrayMap.valueAt(i6));
            }
            if (z5) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (str.equals(arrayMap.valueAt(i5))) {
                return arrayMap.keyAt(i5);
            }
        }
        return null;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void retainValues(@NonNull ArrayMap<String, String> arrayMap, @NonNull ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    static void setViewVisibility(ArrayList<View> arrayList, int i5) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i5);
            }
        }
    }

    static boolean supportsTransition() {
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return false;
        }
        return true;
    }
}
