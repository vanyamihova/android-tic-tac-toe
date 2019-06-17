package eu.vanyamihova.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import eu.vanyamihova.tictactoe.game.GameEngine;
import eu.vanyamihova.tictactoe.game.animation.AnimationHelper;
import eu.vanyamihova.tictactoe.game.models.Player;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
public class MainActivity extends AppCompatActivity {

    private GameEngine gameEngine = new GameEngine();
    private TextView activePlayerView;
    private TextView winnerMessageView;
    private LinearLayout winnerContainerView;
    private GridLayout gridLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayoutView = findViewById(R.id.grid_layout);
        activePlayerView = findViewById(R.id.active_player);
        winnerMessageView = findViewById(R.id.winner_message);
        winnerContainerView = findViewById(R.id.winning_container);

        setActivePlayerLabel();
    }

    public void dropIn(View view) {
        Player player = gameEngine.getActivePlayer();
        if (player == null) {
            return;
        }
        int tappedTag = Integer.parseInt(view.getTag().toString());
        boolean allowAction = gameEngine.isActionAllowed(tappedTag);
        if (!allowAction) {
            return;
        }
        gameEngine.actionProcessed(tappedTag);
        ImageView imageView = (ImageView) view;
        imageView.setTranslationY(-1000f);
        imageView.setImageResource(player.putPull());
        imageView.animate()
                .translationYBy(1000f)
                .rotation(360)
                .setDuration(300);
        if (gameEngine.checkForWinningPositions()) {
            showWinnerContainer();
            winnerMessageView.setText(player.getType() + " has won!");
            return;
        }

        if (gameEngine.checkForNoEmptyPosition()) {
            showWinnerContainer();
            winnerMessageView.setText("It's a draw");
            return;
        }

        gameEngine.switchPlayers();
        setActivePlayerLabel();
    }

    public void playAgain(View view) {
        restartGrid();
        hideWinnerContainer();
        gameEngine.restart();
    }

    private void showWinnerContainer() {
        winnerContainerView.animate()
                .alpha(1)
                .setListener(AnimationHelper.get()
                        .onStart(() -> winnerContainerView.setVisibility(View.VISIBLE))
                        .build())
                .setDuration(300);
    }

    private void hideWinnerContainer() {
        winnerContainerView.animate()
                .alpha(0)
                .setListener(AnimationHelper.get()
                        .onEnd(() -> winnerContainerView.setVisibility(View.GONE))
                        .build())
                .setDuration(300);
    }

    private void restartGrid() {
        for (int index = 0; index < gridLayoutView.getChildCount(); index++) {
            ImageView imageView = (ImageView) gridLayoutView.getChildAt(index);
            imageView.setImageResource(0);
        }
    }

    private void setActivePlayerLabel() {
        Player player = gameEngine.getActivePlayer();
        activePlayerView.setText(player.getType().toString());
    }
}
