package androidx.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class d implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f184a;

    public /* synthetic */ d(ComponentActivity componentActivity) {
        this.f184a = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        ComponentActivity.e(this.f184a, context);
    }
}
