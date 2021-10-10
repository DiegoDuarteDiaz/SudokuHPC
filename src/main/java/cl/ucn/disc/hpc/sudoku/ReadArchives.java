package cl.ucn.disc.hpc.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A Class to read the archives for the sudoku
 */
public class ReadArchives {
    public static void ReadArchives()
    {
        SudokuRepresentation sudoku = ReadTextFile("src/main/resources/sudoku.txt");
        PrintSudokuSpaces(sudoku);
    }

    /**
     * A Method to read the TXT
     * @param path the ubication of the txt archive
     * @return
     */
    public static SudokuRepresentation ReadTextFile(String path)
    {
        try
        {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            int size = Integer.parseInt(scanner.nextLine());
            int [][] grid = new int[size][size];
            int row = 0;
            while (scanner.hasNextLine())
            {
                String[] line = scanner.nextLine().split(" ");
                for (int i = 0; i < size; i++)
                {
                    grid[row][i] = Integer.parseInt(line[i]);
                }
                row++;
            }
            return new SudokuRepresentation(grid);
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
    }

    /**
     * A Method to print the Sudoku Spaces
     * @param sudoku
     */
    public static void PrintSudokuSpaces(SudokuRepresentation sudoku){
        for (int i = 0; i < sudoku.GetSpaces().length; i++)
        {
            List<List<Integer>> row = new ArrayList<>();
            for (int j = 0; j < sudoku.GetSpaces().length; j++)
            {
                row.add(sudoku.GetSpaces()[i][j].GetPossibleValues());
            }
        }
    }
}

