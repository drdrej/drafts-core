package com.touchableheroes.drafts.core.tools;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by asiebert on 12.04.16.
 */
public class InteractionTool {

    public static class ViewWrapper {

        private final View src;

        public ViewWrapper(final View view) {
            this.src = view;
        }


        public void touch() {
          touch(30);
        }

        public void touch( long ms) {
            src.postDelayed(new Runnable() {

                public void run() {
                    src.dispatchTouchEvent(
                            MotionEvent.obtain(
                                    SystemClock.uptimeMillis(),
                                    SystemClock.uptimeMillis(),
                                    MotionEvent.ACTION_DOWN, 0, 0, 0));
                    src.dispatchTouchEvent(
                            MotionEvent.obtain(
                                    SystemClock.uptimeMillis(),
                                    SystemClock.uptimeMillis(),
                                    MotionEvent.ACTION_UP, 0, 0, 0));
                }
            }, ms);
        }
    }

    public static ViewWrapper withView(final View view) {
        return new ViewWrapper(view);
    }
}
