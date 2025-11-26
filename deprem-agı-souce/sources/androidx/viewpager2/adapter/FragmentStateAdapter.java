package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresOptIn;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    FragmentEventDispatcher mFragmentEventDispatcher;
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i5, int i6) {
            onChanged();
        }

        public final void onItemRangeInserted(int i5, int i6) {
            onChanged();
        }

        public final void onItemRangeMoved(int i5, int i6, int i7) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i5, int i6) {
            onChanged();
        }

        public final void onItemRangeChanged(int i5, int i6, @Nullable Object obj) {
            onChanged();
        }
    }

    @RequiresOptIn(level = RequiresOptIn.Level.WARNING)
    public @interface ExperimentalFragmentStateAdapterApi {
    }

    static class FragmentEventDispatcher {
        private List<FragmentTransactionCallback> mCallbacks = new CopyOnWriteArrayList();

        FragmentEventDispatcher() {
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchMaxLifecyclePreUpdated(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentMaxLifecyclePreUpdated : this.mCallbacks) {
                arrayList.add(onFragmentMaxLifecyclePreUpdated.onFragmentMaxLifecyclePreUpdated(fragment, state));
            }
            return arrayList;
        }

        public void dispatchPostEvents(List<FragmentTransactionCallback.OnPostEventListener> list) {
            for (FragmentTransactionCallback.OnPostEventListener onPost : list) {
                onPost.onPost();
            }
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreAdded : this.mCallbacks) {
                arrayList.add(onFragmentPreAdded.onFragmentPreAdded(fragment));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreRemoved : this.mCallbacks) {
                arrayList.add(onFragmentPreRemoved.onFragmentPreRemoved(fragment));
            }
            return arrayList;
        }

        @OptIn(markerClass = {ExperimentalFragmentStateAdapterApi.class})
        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreSavedInstanceState : this.mCallbacks) {
                arrayList.add(onFragmentPreSavedInstanceState.onFragmentPreSavedInstanceState(fragment));
            }
            return arrayList;
        }

        public void registerCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.add(fragmentTransactionCallback);
        }

        public void unregisterCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.remove(fragmentTransactionCallback);
        }
    }

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        /* access modifiers changed from: package-private */
        public void register(@NonNull RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            AnonymousClass1 r22 = new ViewPager2.OnPageChangeCallback() {
                public void onPageScrollStateChanged(int i5) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                public void onPageSelected(int i5) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = r22;
            this.mViewPager.registerOnPageChangeCallback(r22);
            AnonymousClass2 r23 = new DataSetChangeObserver() {
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = r23;
            FragmentStateAdapter.this.registerAdapterDataObserver(r23);
            AnonymousClass3 r24 = new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = r24;
            FragmentStateAdapter.this.mLifecycle.addObserver(r24);
        }

        /* access modifiers changed from: package-private */
        public void unregister(@NonNull RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        /* access modifiers changed from: package-private */
        public void updateFragmentMaxLifecycle(boolean z4) {
            int currentItem;
            Fragment fragment;
            boolean z5;
            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions() && this.mViewPager.getScrollState() == 0 && !FragmentStateAdapter.this.mFragments.isEmpty() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.mViewPager.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.mPrimaryItemId || z4) && (fragment = FragmentStateAdapter.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                    this.mPrimaryItemId = itemId;
                    FragmentTransaction beginTransaction = FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                    ArrayList arrayList = new ArrayList();
                    int i5 = 0;
                    Fragment fragment2 = null;
                    for (int i6 = 0; i6 < FragmentStateAdapter.this.mFragments.size(); i6++) {
                        long keyAt = FragmentStateAdapter.this.mFragments.keyAt(i6);
                        Fragment valueAt = FragmentStateAdapter.this.mFragments.valueAt(i6);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.mPrimaryItemId) {
                                Lifecycle.State state = Lifecycle.State.STARTED;
                                beginTransaction.setMaxLifecycle(valueAt, state);
                                arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(valueAt, state));
                            } else {
                                fragment2 = valueAt;
                            }
                            if (keyAt == this.mPrimaryItemId) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            valueAt.setMenuVisibility(z5);
                        }
                    }
                    if (fragment2 != null) {
                        Lifecycle.State state2 = Lifecycle.State.RESUMED;
                        beginTransaction.setMaxLifecycle(fragment2, state2);
                        arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(fragment2, state2));
                    }
                    if (!beginTransaction.isEmpty()) {
                        beginTransaction.commitNow();
                        Collections.reverse(arrayList);
                        int size = arrayList.size();
                        while (i5 < size) {
                            Object obj = arrayList.get(i5);
                            i5++;
                            FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchPostEvents((List) obj);
                        }
                    }
                }
            }
        }
    }

    public static abstract class FragmentTransactionCallback {
        @NonNull
        private static final OnPostEventListener NO_OP = new OnPostEventListener() {
            public void onPost() {
            }
        };

        public interface OnPostEventListener {
            void onPost();
        }

        @NonNull
        public OnPostEventListener onFragmentMaxLifecyclePreUpdated(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
            return NO_OP;
        }

        @NonNull
        public OnPostEventListener onFragmentPreAdded(@NonNull Fragment fragment) {
            return NO_OP;
        }

        @NonNull
        public OnPostEventListener onFragmentPreRemoved(@NonNull Fragment fragment) {
            return NO_OP;
        }

        @NonNull
        @ExperimentalFragmentStateAdapterApi
        public OnPostEventListener onFragmentPreSavedInstanceState(@NonNull Fragment fragment) {
            return NO_OP;
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @NonNull
    private static String createKey(@NonNull String str, long j5) {
        return str + j5;
    }

    private void ensureFragment(int i5) {
        long itemId = getItemId(i5);
        if (!this.mFragments.containsKey(itemId)) {
            Fragment createFragment = createFragment(i5);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.mFragments.put(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j5) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j5)) {
            return true;
        }
        Fragment fragment = this.mFragments.get(j5);
        if (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) {
            return false;
        }
        return true;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        if (!str.startsWith(str2) || str.length() <= str2.length()) {
            return false;
        }
        return true;
    }

    private Long itemForViewHolder(int i5) {
        Long l5 = null;
        for (int i6 = 0; i6 < this.mItemIdToViewHolder.size(); i6++) {
            if (this.mItemIdToViewHolder.valueAt(i6).intValue() == i5) {
                if (l5 == null) {
                    l5 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i6));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l5;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j5) {
        ViewParent parent;
        Fragment fragment = this.mFragments.get(j5);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j5)) {
                this.mSavedStates.remove(j5);
            }
            if (!fragment.isAdded()) {
                this.mFragments.remove(j5);
            } else if (shouldDelayFragmentTransactions()) {
                this.mHasStaleFragments = true;
            } else {
                if (fragment.isAdded() && containsItem(j5)) {
                    List<FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState = this.mFragmentEventDispatcher.dispatchPreSavedInstanceState(fragment);
                    Fragment.SavedState saveFragmentInstanceState = this.mFragmentManager.saveFragmentInstanceState(fragment);
                    this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreSavedInstanceState);
                    this.mSavedStates.put(j5, saveFragmentInstanceState);
                }
                List<FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved = this.mFragmentEventDispatcher.dispatchPreRemoved(fragment);
                try {
                    this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
                    this.mFragments.remove(j5);
                } finally {
                    this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreRemoved);
                }
            }
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass3 r12 = new Runnable() {
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.mIsInGracePeriod = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r12);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(r12, 10000);
    }

    private void scheduleViewAttach(final Fragment fragment, @NonNull final FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    public void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean containsItem(long j5) {
        if (j5 < 0 || j5 >= ((long) getItemCount())) {
            return false;
        }
        return true;
    }

    @NonNull
    public abstract Fragment createFragment(int i5);

    /* access modifiers changed from: package-private */
    public void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i5 = 0; i5 < this.mFragments.size(); i5++) {
                long keyAt = this.mFragments.keyAt(i5);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i6 = 0; i6 < this.mFragments.size(); i6++) {
                    long keyAt2 = this.mFragments.keyAt(i6);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long longValue : arraySet) {
                removeFragment(longValue.longValue());
            }
        }
    }

    public long getItemId(int i5) {
        return (long) i5;
    }

    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        boolean z4;
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void placeFragmentInViewHolder(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout container = fragmentViewHolder.getContainer();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                scheduleViewAttach(fragment, container);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    addViewToContainer(view, container);
                } else if (!shouldDelayFragmentTransactions()) {
                    scheduleViewAttach(fragment, container);
                    List<FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded = this.mFragmentEventDispatcher.dispatchPreAdded(fragment);
                    try {
                        fragment.setMenuVisibility(false);
                        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                        beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                    } finally {
                        this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreAdded);
                    }
                } else if (!this.mFragmentManager.isDestroyed()) {
                    this.mLifecycle.addObserver(new LifecycleEventObserver() {
                        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
                                    FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public void registerFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.registerCallback(fragmentTransactionCallback);
    }

    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.mFragments.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (isValidKey(next, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.put(parseIdFromKey(next, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, next));
            } else if (isValidKey(next, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(next, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(next);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
        }
        if (!this.mFragments.isEmpty()) {
            this.mHasStaleFragments = true;
            this.mIsInGracePeriod = true;
            gcFragments();
            scheduleGracePeriodEnd();
        }
    }

    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i5 = 0; i5 < this.mFragments.size(); i5++) {
            long keyAt = this.mFragments.keyAt(i5);
            Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i6 = 0; i6 < this.mSavedStates.size(); i6++) {
            long keyAt2 = this.mSavedStates.keyAt(i6);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    public final void setHasStableIds(boolean z4) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public void unregisterFragmentTransactionCallback(@NonNull FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.unregisterCallback(fragmentTransactionCallback);
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i5) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id));
        ensureFragment(i5);
        if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i5) {
        return FragmentViewHolder.create(viewGroup);
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mFragmentEventDispatcher = new FragmentEventDispatcher();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
