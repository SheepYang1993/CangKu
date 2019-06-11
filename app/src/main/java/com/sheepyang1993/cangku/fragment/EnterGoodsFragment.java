package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sheepyang1993.cangku.EditGoodsDialog;
import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 15:30
 * @describe 入库界面
 */
public class EnterGoodsFragment extends BaseFragment {

    private Button btnEnterGoods;

    public static EnterGoodsFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TITLE, title);
        EnterGoodsFragment fragment = new EnterGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_enter_goods;
    }

    @Override
    protected void initView(View view) {
        btnEnterGoods = view.findViewById(R.id.btnEnterGoods);
        btnEnterGoods.setOnClickListener(v -> {
            EditGoodsDialog dialog = new EditGoodsDialog(getActivity());
            dialog.show();
        });
    }

    @Override
    protected void initData() {

    }
}
