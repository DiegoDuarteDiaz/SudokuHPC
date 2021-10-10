package cl.ucn.disc.hpc.sudoku;

/**
 * this is a Quad of X spaces in the sudoku.
 */
public class Quad
{
    // A matrix to reference the Spaces in the sudoku
    private Space[][] _spaces;
    // Create a States to evaluate a Row or a Column in the quad
    public enum EvaluatingType{Row, Column}
    // The current State that can I evaluate in the enum
    private EvaluatingType _evaluatingState;
    // A List to reference the indexes covered by this quad in the x-axis
    private Integer[] _xValueGoTo;
    // A List to reference the indexes covered by this quad on the y-axis
    private Integer[] _yValueGoTo;

    /**
     * The Constructor of the Quad Class.
     */
    public Quad(Space[][] spaces,EvaluatingType evaluatingState, int xFrom, int xTo, int yFrom, int yTo)
    {
        this._spaces= spaces;
        this._evaluatingState = evaluatingState;
        this._xValueGoTo= new Integer[]{xFrom, xTo};
        this._yValueGoTo = new Integer[]{yFrom, yTo};
    }

    /**
     * Check if in the State that evaluate can eliminate
     * @return
     */
    public boolean CanIEliminate()
    {
        if (_evaluatingState == _evaluatingState.Row)
        {
            return CanIDoARowElimination();
        }
        else if(_evaluatingState == _evaluatingState.Column)
        {
            return CanIDoAColumnElimination();
        }
        return false;
    }

    /**
     * Searching if i Can eliminate a value
     * @return
     */
    public boolean CanIDoARowElimination(){
        for (int i = _yValueGoTo[0]; i <= _yValueGoTo[1]; i++)
        {
            for (int j = i; j < _spaces[0].length; j++)
            {
                if (!_spaces[i][j].GetIsByDefault() && _spaces[i][j].HasOneValueInTheSpace())
                {
                    int value = _spaces[i][j].GetFirstPossibleValueInTheCell();
                    for (int k = 0; k < _spaces[0].length; k++)
                    {
                        if (k != j)
                        {
                            if (_spaces[i][k].HasPossibleValuesInTheCells(value))
                            {
                                return true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method to verify the Column elimination
     * @return
     */
    public boolean CanIDoAColumnElimination()
    {
        return true;
    }
}