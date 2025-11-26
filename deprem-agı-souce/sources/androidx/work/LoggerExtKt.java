package androidx.work;

import k3.C2616a;
import kotlin.jvm.internal.t;

public final class LoggerExtKt {
    public static final void logd(String str, C2616a aVar) {
        t.e(str, "tag");
        t.e(aVar, "block");
        Logger.get().debug(str, (String) aVar.invoke());
    }

    public static final void loge(String str, C2616a aVar) {
        t.e(str, "tag");
        t.e(aVar, "block");
        Logger.get().error(str, (String) aVar.invoke());
    }

    public static final void logi(String str, C2616a aVar) {
        t.e(str, "tag");
        t.e(aVar, "block");
        Logger.get().info(str, (String) aVar.invoke());
    }

    public static final void logd(String str, Throwable th, C2616a aVar) {
        t.e(str, "tag");
        t.e(th, "t");
        t.e(aVar, "block");
        Logger.get().debug(str, (String) aVar.invoke(), th);
    }

    public static final void loge(String str, Throwable th, C2616a aVar) {
        t.e(str, "tag");
        t.e(th, "t");
        t.e(aVar, "block");
        Logger.get().error(str, (String) aVar.invoke(), th);
    }

    public static final void logi(String str, Throwable th, C2616a aVar) {
        t.e(str, "tag");
        t.e(th, "t");
        t.e(aVar, "block");
        Logger.get().info(str, (String) aVar.invoke(), th);
    }
}
