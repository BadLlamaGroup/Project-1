public class Proj01_QuickSort implements Proj01_Sort
{
    private boolean inDebug;
    private int baseLen;
    private int mode;

    public Proj01_QuickSort( boolean debug, int mode, int baseLen )
    {
        inDebug = debug;
        this.baseLen = baseLen;
        this.mode = mode;
    }

    @Override
    public void sort( Comparable[] arr )
    {
        if ( inDebug ) {
            System.out.print( "|||||| BEGIN QUICK SORT ||||||" );
            printDebugStatement( -1, arr );
        }

        sortSmaller( arr, 0, arr.length - 1 );

        if ( inDebug ) {
            System.out.print( "|||||| END QUICK SORT ||||||" );
            printDebugStatement( -1, arr );
        }
    }

    public void sortSmaller( Comparable[] arr, int low, int high )
    {
        int j;

        if ( high - low <= baseLen ) {
            if ( inDebug ) {
                System.out.print( "|||||| SORT PARTITION ||||||" );
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

        j = partition( arr, low, high );

        if ( inDebug ) {
            System.out.print( "|||||| AFTER PARTITION ||||||" );
            for ( int currentPos = low; currentPos <= high; currentPos++ ) {
                if ( currentPos == j && currentPos == low ) {
                    System.out.printf( " { %s }", arr[ currentPos ] );
                } else if ( currentPos == low ) {
                    System.out.printf( " { %s", arr[ currentPos ] );
                } else if ( currentPos == j ) {
                    System.out.printf( " %s }", arr[ currentPos ] );
                } else if ( currentPos == j + 1 ) {
                    System.out.printf( " { %s", arr[ currentPos ] );
                } else if ( currentPos == high ) {
                    System.out.printf( " %s }", arr[ currentPos ] );
                } else {
                    System.out.printf( " %s", arr[ currentPos ] );
                }
            }
            System.out.println();
        }

        sortSmaller( arr, low, j );
        sortSmaller( arr, j + 1, high );
    }

    public int partition( Comparable[] arr, int low, int high )
    {
        int midpoint;
        Comparable pivot;

        switch ( mode ) {
            case 0:
                midpoint = low;
                pivot = arr[ midpoint ];
                break;
            case 1:
                midpoint = low + ( high - low ) / 2;
                pivot = arr[ midpoint ];
                break;
            case 2:
                int middle = ( low + high ) / 2;
                if ( arr[ middle ].compareTo( arr[ low ] ) < 0 )
                    swapValues( arr, low, middle );
                if ( arr[ high ].compareTo( arr[ low ] ) < 0 )
                    swapValues( arr, low, high );
                if ( arr[ high ].compareTo( arr[ middle ] ) < 0 )
                    swapValues( arr, middle, high );

                swapValues( arr, middle, high - 1 );
                midpoint = high - 1;
                pivot = arr[ high - 1 ];
                break;
            default:
                midpoint = low + ( high - low ) / 2;
                pivot = arr[ midpoint ];
        }

        Comparable temp;
        boolean done = false;

        if ( inDebug ) {
            System.out.printf( "|||||| PIVOT ||||||" );
            printDebugStatement( midpoint, arr );
        }

        while ( !done ) {
            while ( arr[ low ].compareTo( pivot ) < 0 ) {
                ++low;
            }
            while ( pivot.compareTo( arr[ high ] ) < 0 ) {
                --high;
            }
            if ( low >= high ) {
                done = true;
            } else {
                temp = arr[ low ];
                arr[ low ] = arr[ high ];
                arr[ high ] = temp;
                ++low;
                --high;
            }
        }
        return high;
    }

    private void swapValues( Comparable[] a, int index1, int index2 )
    {
        Comparable tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    private void printDebugStatement( int key, Comparable[] arr )
    {
        for ( int currentPos = 0; currentPos < arr.length; currentPos++ ) {
            if ( currentPos == key ) {
                System.out.printf( " [ %s ]", arr[ currentPos ] );
            } else {
                System.out.printf( " %s", arr[ currentPos ] );
            }
        }
        System.out.println();
    }
}
