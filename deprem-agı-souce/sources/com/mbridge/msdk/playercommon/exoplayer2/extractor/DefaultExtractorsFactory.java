package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.amr.AmrExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.flv.FlvExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Mp4Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.Ac3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.AdtsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final Constructor<? extends Extractor> FLAC_EXTRACTOR_CONSTRUCTOR;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;

    static {
        Constructor<? extends U> constructor = null;
        try {
            constructor = Class.forName("com.mbridge.msdk.playercommon.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor((Class[]) null);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e5) {
            throw new RuntimeException("Error instantiating FLAC extension", e5);
        }
        FLAC_EXTRACTOR_CONSTRUCTOR = constructor;
    }

    public final synchronized Extractor[] createExtractors() {
        int i5;
        Extractor[] extractorArr;
        Constructor<? extends Extractor> constructor = FLAC_EXTRACTOR_CONSTRUCTOR;
        if (constructor == null) {
            i5 = 12;
        } else {
            i5 = 13;
        }
        extractorArr = new Extractor[i5];
        extractorArr[0] = new MatroskaExtractor(this.matroskaFlags);
        extractorArr[1] = new FragmentedMp4Extractor(this.fragmentedMp4Flags);
        extractorArr[2] = new Mp4Extractor(this.mp4Flags);
        extractorArr[3] = new Mp3Extractor(this.mp3Flags);
        extractorArr[4] = new AdtsExtractor();
        extractorArr[5] = new Ac3Extractor();
        extractorArr[6] = new TsExtractor(this.tsMode, this.tsFlags);
        extractorArr[7] = new FlvExtractor();
        extractorArr[8] = new OggExtractor();
        extractorArr[9] = new PsExtractor();
        extractorArr[10] = new WavExtractor();
        extractorArr[11] = new AmrExtractor();
        if (constructor != null) {
            try {
                extractorArr[12] = (Extractor) constructor.newInstance((Object[]) null);
            } catch (Exception e5) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e5);
            }
        }
        return extractorArr;
    }

    public final synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i5) {
        this.fragmentedMp4Flags = i5;
        return this;
    }

    public final synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i5) {
        this.matroskaFlags = i5;
        return this;
    }

    public final synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i5) {
        this.mp3Flags = i5;
        return this;
    }

    public final synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i5) {
        this.mp4Flags = i5;
        return this;
    }

    public final synchronized DefaultExtractorsFactory setTsExtractorFlags(int i5) {
        this.tsFlags = i5;
        return this;
    }

    public final synchronized DefaultExtractorsFactory setTsExtractorMode(int i5) {
        this.tsMode = i5;
        return this;
    }
}
