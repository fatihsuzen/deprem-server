package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import k3.l;

public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ l $afterTextChanged;

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(l lVar) {
        this.$afterTextChanged = lVar;
    }

    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }
}
