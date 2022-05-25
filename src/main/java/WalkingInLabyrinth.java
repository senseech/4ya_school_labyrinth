import java.util.Scanner;

public class WalkingInLabyrinth {
    static int numDots = 0;
    static int countDots = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numLines = in.nextInt();
        int numColons = in.nextInt();
        String[][] mtxValues = new String[numLines][numColons];
        String startPoint = null;
        int cooY = 0;
        int cooX = 0;

        for (int i = 0; i < numLines; i++) {
            String[] tmp_str = in.next().split("");
            for (int j = 0; j < numColons; j++) {
                mtxValues[i][j] = tmp_str[j];
                if (tmp_str[j].equals("S")) {
                    cooY = i;
                    cooX = j;
                }
                if (tmp_str[j].equals(".")) numDots++;
            }
        }

        SearchWay(cooY,cooX, mtxValues);

        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numColons; j++) {
                System.out.print(mtxValues[i][j]);
            }
            System.out.println();
        }
    }
        public static String[][] SearchWay ( int y, int x, String[][] matrix){
            //OUT
            if (numDots == countDots) return matrix;
            //UP
            if (matrix[y - 1][x].equals(".")) {
                matrix[y - 1][x] = "U";
                SearchWay(y - 1, x, matrix);
                countDots++;
            }
            //Down
            else if (matrix[y + 1][x].equals(".")) {
                matrix[y + 1][x] = "D";
                SearchWay(y + 1, x, matrix);
                countDots++;
            }
            //Right
            else if (matrix[y][x + 1].equals(".")) {
                matrix[y][x + 1] = "R";
                SearchWay(y, x + 1, matrix);
                countDots++;
            }
            //Left
            else if (matrix[y][x - 1].equals(".")) {
                matrix[y][x - 1] = "L";
                SearchWay(y, x - 1, matrix);
                countDots++;
            }
            //Impasse
            else {
                if (matrix[y][x].equals("U")) {
                    SearchWay(y + 1, x, matrix);
                }
                if (matrix[y][x].equals("D")) {
                    SearchWay(y - 1, x, matrix);
                }
                if (matrix[y][x].equals("R")) {
                    SearchWay(y, x - 1, matrix);
                }
                if (matrix[y][x].equals("L")) {
                    SearchWay(y, x + 1, matrix);
                }
            }
            return null;
        }
    }
