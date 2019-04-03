package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class PieceManager
{

    private List<IChess.ChessType> whiteRemovedPieces = new ArrayList<>();
    private List<IChess.ChessType> blackRemovedPieces = new ArrayList<>();


    public void addPiece(Piece piece)
    {
        if (piece != null)
        {
            if (piece.getPieceColor() == IChess.ChessColor.CLR_WHITE)
            {
                this.whiteRemovedPieces.add(piece.getPieceType());
            }
            else
            {
                this.blackRemovedPieces.add(piece.getPieceType());
            }
        }
    }

    public List<IChess.ChessType> getRemovedPieces(IChess.ChessColor color) {
        if (color == IChess.ChessColor.CLR_WHITE) {
            return this.whiteRemovedPieces;
        }
        else {
            return this.blackRemovedPieces;
        }

    }
}