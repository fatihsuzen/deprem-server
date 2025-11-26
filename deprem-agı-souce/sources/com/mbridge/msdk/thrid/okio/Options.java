package com.mbridge.msdk.thrid.okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j5, Buffer buffer, int i5, List<ByteString> list, int i6, int i7, List<Integer> list2) {
        int i8;
        int i9;
        long j6;
        int i10;
        List<Integer> list3;
        int i11;
        long j7;
        Buffer buffer2 = buffer;
        int i12 = i5;
        List<ByteString> list4 = list;
        int i13 = i6;
        int i14 = i7;
        List<Integer> list5 = list2;
        if (i13 < i14) {
            int i15 = i13;
            while (i15 < i14) {
                if (list4.get(i15).size() >= i12) {
                    i15++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i6);
            ByteString byteString2 = list4.get(i14 - 1);
            if (i12 == byteString.size()) {
                int intValue = list5.get(i13).intValue();
                int i16 = i13 + 1;
                ByteString byteString3 = list4.get(i16);
                i8 = i16;
                i9 = intValue;
                byteString = byteString3;
            } else {
                i8 = i13;
                i9 = -1;
            }
            long j8 = 2;
            if (byteString.getByte(i12) != byteString2.getByte(i12)) {
                int i17 = 1;
                for (int i18 = i8 + 1; i18 < i14; i18++) {
                    if (list4.get(i18 - 1).getByte(i12) != list4.get(i18).getByte(i12)) {
                        i17++;
                    }
                }
                long intCount = j5 + ((long) intCount(buffer2)) + 2 + ((long) (i17 * 2));
                buffer2.writeInt(i17);
                buffer2.writeInt(i9);
                for (int i19 = i8; i19 < i14; i19++) {
                    byte b5 = list4.get(i19).getByte(i12);
                    if (i19 == i8 || b5 != list4.get(i19 - 1).getByte(i12)) {
                        buffer2.writeInt((int) b5 & 255);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i20 = i8;
                while (i20 < i14) {
                    byte b6 = list4.get(i20).getByte(i12);
                    int i21 = i20 + 1;
                    int i22 = i21;
                    while (true) {
                        if (i22 >= i14) {
                            i22 = i14;
                            break;
                        } else if (b6 != list4.get(i22).getByte(i12)) {
                            break;
                        } else {
                            i22++;
                        }
                    }
                    if (i21 == i22 && i12 + 1 == list4.get(i20).size()) {
                        buffer2.writeInt(list5.get(i20).intValue());
                        list3 = list5;
                        j7 = intCount;
                        i11 = i22;
                    } else {
                        buffer2.writeInt((int) ((((long) intCount(buffer3)) + intCount) * -1));
                        list3 = list5;
                        j7 = intCount;
                        i11 = i22;
                        List<ByteString> list6 = list;
                        buildTrieRecursive(j7, buffer3, i12 + 1, list6, i20, i11, list3);
                        list4 = list6;
                    }
                    intCount = j7;
                    i20 = i11;
                    list5 = list3;
                }
                buffer2.write(buffer3, buffer3.size());
                return;
            }
            List<Integer> list7 = list5;
            int min = Math.min(byteString.size(), byteString2.size());
            int i23 = 0;
            int i24 = i12;
            while (true) {
                if (i24 >= min) {
                    j6 = j8;
                    break;
                }
                j6 = j8;
                if (byteString.getByte(i24) != byteString2.getByte(i24)) {
                    break;
                }
                i23++;
                i24++;
                j8 = j6;
            }
            long intCount2 = j5 + ((long) intCount(buffer2)) + j6 + ((long) i23) + 1;
            buffer2.writeInt(-i23);
            buffer2.writeInt(i9);
            int i25 = i12;
            while (true) {
                i10 = i12 + i23;
                if (i25 >= i10) {
                    break;
                }
                buffer2.writeInt((int) byteString.getByte(i25) & 255);
                i25++;
            }
            if (i8 + 1 != i14) {
                Buffer buffer4 = new Buffer();
                buffer2.writeInt((int) ((((long) intCount(buffer4)) + intCount2) * -1));
                buildTrieRecursive(intCount2, buffer4, i10, list4, i8, i14, list7);
                buffer2.write(buffer4, buffer4.size());
            } else if (i10 == list4.get(i8).size()) {
                buffer2.writeInt(list7.get(i8).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList2.add(-1);
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i6]), Integer.valueOf(i6));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i7 = 0;
            while (i7 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i7);
                int i8 = i7 + 1;
                int i9 = i8;
                while (i9 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i9);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i9)).intValue() > ((Integer) arrayList2.get(i7)).intValue()) {
                        arrayList.remove(i9);
                        arrayList2.remove(i9);
                    } else {
                        i9++;
                    }
                }
                i7 = i8;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int intCount = intCount(buffer);
            int[] iArr = new int[intCount];
            for (int i10 = 0; i10 < intCount; i10++) {
                iArr[i10] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final int size() {
        return this.byteStrings.length;
    }

    public ByteString get(int i5) {
        return this.byteStrings[i5];
    }
}
