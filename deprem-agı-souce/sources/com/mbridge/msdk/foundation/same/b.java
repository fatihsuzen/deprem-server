package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ah;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f9225a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f9226b = null;

    private b() {
    }

    public static b a() {
        if (f9225a == null) {
            synchronized (b.class) {
                try {
                    if (f9225a == null) {
                        f9225a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9225a;
    }

    public final Boolean b() {
        return this.f9226b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("new_bridge_reward_video")) {
            boolean a5 = ah.a().a("new_bridge_reward_video", false, false);
            this.f9226b = Boolean.valueOf(a5);
            return a5;
        } else if (str.equals("new_bridge_reward_show")) {
            return ah.a().a("new_bridge_reward_show", false, false);
        } else {
            return false;
        }
    }
}
