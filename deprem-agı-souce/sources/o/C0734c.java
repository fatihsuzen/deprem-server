package O;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* renamed from: O.c  reason: case insensitive filesystem */
public abstract class C0734c {
    public static int a(Parcel parcel) {
        return t(parcel, 20293);
    }

    public static void b(Parcel parcel, int i5) {
        u(parcel, i5);
    }

    public static void c(Parcel parcel, int i5, boolean z4) {
        v(parcel, i5, 4);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i5, Boolean bool, boolean z4) {
        if (bool != null) {
            v(parcel, i5, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void e(Parcel parcel, int i5, Bundle bundle, boolean z4) {
        if (bundle != null) {
            int t5 = t(parcel, i5);
            parcel.writeBundle(bundle);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void f(Parcel parcel, int i5, byte[] bArr, boolean z4) {
        if (bArr != null) {
            int t5 = t(parcel, i5);
            parcel.writeByteArray(bArr);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void g(Parcel parcel, int i5, Double d5, boolean z4) {
        if (d5 != null) {
            v(parcel, i5, 8);
            parcel.writeDouble(d5.doubleValue());
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void h(Parcel parcel, int i5, Float f5, boolean z4) {
        if (f5 != null) {
            v(parcel, i5, 4);
            parcel.writeFloat(f5.floatValue());
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void i(Parcel parcel, int i5, IBinder iBinder, boolean z4) {
        if (iBinder != null) {
            int t5 = t(parcel, i5);
            parcel.writeStrongBinder(iBinder);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void j(Parcel parcel, int i5, int i6) {
        v(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void k(Parcel parcel, int i5, int[] iArr, boolean z4) {
        if (iArr != null) {
            int t5 = t(parcel, i5);
            parcel.writeIntArray(iArr);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void l(Parcel parcel, int i5, List list, boolean z4) {
        if (list != null) {
            int t5 = t(parcel, i5);
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                parcel.writeInt(((Integer) list.get(i6)).intValue());
            }
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void m(Parcel parcel, int i5, long j5) {
        v(parcel, i5, 8);
        parcel.writeLong(j5);
    }

    public static void n(Parcel parcel, int i5, Long l5, boolean z4) {
        if (l5 != null) {
            v(parcel, i5, 8);
            parcel.writeLong(l5.longValue());
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void o(Parcel parcel, int i5, Parcelable parcelable, int i6, boolean z4) {
        if (parcelable != null) {
            int t5 = t(parcel, i5);
            parcelable.writeToParcel(parcel, i6);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void p(Parcel parcel, int i5, String str, boolean z4) {
        if (str != null) {
            int t5 = t(parcel, i5);
            parcel.writeString(str);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void q(Parcel parcel, int i5, List list, boolean z4) {
        if (list != null) {
            int t5 = t(parcel, i5);
            parcel.writeStringList(list);
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void r(Parcel parcel, int i5, Parcelable[] parcelableArr, int i6, boolean z4) {
        if (parcelableArr != null) {
            int t5 = t(parcel, i5);
            parcel.writeInt(r7);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    w(parcel, parcelable, i6);
                }
            }
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    public static void s(Parcel parcel, int i5, List list, boolean z4) {
        if (list != null) {
            int t5 = t(parcel, i5);
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                Parcelable parcelable = (Parcelable) list.get(i6);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    w(parcel, parcelable, 0);
                }
            }
            u(parcel, t5);
        } else if (z4) {
            v(parcel, i5, 0);
        }
    }

    private static int t(Parcel parcel, int i5) {
        parcel.writeInt(i5 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void u(Parcel parcel, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(dataPosition - i5);
        parcel.setDataPosition(dataPosition);
    }

    private static void v(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    private static void w(Parcel parcel, Parcelable parcelable, int i5) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
