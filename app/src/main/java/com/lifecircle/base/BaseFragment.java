package com.lifecircle.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chenqun on 2017/7/24.
 * 所有Fragment的基类
 */

public abstract class BaseFragment extends Fragment {
	public View view;
	public Context mContext;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**防止次FragmentTabHost切换fragment时会调用onCreateView()重绘UI */
		if (view == null) {
			view = initView(inflater);
		}
		 /**
		  * 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，
		  * 要不然会发生这个rootview已经有parent的错误。 
		  */
		/* ViewGroup parent = (ViewGroup) view.getParent();
		    if (parent != null){  
		        parent.removeView(view);  
		    }*/
		return view;
	}
	/** 初始化view */
	public abstract View initView(LayoutInflater inflater);

}
