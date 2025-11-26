package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        int i5;
        String str;
        if (isSet(32)) {
            return new SeiReader(this.closedCaptionFormats);
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> list = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                list = new ArrayList<>();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if ((readUnsignedByte3 & 128) != 0) {
                        i5 = readUnsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        i5 = 1;
                        str = MimeTypes.APPLICATION_CEA608;
                    }
                    list.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, readString, i5, (DrmInitData) null));
                    parsableByteArray.skipBytes(2);
                }
            }
            parsableByteArray.setPosition(position);
        }
        return new SeiReader(list);
    }

    private boolean isSet(int i5) {
        if ((i5 & this.flags) != 0) {
            return true;
        }
        return false;
    }

    public final SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    public final TsPayloadReader createPayloadReader(int i5, TsPayloadReader.EsInfo esInfo) {
        if (i5 == 2) {
            return new PesReader(new H262Reader());
        }
        if (i5 == 3 || i5 == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (i5 != 15) {
            if (i5 != 17) {
                if (i5 == 21) {
                    return new PesReader(new Id3Reader());
                }
                if (i5 != 27) {
                    if (i5 == 36) {
                        return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                    }
                    if (i5 == 89) {
                        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                    }
                    if (i5 != 138) {
                        if (i5 != 129) {
                            if (i5 != 130) {
                                if (i5 != 134) {
                                    if (i5 != 135) {
                                        return null;
                                    }
                                } else if (isSet(16)) {
                                    return null;
                                } else {
                                    return new SectionReader(new SpliceInfoSectionReader());
                                }
                            }
                        }
                        return new PesReader(new Ac3Reader(esInfo.language));
                    }
                    return new PesReader(new DtsReader(esInfo.language));
                } else if (isSet(4)) {
                    return null;
                } else {
                    return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                }
            } else if (isSet(2)) {
                return null;
            } else {
                return new PesReader(new LatmReader(esInfo.language));
            }
        } else if (isSet(2)) {
            return null;
        } else {
            return new PesReader(new AdtsReader(false, esInfo.language));
        }
    }

    public DefaultTsPayloadReaderFactory(int i5) {
        this(i5, Collections.EMPTY_LIST);
    }

    public DefaultTsPayloadReaderFactory(int i5, List<Format> list) {
        this.flags = i5;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat((String) null, MimeTypes.APPLICATION_CEA608, 0, (String) null));
        }
        this.closedCaptionFormats = list;
    }
}
