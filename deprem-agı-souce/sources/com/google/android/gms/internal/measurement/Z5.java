package com.google.android.gms.internal.measurement;

abstract class Z5 {
    static String a(H4 h42) {
        StringBuilder sb = new StringBuilder(h42.f());
        for (int i5 = 0; i5 < h42.f(); i5++) {
            byte c5 = h42.c(i5);
            if (c5 == 34) {
                sb.append("\\\"");
            } else if (c5 == 39) {
                sb.append("\\'");
            } else if (c5 != 92) {
                switch (c5) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (c5 >= 32 && c5 <= 126) {
                            sb.append((char) c5);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((c5 >>> 6) & 3) + 48));
                            sb.append((char) (((c5 >>> 3) & 7) + 48));
                            sb.append((char) ((c5 & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
