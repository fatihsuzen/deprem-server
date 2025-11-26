package com.inmobi.cmp;

import F1.a;
import F1.b;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;

public interface ChoiceCmpCallback {
    void onActionButtonClicked(a aVar);

    void onCCPAConsentGiven(String str);

    void onCMPUIStatusChanged(b bVar);

    void onCmpError(ChoiceError choiceError);

    void onCmpLoaded(PingReturn pingReturn);

    void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents);

    void onGoogleVendorConsentGiven(ACData aCData);

    void onIABVendorConsentGiven(GDPRData gDPRData);

    void onNonIABVendorConsentGiven(NonIABData nonIABData);

    void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData);

    void onUserMovedToOtherState();
}
