package com.finazzi.distquake;

import android.content.DialogInterface;
import com.finazzi.distquake.FragmentNetwork;

public final /* synthetic */ class J implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentNetwork.c f13250a;

    public /* synthetic */ J(FragmentNetwork.c cVar) {
        this.f13250a = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i8) {
        FragmentNetwork.c.a(this.f13250a, dialogInterface, i8);
    }
}
