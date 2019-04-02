package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition position, ChessBoard board) {
        List<IChess.ChessPosition> chessPositionList;

        chessPositionList = new ArrayList<IChess.ChessPosition>();

        chessPositionList.add(new IChess.ChessPosition(position.x, position.y-3));
        chessPositionList.add(new IChess.ChessPosition(position.x, position.y+1));

        return chessPositionList;
    }
}
