package debug;

import mpi.MPI;
import mpi.MPIException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUrlTest {

    public static void main(String[] args) throws MPIException, IOException {

        System.out.println("Calling mpi init");
        MPI.Init(args);

        System.out.println("Creating url from " + args[0]);
        var fileUrl = new URL(args[0]);
        System.out.println("Url is: " + fileUrl);
        System.out.println("opening connection.");
        var connection = fileUrl.openConnection();
        System.out.println("getting last modified");
        var lastModified = connection.getLastModified();
        System.out.println("last modified: " + lastModified);
        System.out.println("opening stream");
        var stream = connection.getInputStream();

        stream.close();
        System.out.println("Calling mpi finalize");
       MPI.Finalize();
    }
}
