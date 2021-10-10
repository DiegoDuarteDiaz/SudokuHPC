package cl.ucn.disc.hpc.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadArchives {
    public static void ReadArchives()
    {
        SudokuRepresentation sudoku = ReadTextFile("src/main/resources/sudoku.txt");
        PrintSudokuCells(sudoku);
    }

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
    public static void PrintSudokuCells(SudokuRepresentation sudoku){
        for (int i = 0; i < sudoku.GetCells().length; i++)
        {
            List<List<Integer>> row = new ArrayList<>();
            for (int j = 0; j < sudoku.GetCells().length; j++)
            {
                row.add(sudoku.GetCells()[i][j].GetPossibleValues());
            }
        }
    }
}

