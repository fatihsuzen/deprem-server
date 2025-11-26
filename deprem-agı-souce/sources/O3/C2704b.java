package o3;

import java.util.Random;
import kotlin.jvm.internal.t;

/* renamed from: o3.b  reason: case insensitive filesystem */
public final class C2704b extends C2703a {

    /* renamed from: c  reason: collision with root package name */
    private final a f25532c = new a();

    /* renamed from: o3.b$a */
    public static final class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random c() {
        Object obj = this.f25532c.get();
        t.d(obj, "get(...)");
        return (Random) obj;
    }
}
