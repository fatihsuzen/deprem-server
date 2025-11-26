package androidx.core.view;

import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class ViewStructureCompat {
    private final Object mWrappedObj;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        @DoNotInline
        static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        @DoNotInline
        static void setDimens(ViewStructure viewStructure, int i5, int i6, int i7, int i8, int i9, int i10) {
            viewStructure.setDimens(i5, i6, i7, i8, i9, i10);
        }

        @DoNotInline
        static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    @RequiresApi(23)
    @NonNull
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(@NonNull String str) {
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i5, int i6, int i7, int i8, int i9, int i10) {
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, i5, i6, i7, i8, i9, i10);
    }

    public void setText(@NonNull CharSequence charSequence) {
        Api23Impl.setText((ViewStructure) this.mWrappedObj, charSequence);
    }

    @RequiresApi(23)
    @NonNull
    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
