package com.shs.smart_unlock;

import android.graphics.Canvas;
import android.content.Context;
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
	public DebugView(Context context) {
		super(context);
		Recorder = new MySensorRecorder(context.getSystemService(android.content.Context.SENSOR_SERVICE));
	}

	@Override
	protected void onDraw(Canvas canvas){
		this.setText(Float.toString(Recorder.MotionMatrix[0][2]));
	}
}
