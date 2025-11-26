package K;

import N.C0722p;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: K.c  reason: case insensitive filesystem */
public class C0656c extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f2706a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f2707b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f2708c;

    public static C0656c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0656c cVar = new C0656c();
        Dialog dialog2 = (Dialog) C0722p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        cVar.f2706a = dialog2;
        if (onCancelListener != null) {
            cVar.f2707b = onCancelListener;
        }
        return cVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2707b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f2706a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f2708c == null) {
            this.f2708c = new AlertDialog.Builder((Context) C0722p.k(getActivity())).create();
        }
        return this.f2708c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
