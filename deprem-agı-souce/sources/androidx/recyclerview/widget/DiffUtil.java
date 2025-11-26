package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() {
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f417x - diagonal2.f417x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i5, int i6);

        public abstract boolean areItemsTheSame(int i5, int i6);

        @Nullable
        public Object getChangePayload(int i5, int i6) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int i5) {
            int[] iArr = new int[i5];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i5) {
            Arrays.fill(this.mData, i5);
        }

        /* access modifiers changed from: package-private */
        public int get(int i5) {
            return this.mData[i5 + this.mMid];
        }

        /* access modifiers changed from: package-private */
        public void set(int i5, int i6) {
            this.mData[i5 + this.mMid] = i6;
        }
    }

    static class Diagonal {
        public final int size;

        /* renamed from: x  reason: collision with root package name */
        public final int f417x;

        /* renamed from: y  reason: collision with root package name */
        public final int f418y;

        Diagonal(int i5, int i6, int i7) {
            this.f417x = i5;
            this.f418y = i6;
            this.size = i7;
        }

        /* access modifiers changed from: package-private */
        public int endX() {
            return this.f417x + this.size;
        }

        /* access modifiers changed from: package-private */
        public int endY() {
            return this.f418y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z4) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z4;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal;
            if (this.mDiagonals.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.mDiagonals.get(0);
            }
            if (!(diagonal != null && diagonal.f417x == 0 && diagonal.f418y == 0)) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i5) {
            int i6;
            int size = this.mDiagonals.size();
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                Diagonal diagonal = this.mDiagonals.get(i8);
                while (i7 < diagonal.f418y) {
                    if (this.mNewItemStatuses[i7] != 0 || !this.mCallback.areItemsTheSame(i5, i7)) {
                        i7++;
                    } else {
                        if (this.mCallback.areContentsTheSame(i5, i7)) {
                            i6 = 8;
                        } else {
                            i6 = 4;
                        }
                        this.mOldItemStatuses[i5] = (i7 << 4) | i6;
                        this.mNewItemStatuses[i7] = (i5 << 4) | i6;
                        return;
                    }
                }
                i7 = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            int i5;
            for (Diagonal next : this.mDiagonals) {
                for (int i6 = 0; i6 < next.size; i6++) {
                    int i7 = next.f417x + i6;
                    int i8 = next.f418y + i6;
                    if (this.mCallback.areContentsTheSame(i7, i8)) {
                        i5 = 1;
                    } else {
                        i5 = 2;
                    }
                    this.mOldItemStatuses[i7] = (i8 << 4) | i5;
                    this.mNewItemStatuses[i8] = (i7 << 4) | i5;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int i5 = 0;
            for (Diagonal next : this.mDiagonals) {
                while (i5 < next.f417x) {
                    if (this.mOldItemStatuses[i5] == 0) {
                        findMatchingAddition(i5);
                    }
                    i5++;
                }
                i5 = next.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i5, boolean z4) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it.next();
                if (postponedUpdate.posInOwnerList == i5 && postponedUpdate.removal == z4) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z4) {
                    next.currentPos--;
                } else {
                    next.currentPos++;
                }
            }
            return postponedUpdate;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i5) {
            if (i5 < 0 || i5 >= this.mNewListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i5 + ", new list size = " + this.mNewListSize);
            }
            int i6 = this.mNewItemStatuses[i5];
            if ((i6 & 15) == 0) {
                return -1;
            }
            return i6 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i5) {
            if (i5 < 0 || i5 >= this.mOldListSize) {
                throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i5 + ", old list size = " + this.mOldListSize);
            }
            int i6 = this.mOldItemStatuses[i5];
            if ((i6 & 15) == 0) {
                return -1;
            }
            return i6 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i5;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i6 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i7 = this.mOldListSize;
            int i8 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int endX = diagonal.endX();
                int endY = diagonal.endY();
                while (true) {
                    if (i7 <= endX) {
                        break;
                    }
                    i7--;
                    int i9 = this.mOldItemStatuses[i7];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i10, false);
                        if (postponedUpdate != null) {
                            int i11 = (i6 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i7, i11);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i11, 1, this.mCallback.getChangePayload(i7, i10));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i7, (i6 - i7) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i7, 1);
                        i6--;
                    }
                }
                while (i8 > endY) {
                    i8--;
                    int i12 = this.mNewItemStatuses[i8];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i13, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i8, i6 - i7, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i6 - postponedUpdate2.currentPos) - 1, i7);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i7, 1, this.mCallback.getChangePayload(i13, i8));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i7, 1);
                        i6++;
                    }
                }
                int i14 = diagonal.f417x;
                int i15 = diagonal.f418y;
                for (i5 = 0; i5 < diagonal.size; i5++) {
                    if ((this.mOldItemStatuses[i14] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i14, 1, this.mCallback.getChangePayload(i14, i15));
                    }
                    i14++;
                    i15++;
                }
                i7 = diagonal.f417x;
                i8 = diagonal.f418y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t5, @NonNull T t6);

        public abstract boolean areItemsTheSame(@NonNull T t5, @NonNull T t6);

        @Nullable
        public Object getChangePayload(@NonNull T t5, @NonNull T t6) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i5, int i6, boolean z4) {
            this.posInOwnerList = i5;
            this.currentPos = i6;
            this.removal = z4;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        /* access modifiers changed from: package-private */
        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        /* access modifiers changed from: package-private */
        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i5, int i6, int i7, int i8) {
            this.oldListStart = i5;
            this.oldListEnd = i6;
            this.newListStart = i7;
            this.newListEnd = i8;
        }
    }

    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        /* access modifiers changed from: package-private */
        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        /* access modifiers changed from: package-private */
        public boolean hasAdditionOrRemoval() {
            if (this.endY - this.startY != this.endX - this.startX) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isAddition() {
            if (this.endY - this.startY > this.endX - this.startX) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i5 = this.startX;
                return new Diagonal(i5, this.startY, this.endX - i5);
            } else if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            } else {
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i5) {
        boolean z4;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((range.oldSize() - range.newSize()) % 2 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i10 = -i5;
        int i11 = i10;
        while (i11 <= i5) {
            if (i11 == i10 || (i11 != i5 && centeredArray2.get(i11 + 1) < centeredArray2.get(i11 - 1))) {
                i7 = centeredArray2.get(i11 + 1);
                i6 = i7;
            } else {
                i7 = centeredArray2.get(i11 - 1);
                i6 = i7 - 1;
            }
            int i12 = range.newListEnd - ((range.oldListEnd - i6) - i11);
            if (i5 == 0 || i6 != i7) {
                i8 = i12;
            } else {
                i8 = i12 + 1;
            }
            while (i6 > range.oldListStart && i12 > range.newListStart && callback.areItemsTheSame(i6 - 1, i12 - 1)) {
                i6--;
                i12--;
            }
            centeredArray2.set(i11, i6);
            if (!z4 || (i9 = oldSize - i11) < i10 || i9 > i5 || centeredArray.get(i9) < i6) {
                i11 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i12;
                snake.endX = i7;
                snake.endY = i8;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z4 = true;
        if (Math.abs(range.oldSize() - range.newSize()) % 2 != 1) {
            z4 = false;
        }
        int oldSize = range.oldSize() - range.newSize();
        int i10 = -i5;
        int i11 = i10;
        while (i11 <= i5) {
            if (i11 == i10 || (i11 != i5 && centeredArray.get(i11 + 1) > centeredArray.get(i11 - 1))) {
                i7 = centeredArray.get(i11 + 1);
                i6 = i7;
            } else {
                i7 = centeredArray.get(i11 - 1);
                i6 = i7 + 1;
            }
            int i12 = (range.newListStart + (i6 - range.oldListStart)) - i11;
            if (i5 == 0 || i6 != i7) {
                i8 = i12;
            } else {
                i8 = i12 - 1;
            }
            while (i6 < range.oldListEnd && i12 < range.newListEnd && callback.areItemsTheSame(i6, i12)) {
                i6++;
                i12++;
            }
            centeredArray.set(i11, i6);
            if (!z4 || (i9 = oldSize - i11) < i10 + 1 || i9 > i5 - 1 || centeredArray2.get(i9) > i6) {
                i11 += 2;
            } else {
                Snake snake = new Snake();
                snake.startX = i7;
                snake.startY = i8;
                snake.endX = i6;
                snake.endY = i12;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i5 = 0; i5 < oldSize; i5++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i5);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i5);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z4) {
        Range range;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i5 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i5);
        CenteredArray centeredArray2 = new CenteredArray(i5);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range2, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.oldListStart = range2.oldListStart;
                range.newListStart = range2.newListStart;
                range.oldListEnd = midPoint.startX;
                range.newListEnd = midPoint.startY;
                arrayList2.add(range);
                range2.oldListEnd = range2.oldListEnd;
                range2.newListEnd = range2.newListEnd;
                range2.oldListStart = midPoint.endX;
                range2.newListStart = midPoint.endY;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z4);
    }
}
