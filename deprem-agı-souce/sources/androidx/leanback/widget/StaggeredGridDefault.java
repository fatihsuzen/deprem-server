package androidx.leanback.widget;

import androidx.leanback.widget.StaggeredGrid;

final class StaggeredGridDefault extends StaggeredGrid {
    StaggeredGridDefault() {
    }

    private int findRowEdgeLimitSearchIndex(boolean z4) {
        boolean z5 = false;
        if (z4) {
            for (int i5 = this.mLastVisibleIndex; i5 >= this.mFirstVisibleIndex; i5--) {
                int i6 = getLocation(i5).mRow;
                if (i6 == 0) {
                    z5 = true;
                } else if (z5 && i6 == this.mNumRows - 1) {
                    return i5;
                }
            }
            return -1;
        }
        for (int i7 = this.mFirstVisibleIndex; i7 <= this.mLastVisibleIndex; i7++) {
            int i8 = getLocation(i7).mRow;
            if (i8 == this.mNumRows - 1) {
                z5 = true;
            } else if (z5 && i8 == 0) {
                return i7;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0107 A[LOOP:2: B:82:0x0107->B:96:0x012b, LOOP_START, PHI: r6 r9 r10 
      PHI: (r6v9 int) = (r6v3 int), (r6v12 int) binds: [B:81:0x0105, B:96:0x012b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v7 int) = (r9v5 int), (r9v8 int) binds: [B:81:0x0105, B:96:0x012b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v4 int) = (r10v2 int), (r10v6 int) binds: [B:81:0x0105, B:96:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean appendVisibleItemsWithoutCache(int r14, boolean r15) {
        /*
            r13 = this;
            androidx.leanback.widget.Grid$Provider r0 = r13.mProvider
            int r0 = r0.getCount()
            int r1 = r13.mLastVisibleIndex
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 < 0) goto L_0x0077
            int r6 = r13.getLastIndex()
            if (r1 >= r6) goto L_0x0016
            return r4
        L_0x0016:
            int r1 = r13.mLastVisibleIndex
            int r6 = r1 + 1
            androidx.leanback.widget.StaggeredGrid$Location r1 = r13.getLocation((int) r1)
            int r1 = r1.mRow
            int r7 = r13.findRowEdgeLimitSearchIndex(r5)
            if (r7 >= 0) goto L_0x003f
            r8 = r2
            r7 = r4
        L_0x0028:
            int r9 = r13.mNumRows
            if (r7 >= r9) goto L_0x004e
            boolean r8 = r13.mReversedFlow
            if (r8 == 0) goto L_0x0035
            int r8 = r13.getRowMin(r7)
            goto L_0x0039
        L_0x0035:
            int r8 = r13.getRowMax(r7)
        L_0x0039:
            if (r8 == r2) goto L_0x003c
            goto L_0x004e
        L_0x003c:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x003f:
            boolean r8 = r13.mReversedFlow
            if (r8 == 0) goto L_0x0049
            int r7 = r13.findRowMin(r4, r7, r3)
        L_0x0047:
            r8 = r7
            goto L_0x004e
        L_0x0049:
            int r7 = r13.findRowMax(r5, r7, r3)
            goto L_0x0047
        L_0x004e:
            boolean r7 = r13.mReversedFlow
            if (r7 == 0) goto L_0x0059
            int r7 = r13.getRowMin(r1)
            if (r7 > r8) goto L_0x0075
            goto L_0x005f
        L_0x0059:
            int r7 = r13.getRowMax(r1)
            if (r7 < r8) goto L_0x0075
        L_0x005f:
            int r1 = r1 + 1
            int r7 = r13.mNumRows
            if (r1 != r7) goto L_0x0075
            boolean r1 = r13.mReversedFlow
            if (r1 == 0) goto L_0x006f
            int r1 = r13.findRowMin(r4, r3)
        L_0x006d:
            r8 = r1
            goto L_0x0074
        L_0x006f:
            int r1 = r13.findRowMax(r5, r3)
            goto L_0x006d
        L_0x0074:
            r1 = r4
        L_0x0075:
            r7 = r5
            goto L_0x0099
        L_0x0077:
            int r1 = r13.mStartIndex
            r6 = -1
            if (r1 == r6) goto L_0x007e
            r6 = r1
            goto L_0x007f
        L_0x007e:
            r6 = r4
        L_0x007f:
            androidx.collection.CircularArray<androidx.leanback.widget.StaggeredGrid$Location> r1 = r13.mLocations
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0093
            int r1 = r13.getLastIndex()
            androidx.leanback.widget.StaggeredGrid$Location r1 = r13.getLocation((int) r1)
            int r1 = r1.mRow
            int r1 = r1 + r5
            goto L_0x0094
        L_0x0093:
            r1 = r6
        L_0x0094:
            int r7 = r13.mNumRows
            int r1 = r1 % r7
            r7 = r4
            r8 = r7
        L_0x0099:
            r9 = r4
        L_0x009a:
            int r10 = r13.mNumRows
            if (r1 >= r10) goto L_0x014e
            if (r6 == r0) goto L_0x0150
            if (r15 != 0) goto L_0x00aa
            boolean r10 = r13.checkAppendOverLimit(r14)
            if (r10 == 0) goto L_0x00aa
            goto L_0x0150
        L_0x00aa:
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00b3
            int r9 = r13.getRowMin(r1)
            goto L_0x00b7
        L_0x00b3:
            int r9 = r13.getRowMax(r1)
        L_0x00b7:
            r10 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r10) goto L_0x00cb
            if (r9 != r2) goto L_0x00bf
            goto L_0x00cb
        L_0x00bf:
            boolean r10 = r13.mReversedFlow
            if (r10 == 0) goto L_0x00c7
            int r10 = r13.mSpacing
        L_0x00c5:
            int r10 = -r10
            goto L_0x00c9
        L_0x00c7:
            int r10 = r13.mSpacing
        L_0x00c9:
            int r9 = r9 + r10
            goto L_0x00ff
        L_0x00cb:
            if (r1 != 0) goto L_0x00ee
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00d9
            int r9 = r13.mNumRows
            int r9 = r9 - r5
            int r9 = r13.getRowMin(r9)
            goto L_0x00e0
        L_0x00d9:
            int r9 = r13.mNumRows
            int r9 = r9 - r5
            int r9 = r13.getRowMax(r9)
        L_0x00e0:
            if (r9 == r10) goto L_0x00ff
            if (r9 == r2) goto L_0x00ff
            boolean r10 = r13.mReversedFlow
            if (r10 == 0) goto L_0x00eb
            int r10 = r13.mSpacing
            goto L_0x00c5
        L_0x00eb:
            int r10 = r13.mSpacing
            goto L_0x00c9
        L_0x00ee:
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00f9
            int r9 = r1 + -1
            int r9 = r13.getRowMax(r9)
            goto L_0x00ff
        L_0x00f9:
            int r9 = r1 + -1
            int r9 = r13.getRowMin(r9)
        L_0x00ff:
            int r10 = r6 + 1
            int r6 = r13.appendVisibleItemToRow(r6, r1, r9)
            if (r7 == 0) goto L_0x0139
        L_0x0107:
            boolean r11 = r13.mReversedFlow
            if (r11 == 0) goto L_0x0110
            int r11 = r9 - r6
            if (r11 <= r8) goto L_0x0137
            goto L_0x0114
        L_0x0110:
            int r11 = r9 + r6
            if (r11 >= r8) goto L_0x0137
        L_0x0114:
            if (r10 == r0) goto L_0x0136
            if (r15 != 0) goto L_0x011f
            boolean r11 = r13.checkAppendOverLimit(r14)
            if (r11 == 0) goto L_0x011f
            goto L_0x0136
        L_0x011f:
            boolean r11 = r13.mReversedFlow
            if (r11 == 0) goto L_0x0128
            int r6 = -r6
            int r11 = r13.mSpacing
            int r6 = r6 - r11
            goto L_0x012b
        L_0x0128:
            int r11 = r13.mSpacing
            int r6 = r6 + r11
        L_0x012b:
            int r9 = r9 + r6
            int r6 = r10 + 1
            int r10 = r13.appendVisibleItemToRow(r10, r1, r9)
            r12 = r10
            r10 = r6
            r6 = r12
            goto L_0x0107
        L_0x0136:
            return r5
        L_0x0137:
            r6 = r10
            goto L_0x0149
        L_0x0139:
            boolean r6 = r13.mReversedFlow
            if (r6 == 0) goto L_0x0142
            int r6 = r13.getRowMin(r1)
            goto L_0x0146
        L_0x0142:
            int r6 = r13.getRowMax(r1)
        L_0x0146:
            r7 = r5
            r8 = r6
            goto L_0x0137
        L_0x0149:
            int r1 = r1 + 1
            r9 = r5
            goto L_0x009a
        L_0x014e:
            if (r15 == 0) goto L_0x0151
        L_0x0150:
            return r9
        L_0x0151:
            boolean r1 = r13.mReversedFlow
            if (r1 == 0) goto L_0x015b
            int r1 = r13.findRowMin(r4, r3)
        L_0x0159:
            r8 = r1
            goto L_0x0160
        L_0x015b:
            int r1 = r13.findRowMax(r5, r3)
            goto L_0x0159
        L_0x0160:
            r1 = r4
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.appendVisibleItemsWithoutCache(int, boolean):boolean");
    }

    public int findRowMax(boolean z4, int i5, int[] iArr) {
        int i6;
        int edge = this.mProvider.getEdge(i5);
        StaggeredGrid.Location location = getLocation(i5);
        int i7 = location.mRow;
        if (this.mReversedFlow) {
            i6 = i7;
            int i8 = i6;
            int i9 = 1;
            int i10 = i5 + 1;
            int i11 = edge;
            while (i9 < this.mNumRows && i10 <= this.mLastVisibleIndex) {
                StaggeredGrid.Location location2 = getLocation(i10);
                i11 += location2.mOffset;
                int i12 = location2.mRow;
                if (i12 != i8) {
                    i9++;
                    if (!z4 ? i11 >= edge : i11 <= edge) {
                        i8 = i12;
                    } else {
                        edge = i11;
                        i5 = i10;
                        i6 = i12;
                        i8 = i6;
                    }
                }
                i10++;
            }
        } else {
            int i13 = 1;
            int i14 = i5 - 1;
            int i15 = i7;
            StaggeredGrid.Location location3 = location;
            int i16 = edge;
            edge = this.mProvider.getSize(i5) + edge;
            i6 = i15;
            while (i13 < this.mNumRows && i14 >= this.mFirstVisibleIndex) {
                i16 -= location3.mOffset;
                location3 = getLocation(i14);
                int i17 = location3.mRow;
                if (i17 != i15) {
                    i13++;
                    int size = this.mProvider.getSize(i14) + i16;
                    if (!z4 ? size >= edge : size <= edge) {
                        i15 = i17;
                    } else {
                        edge = size;
                        i5 = i14;
                        i6 = i17;
                        i15 = i6;
                    }
                }
                i14--;
            }
        }
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i5;
        }
        return edge;
    }

    public int findRowMin(boolean z4, int i5, int[] iArr) {
        int i6;
        int edge = this.mProvider.getEdge(i5);
        StaggeredGrid.Location location = getLocation(i5);
        int i7 = location.mRow;
        if (this.mReversedFlow) {
            int i8 = 1;
            int i9 = i5 - 1;
            i6 = edge - this.mProvider.getSize(i5);
            int i10 = i7;
            while (i8 < this.mNumRows && i9 >= this.mFirstVisibleIndex) {
                edge -= location.mOffset;
                location = getLocation(i9);
                int i11 = location.mRow;
                if (i11 != i10) {
                    i8++;
                    int size = edge - this.mProvider.getSize(i9);
                    if (!z4 ? size >= i6 : size <= i6) {
                        i10 = i11;
                    } else {
                        i6 = size;
                        i5 = i9;
                        i7 = i11;
                        i10 = i7;
                    }
                }
                i9--;
            }
        } else {
            int i12 = i7;
            int i13 = i12;
            int i14 = 1;
            int i15 = i5 + 1;
            int i16 = edge;
            while (i14 < this.mNumRows && i15 <= this.mLastVisibleIndex) {
                StaggeredGrid.Location location2 = getLocation(i15);
                i16 += location2.mOffset;
                int i17 = location2.mRow;
                if (i17 != i13) {
                    i14++;
                    if (!z4 ? i16 >= edge : i16 <= edge) {
                        i13 = i17;
                    } else {
                        edge = i16;
                        i5 = i15;
                        i12 = i17;
                        i13 = i12;
                    }
                }
                i15++;
            }
            i6 = edge;
            i7 = i12;
        }
        if (iArr != null) {
            iArr[0] = i7;
            iArr[1] = i5;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public int getRowMax(int i5) {
        int i6;
        StaggeredGrid.Location location;
        int i7 = this.mFirstVisibleIndex;
        if (i7 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.mReversedFlow) {
            int edge = this.mProvider.getEdge(i7);
            if (getLocation(this.mFirstVisibleIndex).mRow == i5) {
                return edge;
            }
            int i8 = this.mFirstVisibleIndex;
            do {
                i8++;
                if (i8 <= getLastIndex()) {
                    location = getLocation(i8);
                    edge += location.mOffset;
                }
            } while (location.mRow != i5);
            return edge;
        }
        int edge2 = this.mProvider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow != i5) {
            int i9 = this.mLastVisibleIndex;
            while (true) {
                i9--;
                if (i9 < getFirstIndex()) {
                    break;
                }
                edge2 -= location2.mOffset;
                location2 = getLocation(i9);
                if (location2.mRow == i5) {
                    i6 = location2.mSize;
                    break;
                }
            }
        } else {
            i6 = location2.mSize;
        }
        return edge2 + i6;
        return Integer.MIN_VALUE;
    }

    /* access modifiers changed from: package-private */
    public int getRowMin(int i5) {
        StaggeredGrid.Location location;
        int i6;
        int i7 = this.mFirstVisibleIndex;
        if (i7 < 0) {
            return Integer.MAX_VALUE;
        }
        if (this.mReversedFlow) {
            int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
            StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
            if (location2.mRow != i5) {
                int i8 = this.mLastVisibleIndex;
                while (true) {
                    i8--;
                    if (i8 < getFirstIndex()) {
                        break;
                    }
                    edge -= location2.mOffset;
                    location2 = getLocation(i8);
                    if (location2.mRow == i5) {
                        i6 = location2.mSize;
                        break;
                    }
                }
            } else {
                i6 = location2.mSize;
            }
            return edge - i6;
        }
        int edge2 = this.mProvider.getEdge(i7);
        if (getLocation(this.mFirstVisibleIndex).mRow == i5) {
            return edge2;
        }
        int i9 = this.mFirstVisibleIndex;
        do {
            i9++;
            if (i9 <= getLastIndex()) {
                location = getLocation(i9);
                edge2 += location.mOffset;
            }
        } while (location.mRow != i5);
        return edge2;
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0101 A[LOOP:2: B:80:0x0101->B:94:0x0125, LOOP_START, PHI: r5 r8 r9 
      PHI: (r5v9 int) = (r5v3 int), (r5v12 int) binds: [B:79:0x00ff, B:94:0x0125] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v7 int) = (r8v5 int), (r8v8 int) binds: [B:79:0x00ff, B:94:0x0125] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v3 int) = (r9v1 int), (r9v5 int) binds: [B:79:0x00ff, B:94:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean prependVisibleItemsWithoutCache(int r13, boolean r14) {
        /*
            r12 = this;
            int r0 = r12.mFirstVisibleIndex
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 < 0) goto L_0x0074
            int r5 = r12.getFirstIndex()
            if (r0 <= r5) goto L_0x0011
            return r3
        L_0x0011:
            int r0 = r12.mFirstVisibleIndex
            int r5 = r0 + -1
            androidx.leanback.widget.StaggeredGrid$Location r0 = r12.getLocation((int) r0)
            int r0 = r0.mRow
            int r6 = r12.findRowEdgeLimitSearchIndex(r3)
            if (r6 >= 0) goto L_0x003c
            int r0 = r0 + -1
            int r6 = r12.mNumRows
            int r6 = r6 - r4
            r7 = r1
        L_0x0027:
            if (r6 < 0) goto L_0x004b
            boolean r7 = r12.mReversedFlow
            if (r7 == 0) goto L_0x0032
            int r7 = r12.getRowMax(r6)
            goto L_0x0036
        L_0x0032:
            int r7 = r12.getRowMin(r6)
        L_0x0036:
            if (r7 == r1) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            int r6 = r6 + -1
            goto L_0x0027
        L_0x003c:
            boolean r7 = r12.mReversedFlow
            if (r7 == 0) goto L_0x0046
            int r6 = r12.findRowMax(r4, r6, r2)
        L_0x0044:
            r7 = r6
            goto L_0x004b
        L_0x0046:
            int r6 = r12.findRowMin(r3, r6, r2)
            goto L_0x0044
        L_0x004b:
            boolean r6 = r12.mReversedFlow
            if (r6 == 0) goto L_0x0056
            int r6 = r12.getRowMax(r0)
            if (r6 < r7) goto L_0x0072
            goto L_0x005c
        L_0x0056:
            int r6 = r12.getRowMin(r0)
            if (r6 > r7) goto L_0x0072
        L_0x005c:
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x0072
            int r0 = r12.mNumRows
            int r0 = r0 - r4
            boolean r6 = r12.mReversedFlow
            if (r6 == 0) goto L_0x006d
            int r6 = r12.findRowMax(r4, r2)
        L_0x006b:
            r7 = r6
            goto L_0x0072
        L_0x006d:
            int r6 = r12.findRowMin(r3, r2)
            goto L_0x006b
        L_0x0072:
            r6 = r4
            goto L_0x0099
        L_0x0074:
            int r0 = r12.mStartIndex
            r5 = -1
            if (r0 == r5) goto L_0x007b
            r5 = r0
            goto L_0x007c
        L_0x007b:
            r5 = r3
        L_0x007c:
            androidx.collection.CircularArray<androidx.leanback.widget.StaggeredGrid$Location> r0 = r12.mLocations
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0093
            int r0 = r12.getFirstIndex()
            androidx.leanback.widget.StaggeredGrid$Location r0 = r12.getLocation((int) r0)
            int r0 = r0.mRow
            int r6 = r12.mNumRows
            int r0 = r0 + r6
            int r0 = r0 - r4
            goto L_0x0094
        L_0x0093:
            r0 = r5
        L_0x0094:
            int r6 = r12.mNumRows
            int r0 = r0 % r6
            r6 = r3
            r7 = r6
        L_0x0099:
            r8 = r3
        L_0x009a:
            if (r0 < 0) goto L_0x0148
            if (r5 < 0) goto L_0x014a
            if (r14 != 0) goto L_0x00a8
            boolean r9 = r12.checkPrependOverLimit(r13)
            if (r9 == 0) goto L_0x00a8
            goto L_0x014a
        L_0x00a8:
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00b1
            int r8 = r12.getRowMax(r0)
            goto L_0x00b5
        L_0x00b1:
            int r8 = r12.getRowMin(r0)
        L_0x00b5:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r8 == r1) goto L_0x00c8
            if (r8 != r9) goto L_0x00bc
            goto L_0x00c8
        L_0x00bc:
            boolean r9 = r12.mReversedFlow
            if (r9 == 0) goto L_0x00c3
            int r9 = r12.mSpacing
            goto L_0x00c6
        L_0x00c3:
            int r9 = r12.mSpacing
        L_0x00c5:
            int r9 = -r9
        L_0x00c6:
            int r8 = r8 + r9
            goto L_0x00f9
        L_0x00c8:
            int r8 = r12.mNumRows
            int r8 = r8 - r4
            if (r0 != r8) goto L_0x00e8
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00d6
            int r8 = r12.getRowMax(r3)
            goto L_0x00da
        L_0x00d6:
            int r8 = r12.getRowMin(r3)
        L_0x00da:
            if (r8 == r1) goto L_0x00f9
            if (r8 == r9) goto L_0x00f9
            boolean r9 = r12.mReversedFlow
            if (r9 == 0) goto L_0x00e5
            int r9 = r12.mSpacing
            goto L_0x00c6
        L_0x00e5:
            int r9 = r12.mSpacing
            goto L_0x00c5
        L_0x00e8:
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00f3
            int r8 = r0 + 1
            int r8 = r12.getRowMin(r8)
            goto L_0x00f9
        L_0x00f3:
            int r8 = r0 + 1
            int r8 = r12.getRowMax(r8)
        L_0x00f9:
            int r9 = r5 + -1
            int r5 = r12.prependVisibleItemToRow(r5, r0, r8)
            if (r6 == 0) goto L_0x0133
        L_0x0101:
            boolean r10 = r12.mReversedFlow
            if (r10 == 0) goto L_0x010a
            int r10 = r8 + r5
            if (r10 >= r7) goto L_0x0131
            goto L_0x010e
        L_0x010a:
            int r10 = r8 - r5
            if (r10 <= r7) goto L_0x0131
        L_0x010e:
            if (r9 < 0) goto L_0x0130
            if (r14 != 0) goto L_0x0119
            boolean r10 = r12.checkPrependOverLimit(r13)
            if (r10 == 0) goto L_0x0119
            goto L_0x0130
        L_0x0119:
            boolean r10 = r12.mReversedFlow
            if (r10 == 0) goto L_0x0121
            int r10 = r12.mSpacing
            int r5 = r5 + r10
            goto L_0x0125
        L_0x0121:
            int r5 = -r5
            int r10 = r12.mSpacing
            int r5 = r5 - r10
        L_0x0125:
            int r8 = r8 + r5
            int r5 = r9 + -1
            int r9 = r12.prependVisibleItemToRow(r9, r0, r8)
            r11 = r9
            r9 = r5
            r5 = r11
            goto L_0x0101
        L_0x0130:
            return r4
        L_0x0131:
            r5 = r9
            goto L_0x0143
        L_0x0133:
            boolean r5 = r12.mReversedFlow
            if (r5 == 0) goto L_0x013c
            int r5 = r12.getRowMax(r0)
            goto L_0x0140
        L_0x013c:
            int r5 = r12.getRowMin(r0)
        L_0x0140:
            r6 = r4
            r7 = r5
            goto L_0x0131
        L_0x0143:
            int r0 = r0 + -1
            r8 = r4
            goto L_0x009a
        L_0x0148:
            if (r14 == 0) goto L_0x014b
        L_0x014a:
            return r8
        L_0x014b:
            boolean r0 = r12.mReversedFlow
            if (r0 == 0) goto L_0x0155
            int r0 = r12.findRowMax(r4, r2)
        L_0x0153:
            r7 = r0
            goto L_0x015a
        L_0x0155:
            int r0 = r12.findRowMin(r3, r2)
            goto L_0x0153
        L_0x015a:
            int r0 = r12.mNumRows
            int r0 = r0 - r4
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.prependVisibleItemsWithoutCache(int, boolean):boolean");
    }
}
