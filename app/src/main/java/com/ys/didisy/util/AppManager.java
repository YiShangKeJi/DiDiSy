package com.ys.didisy.util;

import android.app.Activity;
import android.app.Application;
import java.util.ArrayList;
import java.util.List;

/**
 * 必须注册才能使用
 */
public class AppManager extends Application {
	private  ArrayList<Activity> activities = new ArrayList<Activity>();
	private static AppManager instance;

	/**
	 * 单例模式
	 * @return
     */
	public static AppManager getInstance() {
		if (instance == null) {
			instance = new AppManager();
		}
		return instance;
	}

	public void addActivity(Activity activity) {
		activities.add(activity);
	}

	public void finish() {
		for (Activity act : activities) {
			act.finish();
		}
		System.exit(0);
	}
	/**
	 * Activity关闭时，删除Activity列表中的Activity对象*/
	public  void removeActivity(Activity a){
		activities.remove(a);
	}
}