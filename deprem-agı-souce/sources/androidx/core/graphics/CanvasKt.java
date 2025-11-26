package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import k3.l;
import kotlin.jvm.internal.r;

public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f5, float f6, float f7, l lVar) {
        int save = canvas.save();
        canvas.rotate(f5, f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f5, float f6, float f7, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f5, f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int save = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withScale(Canvas canvas, float f5, float f6, float f7, float f8, l lVar) {
        int save = canvas.save();
        canvas.scale(f5, f6, f7, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f5, float f6, float f7, float f8, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 1.0f;
        }
        if ((i5 & 4) != 0) {
            f7 = 0.0f;
        }
        if ((i5 & 8) != 0) {
            f8 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f5, f6, f7, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f5, float f6, l lVar) {
        int save = canvas.save();
        canvas.skew(f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f5, float f6, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f5, float f6, l lVar) {
        int save = canvas.save();
        canvas.translate(f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f5, float f6, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, int i5, int i6, int i7, int i8, l lVar) {
        int save = canvas.save();
        canvas.clipRect(i5, i6, i7, i8);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, float f5, float f6, float f7, float f8, l lVar) {
        int save = canvas.save();
        canvas.clipRect(f5, f6, f7, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }
}
