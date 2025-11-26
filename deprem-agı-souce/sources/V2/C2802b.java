package v2;

import S1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import java.util.List;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2668q;
import z2.F;

/* renamed from: v2.b  reason: case insensitive filesystem */
public abstract class C2802b extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    private F f26039a;

    /* renamed from: v2.b$a */
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2668q f26040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2802b f26041b;

        public a(C2802b bVar, C2668q qVar) {
            t.e(qVar, "download");
            this.f26041b = bVar;
            this.f26040a = qVar;
        }

        public void run() {
            List<Fragment> fragments = this.f26041b.getSupportFragmentManager().getFragments();
            t.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                String string = this.f26041b.getString(R.string.tv_msg_download_complete, new Object[]{this.f26040a.i()});
                t.d(string, "getString(...)");
                Toast.makeText(fragments.get(0).getContext(), string, 1).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (context != null) {
            context = k.f32g.a(context);
        }
        super.attachBaseContext(context);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final F l() {
        return this.f26039a;
    }

    public final void m(C2657f fVar, Presenter.ViewHolder viewHolder) {
        t.e(fVar, "appInfo");
        t.e(viewHolder, "itemViewHolder");
        Intent intent = new Intent(this, TvAppDetailActivity.class);
        intent.putExtra("appInfo", fVar);
        if (com.uptodown.activities.preferences.a.f15150a.P(this)) {
            View view = viewHolder.view;
            if (view instanceof ImageCardView) {
                t.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, ((ImageCardView) view).getMainImageView(), "transition_name").toBundle());
                return;
            }
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f26039a = new F(this);
    }

    public boolean onSearchRequested() {
        startActivity(new Intent(this, TvSearchActivity.class));
        return true;
    }
}
