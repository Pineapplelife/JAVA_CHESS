package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class QueenMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();

        Piece myPiece = board.getPiece(position);
        IChess.ChessPosition posTemp;
        Piece pieceTemp;


        for (int test = 0; test <= 7; test++) {
            int x = 1;
            int y = 1;

            if (test % 4 == 0) {
                x = 0;
            }
            if (test % 4 == 2) {
                y = 0;
            }
            if (test >= 3 && test <= 5) {
                y = -1;
            }
            if (test >= 1 && test <= 3) {
                x = -1;
            }
            for (int i = 1; i <= 7; i++) {
                posTemp = new IChess.ChessPosition(position.x + (i* x), position.y + (i*y));

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


