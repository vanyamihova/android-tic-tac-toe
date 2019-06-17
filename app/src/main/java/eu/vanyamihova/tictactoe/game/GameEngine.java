package eu.vanyamihova.tictactoe.game;

import eu.vanyamihova.tictactoe.game.models.Cat;
import eu.vanyamihova.tictactoe.game.models.Dog;
import eu.vanyamihova.tictactoe.game.models.Player;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
public final class GameEngine {

    private Dog dog = new Dog();
    private Cat cat = new Cat();
    private Player activePlayer = dog;
    private GameState gameState = new GameState();
    private WinningPositions winningPositions = new WinningPositions();

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void switchPlayers() {
        if (activePlayer == cat) {
            activePlayer = dog;
        } else {
            activePlayer = cat;
        }
    }

    public boolean isActionAllowed(int tappedTag) {
        return gameState.getState(tappedTag) == null;
    }

    public void actionProcessed(int tappedTag) {
        gameState.setState(tappedTag, activePlayer.getType());
    }

    public boolean checkForWinningPositions() {
        for (int index = 0; index < winningPositions.getSize(); index++) {
            int[] positions = winningPositions.getPositions(index);
            if (gameState.checkForMatching(positions[0], positions[1], positions[2])) {
                activePlayer = null;
                return true;
            }
        }
        return false;
    }

    public boolean checkForNoEmptyPosition() {
        return gameState.checkForNoEmptyPosition();
    }

    public void restart() {
        activePlayer = dog;
        gameState.restart();
    }

}
