package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class MatroskaExtractor implements Extractor {
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    };
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    /* access modifiers changed from: private */
    public static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final byte[] SSA_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final byte[] SUBRIP_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    /* access modifiers changed from: private */
    public static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int[] blockLacingSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        private InnerEbmlReaderOutput() {
        }

        public final void binaryElement(int i5, int i6, ExtractorInput extractorInput) throws IOException, InterruptedException {
            MatroskaExtractor.this.binaryElement(i5, i6, extractorInput);
        }

        public final void endMasterElement(int i5) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i5);
        }

        public final void floatElement(int i5, double d5) throws ParserException {
            MatroskaExtractor.this.floatElement(i5, d5);
        }

        public final int getElementType(int i5) {
            switch (i5) {
                case MatroskaExtractor.ID_TRACK_TYPE /*131*/:
                case MatroskaExtractor.ID_FLAG_DEFAULT /*136*/:
                case 155:
                case MatroskaExtractor.ID_CHANNELS /*159*/:
                case MatroskaExtractor.ID_PIXEL_WIDTH /*176*/:
                case MatroskaExtractor.ID_CUE_TIME /*179*/:
                case MatroskaExtractor.ID_PIXEL_HEIGHT /*186*/:
                case MatroskaExtractor.ID_TRACK_NUMBER /*215*/:
                case MatroskaExtractor.ID_TIME_CODE /*231*/:
                case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /*241*/:
                case MatroskaExtractor.ID_REFERENCE_BLOCK /*251*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                case MatroskaExtractor.ID_DOC_TYPE_READ_VERSION /*17029*/:
                case MatroskaExtractor.ID_EBML_READ_VERSION /*17143*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING_ORDER /*20529*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING_SCOPE /*20530*/:
                case MatroskaExtractor.ID_SEEK_POSITION /*21420*/:
                case MatroskaExtractor.ID_STEREO_MODE /*21432*/:
                case MatroskaExtractor.ID_DISPLAY_WIDTH /*21680*/:
                case MatroskaExtractor.ID_DISPLAY_UNIT /*21682*/:
                case MatroskaExtractor.ID_DISPLAY_HEIGHT /*21690*/:
                case MatroskaExtractor.ID_FLAG_FORCED /*21930*/:
                case MatroskaExtractor.ID_COLOUR_RANGE /*21945*/:
                case MatroskaExtractor.ID_COLOUR_TRANSFER /*21946*/:
                case MatroskaExtractor.ID_COLOUR_PRIMARIES /*21947*/:
                case MatroskaExtractor.ID_MAX_CLL /*21948*/:
                case MatroskaExtractor.ID_MAX_FALL /*21949*/:
                case MatroskaExtractor.ID_CODEC_DELAY /*22186*/:
                case MatroskaExtractor.ID_SEEK_PRE_ROLL /*22203*/:
                case MatroskaExtractor.ID_AUDIO_BIT_DEPTH /*25188*/:
                case MatroskaExtractor.ID_DEFAULT_DURATION /*2352003*/:
                case MatroskaExtractor.ID_TIMECODE_SCALE /*2807729*/:
                    return 2;
                case 134:
                case MatroskaExtractor.ID_DOC_TYPE /*17026*/:
                case MatroskaExtractor.ID_LANGUAGE /*2274716*/:
                    return 3;
                case MatroskaExtractor.ID_BLOCK_GROUP /*160*/:
                case MatroskaExtractor.ID_TRACK_ENTRY /*174*/:
                case MatroskaExtractor.ID_CUE_TRACK_POSITIONS /*183*/:
                case MatroskaExtractor.ID_CUE_POINT /*187*/:
                case 224:
                case MatroskaExtractor.ID_AUDIO /*225*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS /*18407*/:
                case MatroskaExtractor.ID_SEEK /*19899*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION /*20532*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION /*20533*/:
                case MatroskaExtractor.ID_COLOUR /*21936*/:
                case MatroskaExtractor.ID_MASTERING_METADATA /*21968*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING /*25152*/:
                case MatroskaExtractor.ID_CONTENT_ENCODINGS /*28032*/:
                case MatroskaExtractor.ID_PROJECTION /*30320*/:
                case MatroskaExtractor.ID_SEEK_HEAD /*290298740*/:
                case 357149030:
                case MatroskaExtractor.ID_TRACKS /*374648427*/:
                case MatroskaExtractor.ID_SEGMENT /*408125543*/:
                case MatroskaExtractor.ID_EBML /*440786851*/:
                case MatroskaExtractor.ID_CUES /*475249515*/:
                case MatroskaExtractor.ID_CLUSTER /*524531317*/:
                    return 1;
                case MatroskaExtractor.ID_BLOCK /*161*/:
                case MatroskaExtractor.ID_SIMPLE_BLOCK /*163*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_SETTINGS /*16981*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_KEY_ID /*18402*/:
                case MatroskaExtractor.ID_SEEK_ID /*21419*/:
                case MatroskaExtractor.ID_CODEC_PRIVATE /*25506*/:
                case MatroskaExtractor.ID_PROJECTION_PRIVATE /*30322*/:
                    return 4;
                case MatroskaExtractor.ID_SAMPLING_FREQUENCY /*181*/:
                case MatroskaExtractor.ID_DURATION /*17545*/:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                case MatroskaExtractor.ID_LUMNINANCE_MAX /*21977*/:
                case MatroskaExtractor.ID_LUMNINANCE_MIN /*21978*/:
                    return 5;
                default:
                    return 0;
            }
        }

        public final void integerElement(int i5, long j5) throws ParserException {
            MatroskaExtractor.this.integerElement(i5, j5);
        }

        public final boolean isLevel1Element(int i5) {
            return i5 == 357149030 || i5 == MatroskaExtractor.ID_CLUSTER || i5 == MatroskaExtractor.ID_CUES || i5 == MatroskaExtractor.ID_TRACKS;
        }

        public final void startMasterElement(int i5, long j5, long j6) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i5, j5, j6);
        }

        public final void stringElement(int i5, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i5, str);
        }
    }

    private static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        /* access modifiers changed from: private */
        public String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        @Nullable
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0;
            this.seekPreRollNs = 0;
            this.flagDefault = true;
            this.language = "eng";
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((int) ((this.primaryRChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryRChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryGChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryGChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryBChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryBChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.whitePointChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.whitePointChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) (this.maxMasteringLuminance + 0.5f)));
            wrap.putShort((short) ((int) (this.minMasteringLuminance + 0.5f)));
            wrap.putShort((short) this.maxContentLuminance);
            wrap.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_H263, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] bArr = parsableByteArray.data;
                    for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort == MatroskaExtractor.WAVE_FORMAT_EXTENSIBLE) {
                    parsableByteArray.setPosition(24);
                    if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            byte b5;
            byte b6;
            try {
                if (bArr[0] == 2) {
                    int i5 = 0;
                    int i6 = 1;
                    while (true) {
                        b5 = bArr[i6];
                        if (b5 != -1) {
                            break;
                        }
                        i5 += 255;
                        i6++;
                    }
                    int i7 = i6 + 1;
                    int i8 = i5 + b5;
                    int i9 = 0;
                    while (true) {
                        b6 = bArr[i7];
                        if (b6 != -1) {
                            break;
                        }
                        i9 += 255;
                        i7++;
                    }
                    int i10 = i7 + 1;
                    int i11 = i9 + b6;
                    if (bArr[i10] == 1) {
                        byte[] bArr2 = new byte[i8];
                        System.arraycopy(bArr, i10, bArr2, 0, i8);
                        int i12 = i10 + i8;
                        if (bArr[i12] == 3) {
                            int i13 = i12 + i11;
                            if (bArr[i13] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i13)];
                                System.arraycopy(bArr, i13, bArr3, 0, bArr.length - i13);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0213, code lost:
            r27 = -1;
            r32 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0217, code lost:
            r29 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0219, code lost:
            r28 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0222, code lost:
            r27 = -1;
            r32 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x023a, code lost:
            r28 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0262, code lost:
            r29 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0265, code lost:
            r27 = r1;
            r32 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ea, code lost:
            r27 = -1;
            r29 = r15;
            r28 = null;
            r32 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0364, code lost:
            r1 = r0.flagDefault;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0368, code lost:
            if (r0.flagForced == false) goto L_0x036c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x036a, code lost:
            r5 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x036c, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x036e, code lost:
            r30 = r1 | r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0374, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isAudio(r29) == false) goto L_0x039a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0376, code lost:
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(java.lang.Integer.toString(r46), r29, (java.lang.String) null, -1, r32, r0.channelCount, r0.sampleRate, r27, r28, r0.drmInitData, r30, r0.language);
            r4 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x039a, code lost:
            r1 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a0, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isVideo(r29) == false) goto L_0x0411;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x03a4, code lost:
            if (r0.displayUnit != 0) goto L_0x03b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x03a6, code lost:
            r1 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x03a8, code lost:
            if (r1 != -1) goto L_0x03ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x03aa, code lost:
            r1 = r0.width;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x03ac, code lost:
            r0.displayWidth = r1;
            r1 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b0, code lost:
            if (r1 != -1) goto L_0x03b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b2, code lost:
            r1 = r0.height;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b4, code lost:
            r0.displayHeight = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x03b6, code lost:
            r1 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x03b8, code lost:
            if (r1 == -1) goto L_0x03ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x03ba, code lost:
            r2 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x03bc, code lost:
            if (r2 == -1) goto L_0x03ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x03be, code lost:
            r1 = ((float) (r0.height * r1)) / ((float) (r0.width * r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x03c7, code lost:
            r38 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x03ca, code lost:
            r1 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x03cf, code lost:
            if (r0.hasColorInfo == false) goto L_0x03e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x03d1, code lost:
            r41 = new com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo(r0.colorSpace, r0.colorRange, r0.colorTransfer, getHdrStaticInfo());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x03e2, code lost:
            r33 = r28;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x03e5, code lost:
            r41 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x03e8, code lost:
            r36 = r33;
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(java.lang.Integer.toString(r46), r29, (java.lang.String) null, -1, r32, r0.width, r0.height, -1.0f, r36, -1, r38, r0.projectionData, r0.stereoMode, r41, r0.drmInitData);
            r4 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0411, code lost:
            r15 = r29;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0417, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r15) == false) goto L_0x0428;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0419, code lost:
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(java.lang.Integer.toString(r46), r15, r1, r0.language, r0.drmInitData);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0425, code lost:
            r4 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x042c, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r15) == false) goto L_0x0461;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x042e, code lost:
            r2 = new java.util.ArrayList(2);
            r2.add(com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.access$300());
            r2.add(r0.codecPrivate);
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(java.lang.Integer.toString(r46), r15, (java.lang.String) null, -1, r1, r0.language, -1, r0.drmInitData, Long.MAX_VALUE, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0461, code lost:
            r30 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0467, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r15) != false) goto L_0x047e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x046d, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r15) != false) goto L_0x047e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0473, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r15) == false) goto L_0x0476;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x047d, code lost:
            throw new com.mbridge.msdk.playercommon.exoplayer2.ParserException("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x047e, code lost:
            r33 = r28;
            r28 = java.lang.Integer.toString(r46);
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createImageSampleFormat(r28, r15, (java.lang.String) null, -1, r30, r33, r0.language, r0.drmInitData);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x049b, code lost:
            r2 = r45.track(r0.number, r4);
            r0.output = r2;
            r2.format(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x04a8, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f8, code lost:
            r28 = r1;
            r32 = r3;
            r27 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x01fe, code lost:
            r29 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x020a, code lost:
            r28 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x020c, code lost:
            r27 = -1;
            r32 = -1;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void initializeOutput(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput r45, int r46) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
            /*
                r44 = this;
                r0 = r44
                java.lang.String r1 = r0.codecId
                r1.getClass()
                int r2 = r1.hashCode()
                r3 = 4
                r7 = 2
                r8 = 3
                r9 = -1
                switch(r2) {
                    case -2095576542: goto L_0x0186;
                    case -2095575984: goto L_0x017a;
                    case -1985379776: goto L_0x016e;
                    case -1784763192: goto L_0x0162;
                    case -1730367663: goto L_0x0156;
                    case -1482641358: goto L_0x014a;
                    case -1482641357: goto L_0x013e;
                    case -1373388978: goto L_0x0132;
                    case -933872740: goto L_0x0124;
                    case -538363189: goto L_0x0116;
                    case -538363109: goto L_0x0108;
                    case -425012669: goto L_0x00fa;
                    case -356037306: goto L_0x00ec;
                    case 62923557: goto L_0x00de;
                    case 62923603: goto L_0x00d0;
                    case 62927045: goto L_0x00c2;
                    case 82338133: goto L_0x00b4;
                    case 82338134: goto L_0x00a6;
                    case 99146302: goto L_0x0098;
                    case 444813526: goto L_0x008a;
                    case 542569478: goto L_0x007d;
                    case 725957860: goto L_0x0070;
                    case 738597099: goto L_0x0063;
                    case 855502857: goto L_0x0056;
                    case 1422270023: goto L_0x0049;
                    case 1809237540: goto L_0x003c;
                    case 1950749482: goto L_0x002f;
                    case 1950789798: goto L_0x0022;
                    case 1951062397: goto L_0x0015;
                    default: goto L_0x0012;
                }
            L_0x0012:
                r1 = r9
                goto L_0x0191
            L_0x0015:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x001e
                goto L_0x0012
            L_0x001e:
                r1 = 28
                goto L_0x0191
            L_0x0022:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002b
                goto L_0x0012
            L_0x002b:
                r1 = 27
                goto L_0x0191
            L_0x002f:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0038
                goto L_0x0012
            L_0x0038:
                r1 = 26
                goto L_0x0191
            L_0x003c:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0045
                goto L_0x0012
            L_0x0045:
                r1 = 25
                goto L_0x0191
            L_0x0049:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0052
                goto L_0x0012
            L_0x0052:
                r1 = 24
                goto L_0x0191
            L_0x0056:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x005f
                goto L_0x0012
            L_0x005f:
                r1 = 23
                goto L_0x0191
            L_0x0063:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x006c
                goto L_0x0012
            L_0x006c:
                r1 = 22
                goto L_0x0191
            L_0x0070:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0079
                goto L_0x0012
            L_0x0079:
                r1 = 21
                goto L_0x0191
            L_0x007d:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0086
                goto L_0x0012
            L_0x0086:
                r1 = 20
                goto L_0x0191
            L_0x008a:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0094
                goto L_0x0012
            L_0x0094:
                r1 = 19
                goto L_0x0191
            L_0x0098:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a2
                goto L_0x0012
            L_0x00a2:
                r1 = 18
                goto L_0x0191
            L_0x00a6:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b0
                goto L_0x0012
            L_0x00b0:
                r1 = 17
                goto L_0x0191
            L_0x00b4:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00be
                goto L_0x0012
            L_0x00be:
                r1 = 16
                goto L_0x0191
            L_0x00c2:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00cc
                goto L_0x0012
            L_0x00cc:
                r1 = 15
                goto L_0x0191
            L_0x00d0:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00da
                goto L_0x0012
            L_0x00da:
                r1 = 14
                goto L_0x0191
            L_0x00de:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00e8
                goto L_0x0012
            L_0x00e8:
                r1 = 13
                goto L_0x0191
            L_0x00ec:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00f6
                goto L_0x0012
            L_0x00f6:
                r1 = 12
                goto L_0x0191
            L_0x00fa:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0104
                goto L_0x0012
            L_0x0104:
                r1 = 11
                goto L_0x0191
            L_0x0108:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0112
                goto L_0x0012
            L_0x0112:
                r1 = 10
                goto L_0x0191
            L_0x0116:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0120
                goto L_0x0012
            L_0x0120:
                r1 = 9
                goto L_0x0191
            L_0x0124:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x012e
                goto L_0x0012
            L_0x012e:
                r1 = 8
                goto L_0x0191
            L_0x0132:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x013c
                goto L_0x0012
            L_0x013c:
                r1 = 7
                goto L_0x0191
            L_0x013e:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0148
                goto L_0x0012
            L_0x0148:
                r1 = 6
                goto L_0x0191
            L_0x014a:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0154
                goto L_0x0012
            L_0x0154:
                r1 = 5
                goto L_0x0191
            L_0x0156:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0160
                goto L_0x0012
            L_0x0160:
                r1 = r3
                goto L_0x0191
            L_0x0162:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x016c
                goto L_0x0012
            L_0x016c:
                r1 = r8
                goto L_0x0191
            L_0x016e:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0178
                goto L_0x0012
            L_0x0178:
                r1 = r7
                goto L_0x0191
            L_0x017a:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0184
                goto L_0x0012
            L_0x0184:
                r1 = 1
                goto L_0x0191
            L_0x0186:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0190
                goto L_0x0012
            L_0x0190:
                r1 = 0
            L_0x0191:
                java.lang.String r10 = "application/dvbsubs"
                java.lang.String r11 = "application/vobsub"
                java.lang.String r12 = "application/pgs"
                java.lang.String r13 = ". Setting mimeType to "
                java.lang.String r14 = "Unsupported PCM bit depth: "
                java.lang.String r15 = "audio/raw"
                java.lang.String r2 = "text/x-ssa"
                r16 = 1
                java.lang.String r4 = "application/x-subrip"
                r17 = 0
                java.lang.String r5 = "MatroskaExtractor"
                r18 = 8
                java.lang.String r6 = "audio/x-unknown"
                r19 = 0
                switch(r1) {
                    case 0: goto L_0x0355;
                    case 1: goto L_0x0355;
                    case 2: goto L_0x030e;
                    case 3: goto L_0x0303;
                    case 4: goto L_0x02f7;
                    case 5: goto L_0x02f4;
                    case 6: goto L_0x02e8;
                    case 7: goto L_0x02d2;
                    case 8: goto L_0x02b0;
                    case 9: goto L_0x0355;
                    case 10: goto L_0x029c;
                    case 11: goto L_0x028c;
                    case 12: goto L_0x0289;
                    case 13: goto L_0x0280;
                    case 14: goto L_0x027d;
                    case 15: goto L_0x027a;
                    case 16: goto L_0x0277;
                    case 17: goto L_0x0274;
                    case 18: goto L_0x026d;
                    case 19: goto L_0x026a;
                    case 20: goto L_0x027a;
                    case 21: goto L_0x0240;
                    case 22: goto L_0x023d;
                    case 23: goto L_0x0227;
                    case 24: goto L_0x0220;
                    case 25: goto L_0x021d;
                    case 26: goto L_0x0211;
                    case 27: goto L_0x0202;
                    case 28: goto L_0x01b8;
                    default: goto L_0x01b0;
                }
            L_0x01b0:
                com.mbridge.msdk.playercommon.exoplayer2.ParserException r1 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01b8:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r8)
                byte[] r3 = r0.codecPrivate
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r18)
                java.nio.ByteOrder r5 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r3 = r3.order(r5)
                long r5 = r0.codecDelayNs
                java.nio.ByteBuffer r3 = r3.putLong(r5)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r18)
                java.nio.ByteOrder r5 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r3 = r3.order(r5)
                long r5 = r0.seekPreRollNs
                java.nio.ByteBuffer r3 = r3.putLong(r5)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r15 = "audio/opus"
                r3 = 5760(0x1680, float:8.071E-42)
            L_0x01f8:
                r28 = r1
                r32 = r3
                r27 = r9
            L_0x01fe:
                r29 = r15
                goto L_0x0364
            L_0x0202:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r15 = "audio/flac"
            L_0x020a:
                r28 = r1
            L_0x020c:
                r27 = r9
                r32 = r27
                goto L_0x01fe
            L_0x0211:
                java.lang.String r15 = "audio/eac3"
            L_0x0213:
                r27 = r9
                r32 = r27
            L_0x0217:
                r29 = r15
            L_0x0219:
                r28 = r19
                goto L_0x0364
            L_0x021d:
                java.lang.String r15 = "video/mpeg2"
                goto L_0x0213
            L_0x0220:
                r29 = r4
            L_0x0222:
                r27 = r9
                r32 = r27
                goto L_0x0219
            L_0x0227:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r3 = r0.codecPrivate
                r1.<init>((byte[]) r3)
                com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig r1 = com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r1 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r1
                java.lang.String r15 = "video/hevc"
            L_0x023a:
                r28 = r3
                goto L_0x020c
            L_0x023d:
                r29 = r2
                goto L_0x0222
            L_0x0240:
                int r1 = r0.audioBitDepth
                int r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r1 != 0) goto L_0x0265
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r14)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r13)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r5, r1)
            L_0x0262:
                r29 = r6
                goto L_0x0222
            L_0x0265:
                r27 = r1
                r32 = r9
                goto L_0x0217
            L_0x026a:
                java.lang.String r15 = "video/x-unknown"
                goto L_0x0213
            L_0x026d:
                r27 = r9
                r32 = r27
                r29 = r12
                goto L_0x0219
            L_0x0274:
                java.lang.String r15 = "video/x-vnd.on2.vp9"
                goto L_0x0213
            L_0x0277:
                java.lang.String r15 = "video/x-vnd.on2.vp8"
                goto L_0x0213
            L_0x027a:
                java.lang.String r15 = "audio/vnd.dts"
                goto L_0x0213
            L_0x027d:
                java.lang.String r15 = "audio/ac3"
                goto L_0x0213
            L_0x0280:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r15 = "audio/mp4a-latm"
                goto L_0x020a
            L_0x0289:
                java.lang.String r15 = "audio/vnd.dts.hd"
                goto L_0x0213
            L_0x028c:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r28 = r1
                r27 = r9
                r32 = r27
                r29 = r11
                goto L_0x0364
            L_0x029c:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r3 = r0.codecPrivate
                r1.<init>((byte[]) r3)
                com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig r1 = com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r1 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r1
                java.lang.String r15 = "video/avc"
                goto L_0x023a
            L_0x02b0:
                byte[] r1 = r0.codecPrivate
                byte r5 = r1[r17]
                byte r6 = r1[r16]
                byte r13 = r1[r7]
                byte r1 = r1[r8]
                byte[] r3 = new byte[r3]
                r3[r17] = r5
                r3[r16] = r6
                r3[r7] = r13
                r3[r8] = r1
                java.util.List r1 = java.util.Collections.singletonList(r3)
                r28 = r1
                r27 = r9
                r32 = r27
                r29 = r10
                goto L_0x0364
            L_0x02d2:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r3 = r0.codecPrivate
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = parseFourCcPrivate(r1)
                java.lang.Object r3 = r1.first
                r15 = r3
                java.lang.String r15 = (java.lang.String) r15
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
                goto L_0x020a
            L_0x02e8:
                java.lang.String r15 = "audio/mpeg"
            L_0x02ea:
                r27 = r9
                r29 = r15
                r28 = r19
                r32 = 4096(0x1000, float:5.74E-42)
                goto L_0x0364
            L_0x02f4:
                java.lang.String r15 = "audio/mpeg-L2"
                goto L_0x02ea
            L_0x02f7:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = parseVorbisCodecPrivate(r1)
                java.lang.String r15 = "audio/vorbis"
                r3 = 8192(0x2000, float:1.14794E-41)
                goto L_0x01f8
            L_0x0303:
                com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker r1 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker
                r1.<init>()
                r0.trueHdSampleRechunker = r1
                java.lang.String r15 = "audio/true-hd"
                goto L_0x0213
            L_0x030e:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r3 = r0.codecPrivate
                r1.<init>((byte[]) r3)
                boolean r1 = parseMsAcmCodecPrivate(r1)
                if (r1 == 0) goto L_0x033f
                int r1 = r0.audioBitDepth
                int r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r1 != 0) goto L_0x0265
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r14)
                int r3 = r0.audioBitDepth
                r1.append(r3)
                r1.append(r13)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r5, r1)
                goto L_0x0262
            L_0x033f:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r1.append(r3)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r5, r1)
                goto L_0x0262
            L_0x0355:
                byte[] r1 = r0.codecPrivate
                if (r1 != 0) goto L_0x035c
                r1 = r19
                goto L_0x0360
            L_0x035c:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0360:
                java.lang.String r15 = "video/mp4v-es"
                goto L_0x020a
            L_0x0364:
                boolean r1 = r0.flagDefault
                boolean r3 = r0.flagForced
                if (r3 == 0) goto L_0x036c
                r5 = r7
                goto L_0x036e
            L_0x036c:
                r5 = r17
            L_0x036e:
                r30 = r1 | r5
                boolean r1 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isAudio(r29)
                if (r1 == 0) goto L_0x039a
                java.lang.String r20 = java.lang.Integer.toString(r46)
                int r1 = r0.channelCount
                int r2 = r0.sampleRate
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r0.drmInitData
                java.lang.String r4 = r0.language
                r22 = 0
                r23 = -1
                r25 = r1
                r26 = r2
                r31 = r4
                r21 = r29
                r24 = r32
                r29 = r3
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                r4 = r16
                goto L_0x049b
            L_0x039a:
                r1 = r30
                boolean r3 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isVideo(r29)
                if (r3 == 0) goto L_0x0411
                int r1 = r0.displayUnit
                if (r1 != 0) goto L_0x03b6
                int r1 = r0.displayWidth
                if (r1 != r9) goto L_0x03ac
                int r1 = r0.width
            L_0x03ac:
                r0.displayWidth = r1
                int r1 = r0.displayHeight
                if (r1 != r9) goto L_0x03b4
                int r1 = r0.height
            L_0x03b4:
                r0.displayHeight = r1
            L_0x03b6:
                int r1 = r0.displayWidth
                if (r1 == r9) goto L_0x03ca
                int r2 = r0.displayHeight
                if (r2 == r9) goto L_0x03ca
                int r3 = r0.height
                int r3 = r3 * r1
                float r1 = (float) r3
                int r3 = r0.width
                int r3 = r3 * r2
                float r2 = (float) r3
                float r1 = r1 / r2
            L_0x03c7:
                r38 = r1
                goto L_0x03cd
            L_0x03ca:
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                goto L_0x03c7
            L_0x03cd:
                boolean r1 = r0.hasColorInfo
                if (r1 == 0) goto L_0x03e5
                byte[] r1 = r0.getHdrStaticInfo()
                com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo r2 = new com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo
                int r3 = r0.colorSpace
                int r4 = r0.colorRange
                int r5 = r0.colorTransfer
                r2.<init>(r3, r4, r5, r1)
                r41 = r2
            L_0x03e2:
                r33 = r28
                goto L_0x03e8
            L_0x03e5:
                r41 = r19
                goto L_0x03e2
            L_0x03e8:
                java.lang.String r28 = java.lang.Integer.toString(r46)
                int r1 = r0.width
                int r2 = r0.height
                byte[] r3 = r0.projectionData
                int r4 = r0.stereoMode
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r5 = r0.drmInitData
                r30 = 0
                r31 = -1
                r35 = -1082130432(0xffffffffbf800000, float:-1.0)
                r37 = -1
                r34 = r2
                r39 = r3
                r40 = r4
                r42 = r5
                r36 = r33
                r33 = r1
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
                r4 = r7
                goto L_0x049b
            L_0x0411:
                r15 = r29
                boolean r3 = r4.equals(r15)
                if (r3 == 0) goto L_0x0428
                java.lang.String r2 = java.lang.Integer.toString(r46)
                java.lang.String r3 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r4 = r0.drmInitData
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(r2, r15, r1, r3, r4)
            L_0x0425:
                r4 = r8
                goto L_0x049b
            L_0x0428:
                boolean r2 = r2.equals(r15)
                if (r2 == 0) goto L_0x0461
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>(r7)
                byte[] r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.SSA_DIALOGUE_FORMAT
                r2.add(r3)
                byte[] r3 = r0.codecPrivate
                r2.add(r3)
                java.lang.String r33 = java.lang.Integer.toString(r46)
                java.lang.String r3 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r4 = r0.drmInitData
                r41 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r35 = 0
                r36 = -1
                r39 = -1
                r37 = r1
                r43 = r2
                r38 = r3
                r40 = r4
                r34 = r15
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(r33, r34, r35, r36, r37, r38, r39, r40, r41, r43)
                goto L_0x0425
            L_0x0461:
                r30 = r1
                boolean r1 = r11.equals(r15)
                if (r1 != 0) goto L_0x047e
                boolean r1 = r12.equals(r15)
                if (r1 != 0) goto L_0x047e
                boolean r1 = r10.equals(r15)
                if (r1 == 0) goto L_0x0476
                goto L_0x047e
            L_0x0476:
                com.mbridge.msdk.playercommon.exoplayer2.ParserException r1 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x047e:
                java.lang.String r1 = java.lang.Integer.toString(r46)
                java.lang.String r2 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r0.drmInitData
                r32 = r30
                r30 = 0
                r31 = -1
                r34 = r2
                r35 = r3
                r29 = r15
                r33 = r28
                r28 = r1
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createImageSampleFormat(r28, r29, r30, r31, r32, r33, r34, r35)
                goto L_0x0425
            L_0x049b:
                int r2 = r0.number
                r3 = r45
                com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput r2 = r3.track(r2, r4)
                r0.output = r2
                r2.format(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        public final void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.outputPendingSampleMetadata(this);
            }
        }

        public final void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.reset();
            }
        }
    }

    private static final class TrueHdSampleRechunker {
        private int blockFlags;
        private int chunkSize;
        private boolean foundSyncframe;
        private int sampleCount;
        private final byte[] syncframePrefix = new byte[10];
        private long timeUs;

        public final void outputPendingSampleMetadata(Track track) {
            if (this.foundSyncframe && this.sampleCount > 0) {
                track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                this.sampleCount = 0;
            }
        }

        public final void reset() {
            this.foundSyncframe = false;
        }

        public final void sampleMetadata(Track track, long j5) {
            if (this.foundSyncframe) {
                int i5 = this.sampleCount;
                int i6 = i5 + 1;
                this.sampleCount = i6;
                if (i5 == 0) {
                    this.timeUs = j5;
                }
                if (i6 >= 16) {
                    track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                    this.sampleCount = 0;
                }
            }
        }

        public final void startSample(ExtractorInput extractorInput, int i5, int i6) throws IOException, InterruptedException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != -1) {
                    this.foundSyncframe = true;
                    this.sampleCount = 0;
                } else {
                    return;
                }
            }
            if (this.sampleCount == 0) {
                this.blockFlags = i5;
                this.chunkSize = 0;
            }
            this.chunkSize += i6;
        }
    }

    public MatroskaExtractor() {
        this(0);
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        if (this.segmentContentPosition == -1 || this.durationUs == C.TIME_UNSET || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            jArr3[i6] = this.cueTimesUs.get(i6);
            jArr[i6] = this.segmentContentPosition + this.cueClusterPositions.get(i6);
        }
        while (true) {
            int i7 = size - 1;
            if (i5 < i7) {
                int i8 = i5 + 1;
                iArr[i5] = (int) (jArr[i8] - jArr[i5]);
                jArr2[i5] = jArr3[i8] - jArr3[i5];
                i5 = i8;
            } else {
                iArr[i7] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i7]);
                jArr2[i7] = this.durationUs - jArr3[i7];
                this.cueTimesUs = null;
                this.cueClusterPositions = null;
                return new ChunkIndex(iArr, jArr, jArr2, jArr3);
            }
        }
    }

    private void commitSampleToOutput(Track track, long j5) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j5);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, 10000, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j5, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
        }
        this.sampleRead = true;
        resetSample();
    }

    private void commitSubtitleSample(Track track, String str, int i5, long j5, byte[] bArr) {
        setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i5, j5, bArr);
        TrackOutput trackOutput = track.output;
        ParsableByteArray parsableByteArray = this.subtitleSample;
        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
        this.sampleBytesWritten += this.subtitleSample.limit();
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i5) {
        if (iArr == null) {
            return new int[i5];
        }
        if (iArr.length >= i5) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i5)];
    }

    private static boolean isCodecSupported(String str) {
        if (CODEC_ID_VP8.equals(str) || CODEC_ID_VP9.equals(str) || CODEC_ID_MPEG2.equals(str) || CODEC_ID_MPEG4_SP.equals(str) || CODEC_ID_MPEG4_ASP.equals(str) || CODEC_ID_MPEG4_AP.equals(str) || CODEC_ID_H264.equals(str) || CODEC_ID_H265.equals(str) || CODEC_ID_FOURCC.equals(str) || CODEC_ID_THEORA.equals(str) || CODEC_ID_OPUS.equals(str) || CODEC_ID_VORBIS.equals(str) || CODEC_ID_AAC.equals(str) || CODEC_ID_MP2.equals(str) || CODEC_ID_MP3.equals(str) || CODEC_ID_AC3.equals(str) || CODEC_ID_E_AC3.equals(str) || CODEC_ID_TRUEHD.equals(str) || CODEC_ID_DTS.equals(str) || CODEC_ID_DTS_EXPRESS.equals(str) || CODEC_ID_DTS_LOSSLESS.equals(str) || CODEC_ID_FLAC.equals(str) || CODEC_ID_ACM.equals(str) || CODEC_ID_PCM_INT_LIT.equals(str) || CODEC_ID_SUBRIP.equals(str) || CODEC_ID_ASS.equals(str) || CODEC_ID_VOBSUB.equals(str) || CODEC_ID_PGS.equals(str) || CODEC_ID_DVBSUB.equals(str)) {
            return true;
        }
        return false;
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j5) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j5;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j6 = this.seekPositionAfterBuildingCues;
            if (j6 != -1) {
                positionHolder.position = j6;
                this.seekPositionAfterBuildingCues = -1;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i5) throws IOException, InterruptedException {
        if (this.scratch.limit() < i5) {
            if (this.scratch.capacity() < i5) {
                ParsableByteArray parsableByteArray = this.scratch;
                byte[] bArr = parsableByteArray.data;
                parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i5)), this.scratch.limit());
            }
            ParsableByteArray parsableByteArray2 = this.scratch;
            extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), i5 - this.scratch.limit());
            this.scratch.setLimit(i5);
        }
    }

    private int readToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i5) throws IOException, InterruptedException {
        int i6;
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft > 0) {
            i6 = Math.min(i5, bytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, i6);
        } else {
            i6 = trackOutput.sampleData(extractorInput, i5, false);
        }
        this.sampleBytesRead += i6;
        this.sampleBytesWritten += i6;
        return i6;
    }

    private void readToTarget(ExtractorInput extractorInput, byte[] bArr, int i5, int i6) throws IOException, InterruptedException {
        int min = Math.min(i6, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i5 + min, i6 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i5, min);
        }
        this.sampleBytesRead += i6;
    }

    private void resetSample() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long j5) throws ParserException {
        long j6 = this.timecodeScale;
        if (j6 != C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j5, j6, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSampleDuration(byte[] bArr, long j5, String str, int i5, long j6, byte[] bArr2) {
        byte[] bArr3;
        if (j5 == C.TIME_UNSET) {
            bArr3 = bArr2;
        } else {
            int i6 = (int) (j5 / 3600000000L);
            long j7 = j5 - (((long) (i6 * 3600)) * 1000000);
            int i7 = (int) (j7 / 60000000);
            long j8 = j7 - (((long) (i7 * 60)) * 1000000);
            int i8 = (int) (j8 / 1000000);
            bArr3 = Util.getUtf8Bytes(String.format(Locale.US, str, new Object[]{Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf((int) ((j8 - (((long) i8) * 1000000)) / j6))}));
        }
        System.arraycopy(bArr3, 0, bArr, i5, bArr2.length);
    }

    private void writeSampleData(ExtractorInput extractorInput, Track track, int i5) throws IOException, InterruptedException {
        boolean z4;
        int i6;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i5);
        } else if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i5);
        } else {
            TrackOutput trackOutput = track.output;
            boolean z5 = true;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    int i7 = 128;
                    if (!this.sampleSignalByteRead) {
                        extractorInput.readFully(this.scratch.data, 0, 1);
                        this.sampleBytesRead++;
                        byte b5 = this.scratch.data[0];
                        if ((b5 & 128) != 128) {
                            this.sampleSignalByte = b5;
                            this.sampleSignalByteRead = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b6 = this.sampleSignalByte;
                    if ((b6 & 1) == 1) {
                        if ((b6 & 2) == 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            ParsableByteArray parsableByteArray = this.scratch;
                            byte[] bArr = parsableByteArray.data;
                            if (!z4) {
                                i7 = 0;
                            }
                            bArr[0] = (byte) (i7 | 8);
                            parsableByteArray.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8);
                            this.sampleBytesWritten += 8;
                        }
                        if (z4) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.data, 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i8 = this.samplePartitionCount * 4;
                            this.scratch.reset(i8);
                            extractorInput.readFully(this.scratch.data, 0, i8);
                            this.sampleBytesRead += i8;
                            short s5 = (short) ((this.samplePartitionCount / 2) + 1);
                            int i9 = (s5 * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i9);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s5);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i6 = this.samplePartitionCount;
                                if (i10 >= i6) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                if (i10 % 2 == 0) {
                                    this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i11));
                                } else {
                                    this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i11);
                                }
                                i10++;
                                i11 = readUnsignedIntToInt;
                            }
                            int i12 = (i5 - this.sampleBytesRead) - i11;
                            if (i6 % 2 == 1) {
                                this.encryptionSubsampleDataBuffer.putInt(i12);
                            } else {
                                this.encryptionSubsampleDataBuffer.putShort((short) i12);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i9);
                            trackOutput.sampleData(this.encryptionSubsampleData, i9);
                            this.sampleBytesWritten += i9;
                        }
                    }
                } else {
                    byte[] bArr2 = track.sampleStrippedBytes;
                    if (bArr2 != null) {
                        this.sampleStrippedBytes.reset(bArr2, bArr2.length);
                    }
                }
                this.sampleEncodingHandled = true;
            }
            int limit = i5 + this.sampleStrippedBytes.limit();
            if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                if (track.trueHdSampleRechunker != null) {
                    if (this.sampleStrippedBytes.limit() != 0) {
                        z5 = false;
                    }
                    Assertions.checkState(z5);
                    track.trueHdSampleRechunker.startSample(extractorInput, this.blockFlags, limit);
                }
                while (true) {
                    int i13 = this.sampleBytesRead;
                    if (i13 >= limit) {
                        break;
                    }
                    readToOutput(extractorInput, trackOutput, limit - i13);
                }
            } else {
                byte[] bArr3 = this.nalLength.data;
                bArr3[0] = 0;
                bArr3[1] = 0;
                bArr3[2] = 0;
                int i14 = track.nalUnitLengthFieldLength;
                int i15 = 4 - i14;
                while (this.sampleBytesRead < limit) {
                    int i16 = this.sampleCurrentNalBytesRemaining;
                    if (i16 == 0) {
                        readToTarget(extractorInput, bArr3, i15, i14);
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        this.sampleCurrentNalBytesRemaining = i16 - readToOutput(extractorInput, trackOutput, i16);
                    }
                }
            }
            if (CODEC_ID_VORBIS.equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i5) throws IOException, InterruptedException {
        int length = bArr.length + i5;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(bArr, length + i5);
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i5);
        this.subtitleSample.reset(length);
    }

    /* access modifiers changed from: package-private */
    public final void binaryElement(int i5, int i6, ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i7;
        byte b5;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte b6;
        int i15;
        long j5;
        int i16;
        int i17;
        int i18;
        int i19 = i5;
        int i20 = i6;
        ExtractorInput extractorInput2 = extractorInput;
        int i21 = 1;
        int i22 = 0;
        if (i19 == ID_BLOCK || i19 == ID_SIMPLE_BLOCK) {
            byte b7 = 8;
            if (this.blockState == 0) {
                this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput2, false, true, 8);
                this.blockTrackNumberLength = this.varintReader.getLastLength();
                this.blockDurationUs = C.TIME_UNSET;
                this.blockState = 1;
                this.scratch.reset();
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            if (track == null) {
                extractorInput2.skipFully(i20 - this.blockTrackNumberLength);
                this.blockState = 0;
                return;
            }
            if (this.blockState == 1) {
                readScratch(extractorInput2, 3);
                int i23 = (this.scratch.data[2] & 6) >> 1;
                if (i23 == 0) {
                    this.blockLacingSampleCount = 1;
                    int[] ensureArrayCapacity = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
                    this.blockLacingSampleSizes = ensureArrayCapacity;
                    ensureArrayCapacity[0] = (i20 - this.blockTrackNumberLength) - 3;
                } else if (i19 == ID_SIMPLE_BLOCK) {
                    int i24 = 4;
                    readScratch(extractorInput2, 4);
                    int i25 = (this.scratch.data[3] & 255) + 1;
                    this.blockLacingSampleCount = i25;
                    int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockLacingSampleSizes, i25);
                    this.blockLacingSampleSizes = ensureArrayCapacity2;
                    if (i23 == 2) {
                        int i26 = this.blockLacingSampleCount;
                        Arrays.fill(ensureArrayCapacity2, 0, i26, ((i20 - this.blockTrackNumberLength) - 4) / i26);
                    } else if (i23 == 1) {
                        int i27 = 0;
                        int i28 = 0;
                        while (true) {
                            i16 = this.blockLacingSampleCount;
                            if (i27 >= i16 - 1) {
                                break;
                            }
                            this.blockLacingSampleSizes[i27] = 0;
                            while (true) {
                                i17 = i24 + 1;
                                readScratch(extractorInput2, i17);
                                byte b8 = this.scratch.data[i24] & 255;
                                int[] iArr = this.blockLacingSampleSizes;
                                i18 = iArr[i27] + b8;
                                iArr[i27] = i18;
                                if (b8 != 255) {
                                    break;
                                }
                                i24 = i17;
                            }
                            i28 += i18;
                            i27++;
                            i24 = i17;
                        }
                        this.blockLacingSampleSizes[i16 - 1] = ((i20 - this.blockTrackNumberLength) - i24) - i28;
                    } else if (i23 == 3) {
                        int i29 = 0;
                        int i30 = 0;
                        while (true) {
                            int i31 = this.blockLacingSampleCount;
                            if (i29 >= i31 - 1) {
                                i8 = i21;
                                i9 = i22;
                                b5 = b7;
                                this.blockLacingSampleSizes[i31 - 1] = ((i20 - this.blockTrackNumberLength) - i24) - i30;
                                break;
                            }
                            this.blockLacingSampleSizes[i29] = i22;
                            int i32 = i24 + 1;
                            readScratch(extractorInput2, i32);
                            if (this.scratch.data[i24] != 0) {
                                int i33 = i22;
                                while (true) {
                                    if (i33 >= b7) {
                                        i13 = i21;
                                        i14 = i22;
                                        b6 = b7;
                                        i15 = i29;
                                        j5 = 0;
                                        break;
                                    }
                                    i13 = i21;
                                    int i34 = i13 << (7 - i33);
                                    i14 = i22;
                                    if ((this.scratch.data[i24] & i34) != 0) {
                                        i32 += i33;
                                        readScratch(extractorInput2, i32);
                                        j5 = (long) ((~i34) & this.scratch.data[i24] & 255);
                                        int i35 = i24 + 1;
                                        while (i35 < i32) {
                                            j5 = (j5 << b7) | ((long) (this.scratch.data[i35] & 255));
                                            i35++;
                                            b7 = b7;
                                            i29 = i29;
                                        }
                                        b6 = b7;
                                        i15 = i29;
                                        if (i15 > 0) {
                                            j5 -= (1 << ((i33 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        byte b9 = b7;
                                        int i36 = i29;
                                        i33++;
                                        i22 = i14;
                                        i21 = i13;
                                    }
                                }
                                i24 = i32;
                                if (j5 >= -2147483648L && j5 <= 2147483647L) {
                                    int i37 = (int) j5;
                                    int[] iArr2 = this.blockLacingSampleSizes;
                                    if (i15 != 0) {
                                        i37 += iArr2[i15 - 1];
                                    }
                                    iArr2[i15] = i37;
                                    i30 += i37;
                                    i29 = i15 + 1;
                                    i22 = i14;
                                    i21 = i13;
                                    b7 = b6;
                                }
                            } else {
                                throw new ParserException("No valid varint length mask found");
                            }
                        }
                        throw new ParserException("EBML lacing sample size out of range.");
                    } else {
                        throw new ParserException("Unexpected lacing value: " + i23);
                    }
                } else {
                    throw new ParserException("Lacing only supported in SimpleBlocks.");
                }
                i8 = 1;
                i9 = 0;
                b5 = 8;
                byte[] bArr = this.scratch.data;
                this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((long) ((bArr[i8] & 255) | (bArr[i9] << 8)));
                byte b10 = this.scratch.data[2];
                if ((b10 & 8) == b5) {
                    i10 = i8;
                } else {
                    i10 = i9;
                }
                if (track.type == 2 || (i19 == ID_SIMPLE_BLOCK && (b10 & 128) == 128)) {
                    i11 = i8;
                } else {
                    i11 = i9;
                }
                if (i10 != 0) {
                    i12 = Integer.MIN_VALUE;
                } else {
                    i12 = i9;
                }
                this.blockFlags = i11 | i12;
                this.blockState = 2;
                this.blockLacingSampleIndex = i9;
                i7 = ID_SIMPLE_BLOCK;
            } else {
                i7 = ID_SIMPLE_BLOCK;
            }
            if (i19 == i7) {
                while (true) {
                    int i38 = this.blockLacingSampleIndex;
                    if (i38 < this.blockLacingSampleCount) {
                        writeSampleData(extractorInput2, track, this.blockLacingSampleSizes[i38]);
                        commitSampleToOutput(track, this.blockTimeUs + ((long) ((this.blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000)));
                        this.blockLacingSampleIndex++;
                    } else {
                        this.blockState = 0;
                        return;
                    }
                }
            } else {
                writeSampleData(extractorInput2, track, this.blockLacingSampleSizes[0]);
            }
        } else if (i19 == ID_CONTENT_COMPRESSION_SETTINGS) {
            byte[] bArr2 = new byte[i20];
            this.currentTrack.sampleStrippedBytes = bArr2;
            extractorInput2.readFully(bArr2, 0, i20);
        } else if (i19 == ID_CONTENT_ENCRYPTION_KEY_ID) {
            byte[] bArr3 = new byte[i20];
            extractorInput2.readFully(bArr3, 0, i20);
            this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr3, 0, 0);
        } else if (i19 == ID_SEEK_ID) {
            Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
            extractorInput2.readFully(this.seekEntryIdBytes.data, 4 - i20, i20);
            this.seekEntryIdBytes.setPosition(0);
            this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
        } else if (i19 == ID_CODEC_PRIVATE) {
            byte[] bArr4 = new byte[i20];
            this.currentTrack.codecPrivate = bArr4;
            extractorInput2.readFully(bArr4, 0, i20);
        } else if (i19 == ID_PROJECTION_PRIVATE) {
            byte[] bArr5 = new byte[i20];
            this.currentTrack.projectionData = bArr5;
            extractorInput2.readFully(bArr5, 0, i20);
        } else {
            throw new ParserException("Unexpected id: " + i19);
        }
    }

    /* access modifiers changed from: package-private */
    public final void endMasterElement(int i5) throws ParserException {
        if (i5 != ID_BLOCK_GROUP) {
            if (i5 == ID_TRACK_ENTRY) {
                if (isCodecSupported(this.currentTrack.codecId)) {
                    Track track = this.currentTrack;
                    track.initializeOutput(this.extractorOutput, track.number);
                    SparseArray<Track> sparseArray = this.tracks;
                    Track track2 = this.currentTrack;
                    sparseArray.put(track2.number, track2);
                }
                this.currentTrack = null;
            } else if (i5 == ID_SEEK) {
                int i6 = this.seekEntryId;
                if (i6 != -1) {
                    long j5 = this.seekEntryPosition;
                    if (j5 != -1) {
                        if (i6 == ID_CUES) {
                            this.cuesContentPosition = j5;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i5 == ID_CONTENT_ENCODING) {
                Track track3 = this.currentTrack;
                if (!track3.hasContentEncryption) {
                    return;
                }
                if (track3.cryptoData != null) {
                    track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i5 == ID_CONTENT_ENCODINGS) {
                Track track4 = this.currentTrack;
                if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i5 == 357149030) {
                if (this.timecodeScale == C.TIME_UNSET) {
                    this.timecodeScale = 1000000;
                }
                long j6 = this.durationTimecode;
                if (j6 != C.TIME_UNSET) {
                    this.durationUs = scaleTimecodeToUs(j6);
                }
            } else if (i5 != ID_TRACKS) {
                if (i5 == ID_CUES && !this.sentSeekMap) {
                    this.extractorOutput.seekMap(buildSeekMap());
                    this.sentSeekMap = true;
                }
            } else if (this.tracks.size() != 0) {
                this.extractorOutput.endTracks();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        } else if (this.blockState == 2) {
            if (!this.sampleSeenReferenceBlock) {
                this.blockFlags |= 1;
            }
            commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
            this.blockState = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void floatElement(int i5, double d5) {
        if (i5 == ID_SAMPLING_FREQUENCY) {
            this.currentTrack.sampleRate = (int) d5;
        } else if (i5 != ID_DURATION) {
            switch (i5) {
                case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                    this.currentTrack.primaryRChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                    this.currentTrack.primaryRChromaticityY = (float) d5;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                    this.currentTrack.primaryGChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                    this.currentTrack.primaryGChromaticityY = (float) d5;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                    this.currentTrack.primaryBChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                    this.currentTrack.primaryBChromaticityY = (float) d5;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                    this.currentTrack.whitePointChromaticityX = (float) d5;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                    this.currentTrack.whitePointChromaticityY = (float) d5;
                    return;
                case ID_LUMNINANCE_MAX /*21977*/:
                    this.currentTrack.maxMasteringLuminance = (float) d5;
                    return;
                case ID_LUMNINANCE_MIN /*21978*/:
                    this.currentTrack.minMasteringLuminance = (float) d5;
                    return;
                default:
                    return;
            }
        } else {
            this.durationTimecode = (long) d5;
        }
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    /* access modifiers changed from: package-private */
    public final void integerElement(int i5, long j5) throws ParserException {
        if (i5 != ID_CONTENT_ENCODING_ORDER) {
            if (i5 != ID_CONTENT_ENCODING_SCOPE) {
                boolean z4 = false;
                switch (i5) {
                    case ID_TRACK_TYPE /*131*/:
                        this.currentTrack.type = (int) j5;
                        return;
                    case ID_FLAG_DEFAULT /*136*/:
                        Track track = this.currentTrack;
                        if (j5 == 1) {
                            z4 = true;
                        }
                        track.flagDefault = z4;
                        return;
                    case 155:
                        this.blockDurationUs = scaleTimecodeToUs(j5);
                        return;
                    case ID_CHANNELS /*159*/:
                        this.currentTrack.channelCount = (int) j5;
                        return;
                    case ID_PIXEL_WIDTH /*176*/:
                        this.currentTrack.width = (int) j5;
                        return;
                    case ID_CUE_TIME /*179*/:
                        this.cueTimesUs.add(scaleTimecodeToUs(j5));
                        return;
                    case ID_PIXEL_HEIGHT /*186*/:
                        this.currentTrack.height = (int) j5;
                        return;
                    case ID_TRACK_NUMBER /*215*/:
                        this.currentTrack.number = (int) j5;
                        return;
                    case ID_TIME_CODE /*231*/:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j5);
                        return;
                    case ID_CUE_CLUSTER_POSITION /*241*/:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            this.cueClusterPositions.add(j5);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case ID_REFERENCE_BLOCK /*251*/:
                        this.sampleSeenReferenceBlock = true;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                        if (j5 != 3) {
                            throw new ParserException("ContentCompAlgo " + j5 + " not supported");
                        }
                        return;
                    case ID_DOC_TYPE_READ_VERSION /*17029*/:
                        if (j5 < 1 || j5 > 2) {
                            throw new ParserException("DocTypeReadVersion " + j5 + " not supported");
                        }
                        return;
                    case ID_EBML_READ_VERSION /*17143*/:
                        if (j5 != 1) {
                            throw new ParserException("EBMLReadVersion " + j5 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                        if (j5 != 5) {
                            throw new ParserException("ContentEncAlgo " + j5 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                        if (j5 != 1) {
                            throw new ParserException("AESSettingsCipherMode " + j5 + " not supported");
                        }
                        return;
                    case ID_SEEK_POSITION /*21420*/:
                        this.seekEntryPosition = j5 + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /*21432*/:
                        int i6 = (int) j5;
                        if (i6 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i6 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i6 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i6 == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DISPLAY_WIDTH /*21680*/:
                        this.currentTrack.displayWidth = (int) j5;
                        return;
                    case ID_DISPLAY_UNIT /*21682*/:
                        this.currentTrack.displayUnit = (int) j5;
                        return;
                    case ID_DISPLAY_HEIGHT /*21690*/:
                        this.currentTrack.displayHeight = (int) j5;
                        return;
                    case ID_FLAG_FORCED /*21930*/:
                        Track track2 = this.currentTrack;
                        if (j5 == 1) {
                            z4 = true;
                        }
                        track2.flagForced = z4;
                        return;
                    case ID_CODEC_DELAY /*22186*/:
                        this.currentTrack.codecDelayNs = j5;
                        return;
                    case ID_SEEK_PRE_ROLL /*22203*/:
                        this.currentTrack.seekPreRollNs = j5;
                        return;
                    case ID_AUDIO_BIT_DEPTH /*25188*/:
                        this.currentTrack.audioBitDepth = (int) j5;
                        return;
                    case ID_DEFAULT_DURATION /*2352003*/:
                        this.currentTrack.defaultSampleDurationNs = (int) j5;
                        return;
                    case ID_TIMECODE_SCALE /*2807729*/:
                        this.timecodeScale = j5;
                        return;
                    default:
                        switch (i5) {
                            case ID_COLOUR_RANGE /*21945*/:
                                int i7 = (int) j5;
                                if (i7 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i7 == 2) {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_COLOUR_TRANSFER /*21946*/:
                                int i8 = (int) j5;
                                if (i8 != 1) {
                                    if (i8 == 16) {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    } else if (i8 == 18) {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    } else if (!(i8 == 6 || i8 == 7)) {
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case ID_COLOUR_PRIMARIES /*21947*/:
                                Track track3 = this.currentTrack;
                                track3.hasColorInfo = true;
                                int i9 = (int) j5;
                                if (i9 == 1) {
                                    track3.colorSpace = 1;
                                    return;
                                } else if (i9 == 9) {
                                    track3.colorSpace = 6;
                                    return;
                                } else if (i9 == 4 || i9 == 5 || i9 == 6 || i9 == 7) {
                                    track3.colorSpace = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_MAX_CLL /*21948*/:
                                this.currentTrack.maxContentLuminance = (int) j5;
                                return;
                            case ID_MAX_FALL /*21949*/:
                                this.currentTrack.maxFrameAverageLuminance = (int) j5;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j5 != 1) {
                throw new ParserException("ContentEncodingScope " + j5 + " not supported");
            }
        } else if (j5 != 0) {
            throw new ParserException("ContentEncodingOrder " + j5 + " not supported");
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        this.sampleRead = false;
        boolean z4 = true;
        while (z4 && !this.sampleRead) {
            z4 = this.reader.read(extractorInput);
            if (z4 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z4) {
            return 0;
        }
        for (int i5 = 0; i5 < this.tracks.size(); i5++) {
            this.tracks.valueAt(i5).outputPendingSampleMetadata();
        }
        return -1;
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetSample();
        for (int i5 = 0; i5 < this.tracks.size(); i5++) {
            this.tracks.valueAt(i5).reset();
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return new Sniffer().sniff(extractorInput);
    }

    /* access modifiers changed from: package-private */
    public final void startMasterElement(int i5, long j5, long j6) throws ParserException {
        if (i5 == ID_BLOCK_GROUP) {
            this.sampleSeenReferenceBlock = false;
        } else if (i5 == ID_TRACK_ENTRY) {
            this.currentTrack = new Track();
        } else if (i5 == ID_CUE_POINT) {
            this.seenClusterPositionForCurrentCuePoint = false;
        } else if (i5 == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1;
        } else if (i5 == ID_CONTENT_ENCRYPTION) {
            this.currentTrack.hasContentEncryption = true;
        } else if (i5 == ID_MASTERING_METADATA) {
            this.currentTrack.hasColorInfo = true;
        } else if (i5 == ID_SEGMENT) {
            long j7 = this.segmentContentPosition;
            if (j7 == -1 || j7 == j5) {
                this.segmentContentPosition = j5;
                this.segmentContentSize = j6;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i5 == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i5 != ID_CLUSTER || this.sentSeekMap) {
        } else {
            if (!this.seekForCuesEnabled || this.cuesContentPosition == -1) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
                return;
            }
            this.seekForCues = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void stringElement(int i5, String str) throws ParserException {
        if (i5 == 134) {
            this.currentTrack.codecId = str;
        } else if (i5 != ID_DOC_TYPE) {
            if (i5 == ID_LANGUAGE) {
                String unused = this.currentTrack.language = str;
            }
        } else if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
            throw new ParserException("DocType " + str + " not supported");
        }
    }

    public MatroskaExtractor(int i5) {
        this(new DefaultEbmlReader(), i5);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i5) {
        this.segmentContentPosition = -1;
        this.timecodeScale = C.TIME_UNSET;
        this.durationTimecode = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.cuesContentPosition = -1;
        this.seekPositionAfterBuildingCues = -1;
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i5 & 1) != 0 ? false : true;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
    }
}
