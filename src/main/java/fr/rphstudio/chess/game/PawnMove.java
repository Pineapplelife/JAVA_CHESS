package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();
        Piece myPiece = board.getPiece(position);


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
