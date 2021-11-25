package tec.bd.blockbuster;

import picocli.CommandLine;
import tec.bd.blockbuster.cli.MainCommand;

public class Main {

    public static void main(String... args) {


        CommandLine cmd = new CommandLine(new MainCommand());
        cmd.setExecutionStrategy(new CommandLine.RunAll()); // default is RunLast
        cmd.execute(args);

        if (args.length == 0) { cmd.usage(System.out); }

//        System.out.println("Blockbuster");
//
//        ApplicationContext appContext = new ApplicationContext();
//        Blockbuster blockbuster = appContext.getBlockbuster();
//        List<Movie> movies = blockbuster.getAllMovies();
//        System.out.println("Codigo \t\t Titulo");
//        for(Movie m : movies) {
//            System.out.println(m.getMovieId() +"\t\t" + m.getTitle());
//        }

    }

}
