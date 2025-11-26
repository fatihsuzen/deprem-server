package w1;

public class a {
    public float a(int i5, int i6) {
        if (i6 <= 0 || i5 <= 0) {
            return 0.0f;
        }
        float f5 = ((float) i5) / ((float) i6);
        if (f5 > 1.0f) {
            return 1.0f;
        }
        return f5;
    }
}
