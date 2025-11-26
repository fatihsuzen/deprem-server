package com.mbridge.msdk.newreward.player.view.hybrid.util;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

public class MBHybridUtil {
    private static final String TAG = "MBHybridUtil";

    public static String convert2Unicode(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuilder sb = new StringBuilder(1000);
        sb.setLength(0);
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt <= 255) {
                int i6 = 0;
                while (true) {
                    if (i6 >= 2) {
                        sb.append(charAt);
                        break;
                    } else if (cArr[i6] == charAt) {
                        sb.append("\\" + charAt);
                        break;
                    } else {
                        i6++;
                    }
                }
            } else {
                sb.append("\\u");
                String upperCase = Integer.toHexString(charAt >>> 8).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                String upperCase2 = Integer.toHexString(charAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase2);
            }
        }
        return new String(sb);
    }

    public static double getCurrentVolume(Context context) {
        int i5;
        if (context == null) {
            return -1.0d;
        }
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int i6 = -1;
        if (audioManager != null) {
            i5 = audioManager.getStreamMaxVolume(3);
        } else {
            i5 = -1;
        }
        if (audioManager != null) {
            i6 = audioManager.getStreamVolume(3);
        }
        return (((double) i6) * 100.0d) / ((double) i5);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r4.equals("jpg") == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImageMimeType(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            android.net.Uri r4 = android.net.Uri.parse(r4)
            java.lang.String r4 = r4.getPath()
            r0 = 1
            r2 = -1
            if (r4 == 0) goto L_0x0023
            java.lang.String r3 = "."
            int r3 = r4.lastIndexOf(r3)
            if (r3 == r2) goto L_0x0023
            int r3 = r3 + r0
            java.lang.String r4 = r4.substring(r3)
            goto L_0x0024
        L_0x0023:
            r4 = r1
        L_0x0024:
            r4.getClass()
            int r3 = r4.hashCode()
            switch(r3) {
                case 102340: goto L_0x005a;
                case 105441: goto L_0x0051;
                case 111145: goto L_0x0046;
                case 3268712: goto L_0x003b;
                case 3645340: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            r0 = r2
            goto L_0x0064
        L_0x0030:
            java.lang.String r0 = "webp"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r0 = 4
            goto L_0x0064
        L_0x003b:
            java.lang.String r0 = "jpeg"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            r0 = 3
            goto L_0x0064
        L_0x0046:
            java.lang.String r0 = "png"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x004f
            goto L_0x002e
        L_0x004f:
            r0 = 2
            goto L_0x0064
        L_0x0051:
            java.lang.String r3 = "jpg"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0064
            goto L_0x002e
        L_0x005a:
            java.lang.String r0 = "gif"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0063
            goto L_0x002e
        L_0x0063:
            r0 = 0
        L_0x0064:
            switch(r0) {
                case 0: goto L_0x0071;
                case 1: goto L_0x006e;
                case 2: goto L_0x006b;
                case 3: goto L_0x006e;
                case 4: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            return r1
        L_0x0068:
            java.lang.String r4 = "image/webp"
            return r4
        L_0x006b:
            java.lang.String r4 = "image/png"
            return r4
        L_0x006e:
            java.lang.String r4 = "image/jpeg"
            return r4
        L_0x0071:
            java.lang.String r4 = "image/gif"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.hybrid.util.MBHybridUtil.getImageMimeType(java.lang.String):java.lang.String");
    }

    public static Set<String> getQueryParameterNames(Uri uri) {
        if (uri == null) {
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.EMPTY_SET;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i5 = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i5);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i5);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i5, indexOf2)));
            i5 = indexOf + 1;
        } while (i5 < encodedQuery.length());
        return DesugarCollections.unmodifiableSet(linkedHashSet);
    }

    public static String getQueryParameters(Uri uri) {
        String encodedQuery;
        if (uri == null || (encodedQuery = uri.getEncodedQuery()) == null) {
            return null;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        int i5 = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i5);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i5);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i5, indexOf2)));
            i5 = indexOf + 1;
        } while (i5 < encodedQuery.length());
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : linkedHashSet) {
                jSONObject.put(str, uri.getQueryParameter(str));
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return null;
        }
    }
}
