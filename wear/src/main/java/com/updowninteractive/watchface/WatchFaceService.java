package com.updowninteractive.watchface;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.wearable.watchface.CanvasWatchFaceService;
import android.support.wearable.watchface.WatchFaceStyle;
import android.view.SurfaceHolder;

public class WatchFaceService extends CanvasWatchFaceService {

  @Override
  public Engine onCreateEngine() {
    return new Engine();
  }

  private class Engine extends CanvasWatchFaceService.Engine {
    @Override
    public void onCreate(SurfaceHolder holder) {
      setWatchFaceStyle(new WatchFaceStyle.Builder(WatchFaceService.this)
          .setCardPeekMode(WatchFaceStyle.PEEK_MODE_SHORT)
          .setAmbientPeekMode(WatchFaceStyle.AMBIENT_PEEK_MODE_HIDDEN)
          .setBackgroundVisibility(WatchFaceStyle.BACKGROUND_VISIBILITY_INTERRUPTIVE)
          .setShowSystemUiTime(false)
          .build());
    }

    @Override
    public void onTimeTick() {
      super.onTimeTick();
      invalidate();
    }

    @Override
    public void onDraw(Canvas canvas, Rect bounds) {

    }
  }
}
