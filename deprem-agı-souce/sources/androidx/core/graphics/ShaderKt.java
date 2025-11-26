package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import k3.l;

public final class ShaderKt {
    public static final void transform(Shader shader, l lVar) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
