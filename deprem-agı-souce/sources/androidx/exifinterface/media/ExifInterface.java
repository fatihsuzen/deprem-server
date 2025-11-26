package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.work.WorkRequest;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final boolean DEBUG = false;
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4);
    static final byte[] JPEG_SIGNATURE = {MARKER, MARKER_SOI, MARKER};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int RAF_INFO_SIZE = 160;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag(TAG_STRIP_OFFSETS, FloatWebTemplateView.FLOAT_MINI_CARD, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatter;
    private static final Pattern sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private static final Pattern sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private final AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder = ByteOrder.BIG_ENDIAN;
    private int mExifOffset;
    private final String mFilename;
    private boolean mHasThumbnail;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        private final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void writeByte(int i5) throws IOException {
            this.mOutputStream.write(i5);
        }

        public void writeInt(int i5) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(i5 & 255);
                this.mOutputStream.write((i5 >>> 8) & 255);
                this.mOutputStream.write((i5 >>> 16) & 255);
                this.mOutputStream.write((i5 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i5 >>> 24) & 255);
                this.mOutputStream.write((i5 >>> 16) & 255);
                this.mOutputStream.write((i5 >>> 8) & 255);
                this.mOutputStream.write(i5 & 255);
            }
        }

        public void writeShort(short s5) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write(s5 & 255);
                this.mOutputStream.write((s5 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s5 >>> 8) & 255);
                this.mOutputStream.write(s5 & 255);
            }
        }

        public void writeUnsignedInt(long j5) throws IOException {
            writeInt((int) j5);
        }

        public void writeUnsignedShort(int i5) throws IOException {
            writeShort((short) i5);
        }

        public void write(byte[] bArr, int i5, int i6) throws IOException {
            this.mOutputStream.write(bArr, i5, i6);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d5) {
            this((long) (d5 * 10000.0d), WorkRequest.MIN_BACKOFF_MILLIS);
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        Rational(long j5, long j6) {
            if (j6 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j5;
            this.denominator = j6;
        }
    }

    static {
        ExifTag exifTag = new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4);
        ExifTag exifTag2 = new ExifTag(TAG_SUBFILE_TYPE, 255, 4);
        ExifTag exifTag3 = new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4);
        ExifTag exifTag4 = new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4);
        ExifTag exifTag5 = exifTag2;
        ExifTag exifTag6 = exifTag3;
        ExifTag exifTag7 = exifTag4;
        ExifTag[] exifTagArr = {exifTag, exifTag5, exifTag6, exifTag7, new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, SubsamplingScaleImageView.ORIENTATION_270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, FloatWebTemplateView.FLOAT_MINI_CARD, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = exifTagArr;
        ExifTag[] exifTagArr3 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, 40960, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = exifTagArr3;
        ExifTag[] exifTagArr5 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
        IFD_GPS_TAGS = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = exifTagArr6;
        ExifTag exifTag8 = new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4);
        ExifTag[] exifTagArr8 = exifTagArr5;
        ExifTag exifTag9 = new ExifTag(TAG_SUBFILE_TYPE, 255, 4);
        ExifTag exifTag10 = new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4);
        ExifTag exifTag11 = new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4);
        ExifTag exifTag12 = new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3);
        ExifTag exifTag13 = new ExifTag(TAG_COMPRESSION, 259, 3);
        ExifTag exifTag14 = new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3);
        ExifTag exifTag15 = new ExifTag(TAG_IMAGE_DESCRIPTION, SubsamplingScaleImageView.ORIENTATION_270, 2);
        ExifTag exifTag16 = new ExifTag(TAG_MAKE, 271, 2);
        ExifTag exifTag17 = new ExifTag(TAG_MODEL, 272, 2);
        ExifTag exifTag18 = new ExifTag(TAG_STRIP_OFFSETS, FloatWebTemplateView.FLOAT_MINI_CARD, 3, 4);
        ExifTag exifTag19 = new ExifTag(TAG_ORIENTATION, 274, 3);
        ExifTag exifTag20 = new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3);
        ExifTag exifTag21 = new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4);
        ExifTag exifTag22 = new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4);
        ExifTag exifTag23 = new ExifTag(TAG_X_RESOLUTION, 282, 5);
        ExifTag exifTag24 = new ExifTag(TAG_Y_RESOLUTION, 283, 5);
        ExifTag exifTag25 = exifTag24;
        ExifTag[] exifTagArr9 = {exifTag8, exifTag9, exifTag10, exifTag11, exifTag12, exifTag13, exifTag14, exifTag15, exifTag16, exifTag17, exifTag18, exifTag19, exifTag20, exifTag21, exifTag22, exifTag23, exifTag25, new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, 306, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr9;
        ExifTag[] exifTagArr10 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr10;
        ExifTag[] exifTagArr11 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr11;
        ExifTag[] exifTagArr12 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr12;
        ExifTag[] exifTagArr13 = exifTagArr9;
        ExifTag[] exifTagArr14 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = exifTagArr14;
        ExifTag[][] exifTagArr15 = {exifTagArr2, exifTagArr4, exifTagArr8, exifTagArr7, exifTagArr13, exifTagArr2, exifTagArr10, exifTagArr11, exifTagArr12, exifTagArr14};
        EXIF_TAGS = exifTagArr15;
        sExifTagMapsForReading = new HashMap[exifTagArr15.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr15.length];
        Charset forName = Charset.forName(C.ASCII_NAME);
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i5 = 0;
        while (true) {
            ExifTag[][] exifTagArr16 = EXIF_TAGS;
            if (i5 < exifTagArr16.length) {
                sExifTagMapsForReading[i5] = new HashMap<>();
                sExifTagMapsForWriting[i5] = new HashMap<>();
                for (ExifTag exifTag26 : exifTagArr16[i5]) {
                    sExifTagMapsForReading[i5].put(Integer.valueOf(exifTag26.number), exifTag26);
                    sExifTagMapsForWriting[i5].put(exifTag26.name, exifTag26);
                }
                i5++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr17 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr17[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr17[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr17[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr17[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr17[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr17[5].number), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    loadAttributes(fileInputStream2);
                    closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    private String convertDecimalDegree(double d5) {
        long j5 = (long) d5;
        double d6 = d5 - ((double) j5);
        long j6 = (long) (d6 * 60.0d);
        long round = Math.round((d6 - (((double) j6) / 60.0d)) * 3600.0d * 1.0E7d);
        return j5 + "/1," + j6 + "/1," + round + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private static long[] convertToLongArray(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                jArr[i5] = (long) iArr[i5];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i5 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i5;
            }
            i5 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            ExifAttribute exifAttribute = this.mAttributes[i5].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0086 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r10.setByteOrder(r0)
            long r0 = (long) r11
            r10.seek(r0)
            byte r0 = r10.readByte()
            java.lang.String r1 = "Invalid marker: "
            r2 = -1
            if (r0 != r2) goto L_0x0153
            byte r3 = r10.readByte()
            r4 = -40
            if (r3 != r4) goto L_0x0138
            int r11 = r11 + 2
        L_0x001c:
            byte r0 = r10.readByte()
            if (r0 != r2) goto L_0x011b
            byte r0 = r10.readByte()
            r1 = -39
            if (r0 == r1) goto L_0x0115
            r1 = -38
            if (r0 != r1) goto L_0x0030
            goto L_0x0115
        L_0x0030:
            int r1 = r10.readUnsignedShort()
            int r3 = r1 + -2
            int r4 = r11 + 4
            java.lang.String r5 = "Invalid length"
            if (r3 < 0) goto L_0x010f
            r6 = -31
            r7 = 0
            java.lang.String r8 = "Invalid exif"
            if (r0 == r6) goto L_0x00b8
            r11 = -2
            r6 = 1
            if (r0 == r11) goto L_0x008e
            switch(r0) {
                case -64: goto L_0x0055;
                case -63: goto L_0x0055;
                case -62: goto L_0x0055;
                case -61: goto L_0x0055;
                default: goto L_0x004a;
            }
        L_0x004a:
            switch(r0) {
                case -59: goto L_0x0055;
                case -58: goto L_0x0055;
                case -57: goto L_0x0055;
                default: goto L_0x004d;
            }
        L_0x004d:
            switch(r0) {
                case -55: goto L_0x0055;
                case -54: goto L_0x0055;
                case -53: goto L_0x0055;
                default: goto L_0x0050;
            }
        L_0x0050:
            switch(r0) {
                case -51: goto L_0x0055;
                case -50: goto L_0x0055;
                case -49: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x00e3
        L_0x0055:
            int r11 = r10.skipBytes(r6)
            if (r11 != r6) goto L_0x0086
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r11 = r9.mAttributes
            r11 = r11[r12]
            int r0 = r10.readUnsignedShort()
            long r6 = (long) r0
            java.nio.ByteOrder r0 = r9.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r0 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r6, (java.nio.ByteOrder) r0)
            java.lang.String r3 = "ImageLength"
            r11.put(r3, r0)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r11 = r9.mAttributes
            r11 = r11[r12]
            int r0 = r10.readUnsignedShort()
            long r6 = (long) r0
            java.nio.ByteOrder r0 = r9.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r0 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r6, (java.nio.ByteOrder) r0)
            java.lang.String r3 = "ImageWidth"
            r11.put(r3, r0)
            int r3 = r1 + -7
            goto L_0x00e3
        L_0x0086:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid SOFx"
            r10.<init>(r11)
            throw r10
        L_0x008e:
            byte[] r11 = new byte[r3]
            int r0 = r10.read(r11)
            if (r0 != r3) goto L_0x00b2
            java.lang.String r0 = "UserComment"
            java.lang.String r1 = r9.getAttribute(r0)
            if (r1 != 0) goto L_0x00b0
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r1 = r9.mAttributes
            r1 = r1[r6]
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r6 = ASCII
            r3.<init>(r11, r6)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r11 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createString(r3)
            r1.put(r0, r11)
        L_0x00b0:
            r3 = r7
            goto L_0x00e3
        L_0x00b2:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r8)
            throw r10
        L_0x00b8:
            r0 = 6
            if (r3 >= r0) goto L_0x00bc
            goto L_0x00e3
        L_0x00bc:
            byte[] r3 = new byte[r0]
            int r4 = r10.read(r3)
            if (r4 != r0) goto L_0x0109
            int r4 = r11 + 10
            int r11 = r1 + -8
            byte[] r0 = IDENTIFIER_EXIF_APP1
            boolean r0 = java.util.Arrays.equals(r3, r0)
            if (r0 != 0) goto L_0x00d2
            r3 = r11
            goto L_0x00e3
        L_0x00d2:
            if (r11 <= 0) goto L_0x0103
            r9.mExifOffset = r4
            byte[] r0 = new byte[r11]
            int r1 = r10.read(r0)
            if (r1 != r11) goto L_0x00fd
            int r4 = r4 + r11
            r9.readExifSegment(r0, r12)
            goto L_0x00b0
        L_0x00e3:
            if (r3 < 0) goto L_0x00f7
            int r11 = r10.skipBytes(r3)
            if (r11 != r3) goto L_0x00ef
            int r11 = r4 + r3
            goto L_0x001c
        L_0x00ef:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Invalid JPEG segment"
            r10.<init>(r11)
            throw r10
        L_0x00f7:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r5)
            throw r10
        L_0x00fd:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r8)
            throw r10
        L_0x0103:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r8)
            throw r10
        L_0x0109:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r8)
            throw r10
        L_0x010f:
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r5)
            throw r10
        L_0x0115:
            java.nio.ByteOrder r11 = r9.mExifByteOrder
            r10.setByteOrder(r11)
            return
        L_0x011b:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Invalid marker:"
            r11.append(r12)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0138:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0153:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            r12 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r12 = java.lang.Integer.toHexString(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        return 0;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        int i5;
        int i6;
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            byteOrderedDataInputStream2.seek(0);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            byteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                byteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                byteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i7 = iArr[2];
                int i8 = iArr[0];
                if (i7 > i8 && (i5 = iArr[3]) > (i6 = iArr[1])) {
                    int i9 = (i7 - i8) + 1;
                    int i10 = (i5 - i6) + 1;
                    if (i9 < i10) {
                        int i11 = i9 + i10;
                        i10 = i11 - i10;
                        i9 = i11 - i10;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i9, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i10, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort2);
                }
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i5 = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        getJpegAttributes(byteOrderedDataInputStream, i5, 5);
        byteOrderedDataInputStream.seek((long) i6);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        for (int i7 = 0; i7 < readInt; i7++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort((int) readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort((int) readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages(byteOrderedDataInputStream);
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byteOrderedDataInputStream2.seek(6);
            readImageFileDirectory(byteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (exifAttribute2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        if (this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
            getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
        }
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute != null && exifAttribute2 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        java.lang.Double.parseDouble(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013e, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0144, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0130 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r13) {
        /*
            r0 = 4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = 10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = ","
            boolean r8 = r13.contains(r7)
            r9 = 0
            r10 = 1
            if (r8 == 0) goto L_0x00b6
            java.lang.String[] r13 = r13.split(r7, r5)
            r0 = r13[r9]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r3) goto L_0x0039
            return r0
        L_0x0039:
            int r1 = r13.length
            if (r10 >= r1) goto L_0x00b5
            r1 = r13[r10]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r0.first
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x005d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r3 = r0.first
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r5
            goto L_0x0065
        L_0x005d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0065:
            java.lang.Object r3 = r0.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 == r5) goto L_0x0090
            java.lang.Object r3 = r1.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r7 = r0.second
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0087
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r3 = r0.second
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0090
        L_0x0087:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0091
        L_0x0090:
            r1 = r5
        L_0x0091:
            if (r2 != r5) goto L_0x009b
            if (r1 != r5) goto L_0x009b
            android.util.Pair r13 = new android.util.Pair
            r13.<init>(r4, r6)
            return r13
        L_0x009b:
            if (r2 != r5) goto L_0x00a7
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r6)
            goto L_0x00b2
        L_0x00a7:
            if (r1 != r5) goto L_0x00b2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r6)
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0039
        L_0x00b5:
            return r0
        L_0x00b6:
            java.lang.String r7 = "/"
            boolean r8 = r13.contains(r7)
            r11 = 0
            if (r8 == 0) goto L_0x0102
            java.lang.String[] r13 = r13.split(r7, r5)
            int r0 = r13.length
            if (r0 != r3) goto L_0x00fc
            r0 = r13[r9]     // Catch:{ NumberFormatException -> 0x00fc }
            double r7 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00fc }
            long r7 = (long) r7     // Catch:{ NumberFormatException -> 0x00fc }
            r13 = r13[r10]     // Catch:{ NumberFormatException -> 0x00fc }
            double r9 = java.lang.Double.parseDouble(r13)     // Catch:{ NumberFormatException -> 0x00fc }
            long r9 = (long) r9     // Catch:{ NumberFormatException -> 0x00fc }
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x00f6
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x00de
            goto L_0x00f6
        L_0x00de:
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 > 0) goto L_0x00f0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00fc }
            r13.<init>(r2, r1)     // Catch:{ NumberFormatException -> 0x00fc }
            return r13
        L_0x00f0:
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00fc }
            r13.<init>(r1, r6)     // Catch:{ NumberFormatException -> 0x00fc }
            return r13
        L_0x00f6:
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00fc }
            r13.<init>(r2, r6)     // Catch:{ NumberFormatException -> 0x00fc }
            return r13
        L_0x00fc:
            android.util.Pair r13 = new android.util.Pair
            r13.<init>(r4, r6)
            return r13
        L_0x0102:
            long r1 = java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x0130 }
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 < 0) goto L_0x011c
            r7 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x011c
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x0130 }
            r2 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0130 }
            r1.<init>(r2, r0)     // Catch:{ NumberFormatException -> 0x0130 }
            return r1
        L_0x011c:
            if (r3 >= 0) goto L_0x012a
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x0130 }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0130 }
            r0.<init>(r1, r6)     // Catch:{ NumberFormatException -> 0x0130 }
            return r0
        L_0x012a:
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x0130 }
            r1.<init>(r0, r6)     // Catch:{ NumberFormatException -> 0x0130 }
            return r1
        L_0x0130:
            java.lang.Double.parseDouble(r13)     // Catch:{ NumberFormatException -> 0x013f }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013f }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x013f }
            r13.<init>(r0, r6)     // Catch:{ NumberFormatException -> 0x013f }
            return r13
        L_0x013f:
            android.util.Pair r13 = new android.util.Pair
            r13.<init>(r4, r6)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i5;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int min = Math.min(exifAttribute2.getIntValue(this.mExifByteOrder), byteOrderedDataInputStream.available() - intValue);
            int i6 = this.mMimeType;
            if (i6 == 4 || i6 == 9 || i6 == 10) {
                i5 = this.mExifOffset;
            } else {
                if (i6 == 7) {
                    i5 = this.mOrfMakerNoteOffset;
                }
                if (intValue > 0 && min > 0) {
                    this.mHasThumbnail = true;
                    this.mThumbnailOffset = intValue;
                    this.mThumbnailLength = min;
                    if (this.mFilename == null && this.mAssetInputStream == null) {
                        byte[] bArr = new byte[min];
                        byteOrderedDataInputStream.seek((long) intValue);
                        byteOrderedDataInputStream.readFully(bArr);
                        this.mThumbnailBytes = bArr;
                        return;
                    }
                    return;
                }
            }
            intValue += i5;
            if (intValue > 0) {
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray == null) {
                Log.w(TAG, "stripOffsets should not be null.");
            } else if (convertToLongArray2 == null) {
                Log.w(TAG, "stripByteCounts should not be null.");
            } else {
                long j5 = 0;
                for (long j6 : convertToLongArray2) {
                    j5 += j6;
                }
                int i5 = (int) j5;
                byte[] bArr = new byte[i5];
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < convertToLongArray.length; i8++) {
                    int i9 = (int) convertToLongArray2[i8];
                    int i10 = ((int) convertToLongArray[i8]) - i6;
                    if (i10 < 0) {
                        Log.d(TAG, "Invalid strip offset value");
                    }
                    byteOrderedDataInputStream.seek((long) i10);
                    int i11 = i6 + i10;
                    byte[] bArr2 = new byte[i9];
                    byteOrderedDataInputStream.read(bArr2);
                    i6 = i11 + i9;
                    System.arraycopy(bArr2, 0, bArr, i7, i9);
                    i7 += i9;
                }
                this.mHasThumbnail = true;
                this.mThumbnailBytes = bArr;
                this.mThumbnailLength = i5;
            }
        }
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i5 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i5 >= bArr2.length) {
                return true;
            }
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
            i5++;
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        if (readShort == 20306 || readShort == 21330) {
            return true;
        }
        return false;
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i5 = 0; i5 < bytes.length; i5++) {
            if (bArr[i5] != bytes[i5]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        if (readShort == 85) {
            return true;
        }
        return false;
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 == null) {
            return false;
        }
        int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
        int[] iArr2 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.mMimeType != 3 || (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        if ((intValue != 1 || !Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) && (intValue != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (intValue > 512 || intValue2 > 512) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.mIsSupportedFile = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        addDefaultValuesForCompatibility();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        addDefaultValuesForCompatibility();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAttributes(@androidx.annotation.NonNull java.io.InputStream r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r2 = EXIF_TAGS     // Catch:{ IOException -> 0x004a }
            int r2 = r2.length     // Catch:{ IOException -> 0x004a }
            if (r1 >= r2) goto L_0x0015
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r4.mAttributes     // Catch:{ IOException -> 0x004a }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x004a }
            r3.<init>()     // Catch:{ IOException -> 0x004a }
            r2[r1] = r3     // Catch:{ IOException -> 0x004a }
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0013:
            r5 = move-exception
            goto L_0x0050
        L_0x0015:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004a }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x004a }
            int r5 = r4.getMimeType(r1)     // Catch:{ IOException -> 0x004a }
            r4.mMimeType = r5     // Catch:{ IOException -> 0x004a }
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r5 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x004a }
            r5.<init>((java.io.InputStream) r1)     // Catch:{ IOException -> 0x004a }
            int r1 = r4.mMimeType     // Catch:{ IOException -> 0x004a }
            switch(r1) {
                case 0: goto L_0x003d;
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                case 3: goto L_0x003d;
                case 4: goto L_0x0039;
                case 5: goto L_0x003d;
                case 6: goto L_0x003d;
                case 7: goto L_0x0035;
                case 8: goto L_0x003d;
                case 9: goto L_0x0031;
                case 10: goto L_0x002d;
                case 11: goto L_0x003d;
                default: goto L_0x002c;
            }     // Catch:{ IOException -> 0x004a }
        L_0x002c:
            goto L_0x0040
        L_0x002d:
            r4.getRw2Attributes(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0040
        L_0x0031:
            r4.getRafAttributes(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0040
        L_0x0035:
            r4.getOrfAttributes(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0040
        L_0x0039:
            r4.getJpegAttributes(r5, r0, r0)     // Catch:{ IOException -> 0x004a }
            goto L_0x0040
        L_0x003d:
            r4.getRawAttributes(r5)     // Catch:{ IOException -> 0x004a }
        L_0x0040:
            r4.setThumbnailData(r5)     // Catch:{ IOException -> 0x004a }
            r5 = 1
            r4.mIsSupportedFile = r5     // Catch:{ IOException -> 0x004a }
            r4.addDefaultValuesForCompatibility()
            return
        L_0x004a:
            r4.mIsSupportedFile = r0     // Catch:{ all -> 0x0013 }
            r4.addDefaultValuesForCompatibility()
            return
        L_0x0050:
            r4.addDefaultValuesForCompatibility()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.loadAttributes(java.io.InputStream):void");
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i5) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i6 = this.mMimeType;
        if (i6 == 7 || i6 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt < 8 || readInt >= i5) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i7 = readInt - 8;
            if (i7 > 0 && byteOrderedDataInputStream.skipBytes(i7) != i7) {
                throw new IOException("Couldn't jump to first Ifd: " + i7);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void printAttributes() {
        for (int i5 = 0; i5 < this.mAttributes.length; i5++) {
            Log.d(TAG, "The size of tag group[" + i5 + "]: " + this.mAttributes[i5].size());
            for (Map.Entry next : this.mAttributes[i5].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                Log.d(TAG, "tagName: " + ((String) next.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void readExifSegment(byte[] bArr, int i5) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r27, int r28) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            java.util.Set<java.lang.Integer> r3 = r0.mAttributesOffsets
            int r4 = r1.mPosition
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.mPosition
            int r3 = r3 + 2
            int r4 = r1.mLength
            if (r3 <= r4) goto L_0x001b
            goto L_0x031e
        L_0x001b:
            short r3 = r1.readShort()
            int r4 = r1.mPosition
            int r5 = r3 * 12
            int r4 = r4 + r5
            int r5 = r1.mLength
            if (r4 > r5) goto L_0x031e
            if (r3 > 0) goto L_0x002c
            goto L_0x031e
        L_0x002c:
            r5 = 0
        L_0x002d:
            java.lang.String r9 = "ExifInterface"
            if (r5 >= r3) goto L_0x02ad
            int r10 = r1.readUnsignedShort()
            int r11 = r1.readUnsignedShort()
            int r12 = r1.readInt()
            int r13 = r1.peek()
            long r13 = (long) r13
            r15 = 4
            long r13 = r13 + r15
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$ExifTag>[] r17 = sExifTagMapsForReading
            r4 = r17[r2]
            r18 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r4.get(r6)
            androidx.exifinterface.media.ExifInterface$ExifTag r4 = (androidx.exifinterface.media.ExifInterface.ExifTag) r4
            r6 = 7
            if (r4 != 0) goto L_0x0072
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r20 = r15
            java.lang.String r15 = "Skip the tag entry since tag number is not defined: "
            r7.append(r15)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r9, r7)
        L_0x006e:
            r16 = 4
            goto L_0x00f2
        L_0x0072:
            r20 = r15
            if (r11 <= 0) goto L_0x007b
            int[] r7 = IFD_FORMAT_BYTES_PER_FORMAT
            int r15 = r7.length
            if (r11 < r15) goto L_0x007e
        L_0x007b:
            r16 = 4
            goto L_0x00de
        L_0x007e:
            boolean r15 = r4.isFormatCompatible(r11)
            if (r15 != 0) goto L_0x00a7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r15 = "Skip the tag entry since data format ("
            r7.append(r15)
            java.lang.String[] r15 = IFD_FORMAT_NAMES
            r15 = r15[r11]
            r7.append(r15)
            java.lang.String r15 = ") is unexpected for tag: "
            r7.append(r15)
            java.lang.String r15 = r4.name
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r9, r7)
            goto L_0x006e
        L_0x00a7:
            if (r11 != r6) goto L_0x00ab
            int r11 = r4.primaryFormat
        L_0x00ab:
            r16 = r7
            long r6 = (long) r12
            r15 = r16[r11]
            r22 = r9
            r16 = 4
            long r8 = (long) r15
            long r6 = r6 * r8
            int r8 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r8 < 0) goto L_0x00c6
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c2
            goto L_0x00c6
        L_0x00c2:
            r8 = 1
            r9 = r22
            goto L_0x00f5
        L_0x00c6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            r9 = r22
            android.util.Log.w(r9, r8)
        L_0x00dc:
            r8 = 0
            goto L_0x00f5
        L_0x00de:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r6.append(r7)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r9, r6)
        L_0x00f2:
            r6 = r18
            goto L_0x00dc
        L_0x00f5:
            if (r8 != 0) goto L_0x0100
            r1.seek(r13)
            r20 = r3
            r21 = r5
            goto L_0x02a4
        L_0x0100:
            int r8 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            java.lang.String r15 = "Compression"
            if (r8 <= 0) goto L_0x01a3
            int r8 = r1.readInt()
            r20 = r3
            int r3 = r0.mMimeType
            r21 = r5
            r5 = 7
            if (r3 != r5) goto L_0x0168
            java.lang.String r3 = "MakerNote"
            java.lang.String r5 = r4.name
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0122
            r0.mOrfMakerNoteOffset = r8
        L_0x011f:
            r22 = r6
            goto L_0x017a
        L_0x0122:
            r3 = 6
            if (r2 != r3) goto L_0x011f
            java.lang.String r5 = "ThumbnailImage"
            java.lang.String r3 = r4.name
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x011f
            r0.mOrfThumbnailOffset = r8
            r0.mOrfThumbnailLength = r12
            java.nio.ByteOrder r3 = r0.mExifByteOrder
            r5 = 6
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createUShort((int) r5, (java.nio.ByteOrder) r3)
            int r5 = r0.mOrfThumbnailOffset
            r22 = r6
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r5 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r5, (java.nio.ByteOrder) r7)
            int r6 = r0.mOrfThumbnailLength
            long r6 = (long) r6
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$ExifAttribute r2 = androidx.exifinterface.media.ExifInterface.ExifAttribute.createULong((long) r6, (java.nio.ByteOrder) r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r6 = r0.mAttributes
            r6 = r6[r16]
            r6.put(r15, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r16]
            java.lang.String r6 = "JPEGInterchangeFormat"
            r3.put(r6, r5)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r3 = r0.mAttributes
            r3 = r3[r16]
            java.lang.String r5 = "JPEGInterchangeFormatLength"
            r3.put(r5, r2)
            goto L_0x017a
        L_0x0168:
            r22 = r6
            r2 = 10
            if (r3 != r2) goto L_0x017a
            java.lang.String r2 = "JpgFromRaw"
            java.lang.String r3 = r4.name
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x017a
            r0.mRw2JpgFromRawOffset = r8
        L_0x017a:
            long r2 = (long) r8
            long r6 = r2 + r22
            int r5 = r1.mLength
            r24 = r6
            long r5 = (long) r5
            int r5 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x018a
            r1.seek(r2)
            goto L_0x01a9
        L_0x018a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip the tag entry since data offset is invalid: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
            r1.seek(r13)
            goto L_0x02a4
        L_0x01a3:
            r20 = r3
            r21 = r5
            r22 = r6
        L_0x01a9:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = sExifPointerTagMap
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r3 = 8
            r5 = 3
            if (r2 == 0) goto L_0x023f
            if (r11 == r5) goto L_0x01dd
            r4 = r16
            if (r11 == r4) goto L_0x01d8
            if (r11 == r3) goto L_0x01d3
            r3 = 9
            if (r11 == r3) goto L_0x01cd
            r3 = 13
            if (r11 == r3) goto L_0x01cd
            r3 = -1
            goto L_0x01e2
        L_0x01cd:
            int r3 = r1.readInt()
        L_0x01d1:
            long r3 = (long) r3
            goto L_0x01e2
        L_0x01d3:
            short r3 = r1.readShort()
            goto L_0x01d1
        L_0x01d8:
            long r3 = r1.readUnsignedInt()
            goto L_0x01e2
        L_0x01dd:
            int r3 = r1.readUnsignedShort()
            goto L_0x01d1
        L_0x01e2:
            int r5 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x0227
            int r5 = r1.mLength
            long r5 = (long) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0227
            java.util.Set<java.lang.Integer> r5 = r0.mAttributesOffsets
            int r6 = (int) r3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x0205
            r1.seek(r3)
            int r2 = r2.intValue()
            r0.readImageFileDirectory(r1, r2)
            goto L_0x023b
        L_0x0205:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = " (at "
            r5.append(r2)
            r5.append(r3)
            java.lang.String r2 = ")"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.w(r9, r2)
            goto L_0x023b
        L_0x0227:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r5)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r9, r2)
        L_0x023b:
            r1.seek(r13)
            goto L_0x02a4
        L_0x023f:
            r6 = r22
            int r2 = (int) r6
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r6 = new androidx.exifinterface.media.ExifInterface$ExifAttribute
            r6.<init>(r11, r12, r2)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r2 = r2[r28]
            java.lang.String r7 = r4.name
            r2.put(r7, r6)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r7 = r4.name
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0261
            r0.mMimeType = r5
        L_0x0261:
            java.lang.String r2 = "Make"
            java.lang.String r5 = r4.name
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0275
            java.lang.String r2 = "Model"
            java.lang.String r5 = r4.name
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0283
        L_0x0275:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            java.lang.String r2 = r6.getStringValue(r2)
            java.lang.String r5 = "PENTAX"
            boolean r2 = r2.contains(r5)
            if (r2 != 0) goto L_0x0296
        L_0x0283:
            java.lang.String r2 = r4.name
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x0298
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            int r2 = r6.getIntValue(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x0298
        L_0x0296:
            r0.mMimeType = r3
        L_0x0298:
            int r2 = r1.peek()
            long r2 = (long) r2
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x02a4
            r1.seek(r13)
        L_0x02a4:
            int r5 = r21 + 1
            short r5 = (short) r5
            r2 = r28
            r3 = r20
            goto L_0x002d
        L_0x02ad:
            r18 = 0
            int r2 = r1.peek()
            r16 = 4
            int r2 = r2 + 4
            int r3 = r1.mLength
            if (r2 > r3) goto L_0x031e
            int r2 = r1.readInt()
            long r3 = (long) r2
            int r5 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r5 <= 0) goto L_0x030a
            int r5 = r1.mLength
            if (r2 >= r5) goto L_0x030a
            java.util.Set<java.lang.Integer> r5 = r0.mAttributesOffsets
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x02f5
            r1.seek(r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r4 = 4
            r2 = r2[r4]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02e6
            r0.readImageFileDirectory(r1, r4)
            return
        L_0x02e6:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$ExifAttribute>[] r2 = r0.mAttributes
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x031e
            r0.readImageFileDirectory(r1, r3)
            return
        L_0x02f5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
            return
        L_0x030a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    private void removeAttribute(String str) {
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            this.mAttributes[i5].remove(str);
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i5) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.mAttributes[i5].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute3 = this.mAttributes[i5].get(TAG_IMAGE_WIDTH);
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.mAttributes[i5].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            getJpegAttributes(byteOrderedDataInputStream, exifAttribute.getIntValue(this.mExifByteOrder), i5);
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (dataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream, 6);
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        copy(dataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i5 = readUnsignedShort - 2;
                        if (i5 >= 0) {
                            while (i5 > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i5, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i5 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                        int i6 = readUnsignedShort2 - 2;
                        if (i6 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (i6 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    int i7 = readUnsignedShort2 - 8;
                                    if (dataInputStream.skipBytes(i7) != i7) {
                                        throw new IOException("Invalid length");
                                    }
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2);
                            if (i6 >= 6) {
                                i6 = readUnsignedShort2 - 8;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (i6 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(i6, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                i6 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private void swapBasedOnImageSize(int i5, int i6) throws IOException {
        if (!this.mAttributes[i5].isEmpty() && !this.mAttributes[i6].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i5].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[i5].get(TAG_IMAGE_WIDTH);
            ExifAttribute exifAttribute3 = this.mAttributes[i6].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute4 = this.mAttributes[i6].get(TAG_IMAGE_WIDTH);
            if (exifAttribute != null && exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i5];
                    hashMapArr[i5] = hashMapArr[i6];
                    hashMapArr[i6] = hashMap;
                }
            }
        }
    }

    private boolean updateAttribute(String str, ExifAttribute exifAttribute) {
        boolean z4 = false;
        for (int i5 = 0; i5 < EXIF_TAGS.length; i5++) {
            if (this.mAttributes[i5].containsKey(str)) {
                this.mAttributes[i5].put(str, exifAttribute);
                z4 = true;
            }
        }
        return z4;
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i5) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i5].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute4 = this.mAttributes[i5].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i5].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute6 = this.mAttributes[i5].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute7 = this.mAttributes[i5].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i5].put(TAG_IMAGE_WIDTH, exifAttribute2);
            this.mAttributes[i5].put(TAG_IMAGE_LENGTH, exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(byteOrderedDataInputStream, i5);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i5].put(TAG_IMAGE_LENGTH, createUShort);
                this.mAttributes[i5].put(TAG_IMAGE_WIDTH, createUShort2);
            }
        }
    }

    private void validateImages(InputStream inputStream) throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i5) throws IOException {
        short s5;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = byteOrderedDataOutputStream;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
            for (Object obj : this.mAttributes[i6].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i6].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        int i7 = 2;
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            int i9 = 0;
            for (Map.Entry<String, ExifAttribute> value : this.mAttributes[i8].entrySet()) {
                int size = ((ExifAttribute) value.getValue()).size();
                if (size > 4) {
                    i9 += size;
                }
            }
            iArr2[i8] = iArr2[i8] + i9;
        }
        int i10 = 8;
        for (int i11 = 0; i11 < EXIF_TAGS.length; i11++) {
            if (!this.mAttributes[i11].isEmpty()) {
                iArr[i11] = i10;
                i10 += (this.mAttributes[i11].size() * 12) + 6 + iArr2[i11];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long) i10, this.mExifByteOrder));
            this.mThumbnailOffset = i5 + i10;
            i10 += this.mThumbnailLength;
        }
        int i12 = i10 + 8;
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        byteOrderedDataOutputStream2.writeUnsignedShort(i12);
        byteOrderedDataOutputStream2.write(IDENTIFIER_EXIF_APP1);
        if (this.mExifByteOrder == ByteOrder.BIG_ENDIAN) {
            s5 = BYTE_ALIGN_MM;
        } else {
            s5 = BYTE_ALIGN_II;
        }
        byteOrderedDataOutputStream2.writeShort(s5);
        byteOrderedDataOutputStream2.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream2.writeUnsignedShort(42);
        byteOrderedDataOutputStream2.writeUnsignedInt(8);
        int i13 = 0;
        while (i13 < EXIF_TAGS.length) {
            if (!this.mAttributes[i13].isEmpty()) {
                byteOrderedDataOutputStream2.writeUnsignedShort(this.mAttributes[i13].size());
                int size2 = iArr[i13] + i7 + (this.mAttributes[i13].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i13].entrySet()) {
                    int i14 = sExifTagMapsForWriting[i13].get(next.getKey()).number;
                    ExifAttribute exifAttribute = (ExifAttribute) next.getValue();
                    int size3 = exifAttribute.size();
                    byteOrderedDataOutputStream2.writeUnsignedShort(i14);
                    byteOrderedDataOutputStream2.writeUnsignedShort(exifAttribute.format);
                    byteOrderedDataOutputStream2.writeInt(exifAttribute.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream2.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream2.write(exifAttribute.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream2.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i13 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream2.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream2.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> value2 : this.mAttributes[i13].entrySet()) {
                    byte[] bArr = ((ExifAttribute) value2.getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream2.write(bArr, 0, bArr.length);
                    }
                }
            }
            i13++;
            i7 = 2;
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream2.write(getThumbnailBytes());
        }
        byteOrderedDataOutputStream2.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i12;
    }

    public void flipHorizontally() {
        int i5 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i5 = 2;
                break;
            case 2:
                break;
            case 3:
                i5 = 4;
                break;
            case 4:
                i5 = 3;
                break;
            case 5:
                i5 = 6;
                break;
            case 6:
                i5 = 5;
                break;
            case 7:
                i5 = 8;
                break;
            case 8:
                i5 = 7;
                break;
            default:
                i5 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i5));
    }

    public void flipVertically() {
        int i5 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 3;
                break;
            case 3:
                i5 = 2;
                break;
            case 4:
                break;
            case 5:
                i5 = 8;
                break;
            case 6:
                i5 = 7;
                break;
            case 7:
                i5 = 6;
                break;
            case 8:
                i5 = 5;
                break;
            default:
                i5 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i5));
    }

    public double getAltitude(double d5) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i5 = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d5;
        }
        if (attributeInt != 1) {
            i5 = 1;
        }
        return attributeDouble * ((double) i5);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i5 = exifAttribute.format;
                if (i5 == 5 || i5 == 10) {
                    Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                    if (rationalArr == null || rationalArr.length != 3) {
                        Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                        return null;
                    }
                    Rational rational = rationalArr[0];
                    Integer valueOf = Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator)));
                    Rational rational2 = rationalArr[1];
                    Integer valueOf2 = Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator)));
                    Rational rational3 = rationalArr[2];
                    return String.format("%02d:%02d:%02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator)))});
                }
                Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                return null;
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double getAttributeDouble(@NonNull String str, double d5) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            try {
                return exifAttribute.getDoubleValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
            }
        }
        return d5;
    }

    public int getAttributeInt(@NonNull String str, int i5) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
            }
        }
        return i5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        String attribute = getAttribute(TAG_DATETIME);
        if (attribute != null && sNonZeroTimePattern.matcher(attribute).matches()) {
            try {
                Date parse = sFormatter.parse(attribute, new ParsePosition(0));
                if (parse == null) {
                    return -1;
                }
                long time = parse.getTime();
                String attribute2 = getAttribute(TAG_SUBSEC_TIME);
                if (attribute2 == null) {
                    return time;
                }
                try {
                    long parseLong = Long.parseLong(attribute2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    return time + parseLong;
                } catch (NumberFormatException unused) {
                    return time;
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = sNonZeroTimePattern;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    Date parse = sFormatter.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return -1;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return SubsamplingScaleImageView.ORIENTATION_180;
            case 5:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i5 = this.mThumbnailCompression;
        if (i5 == 6 || i5 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i5 = this.mThumbnailCompression;
        if (i5 == 6 || i5 == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i5 == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                byte[] bArr = this.mThumbnailBytes;
                int i7 = i6 * 3;
                iArr[i6] = (bArr[i7] << 16) + (bArr[i7 + 1] << 8) + bArr[i7 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.mAttributes[4].get(TAG_IMAGE_WIDTH);
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    @Nullable
    public byte[] getThumbnailBytes() {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (!this.mHasThumbnail) {
            return null;
        }
        byte[] bArr = this.mThumbnailBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
            inputStream = this.mAssetInputStream;
            if (inputStream != null) {
                try {
                    if (inputStream.markSupported()) {
                        inputStream.reset();
                    } else {
                        Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");
                        closeQuietly(inputStream);
                        return null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    try {
                        Log.d(TAG, "Encountered exception while getting thumbnail", e);
                        closeQuietly(inputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        closeQuietly(inputStream2);
                        throw th;
                    }
                }
            } else if (this.mFilename != null) {
                inputStream = new FileInputStream(this.mFilename);
            } else {
                inputStream = null;
            }
            if (inputStream != null) {
                if (inputStream.skip((long) this.mThumbnailOffset) == ((long) this.mThumbnailOffset)) {
                    byte[] bArr2 = new byte[this.mThumbnailLength];
                    if (inputStream.read(bArr2) == this.mThumbnailLength) {
                        this.mThumbnailBytes = bArr2;
                        closeQuietly(inputStream);
                        return bArr2;
                    }
                    throw new IOException("Corrupted image");
                }
                throw new IOException("Corrupted image");
            }
            throw new FileNotFoundException();
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
            Log.d(TAG, "Encountered exception while getting thumbnail", e);
            closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(inputStream2);
            throw th;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (!this.mHasThumbnail) {
            return null;
        }
        return new long[]{(long) this.mThumbnailOffset, (long) this.mThumbnailLength};
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        if (attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5) {
            return true;
        }
        return false;
    }

    public boolean isThumbnailCompressed() {
        int i5 = this.mThumbnailCompression;
        if (i5 == 6 || i5 == 7) {
            return true;
        }
        return false;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i5) {
        if (i5 % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            List<Integer> list = ROTATION_ORDER;
            int i6 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i5 / 90)) % 4;
                if (indexOf < 0) {
                    i6 = 4;
                }
                i6 = list.get(indexOf + i6).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i5 / 90)) % 4;
                    if (indexOf2 < 0) {
                        i6 = 4;
                    }
                    i6 = list2.get(indexOf2 + i6).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i6));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        if (!this.mIsSupportedFile || this.mMimeType != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.mFilename != null) {
            this.mThumbnailBytes = getThumbnail();
            File file = new File(this.mFilename + ".tmp");
            if (new File(this.mFilename).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.mFilename);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream = null;
                        th = th3;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                    try {
                        saveJpegAttributes(fileInputStream, fileOutputStream);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        this.mThumbnailBytes = null;
                    } catch (Throwable th4) {
                        th = th4;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th5) {
                    fileOutputStream = null;
                    th = th5;
                    fileInputStream = null;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    file.delete();
                    throw th;
                }
            } else {
                throw new IOException("Could not rename to " + file.getAbsolutePath());
            }
        } else {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
    }

    public void setAltitude(double d5) {
        String str;
        if (d5 >= 0.0d) {
            str = "0";
        } else {
            str = "1";
        }
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d5)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        String str3;
        int i5;
        String str4;
        int i6;
        ExifTag exifTag;
        int i7;
        String str5;
        String str6 = str2;
        String str7 = str;
        if (TAG_ISO_SPEED_RATINGS.equals(str7)) {
            str3 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        } else {
            str3 = str7;
        }
        int i8 = 2;
        String str8 = TAG;
        int i9 = 1;
        if (str6 != null && sTagSetForCompatibility.contains(str3)) {
            if (str3.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = sGpsTimestampPattern.matcher(str6);
                if (!matcher.find()) {
                    Log.w(str8, "Invalid value for " + str3 + " : " + str6);
                    return;
                }
                str6 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str6 = new Rational(Double.parseDouble(str6)).toString();
                } catch (NumberFormatException unused) {
                    Log.w(str8, "Invalid value for " + str3 + " : " + str6);
                    return;
                }
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (i11 < EXIF_TAGS.length) {
            if ((i11 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i11].get(str3)) != null) {
                if (str6 != null) {
                    Pair<Integer, Integer> guessDataFormat = guessDataFormat(str6);
                    if (exifTag.primaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.primaryFormat == ((Integer) guessDataFormat.second).intValue()) {
                        i7 = exifTag.primaryFormat;
                    } else {
                        int i12 = exifTag.secondaryFormat;
                        if (i12 == -1 || !(i12 == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                            int i13 = exifTag.primaryFormat;
                            if (i13 == i9 || i13 == 7 || i13 == i8) {
                                i7 = i13;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str3);
                                sb.append(") value didn't match with one of expected ");
                                sb.append("formats: ");
                                String[] strArr = IFD_FORMAT_NAMES;
                                sb.append(strArr[exifTag.primaryFormat]);
                                String str9 = "";
                                if (exifTag.secondaryFormat == -1) {
                                    str5 = str9;
                                } else {
                                    str5 = ", " + strArr[exifTag.secondaryFormat];
                                }
                                sb.append(str5);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) guessDataFormat.first).intValue()]);
                                if (((Integer) guessDataFormat.second).intValue() != -1) {
                                    str9 = ", " + strArr[((Integer) guessDataFormat.second).intValue()];
                                }
                                sb.append(str9);
                                sb.append(")");
                                Log.w(str8, sb.toString());
                            }
                        } else {
                            i7 = exifTag.secondaryFormat;
                        }
                    }
                    switch (i7) {
                        case 1:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            this.mAttributes[i11].put(str3, ExifAttribute.createByte(str6));
                            continue;
                        case 2:
                        case 7:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            this.mAttributes[i11].put(str3, ExifAttribute.createString(str6));
                            continue;
                        case 3:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            String[] split = str6.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i14 = i5; i14 < split.length; i14++) {
                                iArr[i14] = Integer.parseInt(split[i14]);
                            }
                            this.mAttributes[i11].put(str3, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                            continue;
                        case 4:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            String[] split2 = str6.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i15 = i5; i15 < split2.length; i15++) {
                                jArr[i15] = Long.parseLong(split2[i15]);
                            }
                            this.mAttributes[i11].put(str3, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                            continue;
                        case 5:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            String[] split3 = str6.split(",", -1);
                            Rational[] rationalArr = new Rational[split3.length];
                            for (int i16 = i5; i16 < split3.length; i16++) {
                                String[] split4 = split3[i16].split("/", -1);
                                rationalArr[i16] = new Rational((long) Double.parseDouble(split4[i5]), (long) Double.parseDouble(split4[i6]));
                            }
                            this.mAttributes[i11].put(str3, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                            continue;
                        case 9:
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            String[] split5 = str6.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i17 = i5; i17 < split5.length; i17++) {
                                iArr2[i17] = Integer.parseInt(split5[i17]);
                            }
                            this.mAttributes[i11].put(str3, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                            continue;
                        case 10:
                            String[] split6 = str6.split(",", -1);
                            Rational[] rationalArr2 = new Rational[split6.length];
                            int i18 = i10;
                            while (i18 < split6.length) {
                                String[] split7 = split6[i18].split("/", -1);
                                rationalArr2[i18] = new Rational((long) Double.parseDouble(split7[i10]), (long) Double.parseDouble(split7[i9]));
                                i18++;
                                str8 = str8;
                                i10 = i10;
                                i9 = i9;
                            }
                            str4 = str8;
                            i6 = i9;
                            i5 = i10;
                            this.mAttributes[i11].put(str3, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                            continue;
                        case 12:
                            String[] split8 = str6.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i19 = i10; i19 < split8.length; i19++) {
                                dArr[i19] = Double.parseDouble(split8[i19]);
                            }
                            this.mAttributes[i11].put(str3, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                            break;
                        default:
                            Log.w(str8, "Data format isn't one of expected formats: " + i7);
                            break;
                    }
                } else {
                    this.mAttributes[i11].remove(str3);
                }
            }
            str4 = str8;
            i6 = i9;
            i5 = i10;
            i11++;
            str8 = str4;
            i10 = i5;
            i9 = i6;
            i8 = 2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j5) {
        setAttribute(TAG_DATETIME, sFormatter.format(new Date(j5)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(j5 % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatter.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d5, double d6) {
        String str;
        String str2;
        if (d5 < -90.0d || d5 > 90.0d || Double.isNaN(d5)) {
            throw new IllegalArgumentException("Latitude value " + d5 + " is not valid.");
        } else if (d6 < -180.0d || d6 > 180.0d || Double.isNaN(d6)) {
            throw new IllegalArgumentException("Longitude value " + d6 + " is not valid.");
        } else {
            if (d5 >= 0.0d) {
                str = "N";
            } else {
                str = LATITUDE_SOUTH;
            }
            setAttribute(TAG_GPS_LATITUDE_REF, str);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d5)));
            if (d6 >= 0.0d) {
                str2 = LONGITUDE_EAST;
            } else {
                str2 = LONGITUDE_WEST;
            }
            setAttribute(TAG_GPS_LONGITUDE_REF, str2);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d6)));
        }
    }

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
        }

        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int peek() {
            return this.mPosition;
        }

        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        public byte readByte() throws IOException {
            int i5 = this.mPosition + 1;
            this.mPosition = i5;
            if (i5 <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i5, int i6) throws IOException {
            int i7 = this.mPosition + i6;
            this.mPosition = i7;
            if (i7 > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, i5, i6) != i6) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i5 = this.mPosition + 4;
            this.mPosition = i5;
            if (i5 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            int i5 = this.mPosition + 8;
            this.mPosition = i5;
            if (i5 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i5 = this.mPosition + 2;
            this.mPosition = i5;
            if (i5 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            int i5 = this.mPosition + 2;
            this.mPosition = i5;
            if (i5 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j5) throws IOException {
            int i5 = this.mPosition;
            if (((long) i5) > j5) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j5 -= (long) i5;
            }
            int i6 = (int) j5;
            if (skipBytes(i6) != i6) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public int skipBytes(int i5) throws IOException {
            int min = Math.min(i5, this.mLength - this.mPosition);
            int i6 = 0;
            while (i6 < min) {
                i6 += this.mDataInputStream.skipBytes(min - i6);
            }
            this.mPosition += i6;
            return i6;
        }

        public int read(byte[] bArr, int i5, int i6) throws IOException {
            int read = this.mDataInputStream.read(bArr, i5, i6);
            this.mPosition += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Latitude/longitude values are not parseable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            return null;
        }
    }

    private static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i5, int i6, byte[] bArr) {
            this.format = i5;
            this.numberOfComponents = i6;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes2 = str.getBytes(ExifInterface.ASCII);
                return new ExifAttribute(1, bytes2.length, bytes2);
            }
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j5 : jArr) {
                wrap.putInt((int) j5);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i5 : iArr) {
                wrap.putShort((short) i5);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i5 < jArr.length) {
                    sb.append(jArr[i5]);
                    i5++;
                    if (i5 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i5 < iArr.length) {
                    sb.append(iArr[i5]);
                    i5++;
                    if (i5 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i5 < dArr.length) {
                    sb.append(dArr[i5]);
                    i5++;
                    if (i5 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i5 < rationalArr.length) {
                    sb.append(rationalArr[i5].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i5].denominator);
                    i5++;
                    if (i5 != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: int[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: long[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: int[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: int[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: double[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: double[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r11v23, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* JADX WARNING: type inference failed for: r11v29, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x014c A[SYNTHETIC, Splitter:B:105:0x014c] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0141 A[SYNTHETIC, Splitter:B:99:0x0141] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object getValue(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r3 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch:{ IOException -> 0x0138, all -> 0x0136 }
                byte[] r4 = r10.bytes     // Catch:{ IOException -> 0x0138, all -> 0x0136 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0138, all -> 0x0136 }
                r3.setByteOrder(r11)     // Catch:{ IOException -> 0x0033 }
                int r11 = r10.format     // Catch:{ IOException -> 0x0033 }
                r4 = 0
                switch(r11) {
                    case 1: goto L_0x010c;
                    case 2: goto L_0x00cb;
                    case 3: goto L_0x00ba;
                    case 4: goto L_0x00a9;
                    case 5: goto L_0x008f;
                    case 6: goto L_0x010c;
                    case 7: goto L_0x00cb;
                    case 8: goto L_0x007e;
                    case 9: goto L_0x006d;
                    case 10: goto L_0x0051;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001e;
                    default: goto L_0x0015;
                }
            L_0x0015:
                r3.close()     // Catch:{ IOException -> 0x0019 }
                return r2
            L_0x0019:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
                return r2
            L_0x001e:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0022:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                double r5 = r3.readDouble()     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0022
            L_0x002f:
                r11 = move-exception
                r2 = r3
                goto L_0x014a
            L_0x0033:
                r11 = move-exception
                goto L_0x013a
            L_0x0036:
                r3.close()     // Catch:{ IOException -> 0x003a }
                return r11
            L_0x003a:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
                return r11
            L_0x003f:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0043:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                float r5 = r3.readFloat()     // Catch:{ IOException -> 0x0033 }
                double r5 = (double) r5     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0043
            L_0x0051:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0055:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0033 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x0033 }
                int r7 = r3.readInt()     // Catch:{ IOException -> 0x0033 }
                long r7 = (long) r7     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0055
            L_0x006d:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0071:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0071
            L_0x007e:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0082:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                short r5 = r3.readShort()     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0082
            L_0x008f:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational[] r11 = new androidx.exifinterface.media.ExifInterface.Rational[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x0093:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                long r7 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$Rational r9 = new androidx.exifinterface.media.ExifInterface$Rational     // Catch:{ IOException -> 0x0033 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x0093
            L_0x00a9:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x00ad:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                long r5 = r3.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x00ad
            L_0x00ba:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0033 }
            L_0x00be:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0036
                int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0033 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0033 }
                int r4 = r4 + 1
                goto L_0x00be
            L_0x00cb:
                int r11 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                byte[] r5 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r5 = r5.length     // Catch:{ IOException -> 0x0033 }
                if (r11 < r5) goto L_0x00e5
                r11 = r4
            L_0x00d3:
                byte[] r5 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r6 = r5.length     // Catch:{ IOException -> 0x0033 }
                if (r11 >= r6) goto L_0x00e4
                byte[] r6 = r10.bytes     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r11]     // Catch:{ IOException -> 0x0033 }
                byte r5 = r5[r11]     // Catch:{ IOException -> 0x0033 }
                if (r6 == r5) goto L_0x00e1
                goto L_0x00e5
            L_0x00e1:
                int r11 = r11 + 1
                goto L_0x00d3
            L_0x00e4:
                int r4 = r5.length     // Catch:{ IOException -> 0x0033 }
            L_0x00e5:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
                r11.<init>()     // Catch:{ IOException -> 0x0033 }
            L_0x00ea:
                int r5 = r10.numberOfComponents     // Catch:{ IOException -> 0x0033 }
                if (r4 >= r5) goto L_0x0106
                byte[] r5 = r10.bytes     // Catch:{ IOException -> 0x0033 }
                byte r5 = r5[r4]     // Catch:{ IOException -> 0x0033 }
                if (r5 != 0) goto L_0x00f5
                goto L_0x0106
            L_0x00f5:
                r6 = 32
                if (r5 < r6) goto L_0x00fe
                char r5 = (char) r5     // Catch:{ IOException -> 0x0033 }
                r11.append(r5)     // Catch:{ IOException -> 0x0033 }
                goto L_0x0103
            L_0x00fe:
                r5 = 63
                r11.append(r5)     // Catch:{ IOException -> 0x0033 }
            L_0x0103:
                int r4 = r4 + 1
                goto L_0x00ea
            L_0x0106:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0033 }
                goto L_0x0036
            L_0x010c:
                byte[] r11 = r10.bytes     // Catch:{ IOException -> 0x0033 }
                int r5 = r11.length     // Catch:{ IOException -> 0x0033 }
                r6 = 1
                if (r5 != r6) goto L_0x0126
                byte r5 = r11[r4]     // Catch:{ IOException -> 0x0033 }
                if (r5 < 0) goto L_0x0126
                if (r5 > r6) goto L_0x0126
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                int r5 = r5 + 48
                char r5 = (char) r5     // Catch:{ IOException -> 0x0033 }
                char[] r6 = new char[r6]     // Catch:{ IOException -> 0x0033 }
                r6[r4] = r5     // Catch:{ IOException -> 0x0033 }
                r11.<init>(r6)     // Catch:{ IOException -> 0x0033 }
                goto L_0x0036
            L_0x0126:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                java.nio.charset.Charset r5 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x0033 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0033 }
                r3.close()     // Catch:{ IOException -> 0x0131 }
                return r4
            L_0x0131:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
                return r4
            L_0x0136:
                r11 = move-exception
                goto L_0x014a
            L_0x0138:
                r11 = move-exception
                r3 = r2
            L_0x013a:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x002f }
                if (r3 == 0) goto L_0x0149
                r3.close()     // Catch:{ IOException -> 0x0145 }
                goto L_0x0149
            L_0x0145:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0149:
                return r2
            L_0x014a:
                if (r2 == 0) goto L_0x0154
                r2.close()     // Catch:{ IOException -> 0x0150 }
                goto L_0x0154
            L_0x0150:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0154:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public static ExifAttribute createDouble(double d5, ByteOrder byteOrder) {
            return createDouble(new double[]{d5}, byteOrder);
        }

        public static ExifAttribute createSLong(int i5, ByteOrder byteOrder) {
            return createSLong(new int[]{i5}, byteOrder);
        }

        public static ExifAttribute createULong(long j5, ByteOrder byteOrder) {
            return createULong(new long[]{j5}, byteOrder);
        }

        public static ExifAttribute createUShort(int i5, ByteOrder byteOrder) {
            return createUShort(new int[]{i5}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i5, int i6) {
            this.name = str;
            this.number = i5;
            this.primaryFormat = i6;
            this.secondaryFormat = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean isFormatCompatible(int i5) {
            int i6;
            int i7 = this.primaryFormat;
            if (i7 == 7 || i5 == 7 || i7 == i5 || (i6 = this.secondaryFormat) == i5) {
                return true;
            }
            if ((i7 == 4 || i6 == 4) && i5 == 3) {
                return true;
            }
            if ((i7 == 9 || i6 == 9) && i5 == 8) {
                return true;
            }
            if ((i7 == 12 || i6 == 12) && i5 == 11) {
                return true;
            }
            return false;
        }

        ExifTag(String str, int i5, int i6, int i7) {
            this.name = str;
            this.number = i5;
            this.primaryFormat = i6;
            this.secondaryFormat = i7;
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        if (inputStream != null) {
            this.mFilename = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.mAssetInputStream = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
