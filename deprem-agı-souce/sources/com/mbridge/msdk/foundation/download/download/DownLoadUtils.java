package com.mbridge.msdk.foundation.download.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ap;

public class DownLoadUtils {
    private static final int DOWNLOAD_CONNECTION_TIME_OUT = 20000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    public static final String END_TAG = "<mbridgeloadend></mbridgeloadend>";
    private static final String TAG = "DownLoadUtils";

    public static void getSourceCodeFromNetUrl(final String str, final H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source, final boolean z4) {
        try {
            if (!ap.a(str)) {
                if (URLUtil.isNetworkUrl(str)) {
                    DownloadTask.getInstance().runTask(new a() {
                        public final void cancelTask() {
                        }

                        public final void pauseTask(boolean z4) {
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.ByteArrayOutputStream} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: byte[]} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: byte[]} */
                        /* JADX WARNING: type inference failed for: r7v2 */
                        /* JADX WARNING: Failed to insert additional move for type inference */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:100:0x0158 A[Catch:{ Exception -> 0x0154 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:58:0x00e0 A[SYNTHETIC, Splitter:B:58:0x00e0] */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5 A[Catch:{ Exception -> 0x00af }] */
                        /* JADX WARNING: Removed duplicated region for block: B:63:0x00ea A[SYNTHETIC, Splitter:B:63:0x00ea] */
                        /* JADX WARNING: Removed duplicated region for block: B:79:0x0113 A[Catch:{ all -> 0x00fb }] */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x011d A[Catch:{ all -> 0x00fb }] */
                        /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A[SYNTHETIC, Splitter:B:95:0x0150] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void runTask() {
                            /*
                                r11 = this;
                                java.lang.String r0 = "DownLoadUtils"
                                r1 = 0
                                r2 = 0
                                com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source r3 = r3     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                if (r3 == 0) goto L_0x0017
                                r3.onStart()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                goto L_0x0017
                            L_0x000c:
                                r0 = move-exception
                                r6 = r1
                                goto L_0x014e
                            L_0x0010:
                                r3 = move-exception
                                r4 = r1
                                r5 = r4
                            L_0x0013:
                                r6 = r5
                                r7 = r6
                                goto L_0x00c2
                            L_0x0017:
                                java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.String r4 = r2     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r3.<init>(r4)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r4 = 30000(0x7530, float:4.2039E-41)
                                r3.setReadTimeout(r4)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r4 = 20000(0x4e20, float:2.8026E-41)
                                r3.setConnectTimeout(r4)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5.<init>()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.String r6 = "response code "
                                r5.append(r6)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5.append(r4)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5 = 200(0xc8, float:2.8E-43)
                                if (r4 != r5) goto L_0x0090
                                java.io.InputStream r4 = r3.getInputStream()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5 = 6144(0x1800, float:8.61E-42)
                                byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x008d, all -> 0x008a }
                                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x008d, all -> 0x008a }
                                r6.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x008a }
                            L_0x0057:
                                int r7 = r4.read(r5)     // Catch:{ Exception -> 0x0066 }
                                r8 = -1
                                if (r7 == r8) goto L_0x006b
                                r6.write(r5, r2, r7)     // Catch:{ Exception -> 0x0066 }
                                goto L_0x0057
                            L_0x0062:
                                r0 = move-exception
                            L_0x0063:
                                r1 = r4
                                goto L_0x014e
                            L_0x0066:
                                r3 = move-exception
                                r5 = r1
                                r7 = r5
                                goto L_0x00c2
                            L_0x006b:
                                byte[] r5 = r6.toByteArray()     // Catch:{ Exception -> 0x0066 }
                                if (r5 == 0) goto L_0x0084
                                byte[] r5 = r6.toByteArray()     // Catch:{ Exception -> 0x0066 }
                                boolean r7 = r4     // Catch:{ Exception -> 0x007f }
                                if (r7 != 0) goto L_0x0082
                                java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x007f }
                                r7.<init>(r5)     // Catch:{ Exception -> 0x007f }
                                goto L_0x0086
                            L_0x007f:
                                r3 = move-exception
                                r7 = r1
                                goto L_0x00c2
                            L_0x0082:
                                r7 = r1
                                goto L_0x0086
                            L_0x0084:
                                r5 = r1
                                r7 = r5
                            L_0x0086:
                                java.lang.String r8 = ""
                                r9 = 1
                                goto L_0x00a6
                            L_0x008a:
                                r0 = move-exception
                                r6 = r1
                                goto L_0x0063
                            L_0x008d:
                                r3 = move-exception
                                r5 = r1
                                goto L_0x0013
                            L_0x0090:
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5.<init>()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.String r6 = "responseCode is "
                                r5.append(r6)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r5.append(r4)     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x0010, all -> 0x000c }
                                r4 = r1
                                r5 = r4
                                r6 = r5
                                r7 = r6
                                r9 = r2
                            L_0x00a6:
                                r3.disconnect()     // Catch:{ Exception -> 0x00c1 }
                                if (r4 == 0) goto L_0x00b1
                                r4.close()     // Catch:{ Exception -> 0x00af }
                                goto L_0x00b1
                            L_0x00af:
                                r0 = move-exception
                                goto L_0x00b7
                            L_0x00b1:
                                if (r6 == 0) goto L_0x00bf
                                r6.close()     // Catch:{ Exception -> 0x00af }
                                goto L_0x00bf
                            L_0x00b7:
                                r0.printStackTrace()
                                java.lang.String r8 = r0.getMessage()
                                goto L_0x00e8
                            L_0x00bf:
                                r2 = r9
                                goto L_0x00e8
                            L_0x00c1:
                                r3 = move-exception
                            L_0x00c2:
                                java.lang.String r8 = r3.getMessage()     // Catch:{ all -> 0x0062 }
                                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
                                r9.<init>()     // Catch:{ all -> 0x0062 }
                                java.lang.String r10 = "getStringFromUrl failed "
                                r9.append(r10)     // Catch:{ all -> 0x0062 }
                                java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0062 }
                                r9.append(r3)     // Catch:{ all -> 0x0062 }
                                java.lang.String r3 = r9.toString()     // Catch:{ all -> 0x0062 }
                                com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ all -> 0x0062 }
                                if (r4 == 0) goto L_0x00e3
                                r4.close()     // Catch:{ Exception -> 0x00af }
                            L_0x00e3:
                                if (r6 == 0) goto L_0x00e8
                                r6.close()     // Catch:{ Exception -> 0x00af }
                            L_0x00e8:
                                if (r2 == 0) goto L_0x00fd
                                boolean r0 = r4     // Catch:{ all -> 0x00fb }
                                if (r0 == 0) goto L_0x00fd
                                if (r5 == 0) goto L_0x00fd
                                int r0 = r5.length     // Catch:{ all -> 0x00fb }
                                if (r0 <= 0) goto L_0x00fd
                                com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source r0 = r3     // Catch:{ all -> 0x00fb }
                                java.lang.String r2 = r2     // Catch:{ all -> 0x00fb }
                                r0.onSuccess(r1, r5, r2)     // Catch:{ all -> 0x00fb }
                                goto L_0x014d
                            L_0x00fb:
                                r0 = move-exception
                                goto L_0x0136
                            L_0x00fd:
                                if (r2 == 0) goto L_0x011d
                                boolean r0 = com.mbridge.msdk.foundation.tools.ap.b(r7)     // Catch:{ all -> 0x00fb }
                                if (r0 == 0) goto L_0x011d
                                int r0 = r7.length()     // Catch:{ all -> 0x00fb }
                                if (r0 <= 0) goto L_0x011d
                                java.lang.String r0 = "<mbridgeloadend></mbridgeloadend>"
                                boolean r0 = r7.contains(r0)     // Catch:{ all -> 0x00fb }
                                if (r0 == 0) goto L_0x011d
                                com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source r0 = r3     // Catch:{ all -> 0x00fb }
                                if (r0 == 0) goto L_0x014d
                                java.lang.String r1 = r2     // Catch:{ all -> 0x00fb }
                                r0.onSuccess(r7, r5, r1)     // Catch:{ all -> 0x00fb }
                                goto L_0x014d
                            L_0x011d:
                                com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source r0 = r3     // Catch:{ all -> 0x00fb }
                                if (r0 == 0) goto L_0x014d
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
                                r1.<init>()     // Catch:{ all -> 0x00fb }
                                java.lang.String r2 = "content write failed:"
                                r1.append(r2)     // Catch:{ all -> 0x00fb }
                                r1.append(r8)     // Catch:{ all -> 0x00fb }
                                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fb }
                                r0.onFailed(r1)     // Catch:{ all -> 0x00fb }
                                goto L_0x014d
                            L_0x0136:
                                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                                if (r1 == 0) goto L_0x013d
                                r0.printStackTrace()
                            L_0x013d:
                                com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source r1 = r3
                                if (r1 == 0) goto L_0x014d
                                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0149 }
                                r1.onFailed(r0)     // Catch:{ Exception -> 0x0149 }
                                goto L_0x014d
                            L_0x0149:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x014d:
                                return
                            L_0x014e:
                                if (r1 == 0) goto L_0x0156
                                r1.close()     // Catch:{ Exception -> 0x0154 }
                                goto L_0x0156
                            L_0x0154:
                                r1 = move-exception
                                goto L_0x015c
                            L_0x0156:
                                if (r6 == 0) goto L_0x0162
                                r6.close()     // Catch:{ Exception -> 0x0154 }
                                goto L_0x0162
                            L_0x015c:
                                r1.printStackTrace()
                                r1.getMessage()
                            L_0x0162:
                                throw r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.download.DownLoadUtils.AnonymousClass1.runTask():void");
                        }
                    });
                    return;
                }
            }
            if (iOnDownLoadH5Source != null) {
                iOnDownLoadH5Source.onFailed("url is error");
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
