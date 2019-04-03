package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList;
        Piece myPiece = board.getPiece(position);

        chessPositionList = new ArrayList<IChess.ChessPosition>();
        Piece myPiece = board.getPiece(position);

        if(!myPiece.hasMovedYet()) {
            if (myPiece.getPieceColor() == IChess.ChessColor.CLR_BLACK) {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 1));
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 2));
            }
            else {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 1));
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 2));
            }
        }
        else{
            if(myPiece.getPieceColor() == IChess.ChessColor.CLR_BLACK){
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 1));
            }
            else{
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 1));
            }
        }
        return chessPositionList;
    }
}
