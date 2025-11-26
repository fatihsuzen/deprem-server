package com.google.android.material.textfield;

import android.text.StaticLayout;
import com.google.android.material.internal.StaticLayoutBuilderConfigurer;

public final /* synthetic */ class x implements StaticLayoutBuilderConfigurer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f7132a;

    public /* synthetic */ x(TextInputLayout textInputLayout) {
        this.f7132a = textInputLayout;
    }

    public final void configure(StaticLayout.Builder builder) {
        builder.setBreakStrategy(this.f7132a.placeholderTextView.getBreakStrategy());
    }
}
