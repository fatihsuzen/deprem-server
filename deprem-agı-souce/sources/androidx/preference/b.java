package androidx.preference;

import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class b implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferenceHeaderFragmentCompat f401a;

    public /* synthetic */ b(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        this.f401a = preferenceHeaderFragmentCompat;
    }

    public final void onBackStackChanged() {
        PreferenceHeaderFragmentCompat.m64onViewCreated$lambda10(this.f401a);
    }
}
