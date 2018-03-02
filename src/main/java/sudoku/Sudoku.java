package sudoku;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by AMIT AGRAWAL on 28-02-2018.
 */
public class Sudoku extends HttpServlet {


    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        int matrix[][] ={
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        Sudoku s = new Sudoku();
        s.solve(matrix);
        System.out.println("babauaaaaaaaaaaaaaaaaaa");
    }

    public void destroy() {
        // do nothing.
    }

    public boolean chkRow(int x , int i ,int[][] matrix ){
        for(int n=0;n<9;n++){
            if(matrix[x][n] == i)
                return false;
        }
        return true;
    }

    public boolean chkCol(int y, int j, int [][] matrix){
        for(int m=0;m<9;m++){
            if(matrix[m][y] == j)
                return false;
        }
        return  true;
    }

    public boolean chkGrid(int x , int y, int i, int [][] matrix){
        int rowStart = (x/3)*3;
        int colStart = (y/3)*3;

        for(int k=rowStart;k<rowStart+3;k++){
            for(int l=colStart;l<colStart+3;l++){
                if(matrix[k][l] == i)
                    return false;
            }
        }
        return true;
    }

    public boolean backTrack(int [][] matrix){
        int x=0;
        int y=0;
        boolean unassinged = true;
        for(int i=0;i<9 && unassinged;i++){
            for(int j=0;j<9 && unassinged;j++){
                if(matrix[i][j] == 0){
                    x=i;
                    y=j;
                    unassinged = false;
                }
            }
        }
        if(unassinged){
            return true;
        }

        for(int i=1;i<=9;i++){
            if(chkRow(x,i,matrix) && chkCol(y,i,matrix) && chkGrid(x,y,i,matrix)){
                matrix[x][y] = i;

                if(backTrack(matrix)){
                    return true;
                }
                matrix[x][y] =0;
            }
        }
        return false;
    }

    public void solve(int[][] matrix){
        if(backTrack(matrix)){
            System.out.println("Sudoku Solved");

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Cant be solved");
        }
    }



    public static void main(String[] args) {


    }
}
