package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import exceptions.ChessException;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {

                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc); 

                boolean[][] possibleMoves = chessMatch.possibleMoves(source); 
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
    
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
    
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/H/R/Q): ");
                    String pieceType = sc.nextLine().toUpperCase();
                    while (!pieceType.equals("H") && !pieceType.equals("B") && !pieceType.equals("R") && !pieceType.equals("Q")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/H/R/Q): ");
                        pieceType = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(pieceType);
                }
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());

                //Type "enter"
                System.out.print("Press 'enter' to continue...");

                sc.nextLine();

            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());

                //Type "enter"
                System.out.print("Press 'enter' to continue...");

                sc.nextLine();

            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
