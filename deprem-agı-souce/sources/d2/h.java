package D2;

import M1.e;
import W2.q;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import d3.C2345b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f17995a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17996b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17997c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17998d;

    public enum a {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT;

        static {
            a[] a5;
            f18015q = C2345b.a(a5);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18016a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(2:29|30)|31|33) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                D2.h$a[] r0 = D2.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                D2.h$a r1 = D2.h.a.ALL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                D2.h$a r1 = D2.h.a.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                D2.h$a r1 = D2.h.a.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                D2.h$a r1 = D2.h.a.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                D2.h$a r1 = D2.h.a.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                D2.h$a r1 = D2.h.a.TOP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                D2.h$a r1 = D2.h.a.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                D2.h$a r1 = D2.h.a.LEFT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                D2.h$a r1 = D2.h.a.RIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                D2.h$a r1 = D2.h.a.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                D2.h$a r1 = D2.h.a.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                D2.h$a r1 = D2.h.a.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                D2.h$a r1 = D2.h.a.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                D2.h$a r1 = D2.h.a.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                D2.h$a r1 = D2.h.a.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                f18016a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: D2.h.b.<clinit>():void");
        }
    }

    public h(int i5, a aVar) {
        t.e(aVar, "cornerType");
        this.f17995a = i5;
        this.f17996b = i5 * 2;
        this.f17998d = aVar;
    }

    private final void b(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        int i6 = this.f17996b;
        RectF rectF = new RectF((float) i5, f6 - ((float) i6), (float) (i5 + i6), f6);
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        canvas.drawRect(new RectF((float) i8, (float) i8, (float) (i8 + this.f17996b), f6 - ((float) this.f17995a)), paint);
        int i9 = this.f17997c;
        canvas.drawRect(new RectF((float) (this.f17995a + i9), (float) i9, f5, f6), paint);
    }

    private final void c(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17996b;
        RectF rectF = new RectF(f5 - ((float) i5), f6 - ((float) i5), f5, f6);
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f17997c;
        canvas.drawRect(new RectF((float) i7, (float) i7, f5 - ((float) this.f17995a), f6), paint);
        int i8 = this.f17995a;
        canvas.drawRect(new RectF(f5 - ((float) i8), (float) this.f17997c, f5, f6 - ((float) i8)), paint);
    }

    private final void d(Canvas canvas, Paint paint, float f5, float f6) {
        RectF rectF = new RectF((float) this.f17997c, f6 - ((float) this.f17996b), f5, f6);
        int i5 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f17997c;
        canvas.drawRect(new RectF((float) i6, (float) i6, f5, f6 - ((float) this.f17995a)), paint);
    }

    private final void e(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        int i6 = this.f17996b;
        RectF rectF = new RectF((float) i5, (float) i5, (float) (i5 + i6), (float) (i5 + i6));
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
        int i8 = this.f17996b;
        RectF rectF2 = new RectF(f5 - ((float) i8), f6 - ((float) i8), f5, f6);
        int i9 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i9, (float) i9, paint);
        int i10 = this.f17997c;
        int i11 = this.f17995a;
        canvas.drawRect(new RectF((float) i10, (float) (i10 + i11), f5 - ((float) i11), f6), paint);
        int i12 = this.f17997c;
        int i13 = this.f17995a;
        canvas.drawRect(new RectF((float) (i12 + i13), (float) i12, f5, f6 - ((float) i13)), paint);
    }

    private final void f(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17996b;
        int i6 = this.f17997c;
        RectF rectF = new RectF(f5 - ((float) i5), (float) i6, f5, (float) (i6 + i5));
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        int i9 = this.f17996b;
        RectF rectF2 = new RectF((float) i8, f6 - ((float) i9), (float) (i8 + i9), f6);
        int i10 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i10, (float) i10, paint);
        int i11 = this.f17997c;
        int i12 = this.f17995a;
        canvas.drawRect(new RectF((float) i11, (float) i11, f5 - ((float) i12), f6 - ((float) i12)), paint);
        int i13 = this.f17997c;
        int i14 = this.f17995a;
        canvas.drawRect(new RectF((float) (i13 + i14), (float) (i13 + i14), f5, f6), paint);
    }

    private final void g(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        RectF rectF = new RectF((float) i5, (float) i5, (float) (i5 + this.f17996b), f6);
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f17997c;
        canvas.drawRect(new RectF((float) (this.f17995a + i7), (float) i7, f5, f6), paint);
    }

    private final void h(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        RectF rectF = new RectF((float) i5, (float) i5, f5, (float) (i5 + this.f17996b));
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        RectF rectF2 = new RectF(f5 - ((float) this.f17996b), (float) this.f17997c, f5, f6);
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        int i9 = this.f17995a;
        canvas.drawRect(new RectF((float) i8, (float) (i8 + i9), f5 - ((float) i9), f6), paint);
    }

    private final void i(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        RectF rectF = new RectF((float) i5, (float) i5, f5, (float) (i5 + this.f17996b));
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f17997c;
        RectF rectF2 = new RectF((float) i7, (float) i7, (float) (i7 + this.f17996b), f6);
        int i8 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i8, (float) i8, paint);
        int i9 = this.f17997c;
        int i10 = this.f17995a;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f5, f6), paint);
    }

    private final void j(Canvas canvas, Paint paint, float f5, float f6) {
        RectF rectF = new RectF((float) this.f17997c, f6 - ((float) this.f17996b), f5, f6);
        int i5 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        RectF rectF2 = new RectF(f5 - ((float) this.f17996b), (float) this.f17997c, f5, f6);
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.f17997c;
        int i8 = this.f17995a;
        canvas.drawRect(new RectF((float) i7, (float) i7, f5 - ((float) i8), f6 - ((float) i8)), paint);
    }

    private final void k(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        RectF rectF = new RectF((float) i5, (float) i5, (float) (i5 + this.f17996b), f6);
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        RectF rectF2 = new RectF((float) this.f17997c, f6 - ((float) this.f17996b), f5, f6);
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        int i9 = this.f17995a;
        canvas.drawRect(new RectF((float) (i8 + i9), (float) i8, f5, f6 - ((float) i9)), paint);
    }

    private final void l(Canvas canvas, Paint paint, float f5, float f6) {
        RectF rectF = new RectF(f5 - ((float) this.f17996b), (float) this.f17997c, f5, f6);
        int i5 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f17997c;
        canvas.drawRect(new RectF((float) i6, (float) i6, f5 - ((float) this.f17995a), f6), paint);
    }

    private final void m(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        float f7 = f5 - ((float) i5);
        float f8 = f6 - ((float) i5);
        switch (b.f18016a[this.f17998d.ordinal()]) {
            case 1:
                int i6 = this.f17997c;
                RectF rectF = new RectF((float) i6, (float) i6, f7, f8);
                int i7 = this.f17995a;
                canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
                return;
            case 2:
                n(canvas, paint, f7, f8);
                return;
            case 3:
                o(canvas, paint, f7, f8);
                return;
            case 4:
                b(canvas, paint, f7, f8);
                return;
            case 5:
                c(canvas, paint, f7, f8);
                return;
            case 6:
                p(canvas, paint, f7, f8);
                return;
            case 7:
                d(canvas, paint, f7, f8);
                return;
            case 8:
                g(canvas, paint, f7, f8);
                return;
            case 9:
                l(canvas, paint, f7, f8);
                return;
            case 10:
                j(canvas, paint, f7, f8);
                return;
            case 11:
                k(canvas, paint, f7, f8);
                return;
            case 12:
                h(canvas, paint, f7, f8);
                return;
            case 13:
                i(canvas, paint, f7, f8);
                return;
            case 14:
                e(canvas, paint, f7, f8);
                return;
            case 15:
                f(canvas, paint, f7, f8);
                return;
            default:
                throw new q();
        }
    }

    private final void n(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        int i6 = this.f17996b;
        RectF rectF = new RectF((float) i5, (float) i5, (float) (i5 + i6), (float) (i5 + i6));
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        int i9 = this.f17995a;
        canvas.drawRect(new RectF((float) i8, (float) (i8 + i9), (float) (i8 + i9), f6), paint);
        int i10 = this.f17997c;
        canvas.drawRect(new RectF((float) (this.f17995a + i10), (float) i10, f5, f6), paint);
    }

    private final void o(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17996b;
        int i6 = this.f17997c;
        RectF rectF = new RectF(f5 - ((float) i5), (float) i6, f5, (float) (i6 + i5));
        int i7 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint);
        int i8 = this.f17997c;
        canvas.drawRect(new RectF((float) i8, (float) i8, f5 - ((float) this.f17995a), f6), paint);
        int i9 = this.f17995a;
        canvas.drawRect(new RectF(f5 - ((float) i9), (float) (this.f17997c + i9), f5, f6), paint);
    }

    private final void p(Canvas canvas, Paint paint, float f5, float f6) {
        int i5 = this.f17997c;
        RectF rectF = new RectF((float) i5, (float) i5, f5, (float) (i5 + this.f17996b));
        int i6 = this.f17995a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f17997c;
        canvas.drawRect(new RectF((float) i7, (float) (i7 + this.f17995a), f5, f6), paint);
    }

    public Bitmap a(Bitmap bitmap) {
        t.e(bitmap, "source");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        t.d(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        m(canvas, paint, (float) width, (float) height);
        bitmap.recycle();
        return createBitmap;
    }

    public String key() {
        return "RoundedTransformation(radius=" + this.f17995a + ", margin=" + this.f17997c + ", diameter=" + this.f17996b + ", cornerType=" + this.f17998d.name() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i5, a aVar, int i6, C2633k kVar) {
        this(i5, (i6 & 2) != 0 ? a.ALL : aVar);
    }
}
