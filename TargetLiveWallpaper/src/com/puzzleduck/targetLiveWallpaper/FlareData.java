package com.puzzleduck.targetLiveWallpaper;

public class FlareData {
	private float x;
	private float y;
	private float time;
	private float triggerTime;
	private float stage1Time;
	private float stage2Time;
	private float stage3Time;
	private float tilt;
	private int color1;
	private int color2;
	private int type;
	private int explosionRadius;
	private int explosionCount;
	private int explosion2Count;
	private int explosion2Radius;
	public FlareData() {
		x = 100;
		y = 100;
		time = 0;
		triggerTime = 50;
		setStage1Time(50);
		setStage2Time(20);
		setStage3Time(10);
		tilt = 0;
		color1 = 0xFF00FF00;
		color2 = 0xFF0000FF;
		type = 0;
		explosionRadius = 0;
		explosionCount = 0;
		explosion2Count = 0;
		explosion2Radius = 0;
	}
	
	public FlareData(float inx, float iny, float inTilt, int incolor1, int incolor2, int intype, int stage1, int stage2, int stage3)
	{
		x = inx;
		y = iny;
		time = 0;
		triggerTime = 50;
		setStage1Time(stage1);
		setStage2Time(stage2);
		setStage3Time(stage3);
		tilt = inTilt;
		color1 = incolor1;
		color2 = incolor2;
		type = intype;
		explosionRadius = 0;
		explosionCount = 0;
		explosion2Count = 0;
		explosion2Radius = 0;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public float getTriggerTime() {
		return triggerTime;
	}

	public void setTriggerTime(float triggerTime) {
		this.triggerTime = triggerTime;
	}

	public float getTilt() {
		return tilt;
	}

	public void setTilt(float tilt) {
		this.tilt = tilt;
	}

	public int getColor1() {
		return color1;
	}

	public void setColor1(int color1) {
		this.color1 = color1;
	}

	public int getColor2() {
		return color2;
	}

	public void setColor2(int color2) {
		this.color2 = color2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setStage1Time(float stage1Time) {
		this.stage1Time = stage1Time;
	}

	public float getStage1Time() {
		return stage1Time;
	}

	public void setStage2Time(float stage2Time) {
		this.stage2Time = stage2Time;
	}

	public float getStage2Time() {
		return stage2Time;
	}

	public void setStage3Time(float stage3Time) {
		this.stage3Time = stage3Time;
	}

	public float getStage3Time() {
		return stage3Time;
	}

	public void setExplosionRadius(int explosionRadius) {
		this.explosionRadius = explosionRadius;
	}
	public void incrementExplosionRadius() {
		this.explosionRadius ++;
	}

	public int getExplosionRadius() {
		return explosionRadius;
	}

	public void setExplosionCount(int explosionCount) {
		this.explosionCount = explosionCount;
	}

	public int getExplosionCount() {
		return explosionCount;
	}

	public void setExplosion2Count(int explosion2Count) {
		this.explosion2Count = explosion2Count;
	}

	public int getExplosion2Count() {
		return explosion2Count;
	}

	public void incrementExplosion2Radius() {
		this.explosion2Radius ++;
		
	}
	public int getExplosion2Radius() {
		return explosion2Radius;
	}
}