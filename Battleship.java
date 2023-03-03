public class Battleship {
    //declare vars

    //board
    private int [][] board = new int [3][3];
    
    //user ship coordinates
    private int userShipRow;
    private int userShipCol;

    //comp ship coordinates
    private int compShipRow;
    private int compShipCol;

    //user guess coordinates
    private int userGuessRow;
    private int userGuessCol;

    //user result msg
    private String msg="";

    //computer guess coordinates
    private int compGuessRow;
    private int compGuessCol;

    //computer result msg
    private String compMsg;


    //constructor
    public Battleship(){}

    //set user ship coordinates
    public void setUserShipRow(int userShipRow){
        this.userShipRow=userShipRow;
    }
    public void setUserShipCol(int userShipCol){
        this.userShipCol=userShipCol;
    }

    //set user guess coordinates
    public void setUserGuessRow(int userGuessRow){
        this.userGuessRow=userGuessRow;
    }

    public void setUserGuessCol(int userGuessCol){
        this.userGuessCol=userGuessCol;
    }
    
    //set computer guess coordinates
    public void setCompGuessRow(int compGuessRow){
        this.compGuessRow=compGuessRow;
    }

    public void setCompGuessCol(int compGuessCol){
        this.compGuessCol=compGuessCol;
    }

    //compute

    public void computeBoard(){
        for(int i=0;i<board.length;i++){ //populate board with int 3 (water)
            for(int j=0;j<board[i].length;j++){
                board[i][j]=3;
            }
        }
        board[userShipRow][userShipCol]=1; //set user ship coordinates equal to 1

        //generate comp ship coordinates - random number between 1-3, decrement by 1
        compShipRow = (int)((Math.random()*3)+1);
        compShipCol = (int)((Math.random()*3)+1);

        compShipRow--;
        compShipCol--;

        if(board[compShipRow][compShipCol]!=board[userShipRow][userShipCol]){
            board[compShipRow][compShipCol]=2; //set comp ship coordinates to 2 as long as they are not equal to user ship coordinates
        }
        else{
            while(board[compShipRow][compShipCol]==board[userShipRow][userShipCol])
            compShipRow = (int)((Math.random()*3)); //regenerate the coordinates if the computer ship is at the same position as user ship
            compShipCol = (int)((Math.random()*3));
        }
        board[compShipRow][compShipCol]=2; //in the event of regenerated coordinates, set comp ship location to 2

        //for testing, prints the board
        /* 
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        */
    }
    
    //compute user result
    public void computeResult(){
        if(board[userGuessRow][userGuessCol]==2){
            msg = "You won!"; //win if comp ship is hit
            }
        else if(board[userGuessRow][userGuessCol]==board[userShipRow][userShipCol]){
            msg = "That's your ship!"; //skip if you tried to hit your own ship
        }
        else if(board[userGuessRow][userGuessCol]==3){
            msg="You missed!"; //miss if water (3) is hit
        }
    }

    //compute computer result
    public void computeCompResult(){
        //for testing purposes, prints computer guess coordinates.
        //todo: print computer guess coordinates as part of compMsg
        
        //System.out.println(compGuessRow+" "+compGuessCol);

        if(board[compGuessRow][compGuessCol]==1){
            compMsg = "Computer won"; //computer wins if user ship is hit
        }
            
        else{
            compMsg="Computer Missed";
            }
    }

    //get user result msg
    public String getMsg(){
        return msg;
    }
    //get comp result msg
    public String getCompMsg(){
        return compMsg;
    }

}
