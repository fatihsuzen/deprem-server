package com.uptodown.tv.preferences;

import Q1.C0969z;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.t;
import t2.C2763a;
import t2.b;
import t2.c;
import z2.C2962v;

public final class TvPrivacyPreferences extends C0969z {

    public static final class a extends PreferenceFragmentCompat {
        /* access modifiers changed from: private */
        public static final boolean i(a aVar, Preference preference) {
            t.e(preference, "it");
            C2962v vVar = new C2962v();
            FragmentActivity requireActivity = aVar.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            String string = aVar.getString(R.string.url_contact);
            t.d(string, "getString(...)");
            C2962v.u(vVar, requireActivity, string, (String) null, 4, (Object) null);
            return true;
        }

        /* access modifiers changed from: private */
        public static final boolean j(a aVar, Preference preference) {
            t.e(preference, "it");
            a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
            Context requireContext = aVar.requireContext();
            t.d(requireContext, "requireContext(...)");
            aVar2.H0(requireContext, true);
            Context requireContext2 = aVar.requireContext();
            t.d(requireContext2, "requireContext(...)");
            aVar2.r0(requireContext2, true);
            Context requireContext3 = aVar.requireContext();
            t.d(requireContext3, "requireContext(...)");
            aVar2.w0(requireContext3, true);
            Context requireContext4 = aVar.requireContext();
            t.d(requireContext4, "requireContext(...)");
            aVar2.o1(requireContext4, true);
            aVar.requireActivity().finish();
            return true;
        }

        /* access modifiers changed from: private */
        public static final boolean k(a aVar, Preference preference) {
            t.e(preference, "it");
            a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
            Context requireContext = aVar.requireContext();
            t.d(requireContext, "requireContext(...)");
            aVar2.H0(requireContext, false);
            Context requireContext2 = aVar.requireContext();
            t.d(requireContext2, "requireContext(...)");
            aVar2.r0(requireContext2, false);
            Context requireContext3 = aVar.requireContext();
            t.d(requireContext3, "requireContext(...)");
            aVar2.w0(requireContext3, false);
            Context requireContext4 = aVar.requireContext();
            t.d(requireContext4, "requireContext(...)");
            aVar2.o1(requireContext4, false);
            aVar.requireActivity().finish();
            return true;
        }

        public void onCreatePreferences(Bundle bundle, String str) {
            getPreferenceManager().setSharedPreferencesName("SettingsPreferences");
            addPreferencesFromResource(R.xml.tv_privacy_preferences);
            Preference findPreference = findPreference("right_to_be_forgotten");
            t.b(findPreference);
            findPreference.setOnPreferenceClickListener(new C2763a(this));
            Preference findPreference2 = findPreference("privacy_accept_all");
            t.b(findPreference2);
            findPreference2.setOnPreferenceClickListener(new b(this));
            Preference findPreference3 = findPreference("privacy_decline_all");
            t.b(findPreference3);
            findPreference3.setOnPreferenceClickListener(new c(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getSupportFragmentManager().beginTransaction().replace(16908290, new a()).commit();
    }
}
