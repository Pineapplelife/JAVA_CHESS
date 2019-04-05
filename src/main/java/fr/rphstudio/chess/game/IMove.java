package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;


public interface IMove {

    /**
     * Gets the list of possible moves for a piece on the board.
     * This is up to this method to ensure the moves are possible or not for each piece on the board.
     * This list may be empty because either there is no possible move or because the requested position is empty or outside the board.
     * @param position requested piece position
     * @param board requested chess board
     */

    List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board);

}
