package debug;

import mpi.MPI;
import mpi.MPIException;

public class StringBuilderTest {

    public static void main(String[] args) throws MPIException {

        if (args.length > 0) {
            System.out.println("received some command line arg. Calling MPI.Init");
            MPI.Init(args);
            var rank = MPI.COMM_WORLD.getRank();
            System.out.println("MPI-Rank is: " + rank);
        } else {
            System.out.println("running without MPI.");
        }

        var builder = new StringBuilder();

        for (int i = 0; i < 1000; i++ ) {

            builder.append(i);
        }

        System.out.println(builder);

        if (args.length > 0) {
            System.out.println("Calling MPI.Finalize");
            MPI.Finalize();
        }
    }
}
