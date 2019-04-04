package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class BishopMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList = new ArrayList<>();

        Piece myPiece = board.getPiece(position);
        IChess.ChessPosition posTemp;
        Piece pieceTemp;


        for (int test = 0; test < 4; test++) {
            int x = 0;
            int y = 0;

            switch(test){
                case 0 :
                    y = -1;
                    x = -1;
                    break;
                case 1 :
                    y = -1;
                    x = 1;
                    break;
                case 2 :
                    y = 1;
                    x = -1;
                    break;
                case 3 :
                    y = 1;
                    x = 1;
                    break;
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


