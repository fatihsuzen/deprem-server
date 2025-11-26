package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            public long localToGlobal(long j5) {
                Long l5 = this.mLocalToGlobalLookup.get(j5);
                if (l5 == null) {
                    l5 = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j5, l5);
                }
                return l5.longValue();
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        /* access modifiers changed from: package-private */
        public long obtainId() {
            long j5 = this.mNextStableId;
            this.mNextStableId = 1 + j5;
            return j5;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() {
            public long localToGlobal(long j5) {
                return -1;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() {
            public long localToGlobal(long j5) {
                return j5;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j5);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
