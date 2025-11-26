package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.util.ArrayList;

public class Action {
    public static final long NO_ID = -1;
    private Drawable mIcon;
    private long mId;
    private ArrayList<Integer> mKeyCodes;
    private CharSequence mLabel1;
    private CharSequence mLabel2;

    public Action(long j5) {
        this(j5, "");
    }

    public final void addKeyCode(int i5) {
        this.mKeyCodes.add(Integer.valueOf(i5));
    }

    public final Drawable getIcon() {
        return this.mIcon;
    }

    public final long getId() {
        return this.mId;
    }

    public final CharSequence getLabel1() {
        return this.mLabel1;
    }

    public final CharSequence getLabel2() {
        return this.mLabel2;
    }

    public final void removeKeyCode(int i5) {
        this.mKeyCodes.remove(i5);
    }

    public final boolean respondsToKeyCode(int i5) {
        return this.mKeyCodes.contains(Integer.valueOf(i5));
    }

    public final void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public final void setId(long j5) {
        this.mId = j5;
    }

    public final void setLabel1(CharSequence charSequence) {
        this.mLabel1 = charSequence;
    }

    public final void setLabel2(CharSequence charSequence) {
        this.mLabel2 = charSequence;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mLabel1)) {
            sb.append(this.mLabel1);
        }
        if (!TextUtils.isEmpty(this.mLabel2)) {
            if (!TextUtils.isEmpty(this.mLabel1)) {
                sb.append(" ");
            }
            sb.append(this.mLabel2);
        }
        if (this.mIcon != null && sb.length() == 0) {
            sb.append("(action icon)");
        }
        return sb.toString();
    }

    public Action(long j5, CharSequence charSequence) {
        this(j5, charSequence, (CharSequence) null);
    }

    public Action(long j5, CharSequence charSequence, CharSequence charSequence2) {
        this(j5, charSequence, charSequence2, (Drawable) null);
    }

    public Action(long j5, CharSequence charSequence, CharSequence charSequence2, Drawable drawable) {
        this.mId = -1;
        this.mKeyCodes = new ArrayList<>();
        setId(j5);
        setLabel1(charSequence);
        setLabel2(charSequence2);
        setIcon(drawable);
    }
}
