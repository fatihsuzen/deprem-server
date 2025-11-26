package com.mbridge.msdk.playercommon.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
    private static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private static final String TAG = "SubripDecoder";
    private final StringBuilder textBuilder = new StringBuilder();

    public SubripDecoder() {
        super(TAG);
    }

    private static long parseTimecode(Matcher matcher, int i5) {
        return ((Long.parseLong(matcher.group(i5 + 1)) * 3600000) + (Long.parseLong(matcher.group(i5 + 2)) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + (Long.parseLong(matcher.group(i5 + 3)) * 1000) + Long.parseLong(matcher.group(i5 + 4))) * 1000;
    }

    /* access modifiers changed from: protected */
    public final SubripSubtitle decode(byte[] bArr, int i5, boolean z4) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i5);
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = parsableByteArray.readLine();
                    if (readLine2 == null) {
                        Log.w(TAG, "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine2);
                    if (matcher.matches()) {
                        boolean z5 = true;
                        longArray.add(parseTimecode(matcher, 1));
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            longArray.add(parseTimecode(matcher, 6));
                        } else {
                            z5 = false;
                        }
                        this.textBuilder.setLength(0);
                        while (true) {
                            String readLine3 = parsableByteArray.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br>");
                            }
                            this.textBuilder.append(readLine3.trim());
                        }
                        arrayList.add(new Cue(Html.fromHtml(this.textBuilder.toString())));
                        if (z5) {
                            arrayList.add((Object) null);
                        }
                    } else {
                        Log.w(TAG, "Skipping invalid timing: " + readLine2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(TAG, "Skipping invalid index: " + readLine);
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SubripSubtitle(cueArr, longArray.toArray());
    }
}
