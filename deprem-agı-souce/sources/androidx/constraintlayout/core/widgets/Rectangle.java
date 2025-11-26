package androidx.constraintlayout.core.widgets;

public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f237x;

    /* renamed from: y  reason: collision with root package name */
    public int f238y;

    public boolean contains(int i5, int i6) {
        int i7;
        int i8 = this.f237x;
        if (i5 < i8 || i5 >= i8 + this.width || i6 < (i7 = this.f238y) || i6 >= i7 + this.height) {
            return false;
        }
        return true;
    }

    public int getCenterX() {
        return (this.f237x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f238y + this.height) / 2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i5, int i6) {
        this.f237x -= i5;
        this.f238y -= i6;
        this.width += i5 * 2;
        this.height += i6 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        int i5;
        int i6;
        int i7 = this.f237x;
        int i8 = rectangle.f237x;
        if (i7 < i8 || i7 >= i8 + rectangle.width || (i5 = this.f238y) < (i6 = rectangle.f238y) || i5 >= i6 + rectangle.height) {
            return false;
        }
        return true;
    }

    public void setBounds(int i5, int i6, int i7, int i8) {
        this.f237x = i5;
        this.f238y = i6;
        this.width = i7;
        this.height = i8;
    }
}
