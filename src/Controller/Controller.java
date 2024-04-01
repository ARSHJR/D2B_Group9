package Controller;
import Model.Model;
import View.View;

import java.awt.event.*;
import java.io.IOException;

public class Controller {
    Model model;
    View view;

    final private String artists_filepath = "C:\\Users\\Aarush\\Downloads\\My 10\\exp10_11\\src\\Model\\Artists\\Artists.json";
    final private String songs_filepath = "C:\\Users\\Aarush\\Downloads\\My 10\\exp10_11\\src\\Model\\Songs\\Songs.json";
    final private String copyrights_filepath = "C:\\Users\\Aarush\\Downloads\\My 10\\exp10_11\\src\\Model\\Copyrights\\Copyrights.json";

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.getFf().getCreditsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getCf().setVisible(true);
            }
        });

        view.getCf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.getFf().setVisible(true);
            }
        });

        view.getFf().getManageArtistsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Artists button clicked");
                view.getFf().setVisible(false);
                view.getMA_f().setVisible(true);
            }
        });

        view.getMA_f().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.getFf().setVisible(true);
            }
        });

        model.getMa().setLinesBeingDisplayed(10);
        view.centerInitialSetupArtists(model.getMa().getLinesBeingDisplayed(), model.getMa().getHeaders().size());

        model.getMa().setFirstLineToDisplay(0);
        view.centerUpdateArtists(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());

        view.getMA_f().getArtists_ip().getAtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMa().getFirstLineToDisplay();
                int current_last_line = model.getMa().getLastLineToDisplay();
                int no_of_artists = model.getMa().getTable().size();
                int no_of_display_lines = model.getMa().getLinesBeingDisplayed();

                if(units <= 0 && current_first_line == 0) {
                    model.getMa().setFirstLineToDisplay(0);
                }
                else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0) {
                        model.getMa().setFirstLineToDisplay(0);
                    }
                    else {
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if ( units > 0 && current_last_line == no_of_artists - 1) {
                    model.getMa().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_artists - 1) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_artists - no_of_display_lines) {
                        new_first_line = no_of_artists - no_of_display_lines;
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                    else {
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.centerUpdateArtists(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());
            }
        });

        view.getMA_f().getArtists_ip().getAap().getAddArtistbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int txt_A_id = Integer.valueOf(view.getMA_f().getArtists_ip().getAap().getTxt_A_id().getText());
                String txt_f_name = view.getMA_f().getArtists_ip().getAap().getTxt_A_f_name().getText();
                String txt_l_name = view.getMA_f().getArtists_ip().getAap().getTxt_A_l_name().getText();
                String email = view.getMA_f().getArtists_ip().getAap().getEmail().getText();
                int networth = Integer.valueOf(view.getMA_f().getArtists_ip().getAap().getNetworth().getText());
                String genre = view.getMA_f().getArtists_ip().getAap().getGenre().getText();
                String label = view.getMA_f().getArtists_ip().getAap().getLabel().getText();

                model.getMa().addNewArtists(txt_A_id, txt_f_name, txt_l_name, email, networth, genre, label);

                view.centerUpdateArtists(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());
            }
        });

        view.getMA_f().getArtists_ip().getEap().getGetArtistBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Artist's details clicked");
                String txt_artist_id = view.getMA_f().getArtists_ip().getEap().getTxt_get_artist_idx().getText();
                model.getMa().readArtistsJSON_File(artists_filepath);
                int a_id = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getA_id();
                String a_f_name = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getF_name();
                String a_l_name = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getL_name();
                String email = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getEmail();
                int networth = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getNetWorth();
                String genre = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getA_Genre();
                String label = model.getMa().getTable().get(Integer.valueOf(txt_artist_id)).getA_Label();

                view.getMA_f().getArtists_ip().getEap().getTxt_A_id().setText(String.valueOf(a_id));
                view.getMA_f().getArtists_ip().getEap().getTxt_f_name().setText(a_f_name);
                view.getMA_f().getArtists_ip().getEap().getTxt_l_name().setText(a_l_name);
                view.getMA_f().getArtists_ip().getEap().getEmail().setText(email);
                view.getMA_f().getArtists_ip().getEap().getNetworth().setText(String.valueOf(networth));
                view.getMA_f().getArtists_ip().getEap().getGenre().setText(genre);
                view.getMA_f().getArtists_ip().getEap().getLabel().setText(label);
            }
        });

        view.getMA_f().getArtists_ip().getEap().getEditArtistBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Artists button clicked");
                String txt_artist_idx = view.getMA_f().getArtists_ip().getEap().getTxt_get_artist_idx().getText();
                int txt_A_id = Integer.valueOf(view.getMA_f().getArtists_ip().getEap().getTxt_A_id().getText());
                String txt_A_f_name = view.getMA_f().getArtists_ip().getEap().getTxt_f_name().getText();
                String txt_A_l_name = view.getMA_f().getArtists_ip().getEap().getTxt_l_name().getText();
                String email = view.getMA_f().getArtists_ip().getEap().getEmail().getText();
                int networth = Integer.valueOf(view.getMA_f().getArtists_ip().getEap().getNetworth().getText());
                String genre = view.getMA_f().getArtists_ip().getEap().getGenre().getText();
                String label = view.getMA_f().getArtists_ip().getEap().getLabel().getText();

                model.getMa().editArtists(Integer.valueOf(txt_artist_idx), txt_A_id, txt_A_f_name, txt_A_l_name, email, networth, genre, label);

                view.centerUpdateArtists(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());
            }
        });

        view.getMA_f().getArtists_ip().getDap().getDeleteArtistBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete artist button clicked");
                String txt_artist_idx = view.getMA_f().getArtists_ip().getDap().getTxt_del_artist_id().getText();
                try {
                    int t_id = model.getMa().deleteArtists(Integer.valueOf(txt_artist_idx));
                    for (int i = 0; i < model.getMc().getTable().size(); i++) {
                        if(t_id == model.getMc().getTable().get(i).get_artist_id()) {
                            model.getMc().deleteCopyright(i);
                        }
                    }
                    view.centerUpdateArtists(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException();
                }
            }
        });

        //Songs

        view.getFf().getManageSongsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Manage Songs button clicked");
                view.getFf().setVisible(false);
                view.getMS_f().setVisible(true);
            }
        });

        view.getMS_f().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMs().setLinesBeingDisplayed(10);
        view.centerInitialSetupSongs(model.getMs().getLinesBeingDisplayed(), model.getMs().getHeaders().size());

        model.getMs().setFirstLineToDisplay(0);
        view.centerUpdateSong(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());

        view.getMS_f().getSongIp().getStp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs().getFirstLineToDisplay();
                int current_last_line = model.getMs().getLastLineToDisplay();
                int no_of_artists = model.getMs().getTable().size();
                int no_of_display_lines = model.getMs().getLinesBeingDisplayed();

                if(units <= 0 && current_first_line == 0) {
                    model.getMs().setFirstLineToDisplay(0);
                }
                else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0) {
                        model.getMs().setFirstLineToDisplay(0);
                    }
                    else {
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if ( units > 0 && current_last_line == no_of_artists - 1) {
                    model.getMs().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_artists - 1) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_artists - no_of_display_lines) {
                        new_first_line = no_of_artists - no_of_display_lines;
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                    else {
                        model.getMs().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.centerUpdateSong(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());
            }
        });

        view.getMS_f().getSongIp().getAps().getAddSongBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int txt_s_id = Integer.valueOf(view.getMS_f().getSongIp().getAps().getTxt_song_id().getText());
                String txt_language = view.getMS_f().getSongIp().getAps().getTxt_language().getText();
                String txt_s_name = view.getMS_f().getSongIp().getAps().getTxt_song_name().getText();
                double txt_s_duration = Double.valueOf(view.getMS_f().getSongIp().getAps().getTxt_song_duration().getText());
                double txt_media_rating = Double.valueOf(view.getMS_f().getSongIp().getAps().getTxt_media_rating().getText());
                String txt_media_date = view.getMS_f().getSongIp().getAps().getTxt_media_date().getText();

                try {
                    model.getMs().addNewSong(txt_s_id, txt_language, txt_s_name, txt_s_duration, txt_media_rating, txt_media_date);
                    view.centerUpdateSong(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException();
                }
            }
        });

        view.getMS_f().getSongIp().getEsp().getGetAddSongBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Song button clicked");
                String txt_song_id = view.getMS_f().getSongIp().getEsp().getTxt_get_song_idx().getText();
                model.getMs().readSongsJsonFile(songs_filepath);
                int s_id = model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getSong_id();
                String language = model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getMedia_Lang();
                String s_name = model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getSong_name();
                Double duration = Double.valueOf(model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getSong_duration());
                Double rating = Double.valueOf(model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getMedia_Rating());
                String date = model.getMs().getTable().get(Integer.valueOf(txt_song_id)).getMedia_Date();

                view.getMS_f().getSongIp().getEsp().getTxt_s_id().setText(String.valueOf(s_id));
                view.getMS_f().getSongIp().getEsp().getTxt_language().setText(language);
                view.getMS_f().getSongIp().getEsp().getTxt_s_name().setText(s_name);
                view.getMS_f().getSongIp().getEsp().getTxt_s_duration().setText(String.valueOf(duration));
                view.getMS_f().getSongIp().getEsp().getTxt_media_rating().setText(String.valueOf(rating));
                view.getMS_f().getSongIp().getEsp().getTxt_media_date().setText(date);
            }
        });

        view.getMS_f().getSongIp().getEsp().getEditSongBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Song button clicked");
                String txt_song_idx = view.getMS_f().getSongIp().getEsp().getTxt_get_song_idx().getText();
                String txt_song_id = view.getMS_f().getSongIp().getEsp().getTxt_s_id().getText();
                String txt_language = view.getMS_f().getSongIp().getEsp().getTxt_language().getText();
                String txt_s_name = view.getMS_f().getSongIp().getEsp().getTxt_s_name().getText();
                String txt_duration = view.getMS_f().getSongIp().getEsp().getTxt_s_duration().getText();
                String txt_rating = view.getMS_f().getSongIp().getEsp().getTxt_media_rating().getText();
                String txt_date = view.getMS_f().getSongIp().getEsp().getTxt_media_date().getText();

                try {
                    model.getMs().editSong(Integer.valueOf(txt_song_idx), Integer.valueOf(txt_song_id), txt_language, txt_s_name, Double.valueOf(txt_duration), Double.valueOf(txt_rating), txt_date);
                    view.centerUpdateSong(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMS_f().getSongIp().getDsp().getDeleteSongBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Song button clicked");
                String txt_song_idx = view.getMS_f().getSongIp().getDsp().getTxt_del_s_id().getText();
                try {
                    int t_id = model.getMs().deleteSong(Integer.valueOf(txt_song_idx));
                    for(int i = 0; i < model.getMc().getTable().size(); i++) {
                        if(t_id == model.getMc().getTable().get(i).get_song_id()) {
                            model.getMc().deleteCopyright(i);
                        }
                    }
                    view.centerUpdateSong(model.getMs().getLines(model.getMs().getFirstLineToDisplay(), model.getMs().getLastLineToDisplay()), model.getMs().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException();
                }
            }
        });

        //Copyrights:

        view.getFf().getManageCopyrightsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Copyright button clicked");
                view.getFf().setVisible(false);
                view.getMC_f().setVisible(true);
            }
        });

        view.getMC_f().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMc().setLinesBeingDisplayed(10);
        view.centerInitialSetupCopyright(model.getMc().getLinesBeingDisplayed(), model.getMc().getHeaders().size());

        model.getMc().setFirstLineToDisplay(0);
        view.centerUpdateCopyright(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());

        view.getMC_f().getIc().getCtp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMc().getFirstLineToDisplay();
                int current_last_line = model.getMc().getLastLineToDisplay();
                int no_of_artists = model.getMc().getTable().size();
                int no_of_display_lines = model.getMc().getLinesBeingDisplayed();

                if(units <= 0 && current_first_line == 0) {
                    model.getMc().setFirstLineToDisplay(0);
                }
                else if (units <= 0 && current_first_line > 0) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0) {
                        model.getMc().setFirstLineToDisplay(0);
                    }
                    else {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if ( units > 0 && current_last_line == no_of_artists - 1) {
                    model.getMc().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_artists - 1) {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_artists - no_of_display_lines) {
                        new_first_line = no_of_artists - no_of_display_lines;
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                    else {
                        model.getMc().setFirstLineToDisplay(new_first_line);
                    }
                }
                view.centerUpdateCopyright(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
            }
        });

        view.getMC_f().getIc().getApc().getAddCopyrightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_c_id = view.getMC_f().getIc().getApc().getTxt_c_id().getText();
                String txt_s_id = view.getMC_f().getIc().getApc().getTxt_s_id().getText();
                String txt_a_id = view.getMC_f().getIc().getApc().getTxt_a_id().getText();
                String txt_label = view.getMC_f().getIc().getApc().getTxt_record_lable().getText();
                try {
                    model.getMc().addNewCopyright(Integer.valueOf(txt_c_id), Integer.valueOf(txt_s_id), Integer.valueOf(txt_a_id), txt_label);
                    view.centerUpdateCopyright(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMC_f().getIc().getEcp().getGetCopyrightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Copyright button clicked");
                String txt_c_idx = view.getMC_f().getIc().getEcp().getTxt_get_c_idx().getText();
                model.getMc().readCopyrightsJSONfile(copyrights_filepath);
                int c_id = model.getMc().getTable().get(Integer.valueOf(txt_c_idx)).getCopyright_id();
                int s_id = model.getMc().getTable().get(Integer.valueOf(txt_c_idx)).get_song_id();
                int a_id = model.getMc().getTable().get(Integer.valueOf(txt_c_idx)).get_artist_id();
                String label = model.getMc().getTable().get(Integer.valueOf(txt_c_idx)).getRecord_lable();

                view.getMC_f().getIc().getEcp().getTxt_copyright_id().setText(String.valueOf(c_id));
                view.getMC_f().getIc().getEcp().getTxt_song_id().setText(String.valueOf(s_id));
                view.getMC_f().getIc().getEcp().getTxt_artist_id().setText(String.valueOf(a_id));
                view.getMC_f().getIc().getEcp().getTxt_record_lable().setText(label);
            }
        });

        view.getMC_f().getIc().getEcp().getEditCopyrightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Copyright button clicked");
                String txt_c_idx = view.getMC_f().getIc().getEcp().getTxt_get_c_idx().getText();
                String txt_c_id = view.getMC_f().getIc().getEcp().getTxt_copyright_id().getText();
                String txt_s_id = view.getMC_f().getIc().getEcp().getTxt_song_id().getText();
                String txt_a_id = view.getMC_f().getIc().getEcp().getTxt_artist_id().getText();
                String txt_label = view.getMC_f().getIc().getEcp().getTxt_record_lable().getText();

                try {
                    model.getMc().editCopyright(Integer.valueOf(txt_c_idx), Integer.valueOf(txt_c_id), Integer.valueOf(txt_s_id), Integer.valueOf(txt_a_id), txt_label);
                    view.centerUpdateCopyright(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMC_f().getIc().getDcp().getDeleteCopyrightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Copyright button clicked");
                String txt_c_idx = view.getMC_f().getIc().getDcp().getTxt_del_c_id().getText();
                try {
                    model.getMc().deleteCopyright(Integer.valueOf(txt_c_idx));
                    view.centerUpdateCopyright(model.getMc().getLines(model.getMc().getFirstLineToDisplay(), model.getMc().getLastLineToDisplay()), model.getMc().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException();
                }
            }
        });
    }
}