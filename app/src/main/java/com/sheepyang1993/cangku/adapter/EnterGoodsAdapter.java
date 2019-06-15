package com.sheepyang1993.cangku.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sheepyang1993.cangku.R;
import com.sheepyang1993.cangku.adapter.holder.EnterGoodsHolder;

import java.util.Locale;

import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/15
 */
public class EnterGoodsAdapter extends BaseQuickAdapter<GoodsModel, EnterGoodsHolder> {
    public EnterGoodsAdapter() {
        super(R.layout.item_enter_goods);
    }

    @Override
    protected void convert(EnterGoodsHolder helper, GoodsModel item) {
        helper.tvPostion.setText(String.format(Locale.CHINA, "%d", helper.getLayoutPosition() + 1));
        helper.tvModelId.setText(item.getModelId());
        helper.tvColor.setText(item.getColor());
        helper.tvNumber.setText(String.format(Locale.CHINA, "%d", item.getNumber()));
        helper.tvSize.setText(item.getSize());
        helper.tvAppend.setText(TextUtils.isEmpty(item.getBmobId()) ? "新增型号" : "追加库存");
    }
}
