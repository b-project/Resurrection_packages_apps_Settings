/* 
 *  Create by Linh Phi
 * */
package com.android.settings.bluros;

import android.app.INotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.preference.SwitchPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceScreen;
import android.provider.Settings;

import com.android.internal.logging.MetricsLogger;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class ShakeSettings extends SettingsPreferenceFragment {

    private static final String TAG = "Shake Settings BlurOS";
    private static final String SHAKE_CLEAN_RECENT = "shake_clean_recent";
    private static final String SHAKE_CLEAN_NOTIFICATION = "shake_clean_notification";
    
    private SwitchPreference mEnableShakeClean;
    private SwitchPreference mEnableShakeCleanNoti;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        addPreferencesFromResource(R.xml.bluros_shake_settings);
        PreferenceScreen prefSet = getPreferenceScreen();

        mEnableShakeClean = (SwitchPreference) prefSet.findPreference(SHAKE_CLEAN_RECENT);
        mEnableShakeClean.setChecked(Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.SHAKE_CLEAN_RECENT, 1) == 1);
        mEnableShakeCleanNoti = (SwitchPreference) prefSet.findPreference(SHAKE_CLEAN_NOTIFICATION);
        mEnableShakeCleanNoti.setChecked(Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.SHAKE_CLEAN_NOTIFICATION, 1) == 1);
    }
      protected int getMetricsCategory()
			{
				return MetricsLogger.APPLICATION;
			}

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mEnableShakeClean) {	
            Settings.System.putInt(mContext.getContentResolver(),
                    Settings.System.SHAKE_CLEAN_RECENT, mEnableShakeClean.isChecked()
                    ? 1 : 0);	
        } else         
        if (preference == mEnableShakeCleanNoti) {	
            Settings.System.putInt(mContext.getContentResolver(),
                    Settings.System.SHAKE_CLEAN_NOTIFICATION, mEnableShakeCleanNoti.isChecked()
                    ? 1 : 0);	
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}
