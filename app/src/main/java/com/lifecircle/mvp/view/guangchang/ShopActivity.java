package com.lifecircle.mvp.view.guangchang;



import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lifecircle.R;
import com.lifecircle.adapter.ShopLiftAdapter;
import com.lifecircle.adapter.ShopRightAdapter;
import com.lifecircle.base.BaseActivity;
import com.lifecircle.mvp.model.ShopLiftBean;
import com.lifecircle.mvp.model.ShopRightBean;
import com.lifecircle.utils.ActivityUtil;
import com.lifecircle.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class ShopActivity extends BaseActivity implements View.OnClickListener{

	//头部
	private ImageView toolbar_iv_back;
	private RecyclerView liftRecyclerView;
	private RecyclerView rightRecyclerview;

	private List<ShopLiftBean> listLiftDate=new ArrayList<ShopLiftBean>();
	private List<ShopRightBean> listRightDate=new ArrayList<ShopRightBean>();

	private ShopLiftAdapter shopLiftAdapter;
	private ShopRightAdapter shopRightAdapter;
	private RelativeLayout rl_go_shopcar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		//头部
		initHead();
		initRecyclerView();
	}

	private void initRecyclerView() {
		liftRecyclerView=findViewById(R.id.left_recyclerview);
		for (int i=0;i<4;i++){
			listLiftDate.add(new ShopLiftBean());
		}
		LinearLayoutManager mg = new LinearLayoutManager(this);
		DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(mg.VERTICAL);
		dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
		dividerItemDecoration.setSize(2);
		liftRecyclerView.setLayoutManager(mg);
		liftRecyclerView.addItemDecoration(dividerItemDecoration);
		shopLiftAdapter = new ShopLiftAdapter(R.layout.item_shop_lift, listLiftDate);
		liftRecyclerView.setAdapter(shopLiftAdapter);
		shopLiftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

			}
		});

		rightRecyclerview=findViewById(R.id.right_recyclerview);
		for (int i=0;i<4;i++){
			listRightDate.add(new ShopRightBean());
		}
		LinearLayoutManager m = new LinearLayoutManager(this);
		DividerItemDecoration dividerItem=new DividerItemDecoration(m.VERTICAL);
		dividerItemDecoration.getPaint().setColor(getResources().getColor(R.color.activityback));
		dividerItemDecoration.setSize(2);
		rightRecyclerview.setLayoutManager(m);
		rightRecyclerview.addItemDecoration(dividerItem);
		shopRightAdapter = new ShopRightAdapter(R.layout.item_shop_right, listRightDate);
		rightRecyclerview.setAdapter(shopRightAdapter);
		shopRightAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

			}
		});
		rl_go_shopcar=findViewById(R.id.rl_go_shopcar);
		rl_go_shopcar.setOnClickListener(this);

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
