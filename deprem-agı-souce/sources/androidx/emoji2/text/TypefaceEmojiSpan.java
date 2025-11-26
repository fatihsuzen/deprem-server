package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TypefaceEmojiSpan extends EmojiSpan {
    @Nullable
    private static Paint sDebugPaint;
    @Nullable
    private TextPaint mWorkingPaint;

    public TypefaceEmojiSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        super(typefaceEmojiRasterizer);
    }

    @Nullable
    private TextPaint applyCharacterSpanStyles(@Nullable CharSequence charSequence, int i5, int i6, Paint paint) {
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i5, i6, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (!(characterStyleArr.length == 1 && characterStyleArr[0] == this)) {
                    TextPaint textPaint = this.mWorkingPaint;
                    if (textPaint == null) {
                        textPaint = new TextPaint();
                        this.mWorkingPaint = textPaint;
                    }
                    textPaint.set(paint);
                    for (CharacterStyle updateDrawState : characterStyleArr) {
                        updateDrawState.updateDrawState(textPaint);
                    }
                    return textPaint;
                }
            }
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        } else if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        } else {
            return null;
        }
    }

    @NonNull
    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            sDebugPaint = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }

    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @IntRange(from = 0) int i5, @IntRange(from = 0) int i6, float f5, int i7, int i8, int i9, @NonNull Paint paint) {
        int i10 = i7;
        int i11 = i9;
        Paint paint2 = paint;
        TextPaint applyCharacterSpanStyles = applyCharacterSpanStyles(charSequence, i5, i6, paint2);
        if (!(applyCharacterSpanStyles == null || applyCharacterSpanStyles.bgColor == 0)) {
            drawBackground(canvas, applyCharacterSpanStyles, f5, f5 + ((float) getWidth()), (float) i10, (float) i11);
        }
        TextPaint textPaint = applyCharacterSpanStyles;
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f5, (float) i10, f5 + ((float) getWidth()), (float) i11, getDebugPaint());
        }
        TypefaceEmojiRasterizer typefaceRasterizer = getTypefaceRasterizer();
        float f6 = (float) i8;
        if (textPaint == null) {
            textPaint = paint2;
        }
        typefaceRasterizer.draw(canvas, f5, f6, textPaint);
    }

    /* access modifiers changed from: package-private */
    public void drawBackground(Canvas canvas, TextPaint textPaint, float f5, float f6, float f7, float f8) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        float f9 = f8;
        TextPaint textPaint2 = textPaint;
        canvas.drawRect(f5, f7, f6, f9, textPaint2);
        textPaint2.setStyle(style);
        textPaint2.setColor(color);
    }
}
