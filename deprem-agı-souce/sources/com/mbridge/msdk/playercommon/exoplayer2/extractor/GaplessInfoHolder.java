package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.CommentFrame;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {
    private static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    private static final String GAPLESS_DESCRIPTION = "iTunSMPB";
    private static final String GAPLESS_DOMAIN = "com.apple.iTunes";
    public static final Id3Decoder.FramePredicate GAPLESS_INFO_ID3_FRAME_PREDICATE = new Id3Decoder.FramePredicate() {
        public final boolean evaluate(int i5, int i6, int i7, int i8, int i9) {
            if (i6 == 67 && i7 == 79 && i8 == 77) {
                return i9 == 77 || i5 == 2;
            }
            return false;
        }
    };
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    private boolean setFromComment(String str) {
        Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.encoderDelay = parseInt;
            this.encoderPadding = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean hasGaplessInfo() {
        if (this.encoderDelay == -1 || this.encoderPadding == -1) {
            return false;
        }
        return true;
    }

    public final boolean setFromMetadata(Metadata metadata) {
        for (int i5 = 0; i5 < metadata.length(); i5++) {
            Metadata.Entry entry = metadata.get(i5);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (GAPLESS_DESCRIPTION.equals(commentFrame.description) && setFromComment(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if (GAPLESS_DOMAIN.equals(internalFrame.domain) && GAPLESS_DESCRIPTION.equals(internalFrame.description) && setFromComment(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final boolean setFromXingHeaderValue(int i5) {
        int i6 = i5 >> 12;
        int i7 = i5 & 4095;
        if (i6 <= 0 && i7 <= 0) {
            return false;
        }
        this.encoderDelay = i6;
        this.encoderPadding = i7;
        return true;
    }
}
