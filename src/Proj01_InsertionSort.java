public class Proj01_InsertionSort implements Proj01_Sort
{
    private boolean inDebug;

    public Proj01_InsertionSort( boolean debug )
    {
        inDebug = debug;
    }

    @Override
    public void sort( Comparable[] arr )
    {
        if ( inDebug ) {
            System.out.print( "|||||| BEGIN INSERTION SORT ||||||" );
            printDebugStatement( -1, arr );
        }

        int amtItems = arr.length;
        for ( int pos = 1; pos < amtItems; ++pos ) {
            int key = pos;

            if ( inDebug ) {
                System.out.print( "|||||| CURRENT STATE ||||||" );
                for ( int currentPos = 0; currentPos < arr.length; currentPos++ ) {
                    if ( currentPos == key ) {
                        System.out.print( " . " );
                    }

                    System.out.printf( " %s", arr[ currentPos ] );
                }
                System.out.println();
            }

            while ( key > 0 && arr[ key ].compareTo( arr[ key - 1 ] ) < 0 ) {
                if ( inDebug ) {
                    System.out.print( "|||||| COMPARING ||||||" );
                    printDebugStatement( key, arr );
                }
                Comparable temp = arr[ key ];
                arr[ key ] = arr[ key - 1 ];
                arr[ key - 1 ] = temp;

                --key;
            }

            if( inDebug ) {
                System.out.print( "|||||| AFTER INSERT ||||||" );
                for ( int currentPos = 0; currentPos < arr.length; currentPos++ ) {
                    if ( currentPos == key ) {
                        System.out.printf( " [ %s ]", arr[ currentPos ] );
                    } else {
                        System.out.printf( " %s", arr[ currentPos ] );
                    }
                    if ( currentPos == pos ) {
                        System.out.print( " . " );
                    }
                }
                System.out.println();
            }
        }
        if ( inDebug ) {
            System.out.print( "|||||| END INSERTION SORT ||||||" );
            printDebugStatement( -1, arr );
        }
    }

    public void printDebugStatement( int key, Comparable[] arr )
    {
        for ( int currentPos = 0; currentPos < arr.length; currentPos++ ) {
            if ( currentPos == key - 1 ) {
                System.out.printf( " ***** [ %s ]", arr[ currentPos ] );
            } else if ( currentPos == key ) {
                System.out.printf( " [ %s ] ***** ", arr[ currentPos ] );
            } else {
                System.out.printf( " %s", arr[ currentPos ] );
            }
        }
        System.out.println();
    }
}