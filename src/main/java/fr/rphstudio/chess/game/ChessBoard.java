package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;

public class ChessBoard {

    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[IChess.BOARD_WIDTH][IChess.BOARD_HEIGHT];

        for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
            for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
                IChess.ChessColor color;
                IChess.ChessType typ;
                IMove move;

                if (y <= 1) {
                    color = IChess.ChessColor.CLR_BLACK;
                } else if (y >= 6) {
                    color = IChess.ChessColor.CLR_WHITE;
                } else {
                    continue;
                }
                if (y == 1 || y == 6) {
                    typ = IChess.ChessType.TYP_PAWN;
                    move = new PawnMove();
                } else {
                    switch (x) {
                        case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                        case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                            typ = IChess.ChessType.TYP_ROOK;
                            move = new RookMove();
                            break;
                        case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                        case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                            typ = IChess.ChessType.TYP_KNIGHT;
                            move = new KnightMove();
                            break;
                        case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                        case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                            typ = IChess.ChessType.TYP_BISHOP;
                            move = new PawnMove();
                            break;
                        case IChess.BOARD_POS_X_KING:
                            typ = IChess.ChessType.TYP_KING;
                            move = new KingMove();
                            break;
                        case IChess.BOARD_POS_X_QUEEN:
                            typ = IChess.ChessType.TYP_QUEEN;
                            move = new QueenMove();
                            break;
                        default:
                            throw new Error();
                    }
                }
                board[x][y] = new Piece(color, typ, move);
            }
        }
    }

    public Piece getPiece(IChess.ChessPosition position) {
        Piece piece = null;

        if (position.x < IChess.BOARD_WIDTH && position.x >= 0 && position.y >= 0 && position.y < IChess.BOARD_HEIGHT) {
            piece = this.board[position.x][position.y];
        }
        return piece;
    }

    public int getRemainingPieces(IChess.ChessColor color) {
        int count = 0;
        Piece pi;

        for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
            for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
                pi = this.board[x][y];
                if (pi != null) {
                    if (color == pi.getPieceColor()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1){
        this.board[p1.x][p1.y] = this.board[p0.x][p0.y];
        this.board[p0.x][p0.y] = null;
    }

    private IChess.ChessPosition getKingPosition(IChess.ChessColor color) {
        for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
            for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
                Piece piece = board[x][y];

                if(null != piece && piece.getPieceColor() == color){
                    if (piece.getPieceType() == IChess.ChessType.TYP_KING){
                        return new IChess.ChessPosition(x, y);
                    }
                }
            }
        }
        return null;
    }
    public IChess.ChessKingState getKingState(IChess.ChessColor color){
        IChess.ChessPosition kingPos = getKingPosition(color);
        for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
            for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
                Piece piece = board[x][y];
                IChess.ChessPosition positionE = new IChess.ChessPosition(x, y);
                if (piece != null) {
                    if (piece.getPieceColor() != color) {
                        List<IChess.ChessPosition> myList = piece.getMoves(positionE, this);
                        for (IChess.ChessPosition pos : myList) {
                            if (pos.equals(kingPos)) {
                                return IChess.ChessKingState.KING_THREATEN;
                            }
                        }
                    }
                }
            }
        }
        return IChess.ChessKingState.KING_SAFE;
    }


}