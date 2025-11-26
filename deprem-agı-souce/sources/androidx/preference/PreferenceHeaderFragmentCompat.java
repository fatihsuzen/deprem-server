package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    /* access modifiers changed from: private */
    public OnBackPressedCallback onBackPressedCallback;

    private static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        private final PreferenceHeaderFragmentCompat caller;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
            super(true);
            t.e(preferenceHeaderFragmentCompat, "caller");
            this.caller = preferenceHeaderFragmentCompat;
            preferenceHeaderFragmentCompat.getSlidingPaneLayout().addPanelSlideListener(this);
        }

        public void handleOnBackPressed() {
            this.caller.getSlidingPaneLayout().closePane();
        }

        public void onPanelClosed(View view) {
            t.e(view, "panel");
            setEnabled(false);
        }

        public void onPanelOpened(View view) {
            t.e(view, "panel");
            setEnabled(true);
        }

        public void onPanelSlide(View view, float f5) {
            t.e(view, "panel");
        }
    }

    private final SlidingPaneLayout buildContentView(LayoutInflater layoutInflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_header_width), -1);
        layoutParams.weight = (float) getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        SlidingPaneLayout.LayoutParams layoutParams2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width), -1);
        layoutParams2.weight = (float) getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, layoutParams2);
        return slidingPaneLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10  reason: not valid java name */
    public static final void m64onViewCreated$lambda10(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
        boolean z4;
        t.e(preferenceHeaderFragmentCompat, "this$0");
        OnBackPressedCallback onBackPressedCallback2 = preferenceHeaderFragmentCompat.onBackPressedCallback;
        t.b(onBackPressedCallback2);
        if (preferenceHeaderFragmentCompat.getChildFragmentManager().getBackStackEntryCount() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        onBackPressedCallback2.setEnabled(z4);
    }

    private final void openPreferenceHeader(Preference preference) {
        Fragment fragment;
        if (preference.getFragment() == null) {
            openPreferenceHeader(preference.getIntent());
            return;
        }
        String fragment2 = preference.getFragment();
        if (fragment2 == null) {
            fragment = null;
        } else {
            fragment = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment2);
        }
        if (fragment != null) {
            fragment.setArguments(preference.getExtras());
        }
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = getChildFragmentManager().getBackStackEntryAt(0);
            t.d(backStackEntryAt, "childFragmentManager.getBackStackEntryAt(0)");
            getChildFragmentManager().popBackStack(backStackEntryAt.getId(), 1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        t.d(childFragmentManager, "childFragmentManager");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        beginTransaction.setReorderingAllowed(true);
        int i5 = R.id.preferences_detail;
        t.b(fragment);
        beginTransaction.replace(i5, fragment);
        if (getSlidingPaneLayout().isOpen()) {
            beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        getSlidingPaneLayout().openPane();
        beginTransaction.commit();
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @CallSuper
    public void onAttach(Context context) {
        t.e(context, "context");
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        t.d(parentFragmentManager, "parentFragmentManager");
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        beginTransaction.setPrimaryNavigationFragment(this);
        beginTransaction.commit();
    }

    public Fragment onCreateInitialDetailFragment() {
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.preferences_header);
        if (findFragmentById != null) {
            PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) findFragmentById;
            Fragment fragment = null;
            if (preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount() <= 0) {
                return null;
            }
            int preferenceCount = preferenceFragmentCompat.getPreferenceScreen().getPreferenceCount();
            int i5 = 0;
            while (true) {
                if (i5 >= preferenceCount) {
                    break;
                }
                int i6 = i5 + 1;
                Preference preference = preferenceFragmentCompat.getPreferenceScreen().getPreference(i5);
                t.d(preference, "headerFragment.preferenc…reen.getPreference(index)");
                if (preference.getFragment() == null) {
                    i5 = i6;
                } else {
                    String fragment2 = preference.getFragment();
                    if (fragment2 != null) {
                        fragment = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), fragment2);
                    }
                    if (fragment == null) {
                        return fragment;
                    }
                    fragment.setArguments(preference.getExtras());
                }
            }
            return fragment;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
    }

    public abstract PreferenceFragmentCompat onCreatePreferenceHeader();

    @CallSuper
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        SlidingPaneLayout buildContentView = buildContentView(layoutInflater);
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i5 = R.id.preferences_header;
        if (childFragmentManager.findFragmentById(i5) == null) {
            PreferenceFragmentCompat onCreatePreferenceHeader = onCreatePreferenceHeader();
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            t.d(childFragmentManager2, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager2.beginTransaction();
            t.d(beginTransaction, "beginTransaction()");
            beginTransaction.setReorderingAllowed(true);
            beginTransaction.add(i5, (Fragment) onCreatePreferenceHeader);
            beginTransaction.commit();
        }
        buildContentView.setLockMode(3);
        return buildContentView;
    }

    @CallSuper
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        t.e(preferenceFragmentCompat, "caller");
        t.e(preference, "pref");
        if (preferenceFragmentCompat.getId() == R.id.preferences_header) {
            openPreferenceHeader(preference);
            return true;
        }
        int id = preferenceFragmentCompat.getId();
        int i5 = R.id.preferences_detail;
        if (id != i5) {
            return false;
        }
        FragmentFactory fragmentFactory = getChildFragmentManager().getFragmentFactory();
        ClassLoader classLoader = requireContext().getClassLoader();
        String fragment = preference.getFragment();
        t.b(fragment);
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragment);
        t.d(instantiate, "childFragmentManager.fra….fragment!!\n            )");
        instantiate.setArguments(preference.getExtras());
        FragmentManager childFragmentManager = getChildFragmentManager();
        t.d(childFragmentManager, "childFragmentManager");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        t.d(beginTransaction, "beginTransaction()");
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.replace(i5, instantiate);
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
        return true;
    }

    @CallSuper
    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        boolean z4;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.onBackPressedCallback = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        if (!ViewCompat.isLaidOut(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1(this));
        } else {
            OnBackPressedCallback access$getOnBackPressedCallback$p = this.onBackPressedCallback;
            t.b(access$getOnBackPressedCallback$p);
            if (!getSlidingPaneLayout().isSlideable() || !getSlidingPaneLayout().isOpen()) {
                z4 = false;
            } else {
                z4 = true;
            }
            access$getOnBackPressedCallback$p.setEnabled(z4);
        }
        getChildFragmentManager().addOnBackStackChangedListener(new b(this));
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get(view);
        if (onBackPressedDispatcherOwner != null && (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
            t.b(onBackPressedCallback2);
            onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback2);
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        Fragment onCreateInitialDetailFragment;
        super.onViewStateRestored(bundle);
        if (bundle == null && (onCreateInitialDetailFragment = onCreateInitialDetailFragment()) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            t.d(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            t.d(beginTransaction, "beginTransaction()");
            beginTransaction.setReorderingAllowed(true);
            beginTransaction.replace(R.id.preferences_detail, onCreateInitialDetailFragment);
            beginTransaction.commit();
        }
    }

    private final void openPreferenceHeader(Intent intent) {
        if (intent != null) {
            startActivity(intent);
        }
    }
}
