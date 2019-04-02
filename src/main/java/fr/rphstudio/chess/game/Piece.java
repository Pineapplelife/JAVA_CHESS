package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

import java.util.List;

public class Piece {

    private ChessColor color;
    private ChessType type;
    private IMove move;
    private int nbMoves;


    public Piece(ChessColor c, ChessType t, IMove m) {
        this.color = c;
        this.type = t;
        this.move = m;
        this.nbMoves = 0;
    }

    public ChessColor getPieceColor() {
        return color;
    }

    public ChessType getPieceType() {
        return type;
    }

    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition position, ChessBoard board) {
        return this.move.getPossibleMoves(position, board);
    }

    public void increaseNbMoves() {
        this.nbMoves++;
    }

    public void decreaseNbMoves() {
        this.nbMoves--;
    }

    public boolean hasMovedYet() {
        return nbMoves > 0;
    }
}