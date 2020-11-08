package com.company;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

    public class Main {
        private static String[] Board;
        private static String Turn;

        public static void main(String[] args) {
            String PlayerOne;
            PlayerOne = JOptionPane.showInputDialog("Spelare ett, vad heter du?");
            String PlayerTwo;
            PlayerTwo = JOptionPane.showInputDialog("Spelare två, vad heter du?");
            String redo;
            redo = PlayerOne + " " + "möter " + PlayerTwo + " i luffarschack!";
            JOptionPane.showMessageDialog(null, redo);
            Scanner in = new Scanner(System.in);
            Board = new String[9];
            Turn = "X";
            String Winner = null;
            populateBoardMap();

            System.out.println("Välkommen till  Tic Tac Toe!");
            BoardMap();
            System.out.println(PlayerOne + " börjar, var vänlig ange ett nummer mellan 1-9: ");

            while (Winner == null) {
                String input;
                int number;
                String inp = in.next();
                if(IsNumber(inp)){
                        number = Integer.parseInt(inp);
                        if (!(number > 0 && number <= 9)) {
                            System.out.println("Ogiltligt val! Försök igen: ");
                            continue;
                        }
                        if (Board[number - 1].equals(String.valueOf(number))) {
                        Board[number - 1] = Turn;
                        if (Turn.equals("X")) {
                            Turn = "O";
                        } else {
                            Turn = "X";
                        }
                        BoardMap();
                        Winner = GameWinner();
                    } else {
                        System.out.println("Redan tagen, var vänlig försök igen: ");
                    }
                } else {
                    System.out.println("Ogiltligt val! Försök igen: ");
                }

            }
            System.out.println("Resultat: " + Winner);
            if (Winner.equalsIgnoreCase("Oavgjort")) {
                System.out.println("Matchen blev oavgjord!");
            } else {
                System.out.println("Grattis " + Winner + ", du vann!" );
            }
        }
        private static boolean IsNumber(String value) {
            try {
                double d = Double.parseDouble(value);
            }catch(NumberFormatException | NullPointerException e){
                return false;
            }
            return true;
        }
        private static String GameWinner() {
            for (int a = 0; a < 8; a++) {
                String line = null;
                switch (a) {
                    case 0:
                        line = Board[0] + Board[1] + Board[2];
                        break;
                    case 1:
                        line = Board[3] + Board[4] + Board[5];
                        break;
                    case 2:
                        line = Board[6] + Board[7] + Board[8];
                        break;
                    case 3:
                        line = Board[0] + Board[3] + Board[6];
                        break;
                    case 4:
                        line = Board[1] + Board[4] + Board[7];
                        break;
                    case 5:
                        line = Board[2] + Board[5] + Board[8];
                        break;
                    case 6:
                        line = Board[0] + Board[4] + Board[8];
                        break;
                    case 7:
                        line = Board[2] + Board[4] + Board[6];
                        break;
                }
                if (line.equals("XXX")) {
                    return "X";
                } else if (line.equals("OOO")) {
                    return "O";
                }
            }

            for (int a = 0; a < 9; a++) {
                if (Arrays.asList(Board).contains(String.valueOf(a + 1))) {
                    break;
                } else if (a == 8)
                    return "Oavgjort";
            }
            System.out.println(Turn + "'s tur, var vänlig ange ditt nummer här: ");
            return null;
        }

        private static void BoardMap() {
            System.out.println("|===|===|===|");
            System.out.println("| " + Board[0] + " | " + Board[1] + " | " + Board[2] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + Board[3] + " | " + Board[4] + " | " + Board[5] + " |");
            System.out.println("|-----------|");
            System.out.println("| " + Board[6] + " | " + Board[7] + " | " + Board[8] + " |");
            System.out.println("|===|===|===|");
        }

        private static void populateBoardMap() {
            for (int a = 0; a < 9; a++) {
                Board[a] = String.valueOf(a + 1);
            }
        }
    }