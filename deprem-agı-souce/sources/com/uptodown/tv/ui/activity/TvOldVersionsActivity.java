package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.List;
import kotlin.jvm.internal.t;
import l2.C2668q;
import v2.C2802b;

public final class TvOldVersionsActivity extends C2802b {

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f21183a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f21184b;

        public a(int i5, C2668q qVar) {
            this.f21183a = i5;
            this.f21184b = qVar;
        }

        public void run() {
            List<Fragment> fragments = TvOldVersionsActivity.this.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                Fragment fragment = fragments.get(0);
                if (fragment instanceof TvOldVersionsFragment) {
                    ((TvOldVersionsFragment) fragment).z(this.f21183a);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_old_versions);
    }
}
