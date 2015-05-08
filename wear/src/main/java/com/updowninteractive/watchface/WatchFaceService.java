package com.updowninteractive.watchface;

import android.support.wearable.watchface.CanvasWatchFaceService;

public class WatchFaceService extends CanvasWatchFaceService {

  @Override
  public Engine onCreateEngine() {
    return new Engine();
  }

  private class Engine extends CanvasWatchFaceService.Engine {

  }
}
