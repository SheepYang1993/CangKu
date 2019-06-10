package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.view.View;

import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 15:30
 * @describe 库存列表界面
 */
public class GoodsListFragment extends BaseFragment {

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

    }

    @Override
    protected void initData() {

    }
}
