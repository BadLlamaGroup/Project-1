public class Proj01_SelectionSort implements Proj01_Sort
{
    private boolean inDebug;
    private boolean withinRange;
    private int endValue;
    private int startingValue;
    private int amtItems;

    public Proj01_SelectionSort( boolean debug )
    {
        inDebug = debug;
    }

    @Override
    public void sort( Comparable[] arr )
    {
        if ( !withinRange ) {
            startingValue = 0;
            endValue = arr.length;
        }

        amtItems = endValue;

        if ( inDebug ) {
            System.out.print( "|||||| BEGIN SELECTION SORT ||||||" );
            printDebugStatement( -1, arr, false );
        }

        for ( int outer = startingValue; outer < amtItems; ++outer ) {
            if ( inDebug ) {
                System.out.print( "|||||| CURRENT ||||||" );
                printDebugStatement( outer, arr, true );
            }

            int indexSmallest = outer;
            for ( int inner = outer + 1; inner < amtItems; ++inner ) {
                if ( arr[ inner ].compareTo( arr[ indexSmallest ] ) < 0 ) {
                    indexSmallest = inner;
                    if ( inDebug ) {
                        System.out.print( "|||||| SMALLEST ||||||" );
                        printDebugStatement( indexSmallest, arr, false );
                    }
                }
            }

            Comparable temp = arr[ outer ];
            arr[ outer ] = arr[ indexSmallest ];
            arr[ indexSmallest ] = temp;
        }

        if ( inDebug ) {
            System.out.print( "|||||| END SELECTION SORT ||||||" );
            printDebugStatement( -1, arr, false );
        }
    }

    public void printDebugStatement( int key, Comparable[] arr, boolean useBracket )
    {
        for ( int currentPos = startingValue; currentPos < amtItems; currentPos++ ) {
            if ( currentPos == key ) {
                if( useBracket ){
                    System.out.printf( " [ %s ]", arr[ currentPos ] );
                }
                else{
                    System.out.printf( " { %s }", arr[ currentPos ] );
                }

            } else {
                System.out.printf( " %s", arr[ currentPos ] );
            }
        }
        System.out.println();
    }

    public void setRange( int start, int end )
    {
        endValue = end + 1;
        startingValue = start;
        withinRange = true;
    }
}