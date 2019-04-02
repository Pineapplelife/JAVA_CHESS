package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

public class Piece {

    private ChessColor color;
    private ChessType type;

    public Piece(ChessColor c, ChessType t) {
        this.color = c;
        this.type = t;
    }

    public ChessColor getPieceColor() {
        return color;
    }

    public ChessType getPieceType() {
        return type;
    }
}
