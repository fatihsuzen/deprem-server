package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i5, int i6, int i7, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z4 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z4 = true;
            } else if (z4) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        int i7;
        int i8 = updateOp.itemCount;
        int i9 = updateOp2.positionStart;
        if (i8 < i9) {
            i7 = -1;
        } else {
            i7 = 0;
        }
        int i10 = updateOp.positionStart;
        if (i10 < i9) {
            i7++;
        }
        if (i9 <= i10) {
            updateOp.positionStart = i10 + updateOp2.itemCount;
        }
        int i11 = updateOp2.positionStart;
        if (i11 <= i8) {
            updateOp.itemCount = i8 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i11 + i7;
        list.set(i5, updateOp2);
        list.set(i6, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i5, int i6) {
        AdapterHelper.UpdateOp updateOp = list.get(i5);
        AdapterHelper.UpdateOp updateOp2 = list.get(i6);
        int i7 = updateOp2.cmd;
        if (i7 == 1) {
            swapMoveAdd(list, i5, updateOp, i6, updateOp2);
        } else if (i7 == 2) {
            swapMoveRemove(list, i5, updateOp, i6, updateOp2);
        } else if (i7 == 4) {
            swapMoveUpdate(list, i5, updateOp, i6, updateOp2);
        }
    }

    /* access modifiers changed from: package-private */
    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        boolean z4;
        int i7 = updateOp.positionStart;
        int i8 = updateOp.itemCount;
        boolean z5 = false;
        if (i7 < i8) {
            if (updateOp2.positionStart == i7 && updateOp2.itemCount == i8 - i7) {
                z4 = false;
                z5 = true;
            } else {
                z4 = false;
            }
        } else if (updateOp2.positionStart == i8 + 1 && updateOp2.itemCount == i7 - i8) {
            z4 = true;
            z5 = true;
        } else {
            z4 = true;
        }
        int i9 = updateOp2.positionStart;
        if (i8 < i9) {
            updateOp2.positionStart = i9 - 1;
        } else {
            int i10 = updateOp2.itemCount;
            if (i8 < i9 + i10) {
                updateOp2.itemCount = i10 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i6);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i11 = updateOp.positionStart;
        int i12 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i11 <= i12) {
            updateOp2.positionStart = i12 + 1;
        } else {
            int i13 = updateOp2.itemCount;
            if (i11 < i12 + i13) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i11 + 1, (i12 + i13) - i11, (Object) null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z5) {
            list.set(i5, updateOp2);
            list.remove(i6);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z4) {
            if (updateOp3 != null) {
                int i14 = updateOp.positionStart;
                if (i14 > updateOp3.positionStart) {
                    updateOp.positionStart = i14 - updateOp3.itemCount;
                }
                int i15 = updateOp.itemCount;
                if (i15 > updateOp3.positionStart) {
                    updateOp.itemCount = i15 - updateOp3.itemCount;
                }
            }
            int i16 = updateOp.positionStart;
            if (i16 > updateOp2.positionStart) {
                updateOp.positionStart = i16 - updateOp2.itemCount;
            }
            int i17 = updateOp.itemCount;
            if (i17 > updateOp2.positionStart) {
                updateOp.itemCount = i17 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i18 = updateOp.positionStart;
                if (i18 >= updateOp3.positionStart) {
                    updateOp.positionStart = i18 - updateOp3.itemCount;
                }
                int i19 = updateOp.itemCount;
                if (i19 >= updateOp3.positionStart) {
                    updateOp.itemCount = i19 - updateOp3.itemCount;
                }
            }
            int i20 = updateOp.positionStart;
            if (i20 >= updateOp2.positionStart) {
                updateOp.positionStart = i20 - updateOp2.itemCount;
            }
            int i21 = updateOp.itemCount;
            if (i21 >= updateOp2.positionStart) {
                updateOp.itemCount = i21 - updateOp2.itemCount;
            }
        }
        list.set(i5, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i6, updateOp);
        } else {
            list.remove(i6);
        }
        if (updateOp3 != null) {
            list.add(i5, updateOp3);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r3
            r13.positionStart = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r3
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r3, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r4
        L_0x0021:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r3
            r13.positionStart = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.mCallback
            int r1 = r1 + r3
            java.lang.Object r3 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.obtainUpdateOp(r2, r1, r5, r3)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r9.add(r10, r4)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
