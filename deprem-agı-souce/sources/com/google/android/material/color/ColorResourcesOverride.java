package com.google.android.material.color;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ColorResourcesOverride {
    boolean applyIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);

    @NonNull
    Context wrapContextIfPossible(@NonNull Context context, @NonNull Map<Integer, Integer> map);
}
