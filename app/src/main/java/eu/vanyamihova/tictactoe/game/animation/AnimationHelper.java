package eu.vanyamihova.tictactoe.game.animation;

import android.animation.Animator;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 16.06.2019
 */
public final class AnimationHelper {

    private AnimationEndListener animationEndListener;
    private AnimationStartListener animationStartListener;

    private AnimationHelper() {
    }

    public static AnimationHelper get() {
        return new AnimationHelper();
    }

    public AnimationHelper onEnd(AnimationEndListener animationEndListener) {
        this.animationEndListener = animationEndListener;
        return this;
    }

    public AnimationHelper onStart(AnimationStartListener animationStartListener) {
        this.animationStartListener = animationStartListener;
        return this;
    }

    public AnimationListener build() {
        return new AnimationListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (animationStartListener != null) {
                    animationStartListener.onAnimationStart();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (animationEndListener != null) {
                    animationEndListener.onAnimationEnd();
                }
            }
        };
    }

}
