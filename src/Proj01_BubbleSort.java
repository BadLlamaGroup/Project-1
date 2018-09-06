public class Proj01_BubbleSort implements Proj01_Sort
{
    private boolean inDebug;

    public Proj01_BubbleSort( boolean debug )
    {
        inDebug = debug;
    }

    @Override
    public void sort( Comparable[] arr )
    {
        if ( inDebug ) {
            System.out.print( "|||||| BEGIN BUBBLE SORT ||||||" );
            printDebugStatement( -1, arr );
        }

        int amtItems = arr.length;
        for ( int outer = 0; outer < amtItems - 1; outer++ ) {
            for ( int inner = 0; inner < amtItems - outer - 1; inner++ ) {
                if ( arr[ inner ].compareTo( arr[ inner + 1 ] ) > 0 ) {
                    if ( inDebug ) {
                        System.out.print( "|||||| PRE-SWAP ||||||" );
                        printDebugStatement( inner, arr );
                    }
                    Comparable temp = arr[ inner ];
                    arr[ inner ] = arr[ inner + 1 ];
                    arr[ inner + 1 ] = temp;

                    if ( inDebug ) {
                        System.out.print( "|||||| POST-SWAP ||||||" );
                        printDebugStatement( inner, arr );
                    }
                } else {
                    if ( inDebug ) {
                        System.out.print( "|||||| NO-SWAP ||||||" );
                        printDebugStatement( inner, arr );
                    }
                }
            }
        }

        if ( inDebug ) {
            System.out.print( "|||||| END BUBBLE SORT ||||||" );
            printDebugStatement( -1, arr );
        }
    }

    public void printDebugStatement( int key, Comparable[] arr )
    {
        for ( int currentPos = 0; currentPos < arr.length; currentPos++ ) {
            if ( currentPos == key ) {
                System.out.printf( " ***** [ %s ]", arr[ currentPos ] );
                System.out.printf( " [ %s ] ***** ", arr[ currentPos + 1 ] );
            } else {
                System.out.printf( " %s", arr[ currentPos ] );
            }
        }
        System.out.println();
    }
}