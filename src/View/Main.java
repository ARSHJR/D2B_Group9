package View;

import Controller.Controller;
import Model.Artists.Artists;
import Model.Artists.ManageArtists;
import Model.Copyrights.*;
import Model.Model;
import Model.Songs.ManageSongs;
import Model.Songs.Songs;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}