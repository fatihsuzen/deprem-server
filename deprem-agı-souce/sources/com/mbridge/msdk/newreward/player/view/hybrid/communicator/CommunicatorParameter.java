package com.mbridge.msdk.newreward.player.view.hybrid.communicator;

import android.webkit.WebView;
import androidx.annotation.NonNull;

public class CommunicatorParameter {
    private String path;
    private String query;
    private String scheme;
    private String token;
    private WebView webView;

    public CommunicatorParameter() {
    }

    public String getPath() {
        return this.path;
    }

    public String getQuery() {
        return this.query;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getToken() {
        return this.token;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setWebView(WebView webView2) {
        this.webView = webView2;
    }

    @NonNull
    public String toString() {
        return "CommunicatorParameter{webView=" + this.webView + ", scheme='" + this.scheme + '\'' + ", path='" + this.path + '\'' + ", token='" + this.token + '\'' + ", query='" + this.query + '\'' + '}';
    }

    public CommunicatorParameter(WebView webView2, String str, String str2, String str3, String str4) {
        this.webView = webView2;
        this.scheme = str;
        this.path = str2;
        this.token = str3;
        this.query = str4;
    }
}
