package com.squareup.picasso;

import M1.b;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class f implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final w f13295a;

    /* renamed from: b  reason: collision with root package name */
    final WeakReference f13296b;

    /* renamed from: c  reason: collision with root package name */
    b f13297c;

    f(w wVar, ImageView imageView, b bVar) {
        this.f13295a = wVar;
        this.f13296b = new WeakReference(imageView);
        this.f13297c = bVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f13295a.b();
        this.f13297c = null;
        ImageView imageView = (ImageView) this.f13296b.get();
        if (imageView != null) {
            this.f13296b.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f13296b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f13296b.clear();
            this.f13295a.o().m(width, height).j(imageView, this.f13297c);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
