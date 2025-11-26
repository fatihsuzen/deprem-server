package K;

import N.C0722p;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class o extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f2729a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f2730b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f2731c;

    public static o f(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        o oVar = new o();
        Dialog dialog2 = (Dialog) C0722p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        oVar.f2729a = dialog2;
        if (onCancelListener != null) {
            oVar.f2730b = onCancelListener;
        }
        return oVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f2730b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f2729a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f2731c == null) {
            this.f2731c = new AlertDialog.Builder((Context) C0722p.k(getContext())).create();
        }
        return this.f2731c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
