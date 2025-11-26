package com.mbridge.msdk.foundation.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.fragment.BaseFragment;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.NativeListener;

public class WebViewFragment extends BaseFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BrowserView browserView = new BrowserView(getActivity());
        browserView.loadUrl(getActivity().getIntent().getExtras().getString(NotificationCompat.CATEGORY_MESSAGE));
        browserView.setListener(new BrowserView.a() {
            public final void a(WebView webView, int i5, String str, String str2) {
            }

            public final boolean b(WebView webView, String str) {
                return false;
            }

            public final void c(WebView webView, String str) {
            }

            public final void a(WebView webView, String str) {
            }

            public final void a() {
                WebViewFragment.this.getActivity().finish();
            }

            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (aj.a.b(str) && aj.a.a(WebViewFragment.this.getActivity().getApplicationContext(), str, (NativeListener.NativeTrackingListener) null)) {
                    WebViewFragment.this.getActivity().finish();
                }
            }
        });
        return browserView;
    }
}
