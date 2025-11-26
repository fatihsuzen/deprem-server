package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    static final String FRAGMENT_MANAGER_STATE_TAG = "state";
    static final String FRAGMENT_NAME_PREFIX = "fragment_";
    static final String FRAGMENT_STATE_TAG = "state";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String RESULT_NAME_PREFIX = "result_";
    static final String SAVED_STATE_TAG = "android:support:fragments";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex = new AtomicInteger();
    private final Map<String, BackStackState> mBackStackStates = DesugarCollections.synchronizedMap(new HashMap());
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState = -1;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory = new SpecialEffectsControllerFactory() {
        @NonNull
        public SpecialEffectsController createController(@NonNull ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };
    private boolean mDestroyed;
    private Runnable mExecCommit = new Runnable() {
        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    };
    private boolean mExecutingActions;
    private FragmentFactory mFragmentFactory = null;
    /* access modifiers changed from: private */
    public final FragmentStore mFragmentStore = new FragmentStore();
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory = new FragmentFactory() {
        @NonNull
        public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.getHost().instantiate(FragmentManager.this.getHost().getContext(), str, (Bundle) null);
        }
    };
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments = new ArrayDeque<>();
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
    private final MenuProvider mMenuProvider = new MenuProvider() {
        public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }

        public void onMenuClosed(@NonNull Menu menu) {
            FragmentManager.this.dispatchOptionsMenuClosed(menu);
        }

        public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
            return FragmentManager.this.dispatchOptionsItemSelected(menuItem);
        }

        public void onPrepareMenu(@NonNull Menu menu) {
            FragmentManager.this.dispatchPrepareOptionsMenu(menu);
        }
    };
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners = new CopyOnWriteArrayList<>();
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) {
        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    };
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final Consumer<Configuration> mOnConfigurationChangedListener = new e(this);
    private final Consumer<MultiWindowModeChangedInfo> mOnMultiWindowModeChangedListener = new g(this);
    private final Consumer<PictureInPictureModeChangedInfo> mOnPictureInPictureModeChangedListener = new h(this);
    private final Consumer<Integer> mOnTrimMemoryListener = new f(this);
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions = new ArrayList<>();
    @Nullable
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    /* access modifiers changed from: private */
    public final Map<String, LifecycleAwareResultListener> mResultListeners = DesugarCollections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public final Map<String, Bundle> mResults = DesugarCollections.synchronizedMap(new HashMap());
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory = null;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.Policy mStrictModePolicy;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    public interface BackStackEntry {
        @Deprecated
        @Nullable
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        @Nullable
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    private class ClearBackStackState implements OpGenerator {
        private final String mName;

        ClearBackStackState(@NonNull String str) {
            this.mName = str;
        }

        public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.clearBackStackState(arrayList, arrayList2, this.mName);
        }
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        @NonNull
        public Intent createIntent(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (!(fillInIntent == null || (bundleExtra = fillInIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundleExtra);
                fillInIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                if (fillInIntent.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent((Intent) null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                }
            }
            intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @NonNull
        public ActivityResult parseResult(int i5, @Nullable Intent intent) {
            return new ActivityResult(i5, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    private static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        LifecycleAwareResultListener(@NonNull Lifecycle lifecycle, @NonNull FragmentResultListener fragmentResultListener, @NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle = lifecycle;
            this.mListener = fragmentResultListener;
            this.mObserver = lifecycleEventObserver;
        }

        public boolean isAtLeast(Lifecycle.State state) {
            return this.mLifecycle.getCurrentState().isAtLeast(state);
        }

        public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
            this.mListener.onFragmentResult(str, bundle);
        }

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(@Nullable String str, int i5, int i6) {
            this.mName = str;
            this.mId = i5;
            this.mFlags = i6;
        }

        public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment != null && this.mId < 0 && this.mName == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    private class RestoreBackStackState implements OpGenerator {
        private final String mName;

        RestoreBackStackState(@NonNull String str) {
            this.mName = str;
        }

        public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.restoreBackStackState(arrayList, arrayList2, this.mName);
        }
    }

    private class SaveBackStackState implements OpGenerator {
        private final String mName;

        SaveBackStackState(@NonNull String str) {
            this.mName = str;
        }

        public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.saveBackStackState(arrayList, arrayList2, this.mName);
        }
    }

    public static /* synthetic */ void a(FragmentManager fragmentManager, Integer num) {
        if (fragmentManager.isParentAdded() && num.intValue() == 80) {
            fragmentManager.dispatchLowMemory(false);
        }
    }

    public static /* synthetic */ void c(FragmentManager fragmentManager, PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo) {
        if (fragmentManager.isParentAdded()) {
            fragmentManager.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode(), false);
        }
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void clearBackStackStateViewModels() {
        boolean z4;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z4 = this.mFragmentStore.getNonConfig().isCleared();
        } else if (fragmentHostCallback.getContext() instanceof Activity) {
            z4 = !((Activity) this.mHost.getContext()).isChangingConfigurations();
        } else {
            z4 = true;
        }
        if (z4) {
            for (BackStackState backStackState : this.mBackStackStates.values()) {
                for (String clearNonConfigState : backStackState.mFragments) {
                    this.mFragmentStore.getNonConfig().clearNonConfigState(clearNonConfigState);
                }
            }
        }
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        for (FragmentStateManager fragment : this.mFragmentStore.getActiveFragmentStateManagers()) {
            ViewGroup viewGroup = fragment.getFragment().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> collectChangedControllers(@NonNull ArrayList<BackStackRecord> arrayList, int i5, int i6) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i5 < i6) {
            ArrayList<FragmentTransaction.Op> arrayList2 = arrayList.get(i5).mOps;
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                FragmentTransaction.Op op = arrayList2.get(i7);
                i7++;
                Fragment fragment = op.mFragment;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, this));
                }
            }
            i5++;
        }
        return hashSet;
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, MultiWindowModeChangedInfo multiWindowModeChangedInfo) {
        if (fragmentManager.isParentAdded()) {
            fragmentManager.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode(), false);
        }
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment fragment) {
        if (fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX INFO: finally extract failed */
    private void dispatchStateChange(int i5) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(i5);
            moveToState(i5, false);
            for (SpecialEffectsController forceCompleteAllOperations : collectAllSpecialEffectsController()) {
                forceCompleteAllOperations.forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    public static /* synthetic */ void e(FragmentManager fragmentManager, Configuration configuration) {
        if (fragmentManager.isParentAdded()) {
            fragmentManager.dispatchConfigurationChanged(configuration, false);
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z4) {
        DEBUG = z4;
    }

    private void endAnimatingAwayFragments() {
        for (SpecialEffectsController forceCompleteAllOperations : collectAllSpecialEffectsController()) {
            forceCompleteAllOperations.forceCompleteAllOperations();
        }
    }

    private void ensureExecReady(boolean z4) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
            if (!z4) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private static void executeOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i5, int i6) {
        while (i5 < i6) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                backStackRecord.executePopOps();
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i5++;
        }
    }

    private void executeOpsTogether(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i5, int i6) {
        boolean z4 = arrayList.get(i5).mReorderingAllowed;
        ArrayList<Fragment> arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z5 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            BackStackRecord backStackRecord = arrayList.get(i7);
            if (!arrayList2.get(i7).booleanValue()) {
                primaryNavigationFragment = backStackRecord.expandOps(this.mTmpAddedFragments, primaryNavigationFragment);
            } else {
                primaryNavigationFragment = backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, primaryNavigationFragment);
            }
            if (z5 || backStackRecord.mAddToBackStack) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        this.mTmpAddedFragments.clear();
        if (!z4 && this.mCurState >= 1) {
            for (int i8 = i5; i8 < i6; i8++) {
                ArrayList<FragmentTransaction.Op> arrayList4 = arrayList.get(i8).mOps;
                int size = arrayList4.size();
                int i9 = 0;
                while (i9 < size) {
                    FragmentTransaction.Op op = arrayList4.get(i9);
                    i9++;
                    Fragment fragment = op.mFragment;
                    if (!(fragment == null || fragment.mFragmentManager == null)) {
                        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(fragment));
                    }
                }
            }
        }
        executeOps(arrayList, arrayList2, i5, i6);
        boolean booleanValue = arrayList2.get(i6 - 1).booleanValue();
        for (int i10 = i5; i10 < i6; i10++) {
            BackStackRecord backStackRecord2 = arrayList.get(i10);
            if (booleanValue) {
                for (int size2 = backStackRecord2.mOps.size() - 1; size2 >= 0; size2--) {
                    Fragment fragment2 = backStackRecord2.mOps.get(size2).mFragment;
                    if (fragment2 != null) {
                        createOrGetFragmentStateManager(fragment2).moveToExpectedState();
                    }
                }
            } else {
                ArrayList<FragmentTransaction.Op> arrayList5 = backStackRecord2.mOps;
                int size3 = arrayList5.size();
                int i11 = 0;
                while (i11 < size3) {
                    FragmentTransaction.Op op2 = arrayList5.get(i11);
                    i11++;
                    Fragment fragment3 = op2.mFragment;
                    if (fragment3 != null) {
                        createOrGetFragmentStateManager(fragment3).moveToExpectedState();
                    }
                }
            }
        }
        moveToState(this.mCurState, true);
        for (SpecialEffectsController next : collectChangedControllers(arrayList, i5, i6)) {
            next.updateOperationDirection(booleanValue);
            next.markPostponedState();
            next.executePendingOperations();
        }
        while (i5 < i6) {
            BackStackRecord backStackRecord3 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && backStackRecord3.mIndex >= 0) {
                backStackRecord3.mIndex = -1;
            }
            backStackRecord3.runOnCommitRunnables();
            i5++;
        }
        if (z5) {
            reportBackStackChanged();
        }
    }

    private int findBackStackIndex(@Nullable String str, int i5, boolean z4) {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i5 >= 0) {
            int size = this.mBackStack.size() - 1;
            while (size >= 0) {
                BackStackRecord backStackRecord = this.mBackStack.get(size);
                if ((str != null && str.equals(backStackRecord.getName())) || (i5 >= 0 && i5 == backStackRecord.mIndex)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z4) {
                while (size > 0) {
                    BackStackRecord backStackRecord2 = this.mBackStack.get(size - 1);
                    if ((str == null || !str.equals(backStackRecord2.getName())) && (i5 < 0 || i5 != backStackRecord2.mIndex)) {
                        break;
                    }
                    size--;
                }
                return size;
            } else if (size == this.mBackStack.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z4) {
            return 0;
        } else {
            return this.mBackStack.size() - 1;
        }
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view) {
        F findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            return findViewFragment;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @NonNull
    static FragmentManager findFragmentManager(@NonNull View view) {
        FragmentActivity fragmentActivity;
        Fragment findViewFragment = findViewFragment(view);
        if (findViewFragment == null) {
            Context context = view.getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    fragmentActivity = null;
                    break;
                } else if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (fragmentActivity != null) {
                return fragmentActivity.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (findViewFragment.isAdded()) {
            return findViewFragment.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + findViewFragment + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    @Nullable
    private static Fragment findViewFragment(@NonNull View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        for (SpecialEffectsController forcePostponedExecutePendingOperations : collectAllSpecialEffectsController()) {
            forcePostponedExecutePendingOperations.forcePostponedExecutePendingOperations();
        }
    }

    private boolean generateOpsForPendingActions(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            try {
                int size = this.mPendingActions.size();
                boolean z4 = false;
                for (int i5 = 0; i5 < size; i5++) {
                    z4 |= this.mPendingActions.get(i5).generateOps(arrayList, arrayList2);
                }
                return z4;
            } finally {
                this.mPendingActions.clear();
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            }
        }
    }

    @NonNull
    private FragmentManagerViewModel getChildNonConfig(@NonNull Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    private ViewGroup getFragmentContainer(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    @Nullable
    static Fragment getViewFragment(@NonNull View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean isLoggingEnabled(int i5) {
        if (DEBUG || Log.isLoggable(TAG, i5)) {
            return true;
        }
        return false;
    }

    private boolean isMenuAvailable(@NonNull Fragment fragment) {
        if ((!fragment.mHasMenu || !fragment.mMenuVisible) && !fragment.mChildFragmentManager.checkForMenus()) {
            return false;
        }
        return true;
    }

    private boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        if (!fragment.isAdded() || !this.mParent.getParentFragmentManager().isParentAdded()) {
            return false;
        }
        return true;
    }

    private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i5 = 0;
                int i6 = 0;
                while (i5 < size) {
                    if (!arrayList.get(i5).mReorderingAllowed) {
                        if (i6 != i5) {
                            executeOpsTogether(arrayList, arrayList2, i6, i5);
                        }
                        i6 = i5 + 1;
                        if (arrayList2.get(i5).booleanValue()) {
                            while (i6 < size && arrayList2.get(i6).booleanValue() && !arrayList.get(i6).mReorderingAllowed) {
                                i6++;
                            }
                        }
                        executeOpsTogether(arrayList, arrayList2, i5, i6);
                        i5 = i6 - 1;
                    }
                    i5++;
                }
                if (i6 != size) {
                    executeOpsTogether(arrayList, arrayList2, i6, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i5 = 0; i5 < this.mBackStackChangeListeners.size(); i5++) {
                this.mBackStackChangeListeners.get(i5).onBackStackChanged();
            }
        }
    }

    static int reverseTransit(int i5) {
        if (i5 == 4097) {
            return 8194;
        }
        if (i5 == 8194) {
            return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (i5 == 8197) {
            return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
        }
        if (i5 == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i5 != 4100) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE;
    }

    private void setVisibleRemovingFragment(@NonNull Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i5 = R.id.visible_removing_fragment_view_tag;
            if (fragmentContainer.getTag(i5) == null) {
                fragmentContainer.setTag(i5, fragment);
            }
            ((Fragment) fragmentContainer.getTag(i5)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void startPendingDeferredFragments() {
        for (FragmentStateManager performPendingDeferredStart : this.mFragmentStore.getActiveFragmentStateManagers()) {
            performPendingDeferredStart(performPendingDeferredStart);
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e5) {
                Log.e(TAG, "Failed dumping state", e5);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e6) {
                Log.e(TAG, "Failed dumping state", e6);
            }
        }
        throw runtimeException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        r0 = r3.mOnBackPressedCallback;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (getBackStackEntryCount() <= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (isPrimaryNavigation(r3.mParent) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r0 = r3.mPendingActions
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r1 = r3.mPendingActions     // Catch:{ all -> 0x0013 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0013 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            androidx.activity.OnBackPressedCallback r1 = r3.mOnBackPressedCallback     // Catch:{ all -> 0x0013 }
            r1.setEnabled(r2)     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x002c
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            androidx.activity.OnBackPressedCallback r0 = r3.mOnBackPressedCallback
            int r1 = r3.getBackStackEntryCount()
            if (r1 <= 0) goto L_0x0027
            androidx.fragment.app.Fragment r1 = r3.mParent
            boolean r1 = r3.isPrimaryNavigation(r1)
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            r0.setEnabled(r2)
            return
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.updateOnBackPressedCallbackEnabled():void");
    }

    /* access modifiers changed from: package-private */
    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager addFragment(@NonNull Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "add: " + fragment);
        }
        FragmentStateManager createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void addRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.addRetainedFragment(fragment);
    }

    /* access modifiers changed from: package-private */
    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachController(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> r4, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r5, @androidx.annotation.Nullable final androidx.fragment.app.Fragment r6) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r3.mHost
            if (r0 != 0) goto L_0x016c
            r3.mHost = r4
            r3.mContainer = r5
            r3.mParent = r6
            if (r6 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$7 r5 = new androidx.fragment.app.FragmentManager$7
            r5.<init>(r6)
            r3.addFragmentOnAttachListener(r5)
            goto L_0x001f
        L_0x0015:
            boolean r5 = r4 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r5 == 0) goto L_0x001f
            r5 = r4
            androidx.fragment.app.FragmentOnAttachListener r5 = (androidx.fragment.app.FragmentOnAttachListener) r5
            r3.addFragmentOnAttachListener(r5)
        L_0x001f:
            androidx.fragment.app.Fragment r5 = r3.mParent
            if (r5 == 0) goto L_0x0026
            r3.updateOnBackPressedCallbackEnabled()
        L_0x0026:
            boolean r5 = r4 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r5 == 0) goto L_0x003b
            r5 = r4
            androidx.activity.OnBackPressedDispatcherOwner r5 = (androidx.activity.OnBackPressedDispatcherOwner) r5
            androidx.activity.OnBackPressedDispatcher r0 = r5.getOnBackPressedDispatcher()
            r3.mOnBackPressedDispatcher = r0
            if (r6 == 0) goto L_0x0036
            r5 = r6
        L_0x0036:
            androidx.activity.OnBackPressedCallback r1 = r3.mOnBackPressedCallback
            r0.addCallback(r5, r1)
        L_0x003b:
            if (r6 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r4 = r6.mFragmentManager
            androidx.fragment.app.FragmentManagerViewModel r4 = r4.getChildNonConfig(r6)
            r3.mNonConfig = r4
            goto L_0x005f
        L_0x0046:
            boolean r5 = r4 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r5 == 0) goto L_0x0057
            androidx.lifecycle.ViewModelStoreOwner r4 = (androidx.lifecycle.ViewModelStoreOwner) r4
            androidx.lifecycle.ViewModelStore r4 = r4.getViewModelStore()
            androidx.fragment.app.FragmentManagerViewModel r4 = androidx.fragment.app.FragmentManagerViewModel.getInstance(r4)
            r3.mNonConfig = r4
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.FragmentManagerViewModel r4 = new androidx.fragment.app.FragmentManagerViewModel
            r5 = 0
            r4.<init>(r5)
            r3.mNonConfig = r4
        L_0x005f:
            androidx.fragment.app.FragmentManagerViewModel r4 = r3.mNonConfig
            boolean r5 = r3.isStateSaved()
            r4.setIsStateSaved(r5)
            androidx.fragment.app.FragmentStore r4 = r3.mFragmentStore
            androidx.fragment.app.FragmentManagerViewModel r5 = r3.mNonConfig
            r4.setNonConfig(r5)
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.savedstate.SavedStateRegistryOwner
            if (r5 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x0090
            androidx.savedstate.SavedStateRegistryOwner r4 = (androidx.savedstate.SavedStateRegistryOwner) r4
            androidx.savedstate.SavedStateRegistry r4 = r4.getSavedStateRegistry()
            androidx.fragment.app.i r5 = new androidx.fragment.app.i
            r5.<init>(r3)
            java.lang.String r0 = "android:support:fragments"
            r4.registerSavedStateProvider(r0, r5)
            android.os.Bundle r4 = r4.consumeRestoredStateForKey(r0)
            if (r4 == 0) goto L_0x0090
            r3.restoreSaveStateInternal(r4)
        L_0x0090:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r5 == 0) goto L_0x0128
            androidx.activity.result.ActivityResultRegistryOwner r4 = (androidx.activity.result.ActivityResultRegistryOwner) r4
            androidx.activity.result.ActivityResultRegistry r4 = r4.getActivityResultRegistry()
            if (r6 == 0) goto L_0x00b2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r6.mWho
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r5 = ""
        L_0x00b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FragmentManager:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartActivityForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r1 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r1.<init>()
            androidx.fragment.app.FragmentManager$8 r2 = new androidx.fragment.app.FragmentManager$8
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.register(r0, r1, r2)
            r3.mStartActivityForResult = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartIntentSenderForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.fragment.app.FragmentManager$FragmentIntentSenderContract r1 = new androidx.fragment.app.FragmentManager$FragmentIntentSenderContract
            r1.<init>()
            androidx.fragment.app.FragmentManager$9 r2 = new androidx.fragment.app.FragmentManager$9
            r2.<init>()
            androidx.activity.result.ActivityResultLauncher r0 = r4.register(r0, r1, r2)
            r3.mStartIntentSenderForResult = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "RequestPermissions"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r0 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r0.<init>()
            androidx.fragment.app.FragmentManager$10 r1 = new androidx.fragment.app.FragmentManager$10
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r4 = r4.register(r5, r0, r1)
            r3.mRequestPermissions = r4
        L_0x0128:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.core.content.OnConfigurationChangedProvider
            if (r5 == 0) goto L_0x0135
            androidx.core.content.OnConfigurationChangedProvider r4 = (androidx.core.content.OnConfigurationChangedProvider) r4
            androidx.core.util.Consumer<android.content.res.Configuration> r5 = r3.mOnConfigurationChangedListener
            r4.addOnConfigurationChangedListener(r5)
        L_0x0135:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.core.content.OnTrimMemoryProvider
            if (r5 == 0) goto L_0x0142
            androidx.core.content.OnTrimMemoryProvider r4 = (androidx.core.content.OnTrimMemoryProvider) r4
            androidx.core.util.Consumer<java.lang.Integer> r5 = r3.mOnTrimMemoryListener
            r4.addOnTrimMemoryListener(r5)
        L_0x0142:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.core.app.OnMultiWindowModeChangedProvider
            if (r5 == 0) goto L_0x014f
            androidx.core.app.OnMultiWindowModeChangedProvider r4 = (androidx.core.app.OnMultiWindowModeChangedProvider) r4
            androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo> r5 = r3.mOnMultiWindowModeChangedListener
            r4.addOnMultiWindowModeChangedListener(r5)
        L_0x014f:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.core.app.OnPictureInPictureModeChangedProvider
            if (r5 == 0) goto L_0x015c
            androidx.core.app.OnPictureInPictureModeChangedProvider r4 = (androidx.core.app.OnPictureInPictureModeChangedProvider) r4
            androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo> r5 = r3.mOnPictureInPictureModeChangedListener
            r4.addOnPictureInPictureModeChangedListener(r5)
        L_0x015c:
            androidx.fragment.app.FragmentHostCallback<?> r4 = r3.mHost
            boolean r5 = r4 instanceof androidx.core.view.MenuHost
            if (r5 == 0) goto L_0x016b
            if (r6 != 0) goto L_0x016b
            androidx.core.view.MenuHost r4 = (androidx.core.view.MenuHost) r4
            androidx.core.view.MenuProvider r5 = r3.mMenuProvider
            r4.addMenuProvider(r5)
        L_0x016b:
            return
        L_0x016c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Already attached"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.attachController(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void attachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    /* access modifiers changed from: package-private */
    public boolean checkForMenus() {
        boolean z4 = false;
        for (Fragment next : this.mFragmentStore.getActiveFragments()) {
            if (next != null) {
                z4 = isMenuAvailable(next);
                continue;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public void clearBackStack(@NonNull String str) {
        enqueueAction(new ClearBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    public boolean clearBackStackState(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        if (!restoreBackStackState(arrayList, arrayList2, str)) {
            return false;
        }
        return popBackStackState(arrayList, arrayList2, str, -1, 1);
    }

    public final void clearFragmentResult(@NonNull String str) {
        this.mResults.remove(str);
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing fragment result with key " + str);
        }
    }

    public final void clearFragmentResultListener(@NonNull String str) {
        LifecycleAwareResultListener remove = this.mResultListeners.remove(str);
        if (remove != null) {
            remove.removeObserver();
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Clearing FragmentResultListener for key " + str);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentStateManager createOrGetFragmentStateManager(@NonNull Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, fragment);
        fragmentStateManager2.restoreState(this.mHost.getContext().getClassLoader());
        fragmentStateManager2.setFragmentManagerState(this.mCurState);
        return fragmentStateManager2;
    }

    /* access modifiers changed from: package-private */
    public void detachFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "remove from detach: " + fragment);
                }
                this.mFragmentStore.removeFragment(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    /* access modifiers changed from: package-private */
    public void dispatchConfigurationChanged(@NonNull Configuration configuration, boolean z4) {
        if (z4 && (this.mHost instanceof OnConfigurationChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
                if (z4) {
                    next.mChildFragmentManager.dispatchConfigurationChanged(configuration, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z4 = false;
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && isParentMenuVisible(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z4 = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i5 = 0; i5 < this.mCreatedMenus.size(); i5++) {
                Fragment fragment = this.mCreatedMenus.get(i5);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentHostCallback<?> fragmentHostCallback2 = this.mHost;
        if (fragmentHostCallback2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback2).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback3 = this.mHost;
        if (fragmentHostCallback3 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback3).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback4 = this.mHost;
        if (fragmentHostCallback4 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback4).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentHostCallback<?> fragmentHostCallback5 = this.mHost;
        if ((fragmentHostCallback5 instanceof MenuHost) && this.mParent == null) {
            ((MenuHost) fragmentHostCallback5).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.mStartActivityForResult;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchLowMemory(boolean z4) {
        if (z4 && (this.mHost instanceof OnTrimMemoryProvider)) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performLowMemory();
                if (z4) {
                    next.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchMultiWindowModeChanged(boolean z4, boolean z5) {
        if (z5 && (this.mHost instanceof OnMultiWindowModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z4);
                if (z5) {
                    next.mChildFragmentManager.dispatchMultiWindowModeChanged(z4, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnAttachFragment(@NonNull Fragment fragment) {
        Iterator<FragmentOnAttachListener> it = this.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().onAttachFragment(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnHiddenChanged() {
        for (Fragment next : this.mFragmentStore.getActiveFragments()) {
            if (next != null) {
                next.onHiddenChanged(next.isHidden());
                next.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        if (this.mCurState >= 1) {
            for (Fragment next : this.mFragmentStore.getFragments()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchPause() {
        dispatchStateChange(5);
    }

    /* access modifiers changed from: package-private */
    public void dispatchPictureInPictureModeChanged(boolean z4, boolean z5) {
        if (z5 && (this.mHost instanceof OnPictureInPictureModeChangedProvider)) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z4);
                if (z5) {
                    next.mChildFragmentManager.dispatchPictureInPictureModeChanged(z4, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        boolean z4 = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && isParentMenuVisible(next) && next.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    /* access modifiers changed from: package-private */
    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.mFragmentStore.dump(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size2; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i5).toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size; i6++) {
                BackStackRecord backStackRecord = this.mBackStack.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size3 = this.mPendingActions.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i7 = 0; i7 < size3; i7++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i7);
                        printWriter.print(": ");
                        printWriter.println(this.mPendingActions.get(i7));
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueueAction(@NonNull OpGenerator opGenerator, boolean z4) {
        if (!z4) {
            if (this.mHost != null) {
                checkStateLoss();
            } else if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost != null) {
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                } else if (!z4) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean execPendingActions(boolean z4) {
        ensureExecReady(z4);
        boolean z5 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            z5 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return z5;
    }

    /* access modifiers changed from: package-private */
    public void execSingleAction(@NonNull OpGenerator opGenerator, boolean z4) {
        if (!z4 || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z4);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.burpActive();
        }
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return execPendingActions;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment findActiveFragment(@NonNull String str) {
        return this.mFragmentStore.findActiveFragment(str);
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i5) {
        return this.mFragmentStore.findFragmentById(i5);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        return this.mFragmentStore.findFragmentByTag(str);
    }

    /* access modifiers changed from: package-private */
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.mFragmentStore.findFragmentByWho(str);
    }

    /* access modifiers changed from: package-private */
    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i5) {
        return this.mBackStack.get(i5);
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment findActiveFragment = findActiveFragment(string);
        if (findActiveFragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return findActiveFragment;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment getParent() {
        return this.mParent;
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.mSpecialEffectsControllerFactory;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    @Nullable
    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ViewModelStore getViewModelStore(@NonNull Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    /* access modifiers changed from: package-private */
    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public void hideFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateMenuForFragment(@NonNull Fragment fragment) {
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* access modifiers changed from: package-private */
    public boolean isParentHidden(@Nullable Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    /* access modifiers changed from: package-private */
    public boolean isParentMenuVisible(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public boolean isPrimaryNavigation(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !isPrimaryNavigation(fragmentManager.mParent)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isStateAtLeast(int i5) {
        if (this.mCurState >= i5) {
            return true;
        }
        return false;
    }

    public boolean isStateSaved() {
        if (this.mStateSaved || this.mStopped) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void launchRequestPermissions(@NonNull Fragment fragment, @NonNull String[] strArr, int i5) {
        if (this.mRequestPermissions != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i5));
            this.mRequestPermissions.launch(strArr);
            return;
        }
        this.mHost.onRequestPermissionsFromFragment(fragment, strArr, i5);
    }

    /* access modifiers changed from: package-private */
    public void launchStartActivityForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5, @Nullable Bundle bundle) {
        if (this.mStartActivityForResult != null) {
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i5));
            if (!(intent == null || bundle == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
            }
            this.mStartActivityForResult.launch(intent);
            return;
        }
        this.mHost.onStartActivityFromFragment(fragment, intent, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public void launchStartIntentSenderForResult(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i5, @Nullable Intent intent, int i6, int i7, int i8, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Bundle bundle2 = bundle;
        if (this.mStartIntentSenderForResult != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent = new Intent();
                    intent.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
                }
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent + " for fragment " + fragment);
                }
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle2);
            }
            IntentSenderRequest build = new IntentSenderRequest.Builder(intentSender).setFillInIntent(intent).setFlags(i7, i6).build();
            this.mLaunchedFragments.addLast(new LaunchedFragmentInfo(fragment.mWho, i5));
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.mStartIntentSenderForResult.launch(build);
            return;
        }
        this.mHost.onStartIntentSenderFromFragment(fragment, intentSender, i5, intent, i6, i7, i8, bundle2);
    }

    /* access modifiers changed from: package-private */
    public void moveToState(int i5, boolean z4) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z4 || i5 != this.mCurState) {
            this.mCurState = i5;
            this.mFragmentStore.moveToExpectedState();
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        if (this.mHost != null) {
            this.mStateSaved = false;
            this.mStopped = false;
            this.mNonConfig.setIsStateSaved(false);
            for (Fragment next : this.mFragmentStore.getFragments()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onContainerAvailable(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        for (FragmentStateManager next : this.mFragmentStore.getActiveFragmentStateManagers()) {
            Fragment fragment = next.getFragment();
            if (fragment.mContainerId == fragmentContainerView.getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = fragmentContainerView;
                next.addViewToContainer();
            }
        }
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    /* access modifiers changed from: package-private */
    public void performPendingDeferredStart(@NonNull FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        fragmentStateManager.moveToExpectedState();
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState((String) null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean popBackStackState(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i5, int i6) {
        boolean z4;
        if ((i6 & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int findBackStackIndex = findBackStackIndex(str, i5, z4);
        if (findBackStackIndex < 0) {
            return false;
        }
        for (int size = this.mBackStack.size() - 1; size >= findBackStackIndex; size--) {
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z4) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z4);
    }

    /* access modifiers changed from: package-private */
    public void removeFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (!fragment.mDetached || !isInBackStack) {
            this.mFragmentStore.removeFragment(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeRetainedFragment(@NonNull Fragment fragment) {
        this.mNonConfig.removeRetainedFragment(fragment);
    }

    /* access modifiers changed from: package-private */
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        restoreSaveStateInternal(parcelable);
    }

    public void restoreBackStack(@NonNull String str) {
        enqueueAction(new RestoreBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    public boolean restoreBackStackState(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2, @NonNull String str) {
        BackStackState remove = this.mBackStackStates.remove(str);
        if (remove == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            i5++;
            BackStackRecord backStackRecord2 = backStackRecord;
            if (backStackRecord2.mBeingSaved) {
                ArrayList<FragmentTransaction.Op> arrayList3 = backStackRecord2.mOps;
                int size2 = arrayList3.size();
                int i6 = 0;
                while (i6 < size2) {
                    FragmentTransaction.Op op = arrayList3.get(i6);
                    i6++;
                    Fragment fragment = op.mFragment;
                    if (fragment != null) {
                        hashMap.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator<BackStackRecord> it = remove.instantiate(this, hashMap).iterator();
        while (true) {
            boolean z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    return z4;
                }
                if (it.next().generateOps(arrayList, arrayList2) || z4) {
                    z4 = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void restoreSaveState(@Nullable Parcelable parcelable) {
        if (this.mHost instanceof SavedStateRegistryOwner) {
            throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        restoreSaveStateInternal(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void restoreSaveStateInternal(@Nullable Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable != null) {
            Bundle bundle3 = (Bundle) parcelable;
            for (String next : bundle3.keySet()) {
                if (next.startsWith(RESULT_NAME_PREFIX) && (bundle2 = bundle3.getBundle(next)) != null) {
                    bundle2.setClassLoader(this.mHost.getContext().getClassLoader());
                    this.mResults.put(next.substring(7), bundle2);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String next2 : bundle3.keySet()) {
                if (next2.startsWith(FRAGMENT_NAME_PREFIX) && (bundle = bundle3.getBundle(next2)) != null) {
                    bundle.setClassLoader(this.mHost.getContext().getClassLoader());
                    arrayList.add((FragmentState) bundle.getParcelable(MRAIDCommunicatorUtil.KEY_STATE));
                }
            }
            this.mFragmentStore.restoreSaveState(arrayList);
            FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable(MRAIDCommunicatorUtil.KEY_STATE);
            if (fragmentManagerState != null) {
                this.mFragmentStore.resetActiveFragments();
                ArrayList<String> arrayList2 = fragmentManagerState.mActive;
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    String str = arrayList2.get(i5);
                    i5++;
                    FragmentState savedState = this.mFragmentStore.setSavedState(str, (FragmentState) null);
                    if (savedState != null) {
                        Fragment findRetainedFragmentByWho = this.mNonConfig.findRetainedFragmentByWho(savedState.mWho);
                        if (findRetainedFragmentByWho != null) {
                            if (isLoggingEnabled(2)) {
                                Log.v(TAG, "restoreSaveState: re-attaching retained " + findRetainedFragmentByWho);
                            }
                            fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, findRetainedFragmentByWho, savedState);
                        } else {
                            fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), savedState);
                        }
                        Fragment fragment = fragmentStateManager.getFragment();
                        fragment.mFragmentManager = this;
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreSaveState: active (" + fragment.mWho + "): " + fragment);
                        }
                        fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
                        this.mFragmentStore.makeActive(fragmentStateManager);
                        fragmentStateManager.setFragmentManagerState(this.mCurState);
                    }
                }
                for (Fragment next3 : this.mNonConfig.getRetainedFragments()) {
                    if (!this.mFragmentStore.containsActiveFragment(next3.mWho)) {
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "Discarding retained Fragment " + next3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                        }
                        this.mNonConfig.removeRetainedFragment(next3);
                        next3.mFragmentManager = this;
                        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, next3);
                        fragmentStateManager2.setFragmentManagerState(1);
                        fragmentStateManager2.moveToExpectedState();
                        next3.mRemoving = true;
                        fragmentStateManager2.moveToExpectedState();
                    }
                }
                this.mFragmentStore.restoreAddedFragments(fragmentManagerState.mAdded);
                if (fragmentManagerState.mBackStack != null) {
                    this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
                    int i6 = 0;
                    while (true) {
                        BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                        if (i6 >= backStackRecordStateArr.length) {
                            break;
                        }
                        BackStackRecord instantiate = backStackRecordStateArr[i6].instantiate(this);
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreAllState: back stack #" + i6 + " (index " + instantiate.mIndex + "): " + instantiate);
                            PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                            instantiate.dump("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(instantiate);
                        i6++;
                    }
                } else {
                    this.mBackStack = null;
                }
                this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
                String str2 = fragmentManagerState.mPrimaryNavActiveWho;
                if (str2 != null) {
                    Fragment findActiveFragment = findActiveFragment(str2);
                    this.mPrimaryNav = findActiveFragment;
                    dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
                }
                ArrayList<String> arrayList3 = fragmentManagerState.mBackStackStateKeys;
                if (arrayList3 != null) {
                    for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                        this.mBackStackStates.put(arrayList3.get(i7), fragmentManagerState.mBackStackStates.get(i7));
                    }
                }
                this.mLaunchedFragments = new ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.getSnapshot();
    }

    /* access modifiers changed from: package-private */
    public Parcelable saveAllState() {
        if (this.mHost instanceof SavedStateRegistryOwner) {
            throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle saveAllStateInternal = saveAllStateInternal();
        if (saveAllStateInternal.isEmpty()) {
            return null;
        }
        return saveAllStateInternal;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Bundle saveAllStateInternal() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> saveActiveFragments = this.mFragmentStore.saveActiveFragments();
        ArrayList<FragmentState> allSavedState = this.mFragmentStore.getAllSavedState();
        if (!allSavedState.isEmpty()) {
            ArrayList<String> saveAddedFragments = this.mFragmentStore.saveAddedFragments();
            ArrayList<BackStackRecord> arrayList = this.mBackStack;
            int i5 = 0;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i6 = 0; i6 < size; i6++) {
                    backStackRecordStateArr[i6] = new BackStackRecordState(this.mBackStack.get(i6));
                    if (isLoggingEnabled(2)) {
                        Log.v(TAG, "saveAllState: adding back stack #" + i6 + ": " + this.mBackStack.get(i6));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = saveActiveFragments;
            fragmentManagerState.mAdded = saveAddedFragments;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment = this.mPrimaryNav;
            if (fragment != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.mBackStackStates.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.mLaunchedFragments);
            bundle.putParcelable(MRAIDCommunicatorUtil.KEY_STATE, fragmentManagerState);
            for (String next : this.mResults.keySet()) {
                bundle.putBundle(RESULT_NAME_PREFIX + next, this.mResults.get(next));
            }
            int size2 = allSavedState.size();
            while (i5 < size2) {
                FragmentState fragmentState = allSavedState.get(i5);
                i5++;
                FragmentState fragmentState2 = fragmentState;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MRAIDCommunicatorUtil.KEY_STATE, fragmentState2);
                bundle.putBundle(FRAGMENT_NAME_PREFIX + fragmentState2.mWho, bundle2);
            }
        } else if (isLoggingEnabled(2)) {
            Log.v(TAG, "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public void saveBackStack(@NonNull String str) {
        enqueueAction(new SaveBackStackState(str), false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        if (r4 != 8) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveBackStackState(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.BackStackRecord> r19, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> r20, @androidx.annotation.NonNull java.lang.String r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            r2 = -1
            r3 = 1
            int r2 = r0.findBackStackIndex(r1, r2, r3)
            r4 = 0
            if (r2 >= 0) goto L_0x000e
            return r4
        L_0x000e:
            r5 = r2
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r6 = r0.mBackStack
            int r6 = r6.size()
            java.lang.String r7 = "saveBackStack(\""
            if (r5 >= r6) goto L_0x004c
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r6 = r0.mBackStack
            java.lang.Object r6 = r6.get(r5)
            androidx.fragment.app.BackStackRecord r6 = (androidx.fragment.app.BackStackRecord) r6
            boolean r8 = r6.mReorderingAllowed
            if (r8 != 0) goto L_0x0049
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r1)
            java.lang.String r7 = "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found "
            r9.append(r7)
            r9.append(r6)
            java.lang.String r6 = " that did not use setReorderingAllowed(true)."
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            r8.<init>(r6)
            r0.throwException(r8)
        L_0x0049:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x004c:
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            r6 = r2
        L_0x0052:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r8 = r0.mBackStack
            int r8 = r8.size()
            if (r6 >= r8) goto L_0x011b
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r8 = r0.mBackStack
            java.lang.Object r8 = r8.get(r6)
            androidx.fragment.app.BackStackRecord r8 = (androidx.fragment.app.BackStackRecord) r8
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op> r11 = r8.mOps
            int r12 = r11.size()
            r13 = r4
        L_0x0073:
            if (r13 >= r12) goto L_0x00ac
            java.lang.Object r14 = r11.get(r13)
            int r13 = r13 + 1
            androidx.fragment.app.FragmentTransaction$Op r14 = (androidx.fragment.app.FragmentTransaction.Op) r14
            androidx.fragment.app.Fragment r15 = r14.mFragment
            if (r15 != 0) goto L_0x0082
            goto L_0x0073
        L_0x0082:
            boolean r4 = r14.mFromExpandedOp
            r3 = 2
            if (r4 == 0) goto L_0x0095
            int r4 = r14.mCmd
            r17 = r6
            r6 = 1
            if (r4 == r6) goto L_0x0097
            if (r4 == r3) goto L_0x0097
            r6 = 8
            if (r4 != r6) goto L_0x009d
            goto L_0x0097
        L_0x0095:
            r17 = r6
        L_0x0097:
            r5.add(r15)
            r9.add(r15)
        L_0x009d:
            int r4 = r14.mCmd
            r6 = 1
            if (r4 == r6) goto L_0x00a4
            if (r4 != r3) goto L_0x00a7
        L_0x00a4:
            r10.add(r15)
        L_0x00a7:
            r6 = r17
            r3 = 1
            r4 = 0
            goto L_0x0073
        L_0x00ac:
            r17 = r6
            r9.removeAll(r10)
            boolean r3 = r9.isEmpty()
            if (r3 != 0) goto L_0x0115
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            r4.append(r1)
            java.lang.String r6 = "\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment"
            r4.append(r6)
            int r6 = r9.size()
            r10 = 1
            if (r6 != r10) goto L_0x00ea
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = " "
            r6.append(r10)
            java.util.Iterator r9 = r9.iterator()
            java.lang.Object r9 = r9.next()
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            goto L_0x00fb
        L_0x00ea:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = "s "
            r6.append(r10)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
        L_0x00fb:
            r4.append(r6)
            java.lang.String r6 = " in "
            r4.append(r6)
            r4.append(r8)
            java.lang.String r6 = " that were previously added to the FragmentManager through a separate FragmentTransaction."
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            r0.throwException(r3)
        L_0x0115:
            int r6 = r17 + 1
            r3 = 1
            r4 = 0
            goto L_0x0052
        L_0x011b:
            java.util.ArrayDeque r3 = new java.util.ArrayDeque
            r3.<init>(r5)
        L_0x0120:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x017e
            java.lang.Object r4 = r3.removeFirst()
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r6 = r4.mRetainInstance
            if (r6 == 0) goto L_0x0162
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r1)
            java.lang.String r9 = "\") must not contain retained fragments. Found "
            r8.append(r9)
            boolean r9 = r5.contains(r4)
            if (r9 == 0) goto L_0x014b
            java.lang.String r9 = "direct reference to retained "
            goto L_0x014d
        L_0x014b:
            java.lang.String r9 = "retained child "
        L_0x014d:
            r8.append(r9)
            java.lang.String r9 = "fragment "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r6.<init>(r8)
            r0.throwException(r6)
        L_0x0162:
            androidx.fragment.app.FragmentManager r4 = r4.mChildFragmentManager
            java.util.List r4 = r4.getActiveFragments()
            java.util.Iterator r4 = r4.iterator()
        L_0x016c:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0120
            java.lang.Object r6 = r4.next()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            if (r6 == 0) goto L_0x016c
            r3.addLast(r6)
            goto L_0x016c
        L_0x017e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r5.iterator()
        L_0x0187:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0199
            java.lang.Object r5 = r4.next()
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            java.lang.String r5 = r5.mWho
            r3.add(r5)
            goto L_0x0187
        L_0x0199:
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r5 = r0.mBackStack
            int r5 = r5.size()
            int r5 = r5 - r2
            r4.<init>(r5)
            r5 = r2
        L_0x01a6:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r6 = r0.mBackStack
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x01b5
            r6 = 0
            r4.add(r6)
            int r5 = r5 + 1
            goto L_0x01a6
        L_0x01b5:
            androidx.fragment.app.BackStackState r5 = new androidx.fragment.app.BackStackState
            r5.<init>(r3, r4)
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r3 = r0.mBackStack
            int r3 = r3.size()
            r16 = 1
            int r3 = r3 + -1
        L_0x01c4:
            if (r3 < r2) goto L_0x01f2
            java.util.ArrayList<androidx.fragment.app.BackStackRecord> r6 = r0.mBackStack
            java.lang.Object r6 = r6.remove(r3)
            androidx.fragment.app.BackStackRecord r6 = (androidx.fragment.app.BackStackRecord) r6
            androidx.fragment.app.BackStackRecord r7 = new androidx.fragment.app.BackStackRecord
            r7.<init>((androidx.fragment.app.BackStackRecord) r6)
            r7.collapseOps()
            androidx.fragment.app.BackStackRecordState r8 = new androidx.fragment.app.BackStackRecordState
            r8.<init>((androidx.fragment.app.BackStackRecord) r7)
            int r7 = r3 - r2
            r4.set(r7, r8)
            r10 = 1
            r6.mBeingSaved = r10
            r7 = r19
            r7.add(r6)
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r8 = r20
            r8.add(r6)
            int r3 = r3 + -1
            goto L_0x01c4
        L_0x01f2:
            r10 = 1
            java.util.Map<java.lang.String, androidx.fragment.app.BackStackState> r2 = r0.mBackStackStates
            r2.put(r1, r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.saveBackStackState(java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager == null || !fragmentStateManager.getFragment().equals(fragment)) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return fragmentStateManager.saveInstanceState();
    }

    /* access modifiers changed from: package-private */
    public void scheduleCommit() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.size() == 1) {
                    this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                    this.mHost.getHandler().post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setExitAnimationOrder(@NonNull Fragment fragment, boolean z4) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z4);
        }
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public final void setFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        LifecycleAwareResultListener lifecycleAwareResultListener = this.mResultListeners.get(str);
        if (lifecycleAwareResultListener == null || !lifecycleAwareResultListener.isAtLeast(Lifecycle.State.STARTED)) {
            this.mResults.put(str, bundle);
        } else {
            lifecycleAwareResultListener.onFragmentResult(str, bundle);
        }
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            AnonymousClass6 r02 = new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    Bundle bundle;
                    if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.mResults.get(str)) != null) {
                        fragmentResultListener.onFragmentResult(str, bundle);
                        FragmentManager.this.clearFragmentResult(str);
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        FragmentManager.this.mResultListeners.remove(str);
                    }
                }
            };
            LifecycleAwareResultListener put = this.mResultListeners.put(str, new LifecycleAwareResultListener(lifecycle, fragmentResultListener, r02));
            if (put != null) {
                put.removeObserver();
            }
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + fragmentResultListener);
            }
            lifecycle.addObserver(r02);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    /* access modifiers changed from: package-private */
    public void setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public void setSpecialEffectsControllerFactory(@NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    public void setStrictModePolicy(@Nullable FragmentStrictMode.Policy policy) {
        this.mStrictModePolicy = policy;
    }

    /* access modifiers changed from: package-private */
    public void showFragment(@NonNull Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }

    public void popBackStack(@Nullable String str, int i5) {
        enqueueAction(new PopBackStackState(str, -1, i5), false);
    }

    public boolean popBackStackImmediate(@Nullable String str, int i5) {
        return popBackStackImmediate(str, -1, i5);
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() {
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            public LaunchedFragmentInfo[] newArray(int i5) {
                return new LaunchedFragmentInfo[i5];
            }
        };
        int mRequestCode;
        String mWho;

        LaunchedFragmentInfo(@NonNull String str, int i5) {
            this.mWho = str;
            this.mRequestCode = i5;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }

        LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }
    }

    public void popBackStack(int i5, int i6) {
        popBackStack(i5, i6, false);
    }

    public boolean popBackStackImmediate(int i5, int i6) {
        if (i5 >= 0) {
            return popBackStackImmediate((String) null, i5, i6);
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    /* access modifiers changed from: package-private */
    public void popBackStack(int i5, int i6, boolean z4) {
        if (i5 >= 0) {
            enqueueAction(new PopBackStackState((String) null, i5, i6), z4);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    private boolean popBackStackImmediate(@Nullable String str, int i5, int i6) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i5 < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i5, i6);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th) {
                Throwable th2 = th;
                cleanupExec();
                throw th2;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return popBackStackState;
    }
}
