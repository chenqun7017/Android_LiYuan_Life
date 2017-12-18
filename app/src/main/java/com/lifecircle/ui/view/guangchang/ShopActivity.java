package com.lifecircle.ui.view.guangchang;



import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lifecircle.R;
import com.lifecircle.adapter.PublicListAdapter;
import com.lifecircle.adapter.ShopLiftAdapter;
import com.lifecircle.adapter.ShopRightAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.global.GlobalHttpUrl;
import com.lifecircle.ui.model.PublicNote;
import com.lifecircle.ui.model.ShopLiftBean;
import com.lifecircle.ui.model.ShopRightBean;
import com.lifecircle.ui.view.publicui.PublicActivity;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.utils.ToastUtils;
import com.lifecircle.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ShopActivity extends BaseActivity implements View.OnClickListener{

	//头部
	private ImageView toolbar_iv_back;



	private RecyclerView liftRecyclerView;
	private RecyclerView rightRecyclerview;
	private ShopLiftAdapter shopLiftAdapter;
	private ShopRightAdapter shopRightAdapter;

	private RelativeLayout rl_go_shopcar;

	List<View> V=new ArrayList<View>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		//头部
		initHead();
		liftRecyclerView=findViewById(R.id.left_recyclerview);
		rightRecyclerview=findViewById(R.id.right_recyclerview);
		rl_go_shopcar=findViewById(R.id.rl_go_shopcar);
		rl_go_shopcar.setOnClickListener(this);
		initRecyclerView();
	}

	private void initRecyclerView() {
		OkGo.<String>get(GlobalHttpUrl.MY_SHOP_TYPE)
				.tag(this)
				.execute(new StringCallback() {
					@Override
					public void onSuccess(Response<String> response) {
						Gson gson=new Gson();
						String str=response.body().toString();
						Type type = new TypeToken<ShopLiftBean>(){}.getType();
						final ShopLiftBean shopLiftBean=gson.fromJson(str, type);
						if ((shopLiftBean.getResult()).equals("200")){
							//创建默认的线性LayoutManager
							LinearLayoutManager mLayoutManager = new LinearLayoutManager(ShopActivity.this);
							liftRecyclerView.setLayoutManager(mLayoutManager);
							DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mLayoutManager.VERTICAL);
							dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
							dividerItemDecoration.setSize(2);
							liftRecyclerView.addItemDecoration(dividerItemDecoration);
							List<ShopLiftBean.DataBean> list=shopLiftBean.getData();
							shopLiftAdapter = new ShopLiftAdapter(R.layout.item_shop_lift, list,ShopActivity.this);
							liftRecyclerView.setAdapter(shopLiftAdapter);
							shopLiftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
								@Override
								public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
									//选中状态
								    V.add(adapter.getViewByPosition(liftRecyclerView,0,R.id.rl_shop_left_item));
									V.add(view);
									for (int i=0;i<V.size();i++){
										V.get(i).setBackgroundColor(getResources().getColor(R.color.activityback));
										}
									view.setBackgroundColor(getResources().getColor(R.color.white));

									initDateRight(shopLiftBean.getData().get(position).getId()+"");
								}
							});
							initDateRight(shopLiftBean.getData().get(0).getId()+"");
						}else {
							ToastUtils.showToast(shopLiftBean.getMsg());
						}
					}

				});
	}

	private void initDateRight(String typeid) {
		OkGo.<String>post(GlobalHttpUrl.MY_SHOP_CONTENT)
				.tag(this)
				.params("page","1")
				.params("typeid",typeid)
				.execute(new StringCallback() {
					@Override
					public void onSuccess(Response<String> response) {
						Gson gson=new Gson();
						String str=response.body().toString();
						Type type = new TypeToken<ShopRightBean>(){}.getType();
						ShopRightBean shopRightBean=gson.fromJson(str, type);
						if ((shopRightBean.getResult()).equals("200")){
							LinearLayoutManager m = new LinearLayoutManager(ShopActivity.this);
							DividerItemDecoration dividerItem=new DividerItemDecoration(m.VERTICAL);
							dividerItem.getPaint().setColor(getResources().getColor(R.color.activityback));
							dividerItem.setSize(2);
							rightRecyclerview.setLayoutManager(m);
							rightRecyclerview.addItemDecoration(dividerItem);
							List<ShopRightBean.DataBeanX.DataBean> list=shopRightBean.getData().getData();
							shopRightAdapter = new ShopRightAdapter(R.layout.item_shop_right, list,ShopActivity.this);
							rightRecyclerview.setAdapter(shopRightAdapter);
							shopRightAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
								@Override
								public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

								}
							});
						}
					}

				});
	}


	private void initHead() {
		toolbar_iv_back=findViewById(R.id.toolbar_iv_back);
		toolbar_iv_back.setOnClickListener(this);
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.toolbar_iv_back:
				finish();
				break;
			case R.id.rl_go_shopcar:
				ActivityUtil.startShopCartActivity(this);
				break;

		}

	}
}
