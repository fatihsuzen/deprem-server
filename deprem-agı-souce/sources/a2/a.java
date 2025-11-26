package A2;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.t;
import l2.M;
import m2.C2684d;
import org.json.JSONObject;
import t3.C2780d;
import z2.C2941C;
import z2.P;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private HttpsURLConnection f17258a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f17259b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17260c = "--";

    /* renamed from: d  reason: collision with root package name */
    private final String f17261d = ("SwA" + System.currentTimeMillis() + "SwA");

    /* renamed from: e  reason: collision with root package name */
    private long f17262e;

    public a(C2684d dVar) {
    }

    private final M g(Exception exc, M m5, String str) {
        m5.h(str);
        if (exc.getMessage() != null) {
            m5.i(exc.getMessage());
            return m5;
        }
        m5.i(exc.toString());
        return m5;
    }

    private final void l(String str, String str2) {
        OutputStream outputStream = this.f17259b;
        t.b(outputStream);
        Charset charset = C2780d.f25888b;
        byte[] bytes = (this.f17260c + this.f17261d + "\r\n").getBytes(charset);
        t.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        OutputStream outputStream2 = this.f17259b;
        t.b(outputStream2);
        byte[] bytes2 = "Content-Type: text/plain\r\n".getBytes(charset);
        t.d(bytes2, "getBytes(...)");
        outputStream2.write(bytes2);
        OutputStream outputStream3 = this.f17259b;
        t.b(outputStream3);
        byte[] bytes3 = ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes(charset);
        t.d(bytes3, "getBytes(...)");
        outputStream3.write(bytes3);
        OutputStream outputStream4 = this.f17259b;
        t.b(outputStream4);
        byte[] bytes4 = ("\r\n" + str2 + "\r\n").getBytes(charset);
        t.d(bytes4, "getBytes(...)");
        outputStream4.write(bytes4);
    }

    public final void a(String str, String str2, byte[] bArr, JSONObject jSONObject) {
        t.e(str, "paramName");
        t.e(str2, "fileName");
        t.e(bArr, "bytes");
        try {
            OutputStream outputStream = this.f17259b;
            t.b(outputStream);
            Charset charset = C2780d.f25888b;
            byte[] bytes = (this.f17260c + this.f17261d + "\r\n").getBytes(charset);
            t.d(bytes, "getBytes(...)");
            outputStream.write(bytes);
            OutputStream outputStream2 = this.f17259b;
            t.b(outputStream2);
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes(charset);
            t.d(bytes2, "getBytes(...)");
            outputStream2.write(bytes2);
            OutputStream outputStream3 = this.f17259b;
            t.b(outputStream3);
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            t.d(bytes3, "getBytes(...)");
            outputStream3.write(bytes3);
            OutputStream outputStream4 = this.f17259b;
            t.b(outputStream4);
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            t.d(bytes4, "getBytes(...)");
            outputStream4.write(bytes4);
            OutputStream outputStream5 = this.f17259b;
            t.b(outputStream5);
            byte[] bytes5 = "\r\n".getBytes(charset);
            t.d(bytes5, "getBytes(...)");
            outputStream5.write(bytes5);
            OutputStream outputStream6 = this.f17259b;
            t.b(outputStream6);
            outputStream6.write(bArr, 0, bArr.length);
            OutputStream outputStream7 = this.f17259b;
            t.b(outputStream7);
            byte[] bytes6 = "\r\n".getBytes(charset);
            t.d(bytes6, "getBytes(...)");
            outputStream7.write(bytes6);
        } catch (IOException unused) {
            OutputStream outputStream8 = this.f17259b;
            t.b(outputStream8);
            outputStream8.close();
        } catch (Exception unused2) {
            OutputStream outputStream9 = this.f17259b;
            t.b(outputStream9);
            outputStream9.close();
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = this.f17259b;
            t.b(outputStream10);
            outputStream10.close();
        }
    }

    public final long b(String str, String str2, String str3) {
        t.e(str, "paramName");
        t.e(str2, "fileName");
        long j5 = 0;
        try {
            OutputStream outputStream = this.f17259b;
            t.b(outputStream);
            Charset charset = C2780d.f25888b;
            byte[] bytes = (this.f17260c + this.f17261d + "\r\n").getBytes(charset);
            t.d(bytes, "getBytes(...)");
            outputStream.write(bytes);
            OutputStream outputStream2 = this.f17259b;
            t.b(outputStream2);
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes(charset);
            t.d(bytes2, "getBytes(...)");
            outputStream2.write(bytes2);
            OutputStream outputStream3 = this.f17259b;
            t.b(outputStream3);
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            t.d(bytes3, "getBytes(...)");
            outputStream3.write(bytes3);
            OutputStream outputStream4 = this.f17259b;
            t.b(outputStream4);
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            t.d(bytes4, "getBytes(...)");
            outputStream4.write(bytes4);
            OutputStream outputStream5 = this.f17259b;
            t.b(outputStream5);
            byte[] bytes5 = "\r\n".getBytes(charset);
            t.d(bytes5, "getBytes(...)");
            outputStream5.write(bytes5);
            FileInputStream fileInputStream = new FileInputStream(str3);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    OutputStream outputStream6 = this.f17259b;
                    t.b(outputStream6);
                    outputStream6.write(bArr, 0, read);
                    j5 += (long) read;
                } else {
                    fileInputStream.close();
                    OutputStream outputStream7 = this.f17259b;
                    t.b(outputStream7);
                    byte[] bytes6 = "\r\n".getBytes(C2780d.f25888b);
                    t.d(bytes6, "getBytes(...)");
                    outputStream7.write(bytes6);
                    return j5;
                }
            }
        } catch (OutOfMemoryError unused) {
            OutputStream outputStream8 = this.f17259b;
            if (outputStream8 != null) {
                outputStream8.close();
            }
            return 0;
        } catch (IOException unused2) {
            OutputStream outputStream9 = this.f17259b;
            if (outputStream9 != null) {
                outputStream9.close();
            }
            return 0;
        } catch (Exception unused3) {
            OutputStream outputStream10 = this.f17259b;
            if (outputStream10 != null) {
                outputStream10.close();
            }
            return 0;
        }
    }

    public final void c(String str, String str2) {
        t.e(str, "paramName");
        t.e(str2, "value");
        l(str, str2);
    }

    public final void d(URL url, String str) {
        t.e(url, "url");
        URLConnection openConnection = url.openConnection();
        t.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        this.f17258a = httpsURLConnection;
        t.b(httpsURLConnection);
        httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        HttpsURLConnection httpsURLConnection2 = this.f17258a;
        t.b(httpsURLConnection2);
        httpsURLConnection2.setReadTimeout(30000);
        HttpsURLConnection httpsURLConnection3 = this.f17258a;
        t.b(httpsURLConnection3);
        httpsURLConnection3.setConnectTimeout(30000);
        HttpsURLConnection httpsURLConnection4 = this.f17258a;
        t.b(httpsURLConnection4);
        httpsURLConnection4.setDoInput(true);
        HttpsURLConnection httpsURLConnection5 = this.f17258a;
        t.b(httpsURLConnection5);
        httpsURLConnection5.setDoOutput(true);
        HttpsURLConnection httpsURLConnection6 = this.f17258a;
        t.b(httpsURLConnection6);
        httpsURLConnection6.setRequestProperty("Connection", "Keep-Alive");
        HttpsURLConnection httpsURLConnection7 = this.f17258a;
        t.b(httpsURLConnection7);
        httpsURLConnection7.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f17261d);
        HttpsURLConnection httpsURLConnection8 = this.f17258a;
        t.b(httpsURLConnection8);
        httpsURLConnection8.setRequestProperty("Accept-Charset", "utf-8");
        HttpsURLConnection httpsURLConnection9 = this.f17258a;
        t.b(httpsURLConnection9);
        httpsURLConnection9.setRequestProperty("Accept", "application/json");
        HttpsURLConnection httpsURLConnection10 = this.f17258a;
        t.b(httpsURLConnection10);
        httpsURLConnection10.setRequestProperty("Identificador", "Uptodown_Android");
        HttpsURLConnection httpsURLConnection11 = this.f17258a;
        t.b(httpsURLConnection11);
        httpsURLConnection11.setRequestProperty("apk_file", str);
        HttpsURLConnection httpsURLConnection12 = this.f17258a;
        t.b(httpsURLConnection12);
        httpsURLConnection12.setRequestProperty("Identificador-Version", "694");
        HttpsURLConnection httpsURLConnection13 = this.f17258a;
        t.b(httpsURLConnection13);
        httpsURLConnection13.setRequestProperty("APIKEY", P.f26510a.d());
        C2941C c5 = C2941C.f26481a;
        HttpsURLConnection httpsURLConnection14 = this.f17258a;
        t.b(httpsURLConnection14);
        c5.a(httpsURLConnection14);
        HttpsURLConnection httpsURLConnection15 = this.f17258a;
        t.b(httpsURLConnection15);
        httpsURLConnection15.setFixedLengthStreamingMode((int) this.f17262e);
        HttpsURLConnection httpsURLConnection16 = this.f17258a;
        t.b(httpsURLConnection16);
        httpsURLConnection16.connect();
        HttpsURLConnection httpsURLConnection17 = this.f17258a;
        t.b(httpsURLConnection17);
        this.f17259b = httpsURLConnection17.getOutputStream();
    }

    public final void e() {
        OutputStream outputStream = this.f17259b;
        t.b(outputStream);
        byte[] bytes = (this.f17260c + this.f17261d + this.f17260c + "\r\n").getBytes(C2780d.f25888b);
        t.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        OutputStream outputStream2 = this.f17259b;
        t.b(outputStream2);
        outputStream2.close();
    }

    public final M f(boolean z4) {
        boolean z5;
        InputStream inputStream;
        M m5 = new M();
        try {
            HttpsURLConnection httpsURLConnection = this.f17258a;
            t.b(httpsURLConnection);
            int responseCode = httpsURLConnection.getResponseCode();
            m5.k(responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                HttpsURLConnection httpsURLConnection2 = this.f17258a;
                t.b(httpsURLConnection2);
                InputStream errorStream = httpsURLConnection2.getErrorStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection3 = this.f17258a;
                    t.b(httpsURLConnection3);
                    errorStream = httpsURLConnection3.getInputStream();
                }
                z5 = false;
            } else {
                HttpsURLConnection httpsURLConnection4 = this.f17258a;
                t.b(httpsURLConnection4);
                inputStream = httpsURLConnection4.getInputStream();
                if (inputStream == null) {
                    HttpsURLConnection httpsURLConnection5 = this.f17258a;
                    t.b(httpsURLConnection5);
                    inputStream = httpsURLConnection5.getErrorStream();
                }
                z5 = true;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            if (!z5 || !z4) {
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, C2780d.f25888b));
                }
                m5.i(sb.toString());
            } else {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                while (true) {
                    int read2 = inflaterInputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read2, C2780d.f25888b));
                }
                m5.i(sb.toString());
                inflaterInputStream.close();
            }
            inputStream.close();
            HttpsURLConnection httpsURLConnection6 = this.f17258a;
            t.b(httpsURLConnection6);
            httpsURLConnection6.disconnect();
            return m5;
        } catch (SocketTimeoutException e5) {
            return g(e5, m5, "SocketTimeoutException");
        } catch (IllegalStateException e6) {
            return g(e6, m5, "IllegalStateException");
        } catch (IllegalArgumentException e7) {
            return g(e7, m5, "IllegalArgumentException");
        } catch (SecurityException e8) {
            return g(e8, m5, "SecurityException");
        } catch (NullPointerException e9) {
            return g(e9, m5, "NullPointerException");
        } catch (MalformedURLException e10) {
            return g(e10, m5, "MalformedURLException");
        } catch (ProtocolException e11) {
            return g(e11, m5, "ProtocolException");
        } catch (SSLHandshakeException e12) {
            return g(e12, m5, "SSLHandshakeException");
        } catch (IOException e13) {
            return g(e13, m5, "IOException");
        }
    }

    public final void h(String str, String str2, byte[] bArr) {
        t.e(str, "paramName");
        t.e(str2, "fileName");
        t.e(bArr, "bytes");
        long j5 = this.f17262e;
        long length = j5 + ((long) (this.f17260c + this.f17261d + "\r\n").length());
        this.f17262e = length;
        long j6 = (long) 2;
        long length2 = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").length()) + ((long) 40) + ((long) 35) + j6;
        this.f17262e = length2;
        this.f17262e = length2 + ((long) bArr.length) + j6;
    }

    public final void i(String str, String str2, long j5) {
        t.e(str, "paramName");
        t.e(str2, "fileName");
        long j6 = this.f17262e;
        long length = j6 + ((long) (this.f17260c + this.f17261d + "\r\n").length());
        this.f17262e = length;
        long j7 = (long) 2;
        this.f17262e = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").length()) + ((long) 40) + ((long) 35) + j7 + j5 + j7;
    }

    public final void j() {
        long j5 = this.f17262e;
        this.f17262e = j5 + ((long) (this.f17260c + this.f17261d + this.f17260c + "\r\n").length());
    }

    public final void k(String str, String str2) {
        t.e(str, "paramName");
        t.e(str2, "value");
        long j5 = this.f17262e;
        long length = j5 + ((long) (this.f17260c + this.f17261d + "\r\n").length()) + ((long) 26);
        this.f17262e = length;
        long length2 = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").length());
        this.f17262e = length2;
        this.f17262e = length2 + ((long) ("\r\n" + str2 + "\r\n").length());
    }
}
