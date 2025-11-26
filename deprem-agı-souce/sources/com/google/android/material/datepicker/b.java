package com.google.android.material.datepicker;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DateFormatTextWatcher f7034a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f7035b;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j5) {
        this.f7034a = dateFormatTextWatcher;
        this.f7035b = j5;
    }

    public final void run() {
        DateFormatTextWatcher.a(this.f7034a, this.f7035b);
    }
}
