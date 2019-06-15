package com.sheepyang1993.cangku.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sheepyang1993.cangku.R;
import com.sheepyang1993.cangku.adapter.holder.GoodsHolder;

import java.util.List;
import java.util.Locale;

import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/15
 */
public class GoodsAdapter extends BaseQuickAdapter<GoodsModel, GoodsHolder> {
    public GoodsAdapter(@Nullable List<GoodsModel> data) {
        super(R.layout.item_goods, data);
    }

    @Override
    protected void convert(GoodsHolder helper, GoodsModel item) {
        helper.tvModelId.setText(item.getModelId());
        helper.tvColor.setText(item.getColor());
        helper.tvNumber.setText(String.format(Locale.CHINA, "%d", item.getNumber()));
        helper.tvSize.setText(item.getSize());
    }
}
