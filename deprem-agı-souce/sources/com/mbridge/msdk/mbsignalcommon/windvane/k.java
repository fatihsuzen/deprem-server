package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;

public final class k extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    WindVaneWebView f10243a;

    /* renamed from: b  reason: collision with root package name */
    private d f10244b;

    public k(WindVaneWebView windVaneWebView) {
        this.f10243a = windVaneWebView;
    }

    public final void a(d dVar) {
        this.f10244b = dVar;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        c signalCommunication = this.f10243a.getSignalCommunication();
        if (signalCommunication != null) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            af.a("H5_ENTRY", "onConsoleMessage: message.length() = " + message.length() + " " + message);
            if (message.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                String substring = message.substring(0, message.lastIndexOf(" ") + 1);
                af.a("H5_ENTRY", "message = " + substring);
                signalCommunication.b(substring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        af.b("H5_ENTRY", str2 + "");
        c signalCommunication = this.f10243a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    public final void onProgressChanged(WebView webView, int i5) {
        super.onProgressChanged(webView, i5);
        d dVar = this.f10244b;
        if (dVar != null) {
            dVar.b(webView, i5);
        }
    }
}
