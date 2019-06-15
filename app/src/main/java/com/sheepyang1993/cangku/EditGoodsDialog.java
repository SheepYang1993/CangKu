package com.sheepyang1993.cangku;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.sheepyang1993.sheepcommon.utils.DialogUtil;
import com.sheepyang1993.sheepcommon.widget.BaseDialog;

import java.util.ArrayList;
import java.util.List;

import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/11
 * 出库/入库 编辑弹窗
 */
public class EditGoodsDialog extends BaseDialog {

    private final Activity mActivity;
    private Button btnCreateEnterList;
    private EditText edtCreateEnterList;

    public EditGoodsDialog(@NonNull Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    protected void initView(@NonNull Context context) {
        setContentView(R.layout.dialog_edit_goods);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        edtCreateEnterList = findViewById(R.id.edtCreateEnterList);
        btnCreateEnterList = findViewById(R.id.btnCreateEnterList);
        btnCreateEnterList.setOnClickListener(v -> {
            createEnterList();
        });
    }

    /**
     * 创建入库清单
     */
    private void createEnterList() {
        String text = edtCreateEnterList.getText().toString();
        if (TextUtils.isEmpty(text)) {
            DialogUtil.showToastFailDialog(mActivity, "请输入[入库文本]");
            return;
        }
        List<GoodsModel> list = parseGoodsList(text);
        if (!checkCreated()) {

        }
    }

    /**
     * 解析文本获取货品清单
     *
     * @param text
     * @return
     */
    private List<GoodsModel> parseGoodsList(String text) {
        text = "9058,灰橘,39*12:42.5*34:43*19\n" +
                "9059,红黑,39*12:42.5*34:43*19\n" +
                "1058,蓝色,39*12:42.5*34:43*19\n" +
                "9258,白粉,39*12:42.5*34:43*19\n" +
                "1238,灰分,39*12:42.5*34:43*19\n" +
                "3218,黑白,39*12:42.5*34:43*19\n" +
                "9548,棕色,39*12:42.5*34:43*19\n" +
                "8768,灰粽,39*12:42.5*34:43*19";
        List<GoodsModel> list = new ArrayList<>();
        String[] goodsArray = text.split("\n");
        for (String goods : goodsArray) {
            String[] item = goods.split(",");
            String modelId = item[0];
            String color = item[1];
            String[] sizeNumber = item[2].split(":");
        }
        return list;
    }

    /**
     * 检查数据库是否已经创建了该型号的数据，没有就要新建
     *
     * @return
     */
    private boolean checkCreated() {
        return false;
    }
}
