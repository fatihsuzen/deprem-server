package androidx.leanback.preference;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.VerticalGridView;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceRecyclerViewAccessibilityDelegate;
import androidx.preference.R;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseLeanbackPreferenceFragmentCompat extends PreferenceFragmentCompat {
    private Context mThemedContext;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Fragment getCallbackFragment() {
        return getParentFragment();
    }

    public Context getContext() {
        if (this.mThemedContext == null && getActivity() != null) {
            TypedValue typedValue = new TypedValue();
            getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
            int i5 = typedValue.resourceId;
            if (i5 == 0) {
                i5 = R.style.PreferenceThemeOverlayLeanback;
            }
            this.mThemedContext = new ContextThemeWrapper(super.getContext(), i5);
        }
        return this.mThemedContext;
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        VerticalGridView verticalGridView = (VerticalGridView) layoutInflater.inflate(R.layout.leanback_preferences_list, viewGroup, false);
        verticalGridView.setWindowAlignment(3);
        verticalGridView.setFocusScrollStrategy(0);
        verticalGridView.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(verticalGridView));
        return verticalGridView;
    }
}
