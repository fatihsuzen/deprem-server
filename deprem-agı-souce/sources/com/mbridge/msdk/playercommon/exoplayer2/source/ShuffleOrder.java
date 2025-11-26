package com.mbridge.msdk.playercommon.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int i5) {
            this(i5, new Random());
        }

        private static int[] createShuffledList(int i5, Random random2) {
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i6 + 1;
                int nextInt = random2.nextInt(i7);
                iArr[i6] = iArr[nextInt];
                iArr[nextInt] = i6;
                i6 = i7;
            }
            return iArr;
        }

        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        public ShuffleOrder cloneAndInsert(int i5, int i6) {
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int i7 = 0;
            int i8 = 0;
            while (i8 < i6) {
                iArr[i8] = this.random.nextInt(this.shuffled.length + 1);
                int i9 = i8 + 1;
                int nextInt = this.random.nextInt(i9);
                iArr2[i8] = iArr2[nextInt];
                iArr2[nextInt] = i8 + i5;
                i8 = i9;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[(this.shuffled.length + i6)];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int[] iArr4 = this.shuffled;
                if (i7 >= iArr4.length + i6) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
                }
                if (i10 >= i6 || i11 != iArr[i10]) {
                    int i12 = i11 + 1;
                    int i13 = iArr4[i11];
                    iArr3[i7] = i13;
                    if (i13 >= i5) {
                        iArr3[i7] = i13 + i6;
                    }
                    i11 = i12;
                } else {
                    iArr3[i7] = iArr2[i10];
                    i10++;
                }
                i7++;
            }
        }

        public ShuffleOrder cloneAndRemove(int i5) {
            int i6;
            int[] iArr = new int[(this.shuffled.length - 1)];
            int i7 = 0;
            boolean z4 = false;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i7 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
                int i8 = iArr2[i7];
                if (i8 == i5) {
                    z4 = true;
                } else {
                    if (z4) {
                        i6 = i7 - 1;
                    } else {
                        i6 = i7;
                    }
                    if (i8 > i5) {
                        i8--;
                    }
                    iArr[i6] = i8;
                }
                i7++;
            }
        }

        public int getFirstIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        public int getLastIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        public int getLength() {
            return this.shuffled.length;
        }

        public int getNextIndex(int i5) {
            int i6 = this.indexInShuffled[i5] + 1;
            int[] iArr = this.shuffled;
            if (i6 < iArr.length) {
                return iArr[i6];
            }
            return -1;
        }

        public int getPreviousIndex(int i5) {
            int i6 = this.indexInShuffled[i5] - 1;
            if (i6 >= 0) {
                return this.shuffled[i6];
            }
            return -1;
        }

        public DefaultShuffleOrder(int i5, long j5) {
            this(i5, new Random(j5));
        }

        private DefaultShuffleOrder(int i5, Random random2) {
            this(createShuffledList(i5, random2), random2);
        }

        private DefaultShuffleOrder(int[] iArr, Random random2) {
            this.shuffled = iArr;
            this.random = random2;
            this.indexInShuffled = new int[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                this.indexInShuffled[iArr[i5]] = i5;
            }
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        public UnshuffledShuffleOrder(int i5) {
            this.length = i5;
        }

        public final ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        public final ShuffleOrder cloneAndInsert(int i5, int i6) {
            return new UnshuffledShuffleOrder(this.length + i6);
        }

        public final ShuffleOrder cloneAndRemove(int i5) {
            return new UnshuffledShuffleOrder(this.length - 1);
        }

        public final int getFirstIndex() {
            if (this.length > 0) {
                return 0;
            }
            return -1;
        }

        public final int getLastIndex() {
            int i5 = this.length;
            if (i5 > 0) {
                return i5 - 1;
            }
            return -1;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getNextIndex(int i5) {
            int i6 = i5 + 1;
            if (i6 < this.length) {
                return i6;
            }
            return -1;
        }

        public final int getPreviousIndex(int i5) {
            int i6 = i5 - 1;
            if (i6 >= 0) {
                return i6;
            }
            return -1;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int i5, int i6);

    ShuffleOrder cloneAndRemove(int i5);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i5);

    int getPreviousIndex(int i5);
}
