import java.util.Scanner; 
public class BattleShipsApp { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
        BattleShips game = new BattleShips(); 
        System.out.println("Welcome to BattleShips:"); 
        while (!game.gameOver()) { 
            game.print(); 
            System.out.println("What row and column do you want to fire on?"); 
            System.out.print("row (0-9): "); 
            int row = input.nextInt(); 
            System.out.print("col (0-9): "); 
            int col = input.nextInt(); 
            if(row < 0 || row > 9 || col < 0 || col > 9) { 
                System.out.println("Invalid position. Try again."); 
            } 
            else if (!game.canFire(row, col)) { 
                System.out.println("You have already fired at this position."); 
            } 
            else { 
                game.processFire(row, col); 
            } 
        } 
        game.print(); 
        System.out.println("Congratulations! You have sunk all the ships!"); 
        input.close(); 
    } 
}