package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {

    private ChessBoard chessBoard;
    private static ChessModel INSTANCE;
    private PieceManager pieceManager;

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
        this.pieceManager = new PieceManager();
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece piece = chessBoard.getPiece(p);
        if (p.x < IChess.BOARD_WIDTH && p.x >= 0 && p.y >= 0 && p.y < IChess.BOARD_HEIGHT) {
            if (piece == null) {
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
        if (p.x < IChess.BOARD_WIDTH && p.x >= 0 && p.y >= 0 && p.y < IChess.BOARD_HEIGHT) {
            if (piece == null) {
                throw new EmptyCellException();
            }
        } else {
            throw new OutOfBoardException();
        }
        return piece.getPieceColor();
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return chessBoard.getRemainingPieces(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        Piece pi = this.chessBoard.getPiece(p);
        if (pi != null) {
            return pi.getMoves(p, chessBoard);
        }

        return new ArrayList<>();
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece piece = this.chessBoard.getPiece(p1);
        if (piece != null) {
            pieceManager.addPiece(piece);
        }
        chessBoard.getPiece(p0).increaseNbMoves();
        System.out.println(chessBoard.getPiece(p0).getNbMoves());
        this.chessBoard.movePiece(p0, p1);

        if (chessBoard.getPiece(p1).getPieceType() == ChessType.TYP_PAWN) {
            if (p1.y == 0 && chessBoard.getPiece(p1).getPieceColor() == ChessColor.CLR_WHITE) {
                chessBoard.pawnToQueen(p1, ChessColor.CLR_WHITE);
            }

            if (p1.y == 7 && chessBoard.getPiece(p1).getPieceColor() == ChessColor.CLR_BLACK) {
                chessBoard.pawnToQueen(p1, ChessColor.CLR_BLACK);
            }
        }
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return chessBoard.getKingState(color);
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return pieceManager.getRemovedPieces(color);
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
