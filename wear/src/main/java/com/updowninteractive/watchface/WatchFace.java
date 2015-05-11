package com.updowninteractive.watchface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WatchFace {
  private static final String TIME_FORMAT = "%02d:%02d";
  private static final String DATE_FORMAT = "%02d.%02d.%d";
  private final Paint datePaint;
  private final Paint timePaint;
  private final int backgroundColor;

  WatchFace(Paint timePaint, Paint datePaint, int backgroundColor) {
    this.timePaint = timePaint;
    this.datePaint = datePaint;
    this.backgroundColor = backgroundColor;
  }

  public static WatchFace newInstance(Context context) {
    Resources resources = context.getResources();
    Paint timePaint = new Paint();
    timePaint.setColor(resources.getColor(R.color.watch_face_time));
    timePaint.setTextSize(resources.getDimension(R.dimen.time_size));
    timePaint.setAntiAlias(true);

    Paint datePaint = new Paint();
    datePaint.setColor(resources.getColor(R.color.watch_face_date));
    datePaint.setTextSize(context.getResources().getDimension(R.dimen.date_size));
    datePaint.setAntiAlias(true);

    return new WatchFace(timePaint, datePaint, resources.getColor(R.color.watch_face_fill));
  }

  public void draw(Canvas canvas, Rect bounds) {
    GregorianCalendar time = new GregorianCalendar();
    String timeText = String.format(TIME_FORMAT, time.get(Calendar.HOUR), time.get(Calendar.MINUTE));

    float centerX = bounds.exactCenterX();
    float centerY = bounds.exactCenterY();
    float timeCenterX = centerX - (timePaint.measureText(timeText) / 2.0f);

    Rect boundingBox = new Rect();
    timePaint.getTextBounds(timeText, 0, timeText.length(), boundingBox);
    float timeCenterY = centerY + (boundingBox.height() / 2.0f);

    canvas.drawColor(backgroundColor);
    canvas.drawText(timeText, timeCenterX, timeCenterY, timePaint);

    String dateText = String.format(DATE_FORMAT, time.get(Calendar.DAY_OF_MONTH), time.get(Calendar.MONTH) + 1, time.get(Calendar.YEAR));
    float dateCenterX = centerX - (datePaint.measureText(dateText) / 2.0f);
    float dateCenterY = timeCenterY - (boundingBox.height() + 10.0f);
    canvas.drawText(dateText, dateCenterX, dateCenterY, datePaint);
  }
}
