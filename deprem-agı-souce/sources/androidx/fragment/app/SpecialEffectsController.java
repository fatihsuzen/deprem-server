package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed = false;
    boolean mOperationDirectionIsPop = false;
    final ArrayList<Operation> mPendingOperations = new ArrayList<>();
    final ArrayList<Operation> mRunningOperations = new ArrayList<>();

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.AnonymousClass3.<clinit>():void");
        }
    }

    private static class FragmentStateManagerOperation extends Operation {
        @NonNull
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager, @NonNull CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
            this.mFragmentStateManager = fragmentStateManager;
        }

        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        /* access modifiers changed from: package-private */
        public void onStart() {
            if (getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                Fragment fragment = this.mFragmentStateManager.getFragment();
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                View requireView = getFragment().requireView();
                if (requireView.getParent() == null) {
                    this.mFragmentStateManager.addViewToContainer();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            } else if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                Fragment fragment2 = this.mFragmentStateManager.getFragment();
                View requireView2 = fragment2.requireView();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + fragment2);
                }
                requireView2.clearFocus();
            }
        }
    }

    SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
                if (findPendingOperation != null) {
                    findPendingOperation.mergeWith(state, lifecycleImpact);
                    return;
                }
                final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
                this.mPendingOperations.add(fragmentStateManagerOperation);
                fragmentStateManagerOperation.addCompletionListener(new Runnable() {
                    public void run() {
                        if (SpecialEffectsController.this.mPendingOperations.contains(fragmentStateManagerOperation)) {
                            fragmentStateManagerOperation.getFinalState().applyState(fragmentStateManagerOperation.getFragment().mView);
                        }
                    }
                });
                fragmentStateManagerOperation.addCompletionListener(new Runnable() {
                    public void run() {
                        SpecialEffectsController.this.mPendingOperations.remove(fragmentStateManagerOperation);
                        SpecialEffectsController.this.mRunningOperations.remove(fragmentStateManagerOperation);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private Operation findPendingOperation(@NonNull Fragment fragment) {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Operation operation = arrayList.get(i5);
            i5++;
            Operation operation2 = operation;
            if (operation2.getFragment().equals(fragment) && !operation2.isCanceled()) {
                return operation2;
            }
        }
        return null;
    }

    @Nullable
    private Operation findRunningOperation(@NonNull Fragment fragment) {
        ArrayList<Operation> arrayList = this.mRunningOperations;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Operation operation = arrayList.get(i5);
            i5++;
            Operation operation2 = operation;
            if (operation2.getFragment().equals(fragment) && !operation2.isCanceled()) {
                return operation2;
            }
        }
        return null;
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    private void updateFinalState() {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Operation operation = arrayList.get(i5);
            i5++;
            Operation operation2 = operation;
            if (operation2.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                operation2.mergeWith(Operation.State.from(operation2.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueueAdd(@NonNull Operation.State state, @NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void enqueueHide(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void enqueueRemove(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public void enqueueShow(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* access modifiers changed from: package-private */
    public abstract void executeOperations(@NonNull List<Operation> list, boolean z4);

    /* access modifiers changed from: package-private */
    public void executePendingOperations() {
        if (!this.mIsContainerPostponed) {
            if (!ViewCompat.isAttachedToWindow(this.mContainer)) {
                forceCompleteAllOperations();
                this.mOperationDirectionIsPop = false;
                return;
            }
            synchronized (this.mPendingOperations) {
                try {
                    if (!this.mPendingOperations.isEmpty()) {
                        ArrayList arrayList = new ArrayList(this.mRunningOperations);
                        this.mRunningOperations.clear();
                        int size = arrayList.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Object obj = arrayList.get(i5);
                            i5++;
                            Operation operation = (Operation) obj;
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + operation);
                            }
                            operation.cancel();
                            if (!operation.isComplete()) {
                                this.mRunningOperations.add(operation);
                            }
                        }
                        updateFinalState();
                        ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                        this.mPendingOperations.clear();
                        this.mRunningOperations.addAll(arrayList2);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");
                        }
                        int size2 = arrayList2.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            Object obj2 = arrayList2.get(i6);
                            i6++;
                            ((Operation) obj2).onStart();
                        }
                        executeOperations(arrayList2, this.mOperationDirectionIsPop);
                        this.mOperationDirectionIsPop = false;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void forceCompleteAllOperations() {
        String str;
        String str2;
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.mContainer);
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                ArrayList<Operation> arrayList = this.mPendingOperations;
                int size = arrayList.size();
                int i5 = 0;
                int i6 = 0;
                while (i6 < size) {
                    Operation operation = arrayList.get(i6);
                    i6++;
                    operation.onStart();
                }
                ArrayList arrayList2 = new ArrayList(this.mRunningOperations);
                int size2 = arrayList2.size();
                int i7 = 0;
                while (i7 < size2) {
                    Object obj = arrayList2.get(i7);
                    i7++;
                    Operation operation2 = (Operation) obj;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.mContainer + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(operation2);
                        Log.v(FragmentManager.TAG, sb.toString());
                    }
                    operation2.cancel();
                }
                ArrayList arrayList3 = new ArrayList(this.mPendingOperations);
                int size3 = arrayList3.size();
                while (i5 < size3) {
                    Object obj2 = arrayList3.get(i5);
                    i5++;
                    Operation operation3 = (Operation) obj2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.mContainer + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(operation3);
                        Log.v(FragmentManager.TAG, sb2.toString());
                    }
                    operation3.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
            }
            this.mIsContainerPostponed = false;
            executePendingOperations();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager fragmentStateManager) {
        Operation.LifecycleImpact lifecycleImpact;
        Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
        if (findPendingOperation != null) {
            lifecycleImpact = findPendingOperation.getLifecycleImpact();
        } else {
            lifecycleImpact = null;
        }
        Operation findRunningOperation = findRunningOperation(fragmentStateManager.getFragment());
        if (findRunningOperation == null || (lifecycleImpact != null && lifecycleImpact != Operation.LifecycleImpact.NONE)) {
            return lifecycleImpact;
        }
        return findRunningOperation.getLifecycleImpact();
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: package-private */
    public void markPostponedState() {
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                this.mIsContainerPostponed = false;
                int size = this.mPendingOperations.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = this.mPendingOperations.get(size);
                    Operation.State from = Operation.State.from(operation.getFragment().mView);
                    Operation.State finalState = operation.getFinalState();
                    Operation.State state = Operation.State.VISIBLE;
                    if (finalState == state && from != state) {
                        this.mIsContainerPostponed = operation.getFragment().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateOperationDirection(boolean z4) {
        this.mOperationDirectionIsPop = z4;
    }

    static class Operation {
        @NonNull
        private final List<Runnable> mCompletionListeners = new ArrayList();
        @NonNull
        private State mFinalState;
        @NonNull
        private final Fragment mFragment;
        private boolean mIsCanceled = false;
        private boolean mIsComplete = false;
        @NonNull
        private LifecycleImpact mLifecycleImpact;
        @NonNull
        private final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet<>();

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            this.mFinalState = state;
            this.mLifecycleImpact = lifecycleImpact;
            this.mFragment = fragment;
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                public void onCancel() {
                    Operation.this.cancel();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void addCompletionListener(@NonNull Runnable runnable) {
            this.mCompletionListeners.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            if (!isCanceled()) {
                this.mIsCanceled = true;
                if (this.mSpecialEffectsSignals.isEmpty()) {
                    complete();
                    return;
                }
                ArrayList arrayList = new ArrayList(this.mSpecialEffectsSignals);
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((CancellationSignal) obj).cancel();
                }
            }
        }

        @CallSuper
        public void complete() {
            if (!this.mIsComplete) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
                }
                this.mIsComplete = true;
                for (Runnable run : this.mCompletionListeners) {
                    run.run();
                }
            }
        }

        public final void completeSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            if (this.mSpecialEffectsSignals.remove(cancellationSignal) && this.mSpecialEffectsSignals.isEmpty()) {
                complete();
            }
        }

        @NonNull
        public State getFinalState() {
            return this.mFinalState;
        }

        @NonNull
        public final Fragment getFragment() {
            return this.mFragment;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        /* access modifiers changed from: package-private */
        public final boolean isCanceled() {
            return this.mIsCanceled;
        }

        /* access modifiers changed from: package-private */
        public final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            onStart();
            this.mSpecialEffectsSignals.add(cancellationSignal);
        }

        /* access modifiers changed from: package-private */
        public final void mergeWith(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            int i5 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[lifecycleImpact.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> REMOVED. mLifecycleImpact  = " + this.mLifecycleImpact + " to REMOVING.");
                    }
                    this.mFinalState = State.REMOVED;
                    this.mLifecycleImpact = LifecycleImpact.REMOVING;
                } else if (i5 == 3 && this.mFinalState != State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> " + state + ". ");
                    }
                    this.mFinalState = state;
                }
            } else if (this.mFinalState == State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.mLifecycleImpact + " to ADDING.");
                }
                this.mFinalState = State.VISIBLE;
                this.mLifecycleImpact = LifecycleImpact.ADDING;
            }
        }

        /* access modifiers changed from: package-private */
        public void onStart() {
        }

        @NonNull
        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.mFinalState + "} " + "{" + "mLifecycleImpact = " + this.mLifecycleImpact + "} " + "{" + "mFragment = " + this.mFragment + "}";
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            static State from(@NonNull View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return from(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void applyState(@NonNull View view) {
                int i5 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (i5 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i5 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i5 == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i5 == 4) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }

            @NonNull
            static State from(int i5) {
                if (i5 == 0) {
                    return VISIBLE;
                }
                if (i5 == 4) {
                    return INVISIBLE;
                }
                if (i5 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i5);
            }
        }
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i5 = R.id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i5);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(i5, createController);
        return createController;
    }
}
