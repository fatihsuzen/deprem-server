package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.h;
import com.mbridge.msdk.tracker.network.r;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public final class f {
    public static b.a a(r rVar) {
        long j5;
        long j6;
        long j7;
        boolean z4;
        long j8;
        long j9;
        r rVar2 = rVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = rVar2.f11657c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long a5 = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i5 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z4 = false;
            j7 = 0;
            j6 = 0;
            while (i5 < split.length) {
                String trim = split[i5].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j7 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j6 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z4 = true;
                }
                i5++;
            }
            j5 = 0;
            i5 = 1;
        } else {
            j5 = 0;
            z4 = false;
            j7 = 0;
            j6 = 0;
        }
        String str3 = map.get("Expires");
        long a6 = str3 != null ? a(str3) : j5;
        String str4 = map.get("Last-Modified");
        long a7 = str4 != null ? a(str4) : j5;
        long j10 = currentTimeMillis;
        String str5 = map.get(Command.HTTP_HEADER_ETAG);
        if (i5 != 0) {
            long j11 = j10 + (j7 * 1000);
            if (z4) {
                j8 = j11;
            } else {
                Long.signum(j6);
                j8 = (j6 * 1000) + j11;
            }
            j9 = j11;
        } else {
            j9 = (a5 <= j5 || a6 < a5) ? j5 : j10 + (a6 - a5);
            j8 = j9;
        }
        b.a aVar = new b.a();
        aVar.f11573a = rVar2.f11656b;
        aVar.f11574b = str5;
        aVar.f11578f = j9;
        aVar.f11577e = j8;
        aVar.f11575c = a5;
        aVar.f11576d = a7;
        aVar.f11579g = map;
        aVar.f11580h = rVar2.f11658d;
        return aVar;
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static long a(String str) {
        try {
            Date parse = b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException e5) {
            if ("0".equals(str) || "-1".equals(str)) {
                ae.a("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                ae.a(e5, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0;
        }
    }

    static String a(long j5) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j5));
    }

    static List<h> a(List<h> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (h a5 : list) {
                treeSet.add(a5.a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<h> list2 = aVar.f11580h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (h next : aVar.f11580h) {
                    if (!treeSet.contains(next.a())) {
                        arrayList.add(next);
                    }
                }
            }
        } else if (!aVar.f11579g.isEmpty()) {
            for (Map.Entry next2 : aVar.f11579g.entrySet()) {
                if (!treeSet.contains(next2.getKey())) {
                    arrayList.add(new h((String) next2.getKey(), (String) next2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("Content-Type")) == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";", 0);
        for (int i5 = 1; i5 < split.length; i5++) {
            String[] split2 = split[i5].trim().split("=", 0);
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}
