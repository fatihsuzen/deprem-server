package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONArray;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f9420a = "DomainReport";

    public static boolean a(g gVar, String str) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int Q4 = gVar.Q();
                    JSONArray O4 = gVar.O();
                    JSONArray N4 = gVar.N();
                    if (N4 != null) {
                        for (int i5 = 0; i5 < N4.length(); i5++) {
                            if (str.contains(N4.getString(i5))) {
                                return false;
                            }
                        }
                    }
                    if (Q4 == 2) {
                        if (O4 != null) {
                            for (int i6 = 0; i6 < O4.length(); i6++) {
                                if (str.contains(O4.getString(i6))) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
            } catch (Exception e5) {
                af.b(f9420a, e5.getMessage());
            }
        }
        return true;
    }
}
