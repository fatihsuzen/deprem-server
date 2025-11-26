package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import k3.r;

public final class TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ r $onTextChanged;

    public TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(r rVar) {
        this.$onTextChanged = rVar;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }
}
