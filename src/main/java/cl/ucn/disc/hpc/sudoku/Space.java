package cl.ucn.disc.hpc.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class reference a Space to put a number in the Sudoku.
 */
public class Space
{
    // Need a list to save the possible values in the space
    private List<Integer> _valuesToPut;
    // If the Space is default the boolean take the valor true
    private boolean _defaultSpace = true;
    // Space for access by 1 thread in one moment
    private boolean _lock;

    /**
     * The constructor of the Space Class
     */
    public Space()
    {
        this._valuesToPut = new ArrayList<>();
        this._defaultSpace = false;
        this._lock = false;
    }

    /**
     * Add a possible value in the Space.
     * @param value the value.
     */
    public void AddValue(int value)
    {
        // Check if the value already exists
        if (!_valuesToPut.contains(value))
        {
            _valuesToPut.add(value);
            Collections.sort(_valuesToPut);
        }
    }

    /**
     * Remove a possible value in the Space.
     * @param value the value.
     */
    public void RemoveValue(int value)
    {
        // Check if the value already exists
        if(_valuesToPut.contains(value))
        {
            _valuesToPut.remove(value);
        }
    }

    /**
     * Check if there is only one possible value in the Space.
     * @return true if the size of the list is 1.
     */
    public boolean HasOneValueInTheSpace()
    {
        return _valuesToPut.size() == 1;
    }

    /**
     * Get a list with the current possible values for the Space.
     * @return a list with the possible values.
     */
    public List<Integer> GetPossibleValues()
    {
        return this._valuesToPut;
    }

    /**
     * Check if this cell has a possible value
     * @param value the value.
     * @return true if the value exists.
     */
    public boolean HasPossibleValuesInTheCells(int value)
    {
        return _valuesToPut.contains(value);
    }

    /**
     * Get the first possible value of the Space.
     * @return the first possible value.
     */
    public int GetFirstPossibleValueInTheCell()
    {
        return this._valuesToPut.get(0);
    }

    /**
     * A cell value can be by default.
     * @return true if this is a default cell.
     */
    public boolean GetIsByDefault()
    {
        return this._defaultSpace;
    }

    /**
     * A cell can be locked to prevent data errors.
     * @return true if the cell is locked.
     */
    public boolean GetIsLock()
    {
        return this._lock;
    }

    /**
     * A cell can be locked to prevent data errors.
     * @param isLock true to lock this cell.
     */
    public void SetIsLock(boolean isLock)
    {
        this._lock = isLock;
    }
}