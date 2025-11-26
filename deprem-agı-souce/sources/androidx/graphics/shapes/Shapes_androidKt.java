package androidx.graphics.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;
import kotlin.jvm.internal.t;

public final class Shapes_androidKt {
    private static final void pathFromCubics(Path path, List<? extends Cubic> list) {
        path.rewind();
        int size = list.size();
        boolean z4 = true;
        for (int i5 = 0; i5 < size; i5++) {
            Cubic cubic = (Cubic) list.get(i5);
            if (z4) {
                path.moveTo(cubic.getAnchor0X(), cubic.getAnchor0Y());
                z4 = false;
            }
            path.cubicTo(cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic.getAnchor1X(), cubic.getAnchor1Y());
        }
        path.close();
    }

    public static final Path toPath(RoundedPolygon roundedPolygon) {
        t.e(roundedPolygon, "<this>");
        return toPath$default(roundedPolygon, (Path) null, 1, (Object) null);
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            path = new Path();
        }
        return toPath(roundedPolygon, path);
    }

    public static final RoundedPolygon transformed(RoundedPolygon roundedPolygon, Matrix matrix) {
        t.e(roundedPolygon, "<this>");
        t.e(matrix, "matrix");
        return roundedPolygon.transformed(new Shapes_androidKt$transformed$1(new float[2], matrix));
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path) {
        t.e(roundedPolygon, "<this>");
        t.e(path, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        pathFromCubics(path, roundedPolygon.getCubics());
        return path;
    }

    public static /* synthetic */ Path toPath$default(Morph morph, float f5, Path path, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            path = new Path();
        }
        return toPath(morph, f5, path);
    }

    public static final Path toPath(Morph morph, float f5, Path path) {
        t.e(morph, "<this>");
        t.e(path, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        pathFromCubics(path, morph.asCubics(f5));
        return path;
    }
}
