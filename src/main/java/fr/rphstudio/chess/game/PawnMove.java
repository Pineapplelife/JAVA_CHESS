package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();

        Piece myPiece = board.getPiece(position);
        List<IChess.ChessPosition> chessIsPossibleMove = new ArrayList<>();


<<<<<<< HEAD
        chessPositionList = new ArrayList<IChess.ChessPosition>();
        Piece myPiece = board.getPiece(position);
=======
>>>>>>> master

        if (!myPiece.hasMovedYet()) {
            if (myPiece.getPieceColor() == IChess.ChessColor.CLR_BLACK) {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 1));
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 2));
            } else {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 1));
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 2));
            }
        } else {
            if (myPiece.getPieceColor() == IChess.ChessColor.CLR_BLACK) {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y + 1));
            } else {
                chessPositionList.add(new IChess.ChessPosition(position.x, position.y - 1));
            }
        }
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

