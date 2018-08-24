package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class CustomButton extends AppCompatButton {

    private int indexHint;
    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getIndexHint() {
        return indexHint;
    }

    public void setIndexHint(int indexHint) {
        this.indexHint = indexHint;
    }

}
