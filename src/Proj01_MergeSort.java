public class Proj01_MergeSort implements Proj01_Sort
{
    private boolean inDebug;
    private int baseLen;

    public Proj01_MergeSort( boolean debug, int baseLen )
    {
        inDebug = debug;
        this.baseLen = baseLen;
    }

    @Override
    public void sort( Comparable[] arr )
    {
        if ( inDebug ) {
            System.out.print( "|||||| BEGIN MERGE SORT ||||||" );
            printDebugStatement( arr );
        }

        mergeSort( arr, 0, arr.length - 1 );

        if ( inDebug ) {
            System.out.print( "|||||| END MERGE SORT ||||||" );
            printDebugStatement( arr );
        }
    }

    public void merge( Comparable[] arr, int low, int middle, int high )
    {
        int mergedSize = high - low + 1;
        Comparable[] merged = new Comparable[ mergedSize ];
        int mergePos = 0;
        int leftPos;
        int rightPos;

        leftPos = low;
        rightPos = middle + 1;

        // Add smallest element from left or right partition to merged list
        while ( leftPos <= middle && rightPos <= high ) {
            if ( arr[ leftPos ].compareTo( arr[ rightPos ] ) < 0 ) {
                merged[ mergePos ] = arr[ leftPos ];
                ++leftPos;
            } else {
                merged[ mergePos ] = arr[ rightPos ];
                ++rightPos;
            }
            ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged list
        while ( leftPos <= middle ) {
            merged[ mergePos ] = arr[ leftPos ];
            ++leftPos;
            ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged list
        while ( rightPos <= high ) {
            merged[ mergePos ] = arr[ rightPos ];
            ++rightPos;
            ++mergePos;
        }

        // Copy merge item back to original
        for ( mergePos = 0; mergePos < mergedSize; ++mergePos ) {
            arr[ low + mergePos ] = merged[ mergePos ];
        }
    }

    public void mergeSort( Comparable[] arr, int low, int high )
    {
        int midpoint;

        if ( high - low <= baseLen ) {
            if ( inDebug ) {
                System.out.print( "|||||| SORT HALF ||||||" );
                for ( int currentPos = low; currentPos <= high; currentPos++ ) {
                    if ( currentPos == low && currentPos == high ) {
                        System.out.printf( " { %s }", arr[ currentPos ] );
                    } else if ( currentPos == low ) {
                        System.out.printf( " { %s", arr[ currentPos ] );
                    } else if ( currentPos == high ) {
                        System.out.printf( " %s }", arr[ currentPos ] );
                    } else {
                        System.out.printf( " %s", arr[ currentPos ] );
                    }
                }
                System.out.println();
            }
            Proj01_SelectionSort selectionSort = new Proj01_SelectionSort( inDebug );
            selectionSort.setRange( low, high );
            selectionSort.sort( arr );
            return;
        }

        if ( low < high ) {
            midpoint = ( low + high ) / 2;

            if ( inDebug ) {
                System.out.print( "|||||| MIDPOINT ||||||" );
                System.out.printf( " %s\n", arr[ midpoint ] );
                System.out.print( "|||||| SPLIT ||||||" );
                for ( int currentPos = low; currentPos <= high; currentPos++ ) {
                    if ( currentPos == midpoint && currentPos == low ) {
                        System.out.printf( " { %s }", arr[ currentPos ] );
                    } else if ( currentPos == low ) {
                        System.out.printf( " { %s", arr[ currentPos ] );
                    } else if ( currentPos == midpoint ) {
                        System.out.printf( " %s }", arr[ currentPos ] );
                    } else if ( currentPos == midpoint + 1 ) {
                        System.out.printf( " { %s", arr[ currentPos ] );
                    } else if ( currentPos == high ) {
                        System.out.printf( " %s }", arr[ currentPos ] );
                    } else {
                        System.out.printf( " %s", arr[ currentPos ] );
                    }
                }
                System.out.println();
            }

            // Recursively sort left and right partitions
            mergeSort( arr, low, midpoint );
            mergeSort( arr, midpoint + 1, high );

            // Merge left and right partition in sorted order
            merge( arr, low, midpoint, high );
        }
    }

    private void printDebugStatement( Comparable[] arr )
    {
        for ( Comparable currentValue : arr ) {
            System.out.printf( " %s", currentValue );
        }
        System.out.println();
    }
}
