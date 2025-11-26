package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f9726a;

    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z4);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f9726a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0092, code lost:
        if (r0 != 5) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A[SYNTHETIC, Splitter:B:47:0x00d7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x0181=Splitter:B:63:0x0181, B:45:0x00cb=Splitter:B:45:0x00cb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r16, java.lang.String r17, java.lang.String r18, com.mbridge.msdk.foundation.tools.o.a r19, com.mbridge.msdk.foundation.entity.CampaignEx r20) {
        /*
            r0 = r16
            r1 = r18
            r6 = r20
            r2 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = ""
            r8 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x001a
            goto L_0x018b
        L_0x001a:
            java.lang.String r4 = b(r16, r17, r18)     // Catch:{ Exception -> 0x001f }
            goto L_0x0020
        L_0x001f:
            r4 = r3
        L_0x0020:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.mbridge.msdk.foundation.same.b.c r10 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML
            java.lang.String r10 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r10)
            r5.append(r10)
            java.lang.String r10 = java.io.File.separator
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r5 = 0
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0044 }
            if (r11 != 0) goto L_0x0044
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0044 }
            r11.<init>(r10, r4)     // Catch:{ Exception -> 0x0044 }
            r5 = r11
        L_0x0044:
            if (r5 == 0) goto L_0x004c
            boolean r11 = r5.exists()
            if (r11 != 0) goto L_0x006c
        L_0x004c:
            java.lang.String r5 = ".xml"
            java.lang.String r5 = r4.replace(r5, r3)
            java.io.File r11 = new java.io.File
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            java.lang.String r13 = java.io.File.separator
            r12.append(r13)
            r12.append(r5)
            java.lang.String r5 = r12.toString()
            r11.<init>(r5, r4)
            r5 = r11
        L_0x006c:
            boolean r11 = r5.exists()     // Catch:{ Exception -> 0x0077 }
            if (r11 == 0) goto L_0x0077
            java.lang.String r5 = r5.getPath()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0078
        L_0x0077:
            r5 = r3
        L_0x0078:
            com.mbridge.msdk.foundation.same.report.d.e r11 = new com.mbridge.msdk.foundation.same.report.d.e
            r11.<init>()
            java.lang.String r12 = "scenes"
            java.lang.String r13 = "1"
            r11.a(r12, r13)
            java.lang.String r12 = "url"
            r11.a(r12, r1)
            java.lang.String r12 = "resource_type"
            if (r0 == 0) goto L_0x00a2
            if (r0 == r8) goto L_0x009e
            if (r0 == r2) goto L_0x0095
            r2 = 5
            if (r0 == r2) goto L_0x009e
            goto L_0x00a5
        L_0x0095:
            r2 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00a5 }
            r11.a(r12, r2)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00a5
        L_0x009e:
            r11.a(r12, r7)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00a5
        L_0x00a2:
            r11.a(r12, r9)     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r13 = "m_download_start"
            java.lang.String r14 = "cache"
            java.lang.String r15 = "DynamicViewResourceManager"
            if (r2 != 0) goto L_0x00d7
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto L_0x00d7
            if (r19 == 0) goto L_0x018b
            r3 = r4
            r4 = 0
            r2 = r5
            r5 = 1
            r0 = r19
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00cb
        L_0x00c3:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r15, r0)
        L_0x00cb:
            r11.a(r14, r9)     // Catch:{ Exception -> 0x018b }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x018b }
            r0.a((java.lang.String) r13, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.same.report.d.e) r11)     // Catch:{ Exception -> 0x018b }
            goto L_0x018b
        L_0x00d7:
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0172 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x0172 }
            r4 = 47
            int r4 = r2.lastIndexOf(r4)     // Catch:{ Exception -> 0x0172 }
            int r4 = r4 + r8
            java.lang.String r2 = r2.substring(r4)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = ".zip"
            java.lang.String r9 = r2.replace(r4, r3)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r3 = "test_zip_download "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0172 }
            r4.<init>()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r5 = "start download path： "
            r4.append(r5)     // Catch:{ Exception -> 0x0172 }
            r4.append(r10)     // Catch:{ Exception -> 0x0172 }
            r4.append(r2)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.DownloadMessage r1 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.DownloadResourceType r6 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x0177 }
            r5 = 100
            r3 = r18
            r4 = r2
            r2 = r20
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0174 }
            r6 = r2
            r2 = r4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0172 }
            r1.addExtra(r12, r0)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.MBDownloadManager r0 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.download(r1)     // Catch:{ Exception -> 0x0172 }
            int r1 = com.mbridge.msdk.foundation.same.a.f9202u     // Catch:{ Exception -> 0x0172 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withReadTimeout((long) r3)     // Catch:{ Exception -> 0x0172 }
            int r1 = com.mbridge.msdk.foundation.same.a.f9201t     // Catch:{ Exception -> 0x0172 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withConnectTimeout((long) r3)     // Catch:{ Exception -> 0x0172 }
            r3 = 60000(0xea60, double:2.9644E-319)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withTimeout(r3)     // Catch:{ Exception -> 0x0172 }
            int r1 = com.mbridge.msdk.foundation.same.a.f9200s     // Catch:{ Exception -> 0x0172 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withWriteTimeout(r3)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r1 = "download_scene"
            java.lang.String r3 = "download_dynamic_view"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.with(r1, r3)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.DownloadPriority r1 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withDownloadPriority(r1)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withHttpRetryCounter(r8)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r8 = r0.withDirectoryPathInternal(r10)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.tools.o$1 r0 = new com.mbridge.msdk.foundation.tools.o$1     // Catch:{ Exception -> 0x0172 }
            r4 = r18
            r3 = r19
            r5 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r8.withDownloadStateListener(r0)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r0.build()     // Catch:{ Exception -> 0x0172 }
            r0.start()     // Catch:{ Exception -> 0x0172 }
            goto L_0x0181
        L_0x0172:
            r0 = move-exception
            goto L_0x017a
        L_0x0174:
            r0 = move-exception
            r6 = r2
            goto L_0x017a
        L_0x0177:
            r0 = move-exception
            r6 = r20
        L_0x017a:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r15, r0)
        L_0x0181:
            r11.a(r14, r7)     // Catch:{ Exception -> 0x018b }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x018b }
            r0.a((java.lang.String) r13, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.same.report.d.e) r11)     // Catch:{ Exception -> 0x018b }
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(int, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.o$a, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private static String b(int i5, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                String path = new URL(str2).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    return substring.replace(".zip", "");
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    String replace = substring.replace(".zip", "");
                    List<String> list = f9726a;
                    if (list == null || list.contains(replace)) {
                        return "";
                    }
                    return replace;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(int i5, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = b(i5, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        String str4 = e.a(c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(str4, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str4 + File.separator + str3.replace(".xml", ""), str3);
        }
        return file.getPath();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            android.net.Uri r0 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "natmp"
            java.lang.String r0 = r0.getQueryParameter(r2)     // Catch:{ all -> 0x0022 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r0 = b(r11)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x002f
            return r1
        L_0x002f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca }
            r2.<init>()     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r3)     // Catch:{ Exception -> 0x00ca }
            r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x00ca }
            r2.append(r3)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ca }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00ca }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00ca }
            boolean r0 = r3.isFile()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x005c
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x005c
            java.lang.String r11 = r3.getPath()     // Catch:{ Exception -> 0x00ca }
            return r11
        L_0x005c:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00ca }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x00ca }
            r3 = 47
            int r3 = r0.lastIndexOf(r3)     // Catch:{ Exception -> 0x00ca }
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r8 = r0.substring(r3)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.DownloadMessage r5 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x00ca }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x00ca }
            r6.<init>()     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.DownloadResourceType r10 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x00ca }
            r9 = 100
            r7 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.MBDownloadManager r11 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.download(r5)     // Catch:{ Exception -> 0x00ca }
            int r0 = com.mbridge.msdk.foundation.same.a.f9202u     // Catch:{ Exception -> 0x00ca }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withReadTimeout((long) r5)     // Catch:{ Exception -> 0x00ca }
            int r0 = com.mbridge.msdk.foundation.same.a.f9196o     // Catch:{ Exception -> 0x00ca }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withConnectTimeout((long) r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = "download_scene"
            java.lang.String r3 = "download_dynamic_view"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.with(r0, r3)     // Catch:{ Exception -> 0x00ca }
            int r0 = com.mbridge.msdk.foundation.same.a.f9200s     // Catch:{ Exception -> 0x00ca }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withWriteTimeout(r5)     // Catch:{ Exception -> 0x00ca }
            r5 = 60000(0xea60, double:2.9644E-319)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withTimeout(r5)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.DownloadPriority r0 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadPriority(r0)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withHttpRetryCounter(r4)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDirectoryPathInternal(r2)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.tools.o$2 r0 = new com.mbridge.msdk.foundation.tools.o$2     // Catch:{ Exception -> 0x00ca }
            r0.<init>(r2, r8)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadStateListener(r0)     // Catch:{ Exception -> 0x00ca }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r11 = r11.build()     // Catch:{ Exception -> 0x00ca }
            r11.start()     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(java.lang.String):java.lang.String");
    }
}
