package androidx.savedstate;

import W2.J;
import X2.C2242i;
import X2.C2250q;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.t;

final /* synthetic */ class SavedStateReaderKt__SavedStateReader_androidKt {
    /* access modifiers changed from: private */
    public static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            Object obj2 = bundle2.get(next);
            if (obj != obj2 && !t.a(obj, obj2)) {
                if (!(obj == null || obj2 == null)) {
                    if (!(obj instanceof Bundle) || !(obj2 instanceof Bundle)) {
                        if (!(obj instanceof Object[]) || !(obj2 instanceof Object[])) {
                            if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
                                if (!(obj instanceof short[]) || !(obj2 instanceof short[])) {
                                    if (!(obj instanceof int[]) || !(obj2 instanceof int[])) {
                                        if (!(obj instanceof long[]) || !(obj2 instanceof long[])) {
                                            if (!(obj instanceof float[]) || !(obj2 instanceof float[])) {
                                                if (!(obj instanceof double[]) || !(obj2 instanceof double[])) {
                                                    if (!(obj instanceof char[]) || !(obj2 instanceof char[])) {
                                                        if (!(obj instanceof boolean[]) || !(obj2 instanceof boolean[])) {
                                                            if (!t.a(obj, obj2)) {
                                                            }
                                                        } else if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                                                            return false;
                                                        }
                                                    } else if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                                return false;
                            }
                        } else if (!C2242i.d((Object[]) obj, (Object[]) obj2)) {
                            return false;
                        }
                    } else if (!contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(Bundle bundle) {
        int i5;
        int i6 = 1;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                i5 = contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) obj);
            } else if (obj instanceof Object[]) {
                i5 = C2242i.b((Object[]) obj);
            } else if (obj instanceof byte[]) {
                i5 = Arrays.hashCode((byte[]) obj);
            } else if (obj instanceof short[]) {
                i5 = Arrays.hashCode((short[]) obj);
            } else if (obj instanceof int[]) {
                i5 = Arrays.hashCode((int[]) obj);
            } else if (obj instanceof long[]) {
                i5 = Arrays.hashCode((long[]) obj);
            } else if (obj instanceof float[]) {
                i5 = Arrays.hashCode((float[]) obj);
            } else if (obj instanceof double[]) {
                i5 = Arrays.hashCode((double[]) obj);
            } else if (obj instanceof char[]) {
                i5 = Arrays.hashCode((char[]) obj);
            } else if (obj instanceof boolean[]) {
                i5 = Arrays.hashCode((boolean[]) obj);
            } else if (obj != null) {
                i5 = obj.hashCode();
            } else {
                i5 = 0;
            }
            i6 = (i6 * 31) + i5;
        }
        return i6;
    }

    /* access modifiers changed from: private */
    public static final void contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(Bundle bundle, StringBuilder sb, List<Bundle> list) {
        if (list.contains(bundle)) {
            sb.append("[...]");
            return;
        }
        list.add(bundle);
        sb.append('[');
        int i5 = 0;
        for (String str : bundle.keySet()) {
            int i6 = i5 + 1;
            if (i5 != 0) {
                sb.append(", ");
            }
            sb.append(str + '=');
            Object obj = bundle.get(str);
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Bundle) {
                contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) obj, sb, list);
                J j5 = J.f19942a;
            } else if (obj instanceof Object[]) {
                sb.append(C2242i.e((Object[]) obj));
            } else if (obj instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) obj);
                t.d(arrays, "toString(...)");
                sb.append(arrays);
            } else if (obj instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) obj);
                t.d(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (obj instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) obj);
                t.d(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (obj instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) obj);
                t.d(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (obj instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) obj);
                t.d(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (obj instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) obj);
                t.d(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (obj instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) obj);
                t.d(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (obj instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) obj);
                t.d(arrays8, "toString(...)");
                sb.append(arrays8);
            } else {
                sb.append(obj.toString());
            }
            i5 = i6;
        }
        sb.append(']');
        list.remove(C2250q.i(list));
    }
}
