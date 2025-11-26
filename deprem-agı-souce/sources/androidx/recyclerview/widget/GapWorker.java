package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() {
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z4 = task.neededNextFrame;
            if (z4 != task2.neededNextFrame) {
                return z4 ? -1 : 1;
            }
            int i5 = task2.viewVelocity - task.viewVelocity;
            if (i5 != 0) {
                return i5;
            }
            int i6 = task.distanceToItem - task2.distanceToItem;
            if (i6 != 0) {
                return i6;
            }
            return 0;
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private final ArrayList<Task> mTasks = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
        }

        public void addPosition(int i5, int i6) {
            if (i5 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i6 >= 0) {
                int i7 = this.mCount;
                int i8 = i7 * 2;
                int[] iArr = this.mPrefetchArray;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.mPrefetchArray = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i8 >= iArr.length) {
                    int[] iArr3 = new int[(i7 * 4)];
                    this.mPrefetchArray = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.mPrefetchArray;
                iArr4[i8] = i5;
                iArr4[i8 + 1] = i6;
                this.mCount++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void clearPrefetchPositions() {
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }

        /* access modifiers changed from: package-private */
        public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z4) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z4) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                int i5 = this.mCount;
                if (i5 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i5;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z4;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean lastPrefetchIncludedPosition(int i5) {
            if (this.mPrefetchArray != null) {
                int i6 = this.mCount * 2;
                for (int i7 = 0; i7 < i6; i7 += 2) {
                    if (this.mPrefetchArray[i7] == i5) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setPrefetchVector(int i5, int i6) {
            this.mPrefetchDx = i5;
            this.mPrefetchDy = i6;
        }
    }

    static class Task {
        public int distanceToItem;
        public boolean neededNextFrame;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.neededNextFrame = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    GapWorker() {
    }

    private void buildTaskList() {
        Task task;
        boolean z4;
        int size = this.mRecyclerViews.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i6);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i5 += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i5);
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i8);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                for (int i9 = 0; i9 < layoutPrefetchRegistryImpl.mCount * 2; i9 += 2) {
                    if (i7 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i7);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int i10 = iArr[i9 + 1];
                    if (i10 <= abs) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    task.neededNextFrame = z4;
                    task.viewVelocity = abs;
                    task.distanceToItem = i10;
                    task.view = recyclerView2;
                    task.position = iArr[i9];
                    i7++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    private void flushTaskWithDeadline(Task task, long j5) {
        long j6;
        if (task.neededNextFrame) {
            j6 = Long.MAX_VALUE;
        } else {
            j6 = j5;
        }
        RecyclerView.ViewHolder prefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, j6);
        if (prefetchPositionWithDeadline != null && prefetchPositionWithDeadline.mNestedRecyclerView != null && prefetchPositionWithDeadline.isBound() && !prefetchPositionWithDeadline.isInvalid()) {
            prefetchInnerRecyclerViewWithDeadline(prefetchPositionWithDeadline.mNestedRecyclerView.get(), j5);
        }
    }

    private void flushTasksWithDeadline(long j5) {
        int i5 = 0;
        while (i5 < this.mTasks.size()) {
            Task task = this.mTasks.get(i5);
            if (task.view != null) {
                flushTaskWithDeadline(task, j5);
                task.clear();
                i5++;
            } else {
                return;
            }
        }
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i5) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i6));
            if (childViewHolderInt.mPosition == i5 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j5) {
        String str;
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
            if (layoutPrefetchRegistryImpl.mCount != 0) {
                if (j5 == Long.MAX_VALUE) {
                    str = "RV Nested Prefetch";
                } else {
                    str = "RV Nested Prefetch forced - needed next frame";
                }
                try {
                    Trace.beginSection(str);
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.mCount * 2; i5 += 2) {
                        prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i5], j5);
                    }
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i5, long j5) {
        if (isPrefetchPositionAttached(recyclerView, i5)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        if (j5 == Long.MAX_VALUE) {
            try {
                if (TraceCompat.isEnabled()) {
                    Trace.beginSection("RV Prefetch forced - needed next frame");
                }
            } catch (Throwable th) {
                recyclerView.onExitLayoutOrScroll(false);
                Trace.endSection();
                throw th;
            }
        }
        recyclerView.onEnterLayoutOrScroll();
        RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i5, false, j5);
        if (tryGetViewHolderForPositionByDeadline != null) {
            if (!tryGetViewHolderForPositionByDeadline.isBound() || tryGetViewHolderForPositionByDeadline.isInvalid()) {
                recycler.addViewHolderToRecycledViewPool(tryGetViewHolderForPositionByDeadline, false);
            } else {
                recycler.recycleView(tryGetViewHolderForPositionByDeadline.itemView);
            }
        }
        recyclerView.onExitLayoutOrScroll(false);
        Trace.endSection();
        return tryGetViewHolderForPositionByDeadline;
    }

    public void add(RecyclerView recyclerView) {
        if (!RecyclerView.sDebugAssertionsEnabled || !this.mRecyclerViews.contains(recyclerView)) {
            this.mRecyclerViews.add(recyclerView);
            return;
        }
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    /* access modifiers changed from: package-private */
    public void postFromTraversal(RecyclerView recyclerView, int i5, int i6) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.mRecyclerViews.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            } else if (this.mPostTimeNs == 0) {
                this.mPostTimeNs = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i5, i6);
    }

    /* access modifiers changed from: package-private */
    public void prefetch(long j5) {
        buildTaskList();
        flushTasksWithDeadline(j5);
    }

    public void remove(RecyclerView recyclerView) {
        boolean remove = this.mRecyclerViews.remove(recyclerView);
        if (RecyclerView.sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    public void run() {
        try {
            Trace.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j5 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i5);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j5 = Math.max(recyclerView.getDrawingTime(), j5);
                    }
                }
                if (j5 != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(j5) + this.mFrameIntervalNs);
                }
            }
        } finally {
            this.mPostTimeNs = 0;
            Trace.endSection();
        }
    }
}
