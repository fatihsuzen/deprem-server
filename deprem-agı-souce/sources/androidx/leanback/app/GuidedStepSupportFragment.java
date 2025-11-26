package androidx.leanback.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.DiffCallback;
import androidx.leanback.widget.GuidanceStylist;
import androidx.leanback.widget.GuidedAction;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionAdapterGroup;
import androidx.leanback.widget.GuidedActionsStylist;
import androidx.leanback.widget.NonOverlappingLinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class GuidedStepSupportFragment extends Fragment implements GuidedActionAdapter.FocusListener {
    private static final boolean DEBUG = false;
    private static final String ENTRY_NAME_ENTRANCE = "GuidedStepEntrance";
    private static final String ENTRY_NAME_REPLACE = "GuidedStepDefault";
    private static final String EXTRA_ACTION_PREFIX = "action_";
    private static final String EXTRA_BUTTON_ACTION_PREFIX = "buttonaction_";
    public static final String EXTRA_UI_STYLE = "uiStyle";
    private static final boolean IS_FRAMEWORK_FRAGMENT = false;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_BOTTOM = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int SLIDE_FROM_SIDE = 0;
    private static final String TAG = "GuidedStepF";
    private static final String TAG_LEAN_BACK_ACTIONS_FRAGMENT = "leanBackGuidedStepSupportFragment";
    public static final int UI_STYLE_ACTIVITY_ROOT = 2;
    @Deprecated
    public static final int UI_STYLE_DEFAULT = 0;
    public static final int UI_STYLE_ENTRANCE = 1;
    public static final int UI_STYLE_REPLACE = 0;
    private int entranceTransitionType = 0;
    private List<GuidedAction> mActions = new ArrayList();
    GuidedActionsStylist mActionsStylist;
    private GuidedActionAdapter mAdapter;
    private GuidedActionAdapterGroup mAdapterGroup;
    private List<GuidedAction> mButtonActions = new ArrayList();
    private GuidedActionsStylist mButtonActionsStylist;
    private GuidedActionAdapter mButtonAdapter;
    private GuidanceStylist mGuidanceStylist;
    private GuidedActionAdapter mSubAdapter;
    private ContextThemeWrapper mThemeWrapper;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class DummyFragment extends Fragment {
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = new View(layoutInflater.getContext());
            view.setVisibility(8);
            return view;
        }
    }

    public GuidedStepSupportFragment() {
        onProvideFragmentTransitions();
    }

    public static int add(FragmentManager fragmentManager, GuidedStepSupportFragment guidedStepSupportFragment) {
        return add(fragmentManager, guidedStepSupportFragment, 16908290);
    }

    public static int addAsRoot(FragmentActivity fragmentActivity, GuidedStepSupportFragment guidedStepSupportFragment, int i5) {
        fragmentActivity.getWindow().getDecorView();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(TAG_LEAN_BACK_ACTIONS_FRAGMENT) != null) {
            Log.w(TAG, "Fragment is already exists, likely calling addAsRoot() when savedInstanceState is not null in Activity.onCreate().");
            return -1;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        guidedStepSupportFragment.setUiStyle(2);
        return beginTransaction.replace(i5, (Fragment) guidedStepSupportFragment, TAG_LEAN_BACK_ACTIONS_FRAGMENT).commit();
    }

    private static void addNonNullSharedElementTransition(FragmentTransaction fragmentTransaction, View view, String str) {
        if (view != null) {
            fragmentTransaction.addSharedElement(view, str);
        }
    }

    public static GuidedStepSupportFragment getCurrentGuidedStepSupportFragment(FragmentManager fragmentManager) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(TAG_LEAN_BACK_ACTIONS_FRAGMENT);
        if (findFragmentByTag instanceof GuidedStepSupportFragment) {
            return (GuidedStepSupportFragment) findFragmentByTag;
        }
        return null;
    }

    static String getGuidedStepSupportFragmentClassName(String str) {
        if (str.startsWith(ENTRY_NAME_REPLACE)) {
            return str.substring(17);
        }
        if (str.startsWith(ENTRY_NAME_ENTRANCE)) {
            return str.substring(18);
        }
        return "";
    }

    private LayoutInflater getThemeInflater(LayoutInflater layoutInflater) {
        ContextThemeWrapper contextThemeWrapper = this.mThemeWrapper;
        if (contextThemeWrapper == null) {
            return layoutInflater;
        }
        return layoutInflater.cloneInContext(contextThemeWrapper);
    }

    private static boolean isGuidedStepTheme(Context context) {
        int i5 = R.attr.guidedStepThemeFlag;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i5, typedValue, true) || typedValue.type != 18 || typedValue.data == 0) {
            return false;
        }
        return true;
    }

    static boolean isSaveEnabled(GuidedAction guidedAction) {
        if (!guidedAction.isAutoSaveRestoreEnabled() || guidedAction.getId() == -1) {
            return false;
        }
        return true;
    }

    static boolean isStackEntryUiStyleEntrance(String str) {
        if (str == null || !str.startsWith(ENTRY_NAME_ENTRANCE)) {
            return false;
        }
        return true;
    }

    private void resolveTheme() {
        Context context = getContext();
        int onProvideTheme = onProvideTheme();
        if (onProvideTheme == -1 && !isGuidedStepTheme(context)) {
            int i5 = R.attr.guidedStepTheme;
            TypedValue typedValue = new TypedValue();
            boolean resolveAttribute = context.getTheme().resolveAttribute(i5, typedValue, true);
            if (resolveAttribute) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
                if (isGuidedStepTheme(contextThemeWrapper)) {
                    this.mThemeWrapper = contextThemeWrapper;
                } else {
                    this.mThemeWrapper = null;
                    resolveAttribute = false;
                }
            }
            if (!resolveAttribute) {
                Log.e(TAG, "GuidedStepSupportFragment does not have an appropriate theme set.");
            }
        } else if (onProvideTheme != -1) {
            this.mThemeWrapper = new ContextThemeWrapper(context, onProvideTheme);
        }
    }

    public void collapseAction(boolean z4) {
        GuidedActionsStylist guidedActionsStylist = this.mActionsStylist;
        if (guidedActionsStylist != null && guidedActionsStylist.getActionsGridView() != null) {
            this.mActionsStylist.collapseAction(z4);
        }
    }

    public void collapseSubActions() {
        collapseAction(true);
    }

    public void expandAction(GuidedAction guidedAction, boolean z4) {
        this.mActionsStylist.expandAction(guidedAction, z4);
    }

    public void expandSubActions(GuidedAction guidedAction) {
        if (guidedAction.hasSubActions()) {
            expandAction(guidedAction, true);
        }
    }

    public GuidedAction findActionById(long j5) {
        int findActionPositionById = findActionPositionById(j5);
        if (findActionPositionById >= 0) {
            return this.mActions.get(findActionPositionById);
        }
        return null;
    }

    public int findActionPositionById(long j5) {
        if (this.mActions == null) {
            return -1;
        }
        for (int i5 = 0; i5 < this.mActions.size(); i5++) {
            if (this.mActions.get(i5).getId() == j5) {
                return i5;
            }
        }
        return -1;
    }

    public GuidedAction findButtonActionById(long j5) {
        int findButtonActionPositionById = findButtonActionPositionById(j5);
        if (findButtonActionPositionById >= 0) {
            return this.mButtonActions.get(findButtonActionPositionById);
        }
        return null;
    }

    public int findButtonActionPositionById(long j5) {
        if (this.mButtonActions == null) {
            return -1;
        }
        for (int i5 = 0; i5 < this.mButtonActions.size(); i5++) {
            if (this.mButtonActions.get(i5).getId() == j5) {
                return i5;
            }
        }
        return -1;
    }

    public void finishGuidedStepSupportFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i5 = backStackEntryCount - 1; i5 >= 0; i5--) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i5);
                if (isStackEntryUiStyleEntrance(backStackEntryAt.getName())) {
                    GuidedStepSupportFragment currentGuidedStepSupportFragment = getCurrentGuidedStepSupportFragment(fragmentManager);
                    if (currentGuidedStepSupportFragment != null) {
                        currentGuidedStepSupportFragment.setUiStyle(1);
                    }
                    fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), 1);
                    return;
                }
            }
        }
        ActivityCompat.finishAfterTransition(getActivity());
    }

    /* access modifiers changed from: package-private */
    public final String generateStackEntryName() {
        return generateStackEntryName(getUiStyle(), getClass());
    }

    public View getActionItemView(int i5) {
        RecyclerView.ViewHolder findViewHolderForPosition = this.mActionsStylist.getActionsGridView().findViewHolderForPosition(i5);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    public List<GuidedAction> getActions() {
        return this.mActions;
    }

    /* access modifiers changed from: package-private */
    public final String getAutoRestoreKey(GuidedAction guidedAction) {
        return EXTRA_ACTION_PREFIX + guidedAction.getId();
    }

    public View getButtonActionItemView(int i5) {
        RecyclerView.ViewHolder findViewHolderForPosition = this.mButtonActionsStylist.getActionsGridView().findViewHolderForPosition(i5);
        if (findViewHolderForPosition == null) {
            return null;
        }
        return findViewHolderForPosition.itemView;
    }

    public List<GuidedAction> getButtonActions() {
        return this.mButtonActions;
    }

    /* access modifiers changed from: package-private */
    public final String getButtonAutoRestoreKey(GuidedAction guidedAction) {
        return EXTRA_BUTTON_ACTION_PREFIX + guidedAction.getId();
    }

    public GuidanceStylist getGuidanceStylist() {
        return this.mGuidanceStylist;
    }

    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.mActionsStylist;
    }

    public GuidedActionsStylist getGuidedButtonActionsStylist() {
        return this.mButtonActionsStylist;
    }

    public int getSelectedActionPosition() {
        return this.mActionsStylist.getActionsGridView().getSelectedPosition();
    }

    public int getSelectedButtonActionPosition() {
        return this.mButtonActionsStylist.getActionsGridView().getSelectedPosition();
    }

    public int getUiStyle() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 1;
        }
        return arguments.getInt("uiStyle", 1);
    }

    public boolean isExpanded() {
        return this.mActionsStylist.isExpanded();
    }

    public boolean isFocusOutEndAllowed() {
        return false;
    }

    public boolean isFocusOutStartAllowed() {
        return false;
    }

    public boolean isSubActionsExpanded() {
        return this.mActionsStylist.isSubActionsExpanded();
    }

    public void notifyActionChanged(int i5) {
        GuidedActionAdapter guidedActionAdapter = this.mAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i5);
        }
    }

    public void notifyButtonActionChanged(int i5) {
        GuidedActionAdapter guidedActionAdapter = this.mButtonAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.notifyItemChanged(i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onAddSharedElementTransition(FragmentTransaction fragmentTransaction, GuidedStepSupportFragment guidedStepSupportFragment) {
        View view = guidedStepSupportFragment.getView();
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment_root), "action_fragment_root");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment_background), "action_fragment_background");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.action_fragment), "action_fragment");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_root), "guidedactions_root");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_content), "guidedactions_content");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_list_background), "guidedactions_list_background");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_root2), "guidedactions_root2");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_content2), "guidedactions_content2");
        addNonNullSharedElementTransition(fragmentTransaction, view.findViewById(R.id.guidedactions_list_background2), "guidedactions_list_background2");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGuidanceStylist = onCreateGuidanceStylist();
        this.mActionsStylist = onCreateActionsStylist();
        this.mButtonActionsStylist = onCreateButtonActionsStylist();
        onProvideFragmentTransitions();
        ArrayList arrayList = new ArrayList();
        onCreateActions(arrayList, bundle);
        if (bundle != null) {
            onRestoreActions(arrayList, bundle);
        }
        setActions(arrayList);
        ArrayList arrayList2 = new ArrayList();
        onCreateButtonActions(arrayList2, bundle);
        if (bundle != null) {
            onRestoreButtonActions(arrayList2, bundle);
        }
        setButtonActions(arrayList2);
    }

    public void onCreateActions(List<GuidedAction> list, Bundle bundle) {
    }

    public GuidedActionsStylist onCreateActionsStylist() {
        return new GuidedActionsStylist();
    }

    public View onCreateBackgroundView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.lb_guidedstep_background, viewGroup, false);
    }

    public void onCreateButtonActions(List<GuidedAction> list, Bundle bundle) {
    }

    public GuidedActionsStylist onCreateButtonActionsStylist() {
        GuidedActionsStylist guidedActionsStylist = new GuidedActionsStylist();
        guidedActionsStylist.setAsButtonActions();
        return guidedActionsStylist;
    }

    public GuidanceStylist.Guidance onCreateGuidance(Bundle bundle) {
        return new GuidanceStylist.Guidance("", "", "", (Drawable) null);
    }

    public GuidanceStylist onCreateGuidanceStylist() {
        return new GuidanceStylist();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2 = bundle;
        resolveTheme();
        LayoutInflater themeInflater = getThemeInflater(layoutInflater);
        GuidedStepRootLayout guidedStepRootLayout = (GuidedStepRootLayout) themeInflater.inflate(R.layout.lb_guidedstep_fragment, viewGroup, false);
        guidedStepRootLayout.setFocusOutStart(isFocusOutStartAllowed());
        guidedStepRootLayout.setFocusOutEnd(isFocusOutEndAllowed());
        ViewGroup viewGroup2 = (ViewGroup) guidedStepRootLayout.findViewById(R.id.content_fragment);
        ViewGroup viewGroup3 = (ViewGroup) guidedStepRootLayout.findViewById(R.id.action_fragment);
        ((NonOverlappingLinearLayout) viewGroup3).setFocusableViewAvailableFixEnabled(true);
        viewGroup2.addView(this.mGuidanceStylist.onCreateView(themeInflater, viewGroup2, onCreateGuidance(bundle2)));
        viewGroup3.addView(this.mActionsStylist.onCreateView(themeInflater, viewGroup3));
        View onCreateView = this.mButtonActionsStylist.onCreateView(themeInflater, viewGroup3);
        viewGroup3.addView(onCreateView);
        AnonymousClass1 r12 = new GuidedActionAdapter.EditListener() {
            public void onGuidedActionEditCanceled(GuidedAction guidedAction) {
                GuidedStepSupportFragment.this.onGuidedActionEditCanceled(guidedAction);
            }

            public long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
                return GuidedStepSupportFragment.this.onGuidedActionEditedAndProceed(guidedAction);
            }

            public void onImeClose() {
                GuidedStepSupportFragment.this.runImeAnimations(false);
            }

            public void onImeOpen() {
                GuidedStepSupportFragment.this.runImeAnimations(true);
            }
        };
        this.mAdapter = new GuidedActionAdapter(this.mActions, new GuidedActionAdapter.ClickListener() {
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                GuidedStepSupportFragment.this.onGuidedActionClicked(guidedAction);
                if (GuidedStepSupportFragment.this.isExpanded()) {
                    GuidedStepSupportFragment.this.collapseAction(true);
                } else if (guidedAction.hasSubActions() || guidedAction.hasEditableActivatorView()) {
                    GuidedStepSupportFragment.this.expandAction(guidedAction, true);
                }
            }
        }, this, this.mActionsStylist, false);
        this.mButtonAdapter = new GuidedActionAdapter(this.mButtonActions, new GuidedActionAdapter.ClickListener() {
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                GuidedStepSupportFragment.this.onGuidedActionClicked(guidedAction);
            }
        }, this, this.mButtonActionsStylist, false);
        this.mSubAdapter = new GuidedActionAdapter((List<GuidedAction>) null, new GuidedActionAdapter.ClickListener() {
            public void onGuidedActionClicked(GuidedAction guidedAction) {
                if (!GuidedStepSupportFragment.this.mActionsStylist.isInExpandTransition() && GuidedStepSupportFragment.this.onSubGuidedActionClicked(guidedAction)) {
                    GuidedStepSupportFragment.this.collapseSubActions();
                }
            }
        }, this, this.mActionsStylist, true);
        GuidedActionAdapterGroup guidedActionAdapterGroup = new GuidedActionAdapterGroup();
        this.mAdapterGroup = guidedActionAdapterGroup;
        guidedActionAdapterGroup.addAdpter(this.mAdapter, this.mButtonAdapter);
        this.mAdapterGroup.addAdpter(this.mSubAdapter, (GuidedActionAdapter) null);
        this.mAdapterGroup.setEditListener(r12);
        this.mActionsStylist.setEditListener(r12);
        this.mActionsStylist.getActionsGridView().setAdapter(this.mAdapter);
        if (this.mActionsStylist.getSubActionsGridView() != null) {
            this.mActionsStylist.getSubActionsGridView().setAdapter(this.mSubAdapter);
        }
        this.mButtonActionsStylist.getActionsGridView().setAdapter(this.mButtonAdapter);
        if (this.mButtonActions.size() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) onCreateView.getLayoutParams();
            layoutParams.weight = 0.0f;
            onCreateView.setLayoutParams(layoutParams);
        } else {
            Context context = this.mThemeWrapper;
            if (context == null) {
                context = getContext();
            }
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.guidedActionContentWidthWeightTwoPanels, typedValue, true)) {
                View findViewById = guidedStepRootLayout.findViewById(R.id.action_fragment_root);
                float f5 = typedValue.getFloat();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams2.weight = f5;
                findViewById.setLayoutParams(layoutParams2);
            }
        }
        View onCreateBackgroundView = onCreateBackgroundView(themeInflater, guidedStepRootLayout, bundle2);
        if (onCreateBackgroundView != null) {
            ((FrameLayout) guidedStepRootLayout.findViewById(R.id.guidedstep_background_view_root)).addView(onCreateBackgroundView, 0);
        }
        return guidedStepRootLayout;
    }

    public void onDestroyView() {
        this.mGuidanceStylist.onDestroyView();
        this.mActionsStylist.onDestroyView();
        this.mButtonActionsStylist.onDestroyView();
        this.mAdapter = null;
        this.mSubAdapter = null;
        this.mButtonAdapter = null;
        this.mAdapterGroup = null;
        super.onDestroyView();
    }

    public void onGuidedActionClicked(GuidedAction guidedAction) {
    }

    public void onGuidedActionEditCanceled(GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
    }

    @Deprecated
    public void onGuidedActionEdited(GuidedAction guidedAction) {
    }

    public long onGuidedActionEditedAndProceed(GuidedAction guidedAction) {
        onGuidedActionEdited(guidedAction);
        return -2;
    }

    public void onGuidedActionFocused(GuidedAction guidedAction) {
    }

    /* access modifiers changed from: protected */
    public void onProvideFragmentTransitions() {
        int uiStyle = getUiStyle();
        if (uiStyle == 0) {
            Object createFadeAndShortSlide = TransitionHelper.createFadeAndShortSlide(GravityCompat.END);
            TransitionHelper.exclude(createFadeAndShortSlide, R.id.guidedstep_background, true);
            int i5 = R.id.guidedactions_sub_list_background;
            TransitionHelper.exclude(createFadeAndShortSlide, i5, true);
            setEnterTransition(createFadeAndShortSlide);
            Object createFadeTransition = TransitionHelper.createFadeTransition(3);
            TransitionHelper.include(createFadeTransition, i5);
            Object createChangeBounds = TransitionHelper.createChangeBounds(false);
            Object createTransitionSet = TransitionHelper.createTransitionSet(false);
            TransitionHelper.addTransition(createTransitionSet, createFadeTransition);
            TransitionHelper.addTransition(createTransitionSet, createChangeBounds);
            setSharedElementEnterTransition(createTransitionSet);
        } else if (uiStyle == 1) {
            if (this.entranceTransitionType == 0) {
                Object createFadeTransition2 = TransitionHelper.createFadeTransition(3);
                TransitionHelper.include(createFadeTransition2, R.id.guidedstep_background);
                Object createFadeAndShortSlide2 = TransitionHelper.createFadeAndShortSlide(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
                TransitionHelper.include(createFadeAndShortSlide2, R.id.content_fragment);
                TransitionHelper.include(createFadeAndShortSlide2, R.id.action_fragment_root);
                Object createTransitionSet2 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet2, createFadeTransition2);
                TransitionHelper.addTransition(createTransitionSet2, createFadeAndShortSlide2);
                setEnterTransition(createTransitionSet2);
            } else {
                Object createFadeAndShortSlide3 = TransitionHelper.createFadeAndShortSlide(80);
                TransitionHelper.include(createFadeAndShortSlide3, R.id.guidedstep_background_view_root);
                Object createTransitionSet3 = TransitionHelper.createTransitionSet(false);
                TransitionHelper.addTransition(createTransitionSet3, createFadeAndShortSlide3);
                setEnterTransition(createTransitionSet3);
            }
            setSharedElementEnterTransition((Object) null);
        } else if (uiStyle == 2) {
            setEnterTransition((Object) null);
            setSharedElementEnterTransition((Object) null);
        }
        Object createFadeAndShortSlide4 = TransitionHelper.createFadeAndShortSlide(GravityCompat.START);
        TransitionHelper.exclude(createFadeAndShortSlide4, R.id.guidedstep_background, true);
        TransitionHelper.exclude(createFadeAndShortSlide4, R.id.guidedactions_sub_list_background, true);
        setExitTransition(createFadeAndShortSlide4);
    }

    public int onProvideTheme() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void onRestoreActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            GuidedAction guidedAction = list.get(i5);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onRestoreInstanceState(bundle, getAutoRestoreKey(guidedAction));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void onRestoreButtonActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            GuidedAction guidedAction = list.get(i5);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onRestoreInstanceState(bundle, getButtonAutoRestoreKey(guidedAction));
            }
        }
    }

    public void onResume() {
        super.onResume();
        getView().findViewById(R.id.action_fragment).requestFocus();
    }

    /* access modifiers changed from: package-private */
    public final void onSaveActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            GuidedAction guidedAction = list.get(i5);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, getAutoRestoreKey(guidedAction));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void onSaveButtonActions(List<GuidedAction> list, Bundle bundle) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            GuidedAction guidedAction = list.get(i5);
            if (isSaveEnabled(guidedAction)) {
                guidedAction.onSaveInstanceState(bundle, getButtonAutoRestoreKey(guidedAction));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        onSaveActions(this.mActions, bundle);
        onSaveButtonActions(this.mButtonActions, bundle);
    }

    public boolean onSubGuidedActionClicked(GuidedAction guidedAction) {
        return true;
    }

    public void openInEditMode(GuidedAction guidedAction) {
        this.mActionsStylist.openInEditMode(guidedAction);
    }

    public void popBackStackToGuidedStepSupportFragment(Class<?> cls, int i5) {
        if (GuidedStepSupportFragment.class.isAssignableFrom(cls)) {
            FragmentManager fragmentManager = getFragmentManager();
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            String name = cls.getName();
            if (backStackEntryCount > 0) {
                for (int i6 = backStackEntryCount - 1; i6 >= 0; i6--) {
                    FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i6);
                    if (name.equals(getGuidedStepSupportFragmentClassName(backStackEntryAt.getName()))) {
                        fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), i5);
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void runImeAnimations(boolean z4) {
        ArrayList arrayList = new ArrayList();
        if (z4) {
            this.mGuidanceStylist.onImeAppearing(arrayList);
            this.mActionsStylist.onImeAppearing(arrayList);
            this.mButtonActionsStylist.onImeAppearing(arrayList);
        } else {
            this.mGuidanceStylist.onImeDisappearing(arrayList);
            this.mActionsStylist.onImeDisappearing(arrayList);
            this.mButtonActionsStylist.onImeDisappearing(arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void setActions(List<GuidedAction> list) {
        this.mActions = list;
        GuidedActionAdapter guidedActionAdapter = this.mAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    public void setActionsDiffCallback(DiffCallback<GuidedAction> diffCallback) {
        this.mAdapter.setDiffCallback(diffCallback);
    }

    public void setButtonActions(List<GuidedAction> list) {
        this.mButtonActions = list;
        GuidedActionAdapter guidedActionAdapter = this.mButtonAdapter;
        if (guidedActionAdapter != null) {
            guidedActionAdapter.setActions(list);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEntranceTransitionType(int i5) {
        this.entranceTransitionType = i5;
    }

    public void setSelectedActionPosition(int i5) {
        this.mActionsStylist.getActionsGridView().setSelectedPosition(i5);
    }

    public void setSelectedButtonActionPosition(int i5) {
        this.mButtonActionsStylist.getActionsGridView().setSelectedPosition(i5);
    }

    public void setUiStyle(int i5) {
        boolean z4;
        int uiStyle = getUiStyle();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            z4 = true;
        } else {
            z4 = false;
        }
        arguments.putInt("uiStyle", i5);
        if (z4) {
            setArguments(arguments);
        }
        if (i5 != uiStyle) {
            onProvideFragmentTransitions();
        }
    }

    public static int add(FragmentManager fragmentManager, GuidedStepSupportFragment guidedStepSupportFragment, int i5) {
        GuidedStepSupportFragment currentGuidedStepSupportFragment = getCurrentGuidedStepSupportFragment(fragmentManager);
        int i6 = currentGuidedStepSupportFragment != null ? 1 : 0;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        guidedStepSupportFragment.setUiStyle(1 ^ i6);
        beginTransaction.addToBackStack(guidedStepSupportFragment.generateStackEntryName());
        if (currentGuidedStepSupportFragment != null) {
            guidedStepSupportFragment.onAddSharedElementTransition(beginTransaction, currentGuidedStepSupportFragment);
        }
        return beginTransaction.replace(i5, (Fragment) guidedStepSupportFragment, TAG_LEAN_BACK_ACTIONS_FRAGMENT).commit();
    }

    static String generateStackEntryName(int i5, Class<?> cls) {
        if (i5 == 0) {
            return ENTRY_NAME_REPLACE + cls.getName();
        } else if (i5 != 1) {
            return "";
        } else {
            return ENTRY_NAME_ENTRANCE + cls.getName();
        }
    }
}
