package androidx.leanback.preference;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public abstract class LeanbackSettingsFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback, PreferenceFragmentCompat.OnPreferenceStartScreenCallback, PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback {
    private static final String PREFERENCE_FRAGMENT_TAG = "androidx.leanback.preference.LeanbackSettingsFragment.PREFERENCE_FRAGMENT";
    private final RootViewOnKeyListener mRootViewOnKeyListener = new RootViewOnKeyListener();

    private class RootViewOnKeyListener implements View.OnKeyListener {
        RootViewOnKeyListener() {
        }

        public boolean onKey(View view, int i5, KeyEvent keyEvent) {
            if (i5 == 4) {
                return LeanbackSettingsFragmentCompat.this.getChildFragmentManager().popBackStackImmediate();
            }
            return false;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.leanback_settings_fragment, viewGroup, false);
    }

    public void onPause() {
        super.onPause();
        LeanbackSettingsRootView leanbackSettingsRootView = (LeanbackSettingsRootView) getView();
        if (leanbackSettingsRootView != null) {
            leanbackSettingsRootView.setOnBackKeyListener((View.OnKeyListener) null);
        }
    }

    public boolean onPreferenceDisplayDialog(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        if (preferenceFragmentCompat == null) {
            throw new IllegalArgumentException("Cannot display dialog for preference " + preference + ", Caller must not be null!");
        } else if (preference instanceof ListPreference) {
            LeanbackListPreferenceDialogFragmentCompat newInstanceSingle = LeanbackListPreferenceDialogFragmentCompat.newInstanceSingle(((ListPreference) preference).getKey());
            newInstanceSingle.setTargetFragment(preferenceFragmentCompat, 0);
            startPreferenceFragment(newInstanceSingle);
            return true;
        } else if (preference instanceof MultiSelectListPreference) {
            LeanbackListPreferenceDialogFragmentCompat newInstanceMulti = LeanbackListPreferenceDialogFragmentCompat.newInstanceMulti(((MultiSelectListPreference) preference).getKey());
            newInstanceMulti.setTargetFragment(preferenceFragmentCompat, 0);
            startPreferenceFragment(newInstanceMulti);
            return true;
        } else if (!(preference instanceof EditTextPreference)) {
            return false;
        } else {
            LeanbackEditTextPreferenceDialogFragmentCompat newInstance = LeanbackEditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            newInstance.setTargetFragment(preferenceFragmentCompat, 0);
            startPreferenceFragment(newInstance);
            return true;
        }
    }

    public abstract void onPreferenceStartInitialScreen();

    public void onResume() {
        super.onResume();
        LeanbackSettingsRootView leanbackSettingsRootView = (LeanbackSettingsRootView) getView();
        if (leanbackSettingsRootView != null) {
            leanbackSettingsRootView.setOnBackKeyListener(this.mRootViewOnKeyListener);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            onPreferenceStartInitialScreen();
        }
    }

    public void startImmersiveFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(PREFERENCE_FRAGMENT_TAG);
        if (findFragmentByTag != null && !findFragmentByTag.isHidden()) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.add(R.id.settings_dialog_container, fragment).addToBackStack((String) null).commit();
    }

    public void startPreferenceFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        if (getChildFragmentManager().findFragmentByTag(PREFERENCE_FRAGMENT_TAG) != null) {
            beginTransaction.addToBackStack((String) null).replace(R.id.settings_preference_fragment_container, fragment, PREFERENCE_FRAGMENT_TAG);
        } else {
            beginTransaction.add(R.id.settings_preference_fragment_container, fragment, PREFERENCE_FRAGMENT_TAG);
        }
        beginTransaction.commit();
    }
}
