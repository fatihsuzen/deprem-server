package com.mbridge.msdk.newreward.player.view.hybrid.client;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;
import java.lang.reflect.Method;

public class MBWebChromeClient extends WebChromeClient {
    private final String TAG = "MBWebChromeViewClient";
    private WebViewEventListener mEventListener;
    private HybridCommunicator mMBCommunicator;
    private MBWebView mWebView;

    private void findAndCallClassMethod(HybridCommunicator hybridCommunicator, CommunicatorParameter communicatorParameter) {
        if (hybridCommunicator != null) {
            try {
                Method method = null;
                for (Method method2 : hybridCommunicator.getClass().getMethods()) {
                    if (method2.getName().equals("callNotSupportMethod")) {
                        method = method2;
                    }
                    if (method2.getName().equals(communicatorParameter.getPath())) {
                        Class[] parameterTypes = method2.getParameterTypes();
                        if (parameterTypes.length == 1 && parameterTypes[0].isInstance(communicatorParameter)) {
                            method2.invoke(hybridCommunicator, new Object[]{communicatorParameter});
                            return;
                        }
                    }
                }
                if (method != null) {
                    method.invoke(hybridCommunicator, new Object[]{communicatorParameter});
                }
            } catch (Throwable th) {
                af.b("MBWebChromeViewClient", th.getMessage());
            }
        }
    }

    private String getUriToken(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split(":");
            if (!TextUtils.isEmpty(split[2])) {
                String[] split2 = split[2].split("/");
                if (!TextUtils.isEmpty(split2[0])) {
                    return split2[0];
                }
            }
            return "";
        } catch (Throwable th) {
            af.b("MBWebChromeViewClient", th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A[Catch:{ all -> 0x0014 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onReceiveMessage(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r1 = "MBWebChromeViewClient"
            r2 = 0
            java.lang.String r0 = "mv:"
            boolean r0 = r11.startsWith(r0)     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "mraid:"
            boolean r0 = r11.startsWith(r0)     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x00ab
            goto L_0x0018
        L_0x0014:
            r0 = move-exception
            r11 = r0
            goto L_0x00a4
        L_0x0018:
            java.lang.String r0 = "wv_hybrid:"
            boolean r0 = r11.contains(r0)     // Catch:{ all -> 0x0014 }
            r3 = 1
            java.lang.String r4 = " "
            if (r0 == 0) goto L_0x002c
            int r0 = r11.lastIndexOf(r4)     // Catch:{ all -> 0x0014 }
            int r0 = r0 + r3
            java.lang.String r11 = r11.substring(r2, r0)     // Catch:{ all -> 0x0014 }
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r0.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r5 = "onConsoleMessage: message.length() = "
            r0.append(r5)     // Catch:{ all -> 0x0014 }
            int r5 = r11.length()     // Catch:{ all -> 0x0014 }
            r0.append(r5)     // Catch:{ all -> 0x0014 }
            r0.append(r4)     // Catch:{ all -> 0x0014 }
            r0.append(r11)     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0014 }
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x00a3
            android.net.Uri r0 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = r0.getScheme()     // Catch:{ all -> 0x0014 }
            java.lang.String r8 = r10.getUriToken(r11)     // Catch:{ all -> 0x0014 }
            java.lang.String r11 = r0.getLastPathSegment()     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "mraid"
            if (r6 == 0) goto L_0x006e
            boolean r5 = r6.equals(r4)     // Catch:{ all -> 0x0014 }
            if (r5 == 0) goto L_0x006e
            java.lang.String r11 = r0.getHost()     // Catch:{ all -> 0x0014 }
        L_0x006e:
            r7 = r11
            java.lang.String r11 = r0.getEncodedQuery()     // Catch:{ all -> 0x0014 }
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0014 }
            if (r5 != 0) goto L_0x00a2
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0014 }
            if (r5 == 0) goto L_0x0080
            goto L_0x00a2
        L_0x0080:
            boolean r4 = j$.util.Objects.equals(r6, r4)     // Catch:{ all -> 0x0014 }
            if (r4 == 0) goto L_0x0092
            java.lang.String r0 = com.mbridge.msdk.newreward.player.view.hybrid.util.MBHybridUtil.getQueryParameters(r0)     // Catch:{ all -> 0x0014 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x0092
            r9 = r0
            goto L_0x0093
        L_0x0092:
            r9 = r11
        L_0x0093:
            com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter r4 = new com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r5 = r10.mWebView     // Catch:{ all -> 0x0014 }
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator r11 = r10.mMBCommunicator     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x00a3
            r10.findAndCallClassMethod(r11, r4)     // Catch:{ all -> 0x0014 }
            goto L_0x00a3
        L_0x00a2:
            return r2
        L_0x00a3:
            return r3
        L_0x00a4:
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r11)
        L_0x00ab:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.hybrid.client.MBWebChromeClient.onReceiveMessage(java.lang.String):boolean");
    }

    public HybridCommunicator getHybridCommunicator() {
        return this.mMBCommunicator;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        if (TextUtils.isEmpty(consoleMessage.message()) || !onReceiveMessage(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TextUtils.isEmpty(str2) || !onReceiveMessage(str2)) {
            return false;
        }
        jsPromptResult.confirm("");
        return true;
    }

    public void onProgressChanged(WebView webView, int i5) {
        super.onProgressChanged(webView, i5);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onProgressChanged(webView, i5);
        }
    }

    public void setHybridCommunicator(HybridCommunicator hybridCommunicator) {
        this.mMBCommunicator = hybridCommunicator;
    }

    public void setWeView(MBWebView mBWebView) {
        this.mWebView = mBWebView;
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.mEventListener = webViewEventListener;
    }
}
