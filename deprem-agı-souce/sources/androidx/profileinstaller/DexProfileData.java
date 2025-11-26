package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

class DexProfileData {
    @NonNull
    final String apkName;
    int classSetSize;
    @NonNull
    int[] classes;
    final long dexChecksum;
    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(@NonNull String str, @NonNull String str2, long j5, long j6, int i5, int i6, int i7, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j5;
        this.mTypeIdCount = j6;
        this.classSetSize = i5;
        this.hotMethodRegionSize = i6;
        this.numMethodIds = i7;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
