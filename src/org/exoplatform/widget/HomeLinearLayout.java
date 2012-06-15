/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by The eXo Platform SAS Author : eXoPlatform exo@exoplatform.com May
 * 23, 2012
 */
public class HomeLinearLayout extends LinearLayout {
  private Paint paint = new Paint();

  public HomeLinearLayout(Context context) {
    super(context, null);
  }

  public HomeLinearLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int scaledWidth = getMeasuredWidth();
    int scaledHeight = getMeasuredHeight();
    paint.setStyle(Style.STROKE);
    Bitmap bm = makeRadGrad(getWidth(), getHeight());
    canvas.drawBitmap(bm, 0, 0, paint);
    paint.setDither(true);
    paint.setAntiAlias(true);

    paint.setColor(Color.BLACK);
    canvas.drawLine(scaledWidth / 2, 0, scaledWidth / 2, scaledHeight, paint);
    paint.setColor(Color.rgb(60, 60, 60));
    canvas.drawLine(scaledWidth / 2 + 1, 0, scaledWidth / 2 + 1, scaledHeight, paint);
    paint.setColor(Color.rgb(00, 00, 00));
    canvas.drawLine(0, scaledHeight / 2, scaledWidth, scaledHeight / 2, paint);
    paint.setColor(Color.rgb(51, 51, 51));
    canvas.drawLine(0, scaledHeight / 2 + 1, scaledWidth, scaledHeight / 2 + 1, paint);

  }

  private Bitmap makeRadGrad(int width, int heigh) {
    RadialGradient gradient = new RadialGradient(width / 2,
                                                 heigh / 2,
                                                 heigh / 2,
                                                 0x8F8F8F8F,
                                                 0x1C1C1C1C,
                                                 android.graphics.Shader.TileMode.CLAMP);
    Paint p = new Paint();
    p.setDither(true);
    p.setShader(gradient);

    Bitmap bitmap = Bitmap.createBitmap(width, heigh, Config.ARGB_8888);
    Canvas c = new Canvas(bitmap);
    c.drawOval(new RectF(0, 0, width, heigh), p);

    return bitmap;
  }
}
