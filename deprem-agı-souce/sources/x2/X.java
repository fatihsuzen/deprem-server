package X2;

public abstract class X {
    public static final void a(int i5, int i6) {
        String str;
        if (i5 <= 0 || i6 <= 0) {
            if (i5 != i6) {
                str = "Both size " + i5 + " and step " + i6 + " must be greater than zero.";
            } else {
                str = "size " + i5 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }
}
