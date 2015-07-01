package com.syw.sharedpreferenceslearning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * �ļ��洢�ĵڶ��ַ�ʽSharedPreferences��ʽ������ͨ�����ַ�ʽ�õ�SharedPreferences����:
 * 1��Context���getSharedPreferences(name, mode)����������name���ļ���������·����Ĭ��·��/data/data/<package name>/shared_prefs/
 * 2��Activity���getSharedPreferences(mode)ͬ�����ƣ��Զ�����ǰ������������ļ���
 * 3��PreferenceManager���е�getDefaultSharedPreferences()
 * �õ�SharedPreferences����󣬾����������Խ��д洢���ݣ�
 * 1��ͨ������SharedPreferences�����edit()�����õ�SharedPreferences.Editor����
 * 2��ͨ��SharedPreferenced.Editor�����putString��putBoolean���������
 * 3��ͨ������commit()�����ύ����
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
