package cl.ucn.disc.hpc.sudoku;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SudokuRepresentation
{
    // A matrix that reference the spaces in the sudoku
    private Space[][] _spaces;
    // A list to references the Row default Values
    List<List<Integer>> rowDefaultValues = new ArrayList<>(_spaces.length);
    // A list to references the Column default Values
    List<List<Integer>> columnDefaultValues = new ArrayList<>(_spaces.length);

    /**
     * The constructor of the SudokuRepresentation.
     * @param matrix an int matrix with the initial values of the sudoku spaces.
     */
    public SudokuRepresentation(int[][] matrix)
    {
        // Start with the cells matrix
        this._spaces = new Space[matrix.length][matrix.length];
        SearchTheDefaultValuesInTheRowsAndColumns(matrix);
        LookingPossibleValues(matrix);

    }

    /**
     * Looking for the possible values of each cell in the grid
     * @param matrix an int matrix with the initial values of the sudoku spaces.
     */
    public void LookingPossibleValues(int[][] matrix)
    {
        for(int i = 0; i < _spaces.length; i++)
        {
            for (int j = 0; j < _spaces.length; j++)
            {
                int value = matrix[i][j];
                Space space;
                if (value != 0)
                {
                    space = new Space(value);
                }
                else
                {
                    space = new Space();
                    for (int k = 1; k <= _spaces.length; k++)
                    {
                        if (!rowDefaultValues.get(i).contains(k) && !columnDefaultValues.get(j).contains(k))
                        {
                            space.AddValue(k);
                        }
                    }
                }
                _spaces[i][j] = space;
            }
        }
    }

    /**
     * Search the default values of each row and column
     * @param matrix an int matrix with the initial values of the sudoku spaces.
     */
    public void SearchTheDefaultValuesInTheRowsAndColumns(int[][] matrix)
    {
        for (int i = 0; i < _spaces.length; i++)
        {
            rowDefaultValues.add(new ArrayList<>());
            columnDefaultValues.add(new ArrayList<>());
        }
        for(int i = 0; i < _spaces.length; i++)
        {
            rowDefaultValues.add(new ArrayList<>());
            for (int j = 0; j < _spaces.length; j++)
            {
                int value = matrix[i][j];
                if (value != 0)
                {
                    rowDefaultValues.get(i).add(value);
                    columnDefaultValues.get(j).add(value);
                }
            }
        }
    }


    /**
     * Get the Spaces from the Matrix
     * @return
     */
    public Space[][] GetCells()
    {
        return this._spaces;
    }
}
