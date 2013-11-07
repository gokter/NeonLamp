package com.flyingh.neonlamp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int count;
	private TextView[] textViews = new TextView[7];
	private int[] ids = { R.id.text_view1, R.id.text_view2, R.id.text_view3, R.id.text_view4, R.id.text_view5, R.id.text_view6, R.id.text_view7 };
	private int[] colors = { R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < textViews.length; i++) {
			textViews[i] = (TextView) findViewById(ids[i]);
		}
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < textViews.length; i++) {
							textViews[i].setBackgroundResource(colors[(i + count) % colors.length]);
						}
						++count;
					}
				});
			}
		}, 0, 500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
