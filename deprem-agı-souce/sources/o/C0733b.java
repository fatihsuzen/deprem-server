package O;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

/* renamed from: O.b  reason: case insensitive filesystem */
public abstract class C0733b {

    /* renamed from: O.b$a */
    public static class a extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: O.C0733b.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + u5);
        return readBundle;
    }

    public static byte[] b(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + u5);
        return createByteArray;
    }

    public static int[] c(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + u5);
        return createIntArray;
    }

    public static ArrayList d(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + u5);
        return arrayList;
    }

    public static Parcelable e(Parcel parcel, int i5, Parcelable.Creator creator) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + u5);
        return parcelable;
    }

    public static String f(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + u5);
        return readString;
    }

    public static ArrayList g(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + u5);
        return createStringArrayList;
    }

    public static Object[] h(Parcel parcel, int i5, Parcelable.Creator creator) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + u5);
        return createTypedArray;
    }

    public static ArrayList i(Parcel parcel, int i5, Parcelable.Creator creator) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + u5);
        return createTypedArrayList;
    }

    public static void j(Parcel parcel, int i5) {
        if (parcel.dataPosition() != i5) {
            throw new a("Overread allowed size end=" + i5, parcel);
        }
    }

    public static int k(int i5) {
        return (char) i5;
    }

    public static boolean l(Parcel parcel, int i5) {
        y(parcel, i5, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static Boolean m(Parcel parcel, int i5) {
        boolean z4;
        int u5 = u(parcel, i5);
        if (u5 == 0) {
            return null;
        }
        x(parcel, i5, u5, 4);
        if (parcel.readInt() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    public static Double n(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        if (u5 == 0) {
            return null;
        }
        x(parcel, i5, u5, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static Float o(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        if (u5 == 0) {
            return null;
        }
        x(parcel, i5, u5, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int p(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder q(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        int dataPosition = parcel.dataPosition();
        if (u5 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + u5);
        return readStrongBinder;
    }

    public static int r(Parcel parcel, int i5) {
        y(parcel, i5, 4);
        return parcel.readInt();
    }

    public static long s(Parcel parcel, int i5) {
        y(parcel, i5, 8);
        return parcel.readLong();
    }

    public static Long t(Parcel parcel, int i5) {
        int u5 = u(parcel, i5);
        if (u5 == 0) {
            return null;
        }
        x(parcel, i5, u5, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int u(Parcel parcel, int i5) {
        if ((i5 & SupportMenu.CATEGORY_MASK) != -65536) {
            return (char) (i5 >> 16);
        }
        return parcel.readInt();
    }

    public static void v(Parcel parcel, int i5) {
        parcel.setDataPosition(parcel.dataPosition() + u(parcel, i5));
    }

    public static int w(Parcel parcel) {
        int p5 = p(parcel);
        int u5 = u(parcel, p5);
        int k5 = k(p5);
        int dataPosition = parcel.dataPosition();
        if (k5 == 20293) {
            int i5 = u5 + dataPosition;
            if (i5 >= dataPosition && i5 <= parcel.dataSize()) {
                return i5;
            }
            throw new a("Size read is invalid start=" + dataPosition + " end=" + i5, parcel);
        }
        throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(p5))), parcel);
    }

    private static void x(Parcel parcel, int i5, int i6, int i7) {
        if (i6 != i7) {
            String hexString = Integer.toHexString(i6);
            throw new a("Expected size " + i7 + " got " + i6 + " (0x" + hexString + ")", parcel);
        }
    }

    private static void y(Parcel parcel, int i5, int i6) {
        int u5 = u(parcel, i5);
        if (u5 != i6) {
            String hexString = Integer.toHexString(u5);
            throw new a("Expected size " + i6 + " got " + u5 + " (0x" + hexString + ")", parcel);
        }
    }
}
