package eu.vanyamihova.tictactoe.game.models;

import eu.vanyamihova.tictactoe.R;
import eu.vanyamihova.tictactoe.game.PlayerType;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
public final class Cat extends Player {

    public Cat() {
        super(PlayerType.CAT);
    }

    @Override
    public int putPull() {
        return R.drawable.fish;
    }
}
