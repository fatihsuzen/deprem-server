package j$.time.temporal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import j$.time.d;
import j$.time.g;

public enum h implements q {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f1185a = null;

    public final boolean isDateBased() {
        return true;
    }

    static {
        f1185a = new int[]{0, 90, 181, FloatWebTemplateView.FLOAT_MINI_CARD, 0, 91, 182, 274};
    }

    public static int q(int i5) {
        g D4 = g.D(i5, 1, 1);
        if (D4.z() != d.THURSDAY) {
            return (D4.z() != d.WEDNESDAY || !D4.B()) ? 52 : 53;
        }
        return 53;
    }

    public static int k(g gVar) {
        int ordinal = gVar.z().ordinal();
        int A4 = gVar.A() - 1;
        int i5 = (3 - ordinal) + A4;
        int i6 = i5 - ((i5 / 7) * 7);
        int i7 = i6 - 3;
        if (i7 < -3) {
            i7 = i6 + 4;
        }
        if (A4 < i7) {
            return (int) u.e(1, (long) q(n(gVar.M(SubsamplingScaleImageView.ORIENTATION_180).I(-1)))).f1209d;
        }
        int i8 = ((A4 - i7) / 7) + 1;
        if (i8 != 53 || i7 == -3 || (i7 == -2 && gVar.B())) {
            return i8;
        }
        return 1;
    }

    public static int n(g gVar) {
        int i5 = gVar.f1144a;
        int A4 = gVar.A();
        if (A4 <= 3) {
            if (A4 - gVar.z().ordinal() < -2) {
                return i5 - 1;
            }
            return i5;
        } else if (A4 < 363) {
            return i5;
        } else {
            return ((A4 - 363) - (gVar.B() ? 1 : 0)) - gVar.z().ordinal() >= 0 ? i5 + 1 : i5;
        }
    }
}
