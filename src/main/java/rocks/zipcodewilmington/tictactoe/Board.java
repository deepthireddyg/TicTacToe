package rocks.zipcodewilmington.tictactoe;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;
import java.util.ArrayList;
/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] _matrix;

    public Board(Character[][] matrix) {
        this._matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        String status = getWinner();
        if (status == "X")
            return true;
        else
            return false;
    }

    public Boolean isInFavorOfO() {

        String status = getWinner();
        if (status == "O")
            return true;
        else
            return false;

    }

    public Boolean isTie() {
        String status = getWinner();
        if (status == "")
            return true;
        else
            return false;
    }

    public String getWinner() {
        StringBuilder sbR = new StringBuilder();
        StringBuilder sbC = new StringBuilder();
        StringBuilder sbDig1 = new StringBuilder();
        StringBuilder sbDig2 = new StringBuilder();
        ArrayList<String> al = new ArrayList<String>();
        int n = 2;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sbR.append(_matrix[i][j]);
                sbC.append(_matrix[j][i]);
                if (i == j) {
                    sbDig1.append(_matrix[i][j]);
                }
                if (i + j == n) {
                    sbDig2.append(_matrix[i][j]);
                }
            }
                al.add(sbR.toString());
                al.add(sbC.toString());
                sbR.delete(0, sbR.length());
                sbC.delete(0, sbC.length());
            }
            al.add(sbDig1.toString());
            al.add(sbDig2.toString());

            for (String str : al) {
                if (str.equals("XXX"))
                    return "X";
                else if (str.equals("OOO"))
                    return "O";
            }
            return "";
        }
    }

