package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.core.widget.TextViewCompat;
import androidx.leanback.R;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
class StreamingTextView extends EditText {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.leanback.widget.StreamingTextView";
    static final boolean ANIMATE_DOTS_FOR_PENDING = true;
    private static final boolean DEBUG = false;
    private static final boolean DOTS_FOR_PENDING = true;
    private static final boolean DOTS_FOR_STABLE = false;
    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\S+");
    private static final Property<StreamingTextView, Integer> STREAM_POSITION_PROPERTY = new Property<StreamingTextView, Integer>(Integer.class, "streamPosition") {
        public Integer get(StreamingTextView streamingTextView) {
            return Integer.valueOf(streamingTextView.getStreamPosition());
        }

        public void set(StreamingTextView streamingTextView, Integer num) {
            streamingTextView.setStreamPosition(num.intValue());
        }
    };
    private static final long STREAM_UPDATE_DELAY_MILLIS = 50;
    private static final String TAG = "StreamingTextView";
    private static final float TEXT_DOT_SCALE = 1.3f;
    Bitmap mOneDot;
    final Random mRandom = new Random();
    int mStreamPosition;
    private ObjectAnimator mStreamingAnimation;
    Bitmap mTwoDot;

    private class DottySpan extends ReplacementSpan {
        private final int mPosition;
        private final int mSeed;

        public DottySpan(int i5, int i6) {
            this.mSeed = i5;
            this.mPosition = i6;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
            float f6;
            int measureText = (int) paint.measureText(charSequence, i5, i6);
            int width = StreamingTextView.this.mOneDot.getWidth();
            int i10 = width * 2;
            int i11 = measureText / i10;
            int i12 = (measureText % i10) / 2;
            boolean isLayoutRtl = StreamingTextView.isLayoutRtl(StreamingTextView.this);
            StreamingTextView.this.mRandom.setSeed((long) this.mSeed);
            int alpha = paint.getAlpha();
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = this.mPosition + i13;
                StreamingTextView streamingTextView = StreamingTextView.this;
                if (i14 >= streamingTextView.mStreamPosition) {
                    break;
                }
                float f7 = (float) ((i13 * i10) + i12 + (width / 2));
                if (isLayoutRtl) {
                    f6 = ((((float) measureText) + f5) - f7) - ((float) width);
                } else {
                    f6 = f5 + f7;
                }
                paint.setAlpha((streamingTextView.mRandom.nextInt(4) + 1) * 63);
                if (StreamingTextView.this.mRandom.nextBoolean()) {
                    Bitmap bitmap = StreamingTextView.this.mTwoDot;
                    canvas.drawBitmap(bitmap, f6, (float) (i8 - bitmap.getHeight()), paint);
                } else {
                    Bitmap bitmap2 = StreamingTextView.this.mOneDot;
                    canvas.drawBitmap(bitmap2, f6, (float) (i8 - bitmap2.getHeight()), paint);
                }
            }
            paint.setAlpha(alpha);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence, i5, i6);
        }
    }

    public StreamingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void addColorSpan(SpannableStringBuilder spannableStringBuilder, int i5, String str, int i6) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i6, str.length() + i6, 33);
    }

    private void addDottySpans(SpannableStringBuilder spannableStringBuilder, String str, int i5) {
        Matcher matcher = SPLIT_PATTERN.matcher(str);
        while (matcher.find()) {
            int start = matcher.start() + i5;
            spannableStringBuilder.setSpan(new DottySpan(str.charAt(matcher.start()), start), start, matcher.end() + i5, 33);
        }
    }

    private void cancelStreamAnimation() {
        ObjectAnimator objectAnimator = this.mStreamingAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private Bitmap getScaledBitmap(int i5, float f5) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i5);
        return Bitmap.createScaledBitmap(decodeResource, (int) (((float) decodeResource.getWidth()) * f5), (int) (((float) decodeResource.getHeight()) * f5), false);
    }

    public static boolean isLayoutRtl(View view) {
        if (1 == view.getLayoutDirection()) {
            return true;
        }
        return false;
    }

    private void startStreamAnimation() {
        cancelStreamAnimation();
        int streamPosition = getStreamPosition();
        int length = length();
        int i5 = length - streamPosition;
        if (i5 > 0) {
            if (this.mStreamingAnimation == null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                this.mStreamingAnimation = objectAnimator;
                objectAnimator.setTarget(this);
                this.mStreamingAnimation.setProperty(STREAM_POSITION_PROPERTY);
            }
            this.mStreamingAnimation.setIntValues(new int[]{streamPosition, length});
            this.mStreamingAnimation.setDuration(((long) i5) * STREAM_UPDATE_DELAY_MILLIS);
            this.mStreamingAnimation.start();
        }
    }

    private void updateText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    /* access modifiers changed from: package-private */
    public int getStreamPosition() {
        return this.mStreamPosition;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mOneDot = getScaledBitmap(R.drawable.lb_text_dot_one, TEXT_DOT_SCALE);
        this.mTwoDot = getScaledBitmap(R.drawable.lb_text_dot_two, TEXT_DOT_SCALE);
        reset();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void reset() {
        this.mStreamPosition = -1;
        cancelStreamAnimation();
        setText("");
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        updateText(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void setStreamPosition(int i5) {
        this.mStreamPosition = i5;
        invalidate();
    }

    public void updateRecognizedText(String str, List<Float> list) {
    }

    public void updateRecognizedText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(str2);
            addDottySpans(spannableStringBuilder, str2, length);
        }
        this.mStreamPosition = Math.max(str.length(), this.mStreamPosition);
        updateText(new SpannedString(spannableStringBuilder));
        startStreamAnimation();
    }

    public StreamingTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
