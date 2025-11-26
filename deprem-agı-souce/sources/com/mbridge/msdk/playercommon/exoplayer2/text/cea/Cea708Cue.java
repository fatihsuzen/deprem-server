package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;

final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float f5, int i5, int i6, float f6, int i7, float f7, boolean z4, int i8, int i9) {
        super(charSequence, alignment, f5, i5, i6, f6, i7, f7, z4, i8);
        this.priority = i9;
    }

    public final int compareTo(@NonNull Cea708Cue cea708Cue) {
        int i5 = cea708Cue.priority;
        int i6 = this.priority;
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }
}
