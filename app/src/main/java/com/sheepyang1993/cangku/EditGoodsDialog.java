package com.sheepyang1993.cangku;

import android.content.Context;
import android.support.annotation.NonNull;

import com.sheepyang1993.sheepcommon.widget.BaseDialog;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/11
 * 出库/入库 编辑弹窗
 */
public class EditGoodsDialog extends BaseDialog {

    public EditGoodsDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void initView(@NonNull Context context) {
        setContentView(R.layout.dialog_edit_goods);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }
}
