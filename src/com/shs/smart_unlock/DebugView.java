package com.shs.smart_unlock;

import android.graphics.Canvas;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.hardware.Sensor;

/**
 * Created with IntelliJ IDEA.
 * User: Luke.Lazurite
 * Date: 11/28/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DebugView extends TextView {
	MySensorRecorder Recorder;
	public DebugView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Recorder = new MySensorRecorder(context.getSystemService(android.content.Context.SENSOR_SERVICE));
		this.setText("Hello World123!");
	}

	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		this.setText("Axis: "+Float.toString(Recorder.getDisplacement()[0]));
		invalidate();
	}
}
