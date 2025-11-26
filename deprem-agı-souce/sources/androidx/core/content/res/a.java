package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f254a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Typeface f255b;

    public /* synthetic */ a(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f254a = fontCallback;
        this.f255b = typeface;
    }

    public final void run() {
        this.f254a.onFontRetrieved(this.f255b);
    }
}
