package eu.vanyamihova.tictactoe.game;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 16.06.2019
 */
final class WinningPositions {

    private int[][] positions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int getSize() {
        return positions.length;
    }

    int[] getPositions(int position) {
        return positions[position];
    }

}
