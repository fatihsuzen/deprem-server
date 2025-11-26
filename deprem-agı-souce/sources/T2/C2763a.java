package t2;

import androidx.preference.Preference;
import com.uptodown.tv.preferences.TvPrivacyPreferences;

/* renamed from: t2.a  reason: case insensitive filesystem */
public final /* synthetic */ class C2763a implements Preference.OnPreferenceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvPrivacyPreferences.a f25879a;

    public /* synthetic */ C2763a(TvPrivacyPreferences.a aVar) {
        this.f25879a = aVar;
    }

    public final boolean onPreferenceClick(Preference preference) {
        return TvPrivacyPreferences.a.i(this.f25879a, preference);
    }
}
