package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
	    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
	    Position p = new Position(0, 0);

	    // Vetores para as direções (vertical e horizontal)
	    int[][] directions = {
	        {-1, 0}, // acima
	        {1, 0},  // abaixo
	        {0, -1}, // esquerda
	        {0, 1}   // direita
	    };

	    for (int[] direction : directions) {
	        int rowDirection = direction[0];
	        int colDirection = direction[1];

	        // Inicia a verificação a partir da posição atual da peça
	        p.setValues(position.getRow() + rowDirection, position.getColumn() + colDirection);

	        // Enquanto a posição for válida e não houver peça
	        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	            p.setValues(p.getRow() + rowDirection, p.getColumn() + colDirection);
	        }

	        // Verifica se a última posição contém uma peça oponente
	        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }
	    }

	    return mat;
	}


}
