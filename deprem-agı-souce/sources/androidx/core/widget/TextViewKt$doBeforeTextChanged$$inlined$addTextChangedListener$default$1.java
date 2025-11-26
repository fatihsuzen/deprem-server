package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import k3.r;

public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ r $beforeTextChanged;

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r rVar) {
        this.$beforeTextChanged = rVar;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }

    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }
}
