package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class RookMove implements IMove {

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

        Piece myPiece = board.getPiece(position);
        IChess.ChessPosition posTemp;
        Piece pieceTemp;

        /**
         * Gets the different case of possible moves for the rook.
         */


        for (int test = 0; test < 4; test++) {
            int x = 0;
            int y = 0;

            switch(test){
                case 0 :
                    y = 1;
                break;
                case 1 :
                    x = 1;
                break;
                case 2 :
                    y = -1;
                break;
                case 3 :
                    x = -1;
                break;
            }

            /**
             * Several conditions in order to implements the list of the possible moves.
             * check if the piece is on the board.
             * check if the position is empty or not.
             * if there is a piece on the position, check the color of the piece.
             */

            for (int i = 1; i <= 7; i++) {
                posTemp = new IChess.ChessPosition(position.x + (i*x), position.y + (i*y));

                if (posTemp.x < IChess.BOARD_WIDTH && posTemp.x >= 0 && posTemp.y >= 0 && posTemp.y < IChess.BOARD_HEIGHT) {
                    pieceTemp = board.getPiece(posTemp);
                    if (pieceTemp != null) {
                        if (pieceTemp.getPieceColor() != myPiece.getPieceColor()) {
                            chessPositionList.add(posTemp);
                        }
                        break;
                    } else {
                        chessPositionList.add(posTemp);
                    }
                }
            }
        }
        return chessPositionList;
    }
}


