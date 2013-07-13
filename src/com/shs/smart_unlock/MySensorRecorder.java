package com.shs.smart_unlock;

import java.util.Arrays;

import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class MySensorRecorder implements SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	public float MotionMatrix[][] = new float[3][3];
	public long mSensorTimeStamp;
	public long mCPUTimeStamp;
	
	public MySensorRecorder(SensorManager ActSensorManager) {
		mSensorManager = ActSensorManager;
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	
	public void onStart() {
		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
	}
		
	public void onPause() {
		mSensorManager.unregisterListener(this);
	}
	
	public void onStop() {
		onPause();
		Arrays.fill(MotionMatrix, 0);
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		MotionMatrix[0] = event.values;
		mSensorTimeStamp = event.timestamp;
		mCPUTimeStamp = System.nanoTime();
	}
}
