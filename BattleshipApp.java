/*
 * Create a simple game of Battleship using 2D arrays. The user should be able to position their ship in a 3x3 array, as should the computer. Each ‘player’ should take turns choosing spots in the grid until someone hits the other ship.

Note: For simplicity, each player will only have 1 ship, that takes up 1 grid slot

Note: For simplicity, do not worry about repeated guesses
 */

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class BattleshipApp {
    public static void main(String args[]) {
        //declare vars

        //user ship
        int userShipRow;
        int userShipCol;

        //user guess
        int userGuessRow;
        int userGuessCol;

        //comp guess
        int compGuessRow;
        int compGuessCol;

        String msg=""; //user results
        String compMsg; //computer results

        //declare objects
        Battleship b;
        b=new Battleship();

        //input ship coordinates
        String [] colOptions = {"A","B","C"};
        String [] rowOptions = {"1", "2", "3"};
        ImageIcon grid = new ImageIcon("images/grid.png");
        userShipCol = JOptionPane.showOptionDialog(null, "Place your ship! \nChoose a column", "Place your ship", 0, 3, grid, colOptions, colOptions[0]);
        userShipRow = JOptionPane.showOptionDialog(null, "Place your ship! \nChoose a row", "Place your ship", 0, 3, grid, rowOptions, rowOptions[0]);

        
        //set ship coordinates
        b.setUserShipRow(userShipRow);
        b.setUserShipCol(userShipCol);

        //compute
        b.computeBoard();

        //while no one won
        boolean keepPlaying=true;
        do{
            String [] guessColOptions = {"A","B","C"};
            String [] guessRowOptions = {"1", "2", "3"};

            //take user guess input
            userGuessCol=JOptionPane.showOptionDialog(null, "Try to hit computer's ship! \nChoose a column", "Try to hit the other ship!", 0, 3, grid, guessColOptions, guessColOptions[0]);
            userGuessRow=JOptionPane.showOptionDialog(null, "Try to hit computer's ship! \nChoose a row", "Try to hit the other ship!", 0, 3, grid, guessRowOptions, guessRowOptions[0]);
            //set user guess input
            b.setUserGuessRow(userGuessRow);
            b.setUserGuessCol(userGuessCol);
            //compute user result
            b.computeResult();
            //get user result & output
            msg=b.getMsg();
            JOptionPane.showMessageDialog(null, msg);

            if(msg.equals("You won!")){
                keepPlaying=false; //stop the loop when you win, at the moment loop will keep iterating until computer guesses
                break; //not working without break at the moment
            }

            //take computer guess as random number between 1-3, decrement by 1
            compGuessRow=(int)((Math.random()*3)+1);
            compGuessCol = (int)((Math.random()*3)+1);
            compGuessRow--;
            compGuessCol--;
    
            //set computer guess
            b.setCompGuessRow(compGuessRow);
            b.setCompGuessCol(compGuessCol);
            //compute computer result
            b.computeCompResult();
            //get user result and output
            compMsg=b.getCompMsg();
            JOptionPane.showMessageDialog(null, compMsg);

            if(compMsg.equals("Computer won")){
                keepPlaying=false; //loop will finish if computer wins
            }

        }while(keepPlaying==true);
    }
}
