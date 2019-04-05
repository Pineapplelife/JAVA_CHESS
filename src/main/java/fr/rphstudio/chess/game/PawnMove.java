package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {

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

        /**
         * Gets the different case of possible moves for the pawn
         * Several conditions in order to implements the list of the possible moves.
         * check if the pawn has moved yet
         * allow to the pawn to kill in diagonale
         */

        if (myPiece.getPieceColor() == IChess.ChessColor.CLR_BLACK) {
            for(int i = -1; i <= 1; i += 2){
                IChess.ChessPosition posTemp3 = new IChess.ChessPosition(position.x+i, position.y+1);
                if(board.getPiece(posTemp3) != null){
                    if(board.getPiece(posTemp3).getPieceColor() != myPiece.getPieceColor()) {
                        chessPositionList.add(posTemp3);
                    }
                }
            }
            IChess.ChessPosition posTemp = new IChess.ChessPosition(position.x, position.y+1);
            if(board.getPiece(posTemp) == null){
                chessPositionList.add(posTemp);
                IChess.ChessPosition posTemp2 = new IChess.ChessPosition(position.x, position.y+2);
                if(!myPiece.hasMovedYet()){
                    chessPositionList.add(posTemp2);
                }
            }
        }
        else{
            for(int i = -1; i <= 1; i += 2){
                IChess.ChessPosition posTemp3 = new IChess.ChessPosition(position.x+i, position.y-1);
                if(board.getPiece(posTemp3) != null){
                    if(board.getPiece(posTemp3).getPieceColor() != myPiece.getPieceColor()) {
                        chessPositionList.add(posTemp3);
                    }
                }
            }
            IChess.ChessPosition posTemp = new IChess.ChessPosition(position.x, position.y-1);
            if(board.getPiece(posTemp) == null){
                chessPositionList.add(posTemp);
                IChess.ChessPosition posTemp2 = new IChess.ChessPosition(position.x, position.y-2);
                if(!myPiece.hasMovedYet()){
                    chessPositionList.add(posTemp2);
                }
            }
        }
        return chessPositionList;
    }
}
