package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;
import java.util.Arrays;

public class KeyParser {

    private interface DataType {
        int get(int i5);
    }

    private interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i5 = 0; i5 < size; i5++) {
                CLKey cLKey = (CLKey) parse.get(i5);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i6 = ids.get(content);
                if (i6 == -1) {
                    PrintStream printStream = System.err;
                    printStream.println("unknown type " + content);
                } else {
                    int i7 = dataType.get(i6);
                    if (i7 == 1) {
                        typedBundle.add(i6, parse.getBoolean(i5));
                    } else if (i7 == 2) {
                        typedBundle.add(i6, value.getInt());
                        PrintStream printStream2 = System.out;
                        printStream2.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i7 == 4) {
                        typedBundle.add(i6, value.getFloat());
                        PrintStream printStream3 = System.out;
                        printStream3.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i7 == 8) {
                        typedBundle.add(i6, value.content());
                        PrintStream printStream4 = System.out;
                        printStream4.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
            }
            return typedBundle;
        } catch (CLParsingException e5) {
            PrintStream printStream5 = System.err;
            printStream5.println(e5.toString() + "\n" + Arrays.toString(e5.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
            return typedBundle;
        }
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new a(), new b());
    }
}
