package com.syw.sharedpreferenceslearning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * 文件存储的第二种方式SharedPreferences方式，可以通过三种方式得到SharedPreferences对象:
 * 1、Context类的getSharedPreferences(name, mode)方法产生，name是文件名不包含路径，默认路径/data/data/<package name>/shared_prefs/
 * 2、Activity类的getSharedPreferences(mode)同上类似，自动将当前活动的类名当作文件名
 * 3、PreferenceManager类中的getDefaultSharedPreferences()
 * 得到SharedPreferences对象后，经过三步可以进行存储数据：
 * 1、通过调用SharedPreferences对象的edit()方法得到SharedPreferences.Editor对象
 * 2、通过SharedPreferenced.Editor对象的putString、putBoolean等添加数据
 * 3、通过调用commit()方法提交数据
 */

public class MainActivity extends Activity implements OnClickListener {
	private Button button;
	private Button restore_data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.buttonId);
		restore_data = (Button) findViewById(R.id.restore_data);
		button.setOnClickListener(this);
		restore_data.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonId:
			SharedPreferences p = getSharedPreferences("shared", MODE_PRIVATE);
			SharedPreferences.Editor editor = p.edit();
			editor.putBoolean("syw1", true);
			editor.putString("syw2", "hello");
			editor.putInt("syw3", 1299);
			editor.commit();
			break;
		case R.id.restore_data:
			SharedPreferences pf = getSharedPreferences("shared", MODE_PRIVATE);
			boolean b = pf.getBoolean("syw1", false);
			String s = pf.getString("syw2", null);
			int i = pf.getInt("syw3", 0);
			Log.d("TAG", b + "");
			Log.d("TAG", s + "");
			Log.d("TAG", i + "");
		}
	}

}
