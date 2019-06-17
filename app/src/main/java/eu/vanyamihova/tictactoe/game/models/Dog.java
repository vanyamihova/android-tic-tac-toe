package eu.vanyamihova.tictactoe.game.models;

import eu.vanyamihova.tictactoe.R;
import eu.vanyamihova.tictactoe.game.PlayerType;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
public final class Dog extends Player {

    public Dog() {
        super(PlayerType.DOG);
    }

    @Override
    public int putPull() {
        return R.drawable.bone;
    }

}
