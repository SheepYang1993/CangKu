package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sheepyang1993.cangku.R;
import com.sheepyang1993.cangku.adapter.GoodsAdapter;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;
import com.sheepyang1993.sheepcommon.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

import comsheepyang1993.sheepbmobcangku.api.GoodsApiHelper;
import comsheepyang1993.sheepbmobcangku.callback.Callback;
import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 15:30
 * @describe 库存列表界面
 */
public class GoodsListFragment extends BaseFragment {

    private SwipeRefreshLayout refreshLayout;
    private Button btnRefresh;
    private RecyclerView recyclerview;
    private GoodsAdapter mAdapter;

    public static GoodsListFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, title);
        GoodsListFragment fragment = new GoodsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list;
    }

    @Override
    protected void initView(View view) {
        recyclerview = view.findViewById(R.id.recyclerview);
        btnRefresh = view.findViewById(R.id.btnRefresh);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GoodsAdapter(new ArrayList<>());
        recyclerview.setAdapter(mAdapter);
        btnRefresh.setOnClickListener(v -> getGoodsList());
        refreshLayout.setOnRefreshListener(this::getGoodsList);
    }

    @Override
    protected void initData() {
        getGoodsList();
    }

    /**
     * 获取库存列表
     */
    private void getGoodsList() {
        GoodsApiHelper.getGoodsList(new Callback<List<GoodsModel>>() {
            @Override
            public void onStart() {
                refreshLayout.setRefreshing(true);
                DialogUtil.showLoadingDialog(getActivity(), "正在刷新库存...");
            }

            @Override
            public void onSuccess(List<GoodsModel> data) {
                mAdapter.setNewData(data);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onFinish() {
                refreshLayout.setRefreshing(false);
                DialogUtil.showToastSuccessDialog(getActivity(), "刷新成功");
            }
        });
    }
}
