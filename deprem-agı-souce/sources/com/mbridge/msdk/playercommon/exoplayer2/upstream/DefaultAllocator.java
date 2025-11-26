package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z4, int i5) {
        this(z4, i5, 0);
    }

    public final synchronized Allocation allocate() {
        Allocation allocation;
        try {
            this.allocatedCount++;
            int i5 = this.availableCount;
            if (i5 > 0) {
                Allocation[] allocationArr = this.availableAllocations;
                int i6 = i5 - 1;
                this.availableCount = i6;
                allocation = allocationArr[i6];
                allocationArr[i6] = null;
            } else {
                allocation = new Allocation(new byte[this.individualAllocationSize], 0);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return allocation;
    }

    public final int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    public final synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    public final synchronized void release(Allocation allocation) {
        Allocation[] allocationArr = this.singleAllocationReleaseHolder;
        allocationArr[0] = allocation;
        release(allocationArr);
    }

    public final synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public final synchronized void setTargetBufferSize(int i5) {
        boolean z4;
        if (i5 < this.targetBufferSize) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.targetBufferSize = i5;
        if (z4) {
            trim();
        }
    }

    public final synchronized void trim() {
        try {
            int i5 = 0;
            int max = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
            int i6 = this.availableCount;
            if (max < i6) {
                if (this.initialAllocationBlock != null) {
                    int i7 = i6 - 1;
                    while (i5 <= i7) {
                        Allocation[] allocationArr = this.availableAllocations;
                        Allocation allocation = allocationArr[i5];
                        byte[] bArr = allocation.data;
                        byte[] bArr2 = this.initialAllocationBlock;
                        if (bArr == bArr2) {
                            i5++;
                        } else {
                            Allocation allocation2 = allocationArr[i7];
                            if (allocation2.data != bArr2) {
                                i7--;
                            } else {
                                allocationArr[i5] = allocation2;
                                allocationArr[i7] = allocation;
                                i7--;
                                i5++;
                            }
                        }
                    }
                    max = Math.max(max, i5);
                    if (max >= this.availableCount) {
                        return;
                    }
                }
                Arrays.fill(this.availableAllocations, max, this.availableCount, (Object) null);
                this.availableCount = max;
            }
        } finally {
            while (true) {
            }
        }
    }

    public DefaultAllocator(boolean z4, int i5, int i6) {
        Assertions.checkArgument(i5 > 0);
        Assertions.checkArgument(i6 >= 0);
        this.trimOnReset = z4;
        this.individualAllocationSize = i5;
        this.availableCount = i6;
        this.availableAllocations = new Allocation[(i6 + 100)];
        if (i6 > 0) {
            this.initialAllocationBlock = new byte[(i6 * i5)];
            for (int i7 = 0; i7 < i6; i7++) {
                this.availableAllocations[i7] = new Allocation(this.initialAllocationBlock, i7 * i5);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    public final synchronized void release(Allocation[] allocationArr) {
        try {
            int i5 = this.availableCount;
            int length = allocationArr.length + i5;
            Allocation[] allocationArr2 = this.availableAllocations;
            if (length >= allocationArr2.length) {
                this.availableAllocations = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i5 + allocationArr.length));
            }
            for (Allocation allocation : allocationArr) {
                byte[] bArr = allocation.data;
                if (bArr != this.initialAllocationBlock) {
                    if (bArr.length != this.individualAllocationSize) {
                        throw new IllegalArgumentException("Unexpected allocation: " + System.identityHashCode(allocation.data) + ", " + System.identityHashCode(this.initialAllocationBlock) + ", " + allocation.data.length + ", " + this.individualAllocationSize);
                    }
                }
                Allocation[] allocationArr3 = this.availableAllocations;
                int i6 = this.availableCount;
                this.availableCount = i6 + 1;
                allocationArr3[i6] = allocation;
            }
            this.allocatedCount -= allocationArr.length;
            notifyAll();
        } finally {
            while (true) {
            }
        }
    }
}
