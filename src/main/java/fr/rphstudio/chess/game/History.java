package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class History {

    private IChess.ChessPosition savePos0;
    private Piece startPiece;
    private IChess.ChessPosition savePos1;
    private Piece endPiece;
    private long timer;

    public History(IChess.ChessPosition savePos0, Piece startPiece, IChess.ChessPosition savePos1, Piece endPiece, long timer) {
        this.savePos0 = savePos0;
        this.startPiece = startPiece;
        this.savePos1 = savePos1;
        this.endPiece = endPiece;
        this.timer = timer;
    }


    public IChess.ChessPosition getSavePos0() {
        return savePos0;
    }

    public Piece getStartPiece() {
        return startPiece;
    }

    public IChess.ChessPosition getSavePos1() {
        return savePos1;
    }

    public Piece getEndPiece() {
        return endPiece;
    }

    public long getTimer() {
        return timer;
    }
}
