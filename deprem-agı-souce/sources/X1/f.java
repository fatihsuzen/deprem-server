package x1;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import u1.h;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f16982b = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    private final List f16983a = new ArrayList();

    private void b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void d(String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 50) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
        } else if (!f16982b.matcher(str).matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    private e e(View view) {
        for (e eVar : this.f16983a) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    public List a() {
        return this.f16983a;
    }

    public void c(View view, h hVar, String str) {
        b(view);
        d(str);
        if (e(view) == null) {
            this.f16983a.add(new e(view, hVar, str));
        }
    }

    public void f() {
        this.f16983a.clear();
    }

    public void g(View view) {
        b(view);
        e e5 = e(view);
        if (e5 != null) {
            this.f16983a.remove(e5);
        }
    }
}
