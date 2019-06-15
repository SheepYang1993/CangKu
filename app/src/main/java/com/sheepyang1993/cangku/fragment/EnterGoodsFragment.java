package com.sheepyang1993.cangku.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sheepyang1993.cangku.widget.EnterGoodsDialog;
import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.debug.DebugUtils;
import com.sheepyang1993.sheepcommon.fragment.BaseFragment;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/6/10 15:30
 * @describe 入库界面
 */
public class EnterGoodsFragment extends BaseFragment {

    private Button btnEnterGoods, btnDebug;

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
        btnDebug = view.findViewById(R.id.btnDebug);
        btnEnterGoods = view.findViewById(R.id.btnEnterGoods);
        btnEnterGoods.setOnClickListener(v -> {
            EnterGoodsDialog dialog = new EnterGoodsDialog(getActivity());
            dialog.show();
        });
        btnDebug.setText(DebugUtils.isShowDebugInfo() ? "调试模式(已开启)" : "调试模式(已关闭)");
        btnDebug.setOnClickListener(v -> {
            DebugUtils.setShowDebugInfo(!DebugUtils.isShowDebugInfo());
            btnDebug.setText(DebugUtils.isShowDebugInfo() ? "调试模式(已开启)" : "调试模式(已关闭)");
        });
    }

    @Override
    protected void initData() {

    }
}
