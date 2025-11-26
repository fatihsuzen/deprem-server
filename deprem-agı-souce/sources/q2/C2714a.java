package q2;

import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/* renamed from: q2.a  reason: case insensitive filesystem */
public final class C2714a {

    /* renamed from: a  reason: collision with root package name */
    public static final C2714a f25682a = new C2714a();

    public final String a() {
        DateFormat timeInstance = DateFormat.getTimeInstance();
        timeInstance.setTimeZone(DesugarTimeZone.getTimeZone("gmt"));
        timeInstance.format(new Date(System.currentTimeMillis()));
        Calendar calendar = timeInstance.getCalendar();
        int i5 = (calendar.get(12) * MBridgeCommon.DEFAULT_LOAD_TIMEOUT) + (calendar.get(13) * 1000);
        long timeInMillis = (calendar.getTimeInMillis() - ((long) (i5 + calendar.get(14)))) / ((long) 1000);
        C2724k kVar = C2724k.f25689a;
        return kVar.c("$(=a%·!45J&S" + timeInMillis);
    }

    public final String b() {
        return "https://secure.uptodown.com:443";
    }
}
