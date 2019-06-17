package eu.vanyamihova.tictactoe.game.models;

import eu.vanyamihova.tictactoe.game.PlayerType;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
public abstract class Player {

    private PlayerType playerType;

    Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public abstract int putPull();

    public PlayerType getType() {
        return playerType;
    }

}
