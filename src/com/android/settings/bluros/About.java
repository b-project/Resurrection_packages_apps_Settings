/*
 * About.java
 * 
 * Copyright 2014 westcrip <westcrip@westcrip-altankrk>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
package com.android.settings.bluros;

import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.view.IWindowManager;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.bluros.dialog.AndroidLDialog;
import com.android.settings.R;
import com.android.settings.Utils;
import android.content.pm.PackageManager;
import com.android.internal.logging.MetricsLogger;    
public class About extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {
			
public static final String TAG = "About";
private static final String PROKEY = "com.bluros.";
    AndroidLDialog androidLDialog;
    
    Preference mSiteUrl;
    Preference mForumUrl;
    Preference mSourceUrl;
    Preference mFacebookUrl;
    Preference mDonateUrl;
    Preference mGoogleUrl;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.about_rom);
        PreferenceScreen prefSet = getPreferenceScreen();
        ContentResolver resolver = getContentResolver();
        mSiteUrl = findPreference("bluros_website");
        mForumUrl = findPreference("bluros_forum");
        mSourceUrl = findPreference("bluros_source");
        mFacebookUrl = findPreference("bluros_facebook");
        mDonateUrl = findPreference("bluros_donate");
        mGoogleUrl = findPreference("bluros_google_plus");                  
        // BlurOS Check Key
        if(isAppInstalled("com.bluros.pro")){
		//app installed
		}
		else{
			dialogExample();
		}		
        
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        return false;
    }
    
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSiteUrl) {
            launchUrl("http://bluros.xdavn.com/");
        } else if (preference == mForumUrl) {
            launchUrl("http://xdavn.com/");
        } else if (preference == mSourceUrl) {
            launchUrl("https://github.com/BlurOS");
        } else if (preference == mFacebookUrl) {
            launchUrl("https://www.facebook.com/xdavn");
        } else if (preference == mGoogleUrl) {
            launchUrl("https://plus.google.com/u/0/104221037097741700639");
        } else if (preference == mDonateUrl) {
            launchUrl("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=542JFBZTLCU5W");
            }  else {
                // If not handled, let preferences handle it.
                return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
         return true; 
    }
    
    private void dialogExample() {
        androidLDialog = new AndroidLDialog.Builder(About.this.getActivity())
                //settings title
                .Title("Donate")
                        //settings message
                .Message("You can support ROM development by donating to Team BlurOS. To make a donation just press the Donate button and buy BlurOS PRO Key. After installing the key, this message will not appear again.")
                        //adding positive (right) button
                .setPositiveButton("Donate", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
						Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.bluros.pro");
						Intent i=new Intent(Intent.ACTION_VIEW,uri);
						startActivity(i);
                        androidLDialog.hide();
                    }
                })
                        //adding negative (center) button
                .setNegativeButton("Later", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        androidLDialog.hide();
                    }
                })
                        //showing the dialog!
                .show();

        //optional.. setting icon but it's not very android l like
        //androidLDialog.setIcon(R.drawable.ic_launcher);
        /**
         * Try out functions like
         *         androidLDialog.getTitle();
         *         androidLDialog.setMessageTextSize(CUSTOM_SIZE);
         *         androidLDialog.setTitleTextSize(CUSTOM_SIZE);
         *         androidLDialog.getMessage();
         *         androidLDialog.setMessageColor(android.R.color.black);
         *         androidLDialog.setTitleColor(android.R.color.black);
         *         androidLDialog.setBackground(R.drawable.someBackground);
         *
         *         SEE ALL FEATURES OF THIS LIBRARY IN THE README
         */
    }
    
	private boolean isAppInstalled(String uri) {
		PackageManager pm = getPackageManager();
		boolean installed = false;
		try {
		pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
		installed = true;
		} catch (PackageManager.NameNotFoundException e) {
		installed = false;
		}
		return installed;
	}
    
    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent donate = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(donate);
    }
    protected int getMetricsCategory()
    {
	return MetricsLogger.APPLICATION;
    }
}
