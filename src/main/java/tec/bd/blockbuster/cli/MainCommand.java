package tec.bd.blockbuster.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bd.blockbuster.cli.movie.*;

@Command(
        name = "BlockbusterAPP",
        subcommands = {
                GetMoviesCommand.class,
                GetByTitleCommand.class,
                CreateMovieCommand.class,
                DeleteMovieCommand.class,
                UpdateMovieCommand.class,
                HelpCommand.class
        },
        description = "Manage Movies and Customers")
public class MainCommand implements Runnable {

    @Override
    public void run() {

    }
}