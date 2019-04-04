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
            IChess.ChessPosition posTemp = new IChess.ChessPosition(position.x, position.y+1);
            for(int i = -1; i < 2; i += 2){
                posTemp = new IChess.ChessPosition(posTemp.x+i,posTemp.y);
                if(board.getPiece(posTemp) != null){
                    if(myPiece.getPieceColor() != board.getPiece(posTemp).getPieceColor()){
                        chessPositionList.add(posTemp);
                    }
                }
            }
            posTemp = new IChess.ChessPosition(position.x, position.y+1);
            if (board.getPiece(posTemp) == null) {
                chessPositionList.add(posTemp);
                if (!myPiece.hasMovedYet()) {
                    posTemp = new IChess.ChessPosition(posTemp.x, posTemp.y + 1);
                    chessPositionList.add(posTemp);
                }
            }
        } else {
            IChess.ChessPosition posTemp = new IChess.ChessPosition(position.x, position.y-1);
            for(int i = -1; i < 2; i += 2){
                posTemp = new IChess.ChessPosition(posTemp.x+i,posTemp.y);
                if(board.getPiece(posTemp) != null){
                    if(myPiece.getPieceColor() != board.getPiece(posTemp).getPieceColor()){
                        chessPositionList.add(posTemp);
                    }
                }
            }
            posTemp = new IChess.ChessPosition(position.x, position.y-1);
            if (board.getPiece(posTemp) == null) {
                chessPositionList.add(posTemp);
                if (!myPiece.hasMovedYet()) {
                    posTemp = new IChess.ChessPosition(posTemp.x, posTemp.y - 1);
                    chessPositionList.add(posTemp);
                }
            }
        }
        return chessPositionList;
    }
}

