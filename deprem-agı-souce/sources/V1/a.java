package v1;

import com.mbridge.msdk.foundation.entity.CampaignEx;

public enum a {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    

    /* renamed from: a  reason: collision with root package name */
    String f16746a;

    private a(String str) {
        this.f16746a = str;
    }

    public String toString() {
        return this.f16746a;
    }
}
