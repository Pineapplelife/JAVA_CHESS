package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class ChessBoard {

    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[IChess.BOARD_WIDTH][IChess.BOARD_HEIGHT];

        for (int x = 0; x < IChess.BOARD_WIDTH; x++) {
            for (int y = 0; y < IChess.BOARD_HEIGHT; y++) {
                IChess.ChessColor color;
                IChess.ChessType typ;
                if (y <= 1) {
                    color = IChess.ChessColor.CLR_BLACK;
                } else if (y >= 6) {
                    color = IChess.ChessColor.CLR_WHITE;
                } else {
                    continue;
                }
                if (y == 1 || y == 6) {
                    typ = IChess.ChessType.TYP_PAWN;
                } else {
                    switch (x) {
                        case IChess.BOARD_POS_X_QUEENSIDE_ROOK:
                        case IChess.BOARD_POS_X_KINGSIDE_ROOK:
                            typ = IChess.ChessType.TYP_ROOK;
                            break;
                        case IChess.BOARD_POS_X_QUEENSIDE_KNIGHT:
                        case IChess.BOARD_POS_X_KINGSIDE_KNIGHT:
                            typ = IChess.ChessType.TYP_KNIGHT;
                            break;
                        case IChess.BOARD_POS_X_QUEENSIDE_BISHOP:
                        case IChess.BOARD_POS_X_KINGSIDE_BISHOP:
                            typ = IChess.ChessType.TYP_BISHOP;
                            break;
                        case IChess.BOARD_POS_X_KING:
                            typ = IChess.ChessType.TYP_KING;
                            break;
                        case IChess.BOARD_POS_X_QUEEN:
                            typ = IChess.ChessType.TYP_QUEEN;
                            break;
                        default:
                            throw new Error();
                    }
                }
                board[x][y] = new Piece(color, typ);
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

}