package J;

import a0.C0995a;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import j$.util.Objects;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;

/* renamed from: J.c  reason: case insensitive filesystem */
public class C0647c {

    /* renamed from: h  reason: collision with root package name */
    private static int f2619h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f2620i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f2621j = G.f2613a;

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f2622k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap f2623a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f2624b;

    /* renamed from: c  reason: collision with root package name */
    private final E f2625c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f2626d;

    /* renamed from: e  reason: collision with root package name */
    private final Messenger f2627e;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f2628f;

    /* renamed from: g  reason: collision with root package name */
    private l f2629g;

    public C0647c(Context context) {
        this.f2624b = context;
        this.f2625c = new E(context);
        this.f2627e = new Messenger(new i(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2626d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ C1698l e(Bundle bundle) {
        if (m(bundle)) {
            return C1701o.e((Object) null);
        }
        return C1701o.e(bundle);
    }

    static /* bridge */ /* synthetic */ void g(C0647c cVar, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new k());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof l) {
                        cVar.f2629g = (l) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        cVar.f2628f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                        if (stringExtra2 == null) {
                            Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !Objects.equals(split[1], "ID")) {
                                Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            cVar.l(str, intent2.putExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2).getExtras());
                            return;
                        }
                        synchronized (cVar.f2623a) {
                            int i5 = 0;
                            while (i5 < cVar.f2623a.size()) {
                                try {
                                    cVar.l((String) cVar.f2623a.keyAt(i5), intent2.getExtras());
                                    i5++;
                                } finally {
                                }
                            }
                        }
                        return;
                    }
                    Matcher matcher = f2622k.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            cVar.l(group, extras);
                            return;
                        }
                        return;
                    } else if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    private final C1698l i(Bundle bundle) {
        String j5 = j();
        C1699m mVar = new C1699m();
        synchronized (this.f2623a) {
            this.f2623a.put(j5, mVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f2625c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        k(this.f2624b, intent);
        intent.putExtra("kid", "|ID|" + j5 + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f2627e);
        if (!(this.f2628f == null && this.f2629g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f2628f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f2629g.b(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            mVar.a().b(f2621j, new C0652h(this, j5, this.f2626d.schedule(new C0651g(mVar), 30, TimeUnit.SECONDS)));
            return mVar.a();
        }
        if (this.f2625c.b() == 2) {
            this.f2624b.sendBroadcast(intent);
        } else {
            this.f2624b.startService(intent);
        }
        mVar.a().b(f2621j, new C0652h(this, j5, this.f2626d.schedule(new C0651g(mVar), 30, TimeUnit.SECONDS)));
        return mVar.a();
    }

    private static synchronized String j() {
        String num;
        synchronized (C0647c.class) {
            int i5 = f2619h;
            f2619h = i5 + 1;
            num = Integer.toString(i5);
        }
        return num;
    }

    private static synchronized void k(Context context, Intent intent) {
        synchronized (C0647c.class) {
            try {
                if (f2620i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f2620i = PendingIntent.getBroadcast(context, 0, intent2, C0995a.f4506a);
                }
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, f2620i);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final void l(String str, Bundle bundle) {
        synchronized (this.f2623a) {
            try {
                C1699m mVar = (C1699m) this.f2623a.remove(str);
                if (mVar == null) {
                    Log.w("Rpc", "Missing callback for " + str);
                    return;
                }
                mVar.c(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean m(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("google.messenger")) {
            return false;
        }
        return true;
    }

    public C1698l a() {
        if (this.f2625c.a() >= 241100000) {
            return D.b(this.f2624b).d(5, Bundle.EMPTY).g(f2621j, C0650f.f2631a);
        }
        return C1701o.d(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public C1698l b(C0645a aVar) {
        if (this.f2625c.a() < 233700000) {
            return C1701o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", aVar.d());
        Integer f5 = aVar.f();
        if (f5 != null) {
            bundle.putInt("google.product_id", f5.intValue());
        }
        return D.b(this.f2624b).c(3, bundle);
    }

    public C1698l c(Bundle bundle) {
        if (this.f2625c.a() >= 12000000) {
            return D.b(this.f2624b).d(1, bundle).g(f2621j, C0649e.f2630a);
        }
        if (this.f2625c.b() != 0) {
            return i(bundle).h(f2621j, new H(this, bundle));
        }
        return C1701o.d(new IOException("MISSING_INSTANCEID_SERVICE"));
    }

    public C1698l d(boolean z4) {
        if (this.f2625c.a() < 241100000) {
            return C1701o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z4);
        return D.b(this.f2624b).c(4, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1698l f(Bundle bundle, C1698l lVar) {
        if (lVar.n() && m((Bundle) lVar.j())) {
            return i(bundle).o(f2621j, F.f2612a);
        }
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, C1698l lVar) {
        synchronized (this.f2623a) {
            this.f2623a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
