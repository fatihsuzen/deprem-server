package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import com.mbridge.msdk.foundation.tools.af;

public class b implements com.mbridge.msdk.video.signal.b {
    public void a() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onPause");
    }

    public void b() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onResume");
    }

    public void c() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onDestory");
    }

    public final void d() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onStop");
    }

    public final void e() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onStart");
    }

    public final void f() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onRestart");
    }

    public void g() {
        af.a("DefaultJSActivity", "DefaultJSActivity-onBackPressed");
    }

    public int h() {
        af.a("DefaultJSActivity", "isSystemResume");
        return 0;
    }

    public void a(Configuration configuration) {
        af.a("DefaultJSActivity", "DefaultJSActivity-onConfigurationChanged:" + configuration.orientation);
    }

    public void a(int i5) {
        af.a("DefaultJSActivity", "setSystemResume,isResume:" + i5);
    }
}
