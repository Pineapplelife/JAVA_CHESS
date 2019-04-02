package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {

    private ChessBoard chessBoard;
    private static ChessModel INSTANCE;

    private ChessModel() {
    }

    public static ChessModel getInstance() {
        if (ChessModel.INSTANCE == null) {
            ChessModel.INSTANCE = new ChessModel();
        }
        return ChessModel.INSTANCE;
    }

    @Override
    public void reinit() {
        this.chessBoard = new ChessBoard();
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = chessBoard.getPiece(p);
        if (p.x < IChess.BOARD_WIDTH && p.x >= 0 && p.y >= 0 && p.y < IChess.BOARD_HEIGHT){
            if (piece == null){
                throw new EmptyCellException();
            }
        } else {
            throw new OutOfBoardException();
        }
        return piece.getPieceType();
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = chessBoard.getPiece(p);
        if (p.x < IChess.BOARD_WIDTH && p.x >= 0 && p.y >= 0 && p.y < IChess.BOARD_HEIGHT){
            if (piece == null){
                throw new EmptyCellException();
            }
        } else {
            throw new OutOfBoardException();
        }
        return piece.getPieceColor();
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return 0;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        return new ArrayList<ChessPosition>();
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {

    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<ChessType>();
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }
}
