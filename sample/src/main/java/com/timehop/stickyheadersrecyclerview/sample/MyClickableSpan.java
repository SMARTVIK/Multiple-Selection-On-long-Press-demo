package com.timehop.stickyheadersrecyclerview.sample;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class MyClickableSpan extends ClickableSpan {

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }
}
