import java.util.Random; 
public class BattleShips { 
    private char[][] grid; 
    public BattleShips() { 
        grid = new char[10][10]; 
        placeShips(); 
    } 
    public void print() { 
        System.out.print("   "); 
        for (int col = 0; col < 10; col++) { 
            System.out.print(col + " "); 
        } 
        System.out.println(); 
        for (int row = 0; row < 10; row++) { 
            System.out.print(row + "  "); 
            for (int col = 0; col < 10; col++) { 
                if(grid[row][col] == 'S') { 
                    System.out.print("[ ]"); 
                } else if (grid[row][col] == '\u0000') { 
                    System.out.print("[ ]"); 
                } else { 
                    System.out.print("[" + grid[row][col] + "]"); 
                } 
            } 
            System.out.println(); 
        } 
    } 
    public void placeShips() { 
        Random rand = new Random(); 
        int[] ships = {5, 4, 3, 2, 1}; 
        for (int length : ships) { 
            boolean placed = false; 
            while (!placed) { 
                int row = rand.nextInt(10); 
                int col = rand.nextInt(10); 
                if (col + length <= 10) { 
                    boolean available = true; 
                   for  (int i = 0; i < length; i++) { 
                      if(grid[row][col + i] == 'S') { 
                            available = false; 
                        } 
                    } 
                    if(available) { 
                        for (int i = 0; i < length; i++) { 
                            grid[row][col + i] = 'S'; 
                        } 
                        placed = true; 
                    } 
                } 
            } 
        } 
    } 
    public boolean canFire(int row, int col) { 
        return grid[row][col] != 'H' && 
               grid[row][col] != 'M'; 
    } 
    public void processFire(int row, int col) { 
        if(grid[row][col] == 'S') { 
            grid[row][col] = 'H'; 
        } else { 
            grid[row][col] = 'M'; 
        } 
    } 
    public boolean gameOver() { 
        for (int row = 0; row < 10; row++) { 
            for (int col = 0; col < 10; col++) { 
                if(grid[row][col] == 'S') { 
                    return false; 
                } 
            } 
        } 
        return true; 
    } 
}