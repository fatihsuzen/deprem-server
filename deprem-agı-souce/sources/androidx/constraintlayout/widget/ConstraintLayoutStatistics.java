package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.constraintlayout.core.Metrics;
import java.text.DecimalFormat;

public class ConstraintLayoutStatistics {
    public static final int DURATION_OF_CHILD_MEASURES = 5;
    public static final int DURATION_OF_LAYOUT = 7;
    public static final int DURATION_OF_MEASURES = 6;
    private static int MAX_WORD = 25;
    public static final int NUMBER_OF_CHILD_MEASURES = 4;
    public static final int NUMBER_OF_CHILD_VIEWS = 3;
    public static final int NUMBER_OF_EQUATIONS = 9;
    public static final int NUMBER_OF_LAYOUTS = 1;
    public static final int NUMBER_OF_ON_MEASURES = 2;
    public static final int NUMBER_OF_SIMPLE_EQUATIONS = 10;
    public static final int NUMBER_OF_VARIABLES = 8;
    private static final String WORD_PAD = new String(new char[25]).replace(0, ' ');
    ConstraintLayout mConstraintLayout;
    private final Metrics mMetrics;

    public ConstraintLayoutStatistics(ConstraintLayout constraintLayout) {
        this.mMetrics = new Metrics();
        attach(constraintLayout);
    }

    private String compare(DecimalFormat decimalFormat, ConstraintLayoutStatistics constraintLayoutStatistics, int i5) {
        String str = fmt(decimalFormat, ((float) getValue(i5)) * 1.0E-6f, 7) + " -> " + fmt(decimalFormat, ((float) constraintLayoutStatistics.getValue(i5)) * 1.0E-6f, 7) + "ms";
        String str2 = WORD_PAD + geName(i5);
        return "CL Perf: " + (str2.substring(str2.length() - MAX_WORD) + " = ") + str;
    }

    private String fmt(DecimalFormat decimalFormat, float f5, int i5) {
        String str = new String(new char[i5]).replace(0, ' ') + decimalFormat.format((double) f5);
        return str.substring(str.length() - i5);
    }

    @SuppressLint({"LogConditional"})
    private void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        Log.v(str, "CL Perf: --------  Performance .(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")  ------ ");
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        Log.v(str, log(decimalFormat, 5));
        Log.v(str, log(decimalFormat, 7));
        Log.v(str, log(decimalFormat, 6));
        Log.v(str, log(1));
        Log.v(str, log(2));
        Log.v(str, log(3));
        Log.v(str, log(4));
        Log.v(str, log(8));
        Log.v(str, log(9));
        Log.v(str, log(10));
    }

    public void attach(ConstraintLayout constraintLayout) {
        constraintLayout.fillMetrics(this.mMetrics);
        this.mConstraintLayout = constraintLayout;
    }

    public void detach() {
        ConstraintLayout constraintLayout = this.mConstraintLayout;
        if (constraintLayout != null) {
            constraintLayout.fillMetrics((Metrics) null);
        }
    }

    /* access modifiers changed from: package-private */
    public String geName(int i5) {
        switch (i5) {
            case 1:
                return "NumberOfLayouts";
            case 2:
                return "MeasureCalls";
            case 3:
                return "ChildCount";
            case 4:
                return "ChildrenMeasures";
            case 5:
                return "MeasuresWidgetsDuration ";
            case 6:
                return "MeasureDuration";
            case 7:
                return "MeasuresLayoutDuration";
            case 8:
                return "SolverVariables";
            case 9:
                return "SolverEquations";
            case 10:
                return "SimpleEquations";
            default:
                return "";
        }
    }

    public long getValue(int i5) {
        switch (i5) {
            case 1:
                return (long) this.mMetrics.mNumberOfLayouts;
            case 2:
                return this.mMetrics.mMeasureCalls;
            case 3:
                return this.mMetrics.mChildCount;
            case 4:
                return (long) this.mMetrics.mNumberOfMeasures;
            case 5:
                return this.mMetrics.measuresWidgetsDuration;
            case 6:
                return this.mMetrics.mMeasureDuration;
            case 7:
                return this.mMetrics.measuresLayoutDuration;
            case 8:
                return this.mMetrics.mVariables;
            case 9:
                return this.mMetrics.mEquations;
            case 10:
                return this.mMetrics.mSimpleEquations;
            default:
                return 0;
        }
    }

    public void logSummary(String str) {
        log(str);
    }

    public void reset() {
        this.mMetrics.reset();
    }

    public ConstraintLayoutStatistics clone() {
        return new ConstraintLayoutStatistics(this);
    }

    @SuppressLint({"LogConditional"})
    public void logSummary(String str, ConstraintLayoutStatistics constraintLayoutStatistics) {
        if (constraintLayoutStatistics == null) {
            log(str);
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###.000");
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        Log.v(str, "CL Perf: -=  Performance .(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")  =- ");
        Log.v(str, compare(decimalFormat, constraintLayoutStatistics, 5));
        Log.v(str, compare(decimalFormat, constraintLayoutStatistics, 7));
        Log.v(str, compare(decimalFormat, constraintLayoutStatistics, 6));
        Log.v(str, compare(constraintLayoutStatistics, 1));
        Log.v(str, compare(constraintLayoutStatistics, 2));
        Log.v(str, compare(constraintLayoutStatistics, 3));
        Log.v(str, compare(constraintLayoutStatistics, 4));
        Log.v(str, compare(constraintLayoutStatistics, 8));
        Log.v(str, compare(constraintLayoutStatistics, 9));
        Log.v(str, compare(constraintLayoutStatistics, 10));
    }

    public ConstraintLayoutStatistics(ConstraintLayoutStatistics constraintLayoutStatistics) {
        Metrics metrics = new Metrics();
        this.mMetrics = metrics;
        metrics.copy(constraintLayoutStatistics.mMetrics);
    }

    private String compare(ConstraintLayoutStatistics constraintLayoutStatistics, int i5) {
        String str = getValue(i5) + " -> " + constraintLayoutStatistics.getValue(i5);
        String str2 = WORD_PAD + geName(i5);
        return "CL Perf: " + (str2.substring(str2.length() - MAX_WORD) + " = ") + str;
    }

    private String log(DecimalFormat decimalFormat, int i5) {
        String fmt = fmt(decimalFormat, ((float) getValue(i5)) * 1.0E-6f, 7);
        String str = WORD_PAD + geName(i5);
        return "CL Perf: " + (str.substring(str.length() - MAX_WORD) + " = ") + fmt;
    }

    private String log(int i5) {
        String l5 = Long.toString(getValue(i5));
        String str = WORD_PAD + geName(i5);
        return "CL Perf: " + (str.substring(str.length() - MAX_WORD) + " = ") + l5;
    }
}
