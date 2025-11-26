package K;

abstract class N {
    static int a(int i5) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i6 = 0;
        while (i6 < 6) {
            int i7 = iArr[i6];
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            } else if (i8 == i5) {
                return i7;
            } else {
                i6++;
            }
        }
        return 1;
    }
}
