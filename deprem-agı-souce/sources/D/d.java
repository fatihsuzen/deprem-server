package D;

import W.i;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class d {
    public static final void a(String str) {
        HttpURLConnection httpURLConnection;
        try {
            i.b(263);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                Log.w("HttpUrlPinger", sb.toString());
            }
            httpURLConnection.disconnect();
            i.a();
        } catch (IndexOutOfBoundsException e5) {
            String message = e5.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            Log.w("HttpUrlPinger", sb2.toString(), e5);
            i.a();
        } catch (IOException | RuntimeException e6) {
            String message2 = e6.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
            sb3.append("Error while pinging URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message2);
            Log.w("HttpUrlPinger", sb3.toString(), e6);
            i.a();
        } catch (Throwable th) {
            i.a();
            throw th;
        }
    }
}
