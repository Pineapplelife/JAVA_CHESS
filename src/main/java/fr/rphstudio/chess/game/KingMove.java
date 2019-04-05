package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class KingMove implements IMove {

    /**
     * Gets the list of possible moves for a piece on the board.
     * This is up to this method to ensure the moves are possible or not for each piece on the board.
     * This list may be empty because either there is no possible move or because the requested position is empty or outside the board.
     * @param position requested piece position.
     * @param board requested chess board
     * @return the list of possible moves for the requested piece position. The returned list reference must not be null.
     */

    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {

        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();
        List<IChess.ChessPosition> chessIsPossibleMove = new ArrayList<>();

        chessPositionList.add(new IChess.ChessPosition(position.x + 1, position.y));
        chessPositionList.add(new IChess.ChessPosition(position.x + 1, position.y + 1));
        chessPositionList.add(new IChess.ChessPosition(position.x + 1, position.y - 1));
        chessPositionList.add(new IChess.ChessPosition(position.x - 1, position.y));
        chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 1));
        chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 1));
        chessPositionList.add(new IChess.ChessPosition(position.x - 1, position.y - 1));
        chessPositionList.add(new IChess.ChessPosition(position.x - 1, position.y + 1));
        Piece myPiece = board.getPiece(position);

        /**
         * Several conditions in order to implements the list of the possible moves.
         * check if the piece is on the board.
         * check if the position is empty or not.
         * if there is a piece on the position, check the color of the piece.
         */

        for (int i = 0; i < chessPositionList.size(); i++) {
            IChess.ChessPosition posTemp = chessPositionList.get(i);

            if (posTemp.x < IChess.BOARD_WIDTH && posTemp.x >= 0 && posTemp.y >= 0 && posTemp.y < IChess.BOARD_HEIGHT) {
                Piece pieceTemp = board.getPiece(posTemp);
                if (pieceTemp != null) {
                    if (pieceTemp.getPieceColor() == myPiece.getPieceColor()) {
                        continue;
                    }
                }
                chessIsPossibleMove.add(posTemp);
            }
        }
        return chessIsPossibleMove;
    }
}
