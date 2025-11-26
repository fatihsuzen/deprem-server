package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {

    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i5, byte[] bArr) {
            this.language = str;
            this.type = i5;
            this.initializationData = bArr;
        }
    }

    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int i5, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> list2;
            this.streamType = i5;
            this.language = str;
            if (list == null) {
                list2 = Collections.EMPTY_LIST;
            } else {
                list2 = DesugarCollections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = list2;
            this.descriptorBytes = bArr;
        }
    }

    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i5, EsInfo esInfo);
    }

    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i5, int i6) {
            this(Integer.MIN_VALUE, i5, i6);
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public final void generateNewId() {
            int i5;
            int i6 = this.trackId;
            if (i6 == Integer.MIN_VALUE) {
                i5 = this.firstTrackId;
            } else {
                i5 = i6 + this.trackIdIncrement;
            }
            this.trackId = i5;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public final String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        public final int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public TrackIdGenerator(int i5, int i6, int i7) {
            String str;
            if (i5 != Integer.MIN_VALUE) {
                str = i5 + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i6;
            this.trackIdIncrement = i7;
            this.trackId = Integer.MIN_VALUE;
        }
    }

    void consume(ParsableByteArray parsableByteArray, boolean z4) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();
}
