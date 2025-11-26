package N;

import android.net.Uri;

public abstract class s0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f3150a;

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f3151b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f3152c = 0;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        f3150a = parse;
        f3151b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
