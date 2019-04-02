package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class KnightMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {

        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();
        List<IChess.ChessPosition> chessIsPossibleMove = new ArrayList<>();

        chessPositionList.add(new IChess.ChessPosition(position.x + 1, position.y - 2));
        chessPositionList.add(new IChess.ChessPosition(position.x + 1, position.y + 2));
        chessPositionList.add(new IChess.ChessPosition(position.x - 1, position.y - 2));
        chessPositionList.add(new IChess.ChessPosition(position.x - 1, position.y + 2));
        chessPositionList.add(new IChess.ChessPosition(position.x + 2, position.y - 1));
        chessPositionList.add(new IChess.ChessPosition(position.x + 2, position.y + 1));
        chessPositionList.add(new IChess.ChessPosition(position.x - 2, position.y - 1));
        chessPositionList.add(new IChess.ChessPosition(position.x - 2, position.y + 1));
        Piece myPiece = board.getPiece(position);

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
