package com.kynam.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void pause() {
		if (mPlayer.isPlaying())
			mPlayer.pause();
		else mPlayer.start();
	}
	
	public void play(Context c) {
		stop();
		
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				stop();
				
			}
		});
		
		mPlayer.start();
	}
}
