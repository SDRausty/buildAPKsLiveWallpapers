package com.ariwilson.seismowallpaper;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SeismoWallpaperSettings extends PreferenceActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getPreferenceManager().setSharedPreferencesName(
        SeismoWallpaper.PREFERENCES);
    addPreferencesFromResource(R.xml.settings);
  }
}
