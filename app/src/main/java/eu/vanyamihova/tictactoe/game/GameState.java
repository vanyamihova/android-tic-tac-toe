package eu.vanyamihova.tictactoe.game;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 15.06.2019
 */
final class GameState {

    private PlayerType[] states = {null, null, null, null, null, null, null, null, null};

    PlayerType getState(int position) {
        return states[position];
    }

    void setState(int position, PlayerType playerType) {
        states[position] = playerType;
    }

    boolean checkForMatching(int position1, int position2, int position3) {
        return states[position1] == states[position2] &&
                states[position1] == states[position3] &&
                states[position1] != null;
    }

    boolean checkForNoEmptyPosition() {
        for (PlayerType state : states) {
            if (state == null) {
                return false;
            }
        }
        return true;
    }

    void restart() {
        for (int index = 0; index < states.length; index++) {
            states[index] = null;
        }
    }

}
