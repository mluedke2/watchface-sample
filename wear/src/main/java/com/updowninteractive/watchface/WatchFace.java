package com.updowninteractive.watchface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.format.Time;

public class WatchFace {
  private static final String TIME_FORMAT = "02d:02d";
  private final Paint timePaint;
  private final int backgroundColor;

  WatchFace(Paint timePaint, int backgroundColor) {
    this.timePaint = timePaint;
    this.backgroundColor = backgroundColor;
  }

  public static WatchFace newInstance(Context context) {
    Resources resources = context.getResources();
    Paint timePaint = new Paint();
    timePaint.setColor(resources.getColor(R.color.watch_face_time));
    timePaint.setTextSize(resources.getDimension(R.dimen.time_size));
    timePaint.setAntiAlias(true);
    return new WatchFace(timePaint, resources.getColor(R.color.watch_face_fill));
  }

  public void draw(Canvas canvas, Rect bounds) {
    // 1
    Time time = new Time();
    time.setToNow();

    canvas.drawColor(backgroundColor);
  }
}
