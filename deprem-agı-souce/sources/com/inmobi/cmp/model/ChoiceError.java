package com.inmobi.cmp.model;

public enum ChoiceError {
    NO_CONNECTION("No connection found to load CMP"),
    ACTIVITY_ERROR("Your launcher activity should extends from AppCompatActivity"),
    INVALID_PCODE("Given pCode is invalid"),
    UNKNOWN_CONFIG("Could not find configuration for this packageId. Have you set it up in Inmobi Choice web portal?"),
    MISSING_INITIALIZATION("SDK must be initialized first by calling startChoice method"),
    NETWORK_CALL_FAILED("An error has occurred when CMP tried to execute a network call"),
    INVALID_JSON_FORMAT("An invalid json format has been found when CMP tried to read the data"),
    FAILED_LOGO_DOWNLOAD("Couldn't load publisher logo, url is empty or it doesn't return an image"),
    TC_MODEL_PROPERTY_ERROR("An error has occurred when a TCModel property was tried to be set"),
    GEO_IP_UNEXPECTED_ERROR("An unexpected value was received from GeoIp service"),
    NETWORK_UNEXPECTED_ERROR("An unexpected error has occurred when CMP tried to do a network call"),
    NETWORK_FILE_NOT_FOUND_ERROR("FileNotFoundException has been captured when CMP tried to do a network call"),
    ENCODE_NUM_BIT_ERROR("The value is too large to be encode into the number of bits passed"),
    ENCODE_INVALID_BIT_LENGTH("Invalid bit length"),
    INVALID_URL("An invalid URL has been passed"),
    INVALID_LOCATION("This consent is not available for the given country"),
    MISSING_INIT_SCREEN_TEXTS("Init screen texts are missing"),
    GDPR_NA("GDPR is not applicable for this scenario"),
    GBC_NOT_APPLICABLE("Either GBC is not applicable or disabled for the current location"),
    US_PRIVACY_NOT_APPLICABLE("Either US Privacy is not applicable or disabled for the current location"),
    UNEXPECTED_ERROR_OCCURRED("Some unknown error occurred"),
    ERROR_WHILE_SAVING_CONSENT("Some error occurred while saving consent"),
    AUTO_POPUP_DISABLED_AND_NOT_APPLICABLE("Auto pop-up is disabled and not applicable for this region because CCPA is enabled for this region"),
    AUTO_POP_NOT_APPLICABLE("Auto pop-up is not applicable for this region as CCPA is enabled"),
    AUTO_POPUP_DISABLED("Auto pop-up is disabled so no dialog will be shown"),
    US_REGULATION_NO_RE_TRIGGER("MSPA is applicable but no need to re-trigger the screen");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f7846a;

    /* access modifiers changed from: public */
    ChoiceError(String str) {
        this.f7846a = str;
    }

    public final String getMessage() {
        return this.f7846a;
    }
}
