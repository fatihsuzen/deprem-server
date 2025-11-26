package H;

import L.g;
import L.h;
import M.C0695o;
import N.C0722p;
import Q.a;
import Y.d;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final a f2492c = new a("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f2493a;

    /* renamed from: b  reason: collision with root package name */
    private final C0695o f2494b = new C0695o((L.f) null);

    public f(String str) {
        this.f2493a = C0722p.e(str);
    }

    public static g a(String str) {
        if (str == null) {
            return h.a(new Status(4), (L.f) null);
        }
        f fVar = new f(str);
        new Thread(fVar).start();
        return fVar.f2494b;
    }

    public final void run() {
        Status status = Status.f4851h;
        try {
            String str = this.f2493a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
            sb.append("https://accounts.google.com/o/oauth2/revoke?token=");
            sb.append(str);
            URL url = new URL(sb.toString());
            int i5 = d.f4484a;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f4849f;
            } else {
                f2492c.b("Unable to revoke access!", new Object[0]);
            }
            a aVar = f2492c;
            StringBuilder sb2 = new StringBuilder(String.valueOf(responseCode).length() + 15);
            sb2.append("Response Code: ");
            sb2.append(responseCode);
            aVar.a(sb2.toString(), new Object[0]);
        } catch (IOException e5) {
            f2492c.b("IOException when revoking access: ".concat(String.valueOf(e5.toString())), new Object[0]);
        } catch (Exception e6) {
            f2492c.b("Exception when revoking access: ".concat(String.valueOf(e6.toString())), new Object[0]);
        }
        this.f2494b.f(status);
    }
}
