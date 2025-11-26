package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import java.util.List;
import kotlin.jvm.internal.t;
import l2.C2668q;
import v2.C2802b;

public final class TvMyDownloadsActivity extends C2802b {

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f21180a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f21181b;

        public a(int i5, C2668q qVar) {
            this.f21180a = i5;
            this.f21181b = qVar;
        }

        public void run() {
            List<Fragment> fragments = TvMyDownloadsActivity.this.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvMyDownloadsFragment) {
                    ((TvMyDownloadsFragment) fragment).t(this.f21180a);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_my_downloads_activity);
    }
}
