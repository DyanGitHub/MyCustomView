package com.dy.mytopbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Topbar mTopbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTopbar= (Topbar) findViewById(R.id.topbar);
		mTopbar.setOnTopClickListener(new Topbar.TopClickListener() {
			@Override
			public void onLeftClick() {
				Toast.makeText(MainActivity.this,"MainActivity left",Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onrightClick() {
				Toast.makeText(MainActivity.this,"MainActivity right",Toast.LENGTH_SHORT).show();
			}
		});
		mTopbar.setLeftIsVisiable(false);
	}
}
