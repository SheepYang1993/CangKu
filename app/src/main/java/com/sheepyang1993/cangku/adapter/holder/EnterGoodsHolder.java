package com.sheepyang1993.cangku.adapter.holder;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.sheepyang1993.cangku.R;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/15
 */
public class EnterGoodsHolder extends BaseViewHolder {
    public TextView tvModelId;
    public TextView tvSize;
    public TextView tvColor;
    public TextView tvNumber;
    public TextView tvPostion;
    public TextView tvAppend;

    public EnterGoodsHolder(View view) {
        super(view);
        tvModelId = view.findViewById(R.id.tvModelId);
        tvSize = view.findViewById(R.id.tvSize);
        tvColor = view.findViewById(R.id.tvColor);
        tvNumber = view.findViewById(R.id.tvNumber);
        tvPostion = view.findViewById(R.id.tvPostion);
        tvAppend = view.findViewById(R.id.tvAppend);
    }
}
