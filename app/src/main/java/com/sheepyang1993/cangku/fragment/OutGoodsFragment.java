package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.view.View;

import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 15:29
 * @describe 出库界面
 */
public class OutGoodsFragment extends BaseFragment {

    public static OutGoodsFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, title);
        OutGoodsFragment fragment = new OutGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_out_goods;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
