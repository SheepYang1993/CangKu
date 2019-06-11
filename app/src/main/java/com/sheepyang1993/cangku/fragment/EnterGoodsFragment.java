package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sheepyang1993.cangku.EditGoodsDialog;
import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import comsheepyang1993.sheepbmobcangku.api.GoodsApiHelper;
import comsheepyang1993.sheepbmobcangku.callback.Callback;
import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

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
            List<GoodsModel> list = new ArrayList<>();
            GoodsModel goods = new GoodsModel();
            goods.setModelId("9058");
            goods.setNumber(45);
            goods.setSize("42.5");
            goods.setColor("灰橘");
            list.add(goods);
            GoodsModel goods2 = new GoodsModel();
            goods2.setModelId("9067");
            goods2.setNumber(32);
            goods2.setSize("44");
            goods2.setColor("红黑");
            list.add(goods2);
            GoodsApiHelper.addGoods(list, new Callback() {
                @Override
                public void onSuccess(Object data) {

                }

                @Override
                public void onError() {

                }
            });
        });
    }

    @Override
    protected void initData() {

    }
}
