/*
* Copyright (C) 2015 BlurOS Rom
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.android.settings.bluros;

import android.content.Context;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.provider.Settings;
import android.provider.SearchIndexableResource;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.MetricsLogger;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

import java.util.ArrayList;
import java.util.List;

public class RecentsSettings extends SettingsPreferenceFragment
            implements OnPreferenceChangeListener, Indexable {

    private static final String TAG = "RecentsSettings";
    private static final String USE_SLIM_RECENTS = "use_slim_recents";	
    private static final String SHOW_CLEAR_ALL_RECENTS = "show_clear_all_recents";
    private static final String RECENTS_CLEAR_ALL_LOCATION = "recents_clear_all_location";
    private static final String IMMERSIVE_RECENTS = "immersive_recents";
    private static final String PREF_HIDDEN_RECENTS_APPS_START = "hide_app_from_recents";
    
    // Package name of the hidden recetns apps activity
    public static final String HIDDEN_RECENTS_PACKAGE_NAME = "com.android.settings";
    // Intent for launching the hidden recents actvity
    public static Intent INTENT_HIDDEN_RECENTS_SETTINGS = new Intent(Intent.ACTION_MAIN)
    .setClassName(HIDDEN_RECENTS_PACKAGE_NAME,
    HIDDEN_RECENTS_PACKAGE_NAME + ".bluros.HAFRAppListActivity"); 
    
    private SwitchPreference mRecentsClearAll;
    private ListPreference mRecentsClearAllLocation;
    private SwitchPreference mUseSlimRecents;
    private ListPreference mImmersiveRecents;	
    private Preference mHiddenRecentsApps;


    @Override
    protected int getMetricsCategory() {
        return MetricsLogger.DEVELOPMENT;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.recents_settings);
        ContentResolver resolver = getActivity().getContentResolver();
        PreferenceScreen prefSet = getPreferenceScreen();
	
        int intColor;
        String hexColor;


        mImmersiveRecents = (ListPreference) findPreference(IMMERSIVE_RECENTS);
        mImmersiveRecents.setValue(String.valueOf(Settings.System.getInt(
                getContentResolver(), Settings.System.IMMERSIVE_RECENTS, 0)));
        mImmersiveRecents.setSummary(mImmersiveRecents.getEntry());
        mImmersiveRecents.setOnPreferenceChangeListener(this);

        mRecentsClearAll = (SwitchPreference) prefSet.findPreference(SHOW_CLEAR_ALL_RECENTS);
        mRecentsClearAll.setChecked(Settings.System.getIntForUser(resolver,
            Settings.System.SHOW_CLEAR_ALL_RECENTS, 1, UserHandle.USER_CURRENT) == 1);
        mRecentsClearAll.setOnPreferenceChangeListener(this);

        mRecentsClearAllLocation = (ListPreference) prefSet.findPreference(RECENTS_CLEAR_ALL_LOCATION);
        int location = Settings.System.getIntForUser(resolver,
                Settings.System.RECENTS_CLEAR_ALL_LOCATION, 6, UserHandle.USER_CURRENT);
        mRecentsClearAllLocation.setValue(String.valueOf(location));
        mRecentsClearAllLocation.setSummary(mRecentsClearAllLocation.getEntry());
        mRecentsClearAllLocation.setOnPreferenceChangeListener(this);
        boolean slimRecent = Settings.System.getInt(getActivity().getContentResolver(),
                    Settings.System.USE_SLIM_RECENTS, 0) == 1;
                               
        mHiddenRecentsApps = (Preference) prefSet.findPreference(PREF_HIDDEN_RECENTS_APPS_START);

        if (slimRecent) {
            mRecentsClearAll.setEnabled(false);
            mRecentsClearAllLocation.setEnabled(false);
        } else {
            mRecentsClearAll.setEnabled(true);
            mRecentsClearAllLocation.setEnabled(true);
       }

    
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ContentResolver resolver = getActivity().getContentResolver();
        if (preference == mRecentsClearAll) {
            boolean show = (Boolean) newValue;
            Settings.System.putIntForUser(getActivity().getContentResolver(),
                    Settings.System.SHOW_CLEAR_ALL_RECENTS, show ? 1 : 0, UserHandle.USER_CURRENT);
            return true;
        }
        if (preference == mImmersiveRecents) {
            Settings.System.putInt(getContentResolver(), Settings.System.IMMERSIVE_RECENTS,
                    Integer.valueOf((String) newValue));
            mImmersiveRecents.setValue(String.valueOf(newValue));
            mImmersiveRecents.setSummary(mImmersiveRecents.getEntry());    
        } else if (preference == mRecentsClearAllLocation) {
            int location = Integer.valueOf((String) newValue);
            int index = mRecentsClearAllLocation.findIndexOfValue((String) newValue);
            Settings.System.putIntForUser(getActivity().getContentResolver(),
                    Settings.System.RECENTS_CLEAR_ALL_LOCATION, location, UserHandle.USER_CURRENT);
            mRecentsClearAllLocation.setSummary(mRecentsClearAllLocation.getEntries()[index]);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mHiddenRecentsApps) {
            getActivity().startActivity(INTENT_HIDDEN_RECENTS_SETTINGS);
        } else {
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
        return false;
    }

   public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {
                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                                                                            boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();

                    SearchIndexableResource sir = new SearchIndexableResource(context);
                   sir.xmlResId = R.xml.recents_settings;
                    result.add(sir);

                    return result;
                }

                @Override
                public List<String> getNonIndexableKeys(Context context) {
                    final List<String> keys = new ArrayList<String>();
                    return keys;
                }
        };
}

