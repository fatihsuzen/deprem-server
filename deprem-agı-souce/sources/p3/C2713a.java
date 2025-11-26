package p3;

import j$.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import kotlin.jvm.internal.t;
import o3.C2703a;

/* renamed from: p3.a  reason: case insensitive filesystem */
public final class C2713a extends C2703a {
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        t.d(current, "current(...)");
        return current;
    }
}
