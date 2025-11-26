package N;

import K.C0667n;
import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: N.s  reason: case insensitive filesystem */
public class C0724s {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f3148a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3149b;

    public C0724s(Context context) {
        C0722p.k(context);
        Resources resources = context.getResources();
        this.f3148a = resources;
        this.f3149b = resources.getResourcePackageName(C0667n.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.f3148a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f3149b);
        if (identifier == 0) {
            return null;
        }
        return this.f3148a.getString(identifier);
    }
}
