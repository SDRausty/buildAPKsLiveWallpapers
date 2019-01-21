package com.ariwilson.seismowallpaper;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

public class SeismoWallpaper extends WallpaperService {
  public static final String PREFERENCES =
      "com.ariwilson.seismowallpaper";

  @Override
  public Engine onCreateEngine() {
    return new SeismoEngine(33);
  }

  private class SeismoEngine extends Engine implements
      SharedPreferences.OnSharedPreferenceChangeListener {
    SeismoEngine(int period) {
      preferences_ = SeismoWallpaper.this.getSharedPreferences(PREFERENCES, 0);
      preferences_.registerOnSharedPreferenceChangeListener(this);
      filter_ = preferences_.getBoolean("filter", true);
      axis_ = Integer.parseInt(preferences_.getString("axis", "2"));
      line_color_ = preferences_.getInt("line_color", Color.BLACK);
      background_color_ = preferences_.getInt("background_color", Color.WHITE);
      ctx_ = getApplicationContext();
      period_ = period;
    }

    @Override
    public void onVisibilityChanged(boolean visible) {
      super.onVisibilityChanged(visible);
      if (visible) {
        AccelerometerReader reader = new AccelerometerReader(ctx_);
        view_thread_ = new SeismoViewThread(ctx_, getSurfaceHolder(), filter_,
                                            axis_, line_color_,
                                            background_color_, period_);
        reader_thread_ = new AccelerometerReaderThread(reader, view_thread_,
                                                       false, period_);
        view_thread_.setSurfaceSize(canvas_width_, canvas_height_);
        view_thread_.start();
        reader_thread_.start();        
      } else {
        view_thread_.setRunning(false);
        reader_thread_.setRunning(false);
        try {
          view_thread_.join();
          reader_thread_.join();
        } catch (InterruptedException e) {
          // Do nothing.
        }
      }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences preferences,
                                          String key) {
      if (key.equals("filter")) {
        filter_ = preferences.getBoolean(key, true);
        view_thread_.setFilter(filter_);
      } else if (key.equals("axis")) {
        axis_ = Integer.parseInt(preferences.getString(key, "2"));
        view_thread_.setAxis(axis_);
      } else if (key.equals("line_color")) {
        line_color_ = preferences.getInt(key, Color.BLACK);
        view_thread_.setLineColor(line_color_);
      } else if (key.equals("background_color")) {
        background_color_ = preferences.getInt(key, Color.WHITE);
        view_thread_.setBackgroundColor(background_color_);
      } else {
        Log.e("SeismoWallpaper", "Unknown setting key " + key);
      }
    }    

    @Override
    public void onSurfaceChanged(SurfaceHolder holder, int format, int width,
                                 int height) {
      canvas_height_ = height;
      canvas_width_ = width;
    } 

    private SharedPreferences preferences_;
    private AccelerometerReaderThread reader_thread_;
    private SeismoViewThread view_thread_;
    private int canvas_height_;
    private int canvas_width_;
    private boolean filter_;
    private int axis_;
    private int line_color_;
    private int background_color_;
    private Context ctx_;
    private int period_;
  }
}
