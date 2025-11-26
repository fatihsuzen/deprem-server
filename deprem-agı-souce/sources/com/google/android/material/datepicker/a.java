package com.google.android.material.datepicker;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DateFormatTextWatcher f7032a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7033b;

    public /* synthetic */ a(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        this.f7032a = dateFormatTextWatcher;
        this.f7033b = str;
    }

    public final void run() {
        DateFormatTextWatcher.b(this.f7032a, this.f7033b);
    }
}
