package debug;

import mpi.MPI;
import mpi.MPIException;

public class SystemPropertiesTest {

    public static void main(String[] args) throws MPIException {

        if (args.length > 0 ) {
            System.out.println("Calling mpi init");
            MPI.Init(args);
        }

        String filename = null;
        var property = System.getProperty(
                "java.net.ftp.imagepath."+filename);
        System.out.println(property);

        filename = "tar";
        property = System.getProperty(
                "java.net.ftp.imagepath."+filename);
        System.out.println(property);

        if (args.length > 0 ) {
            System.out.println("Calling mpi finalize");
            MPI.Finalize();
        }
    }
}
