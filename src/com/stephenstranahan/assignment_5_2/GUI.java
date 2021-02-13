package com.stephenstranahan.assignment_5_2;


import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class GUI implements Runnable {
    private JEditorPane returnArea;

    private JButton search;
    private JButton save;
    private JButton close;
    private JLabel titleLabel;
    private JLabel TitleLabel;
    private JPanel p1;
    private JPanel p3;
    private JPanel p4;
    private JTextField enterSearchTitleHereTextField;
    private JPanel mainPanel;
    private JScrollPane scroll;
    private JButton next;
    private JButton previous;

    private String str;
    private String str2;
    private String line;


    private int offset = 0;


    public GUI() {


        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(0);
            }
        });

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String title = null;
                String urlStr = null;

                if (!enterSearchTitleHereTextField.getText().equals("")) {
                    title = enterSearchTitleHereTextField.getText();

                    urlStr = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=" + title + "&api-key=jjLhMLHHp43pEGBw0HaJEqcehYpMiiCA";

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    URL myUrl = null;
                    try {
                        myUrl = new URL(urlStr);
                    } catch (MalformedURLException malformedURLException) {
                        malformedURLException.printStackTrace();
                    }

                    URLConnection myUrlConnection = null;
                    try {
                        myUrlConnection = myUrl.openConnection();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStream myInputStream = null;
                    try {
                        myInputStream = myUrlConnection.getInputStream();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStreamReader myInputStreamReader;
                    myInputStreamReader = new InputStreamReader(myInputStream, StandardCharsets.UTF_8);

                    BufferedReader in = new BufferedReader(myInputStreamReader);

                    try {
                        str2 = readJSON(line, in, str);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    JSONObject returnJSON;
                    returnJSON = new JSONObject(str2.substring(4));

                    int numRes = returnJSON.getInt("num_results");

                    if (returnJSON.getInt("num_results") == 0)
                        returnArea.setText("No results found");

                    JSONArray resArr = returnJSON.getJSONArray("results");

                    String[] titleArr = new String[numRes];
                    String[] ratingArr = new String[numRes];
                    String[] bylineArr = new String[numRes];
                    String[] headlineArr = new String[numRes];
                    String[] summArr = new String[numRes];
                    String[] pubDateArr = new String[numRes];
                    String[] openDateArr = new String[numRes];
                    JSONObject[] linkArr = new JSONObject[numRes];
                    String[] linkURLArr = new String[numRes];
                    String[] linkDispArr = new String[numRes];
                    JSONObject[] imgArr = new JSONObject[numRes];
                    String[] imgURLArr = new String[numRes];


                    JSONObject[] objArr = new JSONObject[resArr.length()];

                    for (int i = 0; i < resArr.length(); i++) {
                        objArr[i] = resArr.getJSONObject(i);
                        titleArr[i] = objArr[i].getString("display_title");
                        ratingArr[i] = objArr[i].getString("mpaa_rating");
                        bylineArr[i] = objArr[i].getString("byline");
                        headlineArr[i] = objArr[i].getString("headline");
                        pubDateArr[i] = objArr[i].getString("publication_date");
                        if (!objArr[i].get("opening_date").equals(null)) {
                            openDateArr[i] = objArr[i].getString("opening_date");
                        } else {
                            openDateArr[i] = " ";
                        }
                        if (!objArr[i].get("summary_short").equals(null)) {
                            summArr[i] = objArr[i].getString("summary_short");
                        } else {
                            summArr[i] = " ";
                        }
                        linkArr[i] = objArr[i].getJSONObject("link");
                        linkURLArr[i] = linkArr[i].getString("url");
                        linkDispArr[i] = linkArr[i].getString("suggested_link_text");
                    }

                    String returnStr = "";


                    returnStr += "\n\n\tYOU SEARCHED:\t" + enterSearchTitleHereTextField.getText() + "\n\n" + "\tNUMBER OF RESULTS:\t" + numRes + "\n\n\n";


                    for (int i = 0; i < numRes; i++) {
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n";
                        returnStr += "\tTitle:\t\t" + titleArr[i] + "\n";
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n";
                        returnStr += "\tRating:\t\t" + ratingArr[i] + "\n\n";
                        returnStr += "\tReview by:\t\t" + bylineArr[i] + "\n\n";
                        returnStr += "\tReview Title:\t\t" + headlineArr[i] + "\n\n";
                        returnStr += "\tReview Published Date:\t" + pubDateArr[i] + "\n\n";
                        returnStr += "\tFilm Opening Date:\t" + openDateArr[i] + "\n\n";
                        returnStr += "\tURL of review:\t\t" + linkURLArr[i] + "\n";
                        returnStr += "\n";
                    }

                    returnArea.setText(returnStr);
                    scroll.setWheelScrollingEnabled(true);
                    returnArea.setCaretPosition(0);

                } else {
                    returnArea.setText("Error: you must enter a movie title to search.");
                }
            }

//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//
//                String title = null;
//                String urlStr = null;
//
//                if (!enterSearchTitleHereTextField.getText().equals("")) {
//                    title = enterSearchTitleHereTextField.getText();
//
//                    urlStr = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=" + title + "&api-key=jjLhMLHHp43pEGBw0HaJEqcehYpMiiCA";
//
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//                    URL myUrl = null;
//                    try {
//                        myUrl = new URL(urlStr);
//                    } catch (MalformedURLException malformedURLException) {
//                        malformedURLException.printStackTrace();
//                    }
//
//                    URLConnection myUrlConnection = null;
//                    try {
//                        myUrlConnection = myUrl.openConnection();
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                    InputStream myInputStream = null;
//                    try {
//                        myInputStream = myUrlConnection.getInputStream();
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                    InputStreamReader myInputStreamReader;
//                    myInputStreamReader = new InputStreamReader(myInputStream);
//
//                    BufferedReader in = new BufferedReader(myInputStreamReader);
//
//                    try {
//                        str2 = readJSON(line, in, str);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                    JSONObject returnJSON;
//                    returnJSON = new JSONObject(str2.substring(4));
//
//                    int numRes = returnJSON.getInt("num_results");
//
//                    if (returnJSON.getInt("num_results") == 0)
//                        returnArea.setText("No results found");
//
//                    JSONArray resArr = returnJSON.getJSONArray("results");
//
//                    String[] titleArr = new String[numRes];
//                    String[] ratingArr = new String[numRes];
//                    String[] bylineArr = new String[numRes];
//                    String[] headlineArr = new String[numRes];
//                    String[] summArr = new String[numRes];
//                    String[] pubDateArr = new String[numRes];
//                    String[] openDateArr = new String[numRes];
//                    JSONObject[] linkArr = new JSONObject[numRes];
//                    String[] linkURLArr = new String[numRes];
//                    String[] linkDispArr = new String[numRes];
//                    JSONObject[] imgArr = new JSONObject[numRes];
//                    String[] imgURLArr = new String[numRes];
//
//
//                    JSONObject[] objArr = new JSONObject[resArr.length()];
//
//                    for (int i = 0; i < resArr.length(); i++) {
//                        objArr[i] = resArr.getJSONObject(i);
//                        titleArr[i] = objArr[i].getString("display_title");
//                        ratingArr[i] = objArr[i].getString("mpaa_rating");
//                        bylineArr[i] = objArr[i].getString("byline");
//                        headlineArr[i] = objArr[i].getString("headline");
//                        pubDateArr[i] = objArr[i].getString("publication_date");
//                        if (!objArr[i].get("opening_date").equals(null)) {
//                            openDateArr[i] = objArr[i].getString("opening_date");
//                        } else {
//                            openDateArr[i] = " ";
//                        }
//                        if (!objArr[i].get("summary_short").equals(null)) {
//                            summArr[i] = objArr[i].getString("summary_short");
//                        } else {
//                            summArr[i] = " ";
//                        }
//                        linkArr[i] = objArr[i].getJSONObject("link");
//                        linkURLArr[i] = linkArr[i].getString("url");
//                        linkDispArr[i] = linkArr[i].getString("suggested_link_text");
//                    }
//
//
//                    String returnStr = "";
//
//                    returnStr += "\n\n\tYOU SEARCHED:\t" + enterSearchTitleHereTextField.getText() + "\n\n" + "\tNUMBER OF RESULTS:\t" + numRes + "\n\n\n";
//
//
//                    for (int i = 0; i < numRes; i++) {
//                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n";
//                        returnStr += "\tTitle:\t\t" + titleArr[i] + "\n";
//                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n";
//                        returnStr += "\tRating:\t\t" + ratingArr[i] + "\n\n";
//                        returnStr += "\tReview by:\t\t" + bylineArr[i] + "\n\n";
//                        returnStr += "\tReview Title:\t\t" + headlineArr[i] + "\n\n";
//                        returnStr += "\tReview Published Date:\t" + pubDateArr[i] + "\n\n";
//                        returnStr += "\tFilm Opening Date:\t" + openDateArr[i] + "\n\n";
//                        returnStr += "\tURL of review:\t\t" + linkURLArr[i] + "\n";
//                        returnStr += "\n";
//                    }
//
//
//                    returnArea.setText(returnStr);
//                    scroll.setWheelScrollingEnabled(true);
//                    returnArea.setCaretPosition(0);
//
//                } else {
//                    returnArea.setText("Error: you must enter a movie title to search.");
//                }
//            }
        });
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(save); //parent component to JFileChooser
                if (returnVal == JFileChooser.APPROVE_OPTION) { //OK button pressed by user
                    File file = fc.getSelectedFile(); //get File selected by user
                    BufferedWriter outFile = null;

                    String returnStr = returnArea.getText();

                    try {
                        outFile = new BufferedWriter(new FileWriter(file)); //use its name
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    try {
                        outFile.write(returnStr);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
            }

//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//                final JFileChooser fc = new JFileChooser();
//                int returnVal = fc.showSaveDialog(save); //parent component to JFileChooser
//                if (returnVal == JFileChooser.APPROVE_OPTION) { //OK button pressed by user
//                    File file = fc.getSelectedFile(); //get File selected by user
//                    BufferedWriter outFile = null;
//
//                    try {
//                        outFile = new BufferedWriter(new FileWriter(file)); //use its name
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//
//                    try {
//                        outFile.write(returnStr);
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                }
//            }
        });

        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                offset += 20;


                String title = null;
                String urlStr = null;

                if (!enterSearchTitleHereTextField.getText().equals("")) {
                    title = enterSearchTitleHereTextField.getText();

                    urlStr = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?offset=" + offset + "&query=" + title + "&api-key=jjLhMLHHp43pEGBw0HaJEqcehYpMiiCA";

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    URL myUrl = null;
                    try {
                        myUrl = new URL(urlStr);
                    } catch (MalformedURLException malformedURLException) {
                        malformedURLException.printStackTrace();
                    }

                    URLConnection myUrlConnection = null;
                    try {
                        myUrlConnection = myUrl.openConnection();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStream myInputStream = null;
                    try {
                        myInputStream = myUrlConnection.getInputStream();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStreamReader myInputStreamReader;
                    myInputStreamReader = new InputStreamReader(myInputStream, StandardCharsets.UTF_8);

                    BufferedReader in = new BufferedReader(myInputStreamReader);

                    try {
                        str2 = readJSON(line, in, str);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        next.setEnabled(false);
                    }

                    JSONObject returnJSON;
                    returnJSON = new JSONObject(str2.substring(4));

                    int numRes = returnJSON.getInt("num_results");

                    if (returnJSON.getInt("num_results") == 0)
                        returnArea.setText("No results found");

                    JSONArray resArr = returnJSON.getJSONArray("results");

                    String[] titleArr = new String[numRes];
                    String[] ratingArr = new String[numRes];
                    String[] bylineArr = new String[numRes];
                    String[] headlineArr = new String[numRes];
                    String[] summArr = new String[numRes];
                    String[] pubDateArr = new String[numRes];
                    String[] openDateArr = new String[numRes];
                    JSONObject[] linkArr = new JSONObject[numRes];
                    String[] linkURLArr = new String[numRes];
                    String[] linkDispArr = new String[numRes];
                    JSONObject[] imgArr = new JSONObject[numRes];
                    String[] imgURLArr = new String[numRes];


                    JSONObject[] objArr = new JSONObject[resArr.length()];

                    for (int i = 0; i < resArr.length(); i++) {
                        objArr[i] = resArr.getJSONObject(i);
                        titleArr[i] = objArr[i].getString("display_title");
                        ratingArr[i] = objArr[i].getString("mpaa_rating");
                        bylineArr[i] = objArr[i].getString("byline");
                        headlineArr[i] = objArr[i].getString("headline");
                        pubDateArr[i] = objArr[i].getString("publication_date");
                        if (!objArr[i].get("opening_date").equals(null)) {
                            openDateArr[i] = objArr[i].getString("opening_date");
                        } else {
                            openDateArr[i] = " ";
                        }
                        if (!objArr[i].get("summary_short").equals(null)) {
                            summArr[i] = objArr[i].getString("summary_short");
                        } else {
                            summArr[i] = " ";
                        }
                        linkArr[i] = objArr[i].getJSONObject("link");
                        linkURLArr[i] = linkArr[i].getString("url");
                        linkDispArr[i] = linkArr[i].getString("suggested_link_text");
                    }


                    String returnStr = "";

                    //                   returnStr += "\n\n\tYOU SEARCHED:\t" + enterSearchTitleHereTextField.getText() + "\n\n" + "\tNUMBER OF RESULTS:\t" + numRes + "\n\n\n";


                    for (int i = 0; i < numRes; i++) {
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n";
                        returnStr += "\tTitle:\t\t" + titleArr[i] + "\n";
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n";
                        returnStr += "\tRating:\t\t" + ratingArr[i] + "\n\n";
                        returnStr += "\tReview by:\t\t" + bylineArr[i] + "\n\n";
                        returnStr += "\tReview Title:\t\t" + headlineArr[i] + "\n\n";
                        returnStr += "\tReview Published Date:\t" + pubDateArr[i] + "\n\n";
                        returnStr += "\tFilm Opening Date:\t" + openDateArr[i] + "\n\n";
                        returnStr += "\tURL of review:\t\t" + linkURLArr[i] + "\n";
                        returnStr += "\n";
                    }


                    returnArea.setText(returnStr);
                    scroll.setWheelScrollingEnabled(true);
                    returnArea.setCaretPosition(0);

                } else {
                    returnArea.setText("Error: you must enter a movie title to search.");
                }
                previous.setEnabled(true);
            }

        });

        enterSearchTitleHereTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search.doClick();
                }
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = null;
                String urlStr = null;

                if (!enterSearchTitleHereTextField.getText().equals("")) {
                    title = enterSearchTitleHereTextField.getText();

                    urlStr = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=" + title + "&api-key=jjLhMLHHp43pEGBw0HaJEqcehYpMiiCA";

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    URL myUrl = null;
                    try {
                        myUrl = new URL(urlStr);
                    } catch (MalformedURLException malformedURLException) {
                        malformedURLException.printStackTrace();
                    }

                    URLConnection myUrlConnection = null;
                    try {
                        myUrlConnection = myUrl.openConnection();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStream myInputStream = null;
                    try {
                        myInputStream = myUrlConnection.getInputStream();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStreamReader myInputStreamReader;
                    myInputStreamReader = new InputStreamReader(myInputStream, StandardCharsets.UTF_8);

                    BufferedReader in = new BufferedReader(myInputStreamReader);

                    try {
                        str2 = readJSON(line, in, str);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    JSONObject returnJSON;
                    returnJSON = new JSONObject(str2.substring(4));

                    int numRes = returnJSON.getInt("num_results");

                    if (returnJSON.getInt("num_results") == 0)
                        returnArea.setText("No results found");

                    JSONArray resArr = returnJSON.getJSONArray("results");

                    String[] titleArr = new String[numRes];
                    String[] ratingArr = new String[numRes];
                    String[] bylineArr = new String[numRes];
                    String[] headlineArr = new String[numRes];
                    String[] summArr = new String[numRes];
                    String[] pubDateArr = new String[numRes];
                    String[] openDateArr = new String[numRes];
                    JSONObject[] linkArr = new JSONObject[numRes];
                    String[] linkURLArr = new String[numRes];
                    String[] linkDispArr = new String[numRes];
                    JSONObject[] imgArr = new JSONObject[numRes];
                    String[] imgURLArr = new String[numRes];


                    JSONObject[] objArr = new JSONObject[resArr.length()];

                    for (int i = 0; i < resArr.length(); i++) {
                        objArr[i] = resArr.getJSONObject(i);
                        titleArr[i] = objArr[i].getString("display_title");
                        ratingArr[i] = objArr[i].getString("mpaa_rating");
                        bylineArr[i] = objArr[i].getString("byline");
                        headlineArr[i] = objArr[i].getString("headline");
                        pubDateArr[i] = objArr[i].getString("publication_date");
                        if (!objArr[i].get("opening_date").equals(null)) {
                            openDateArr[i] = objArr[i].getString("opening_date");
                        } else {
                            openDateArr[i] = " ";
                        }
                        if (!objArr[i].get("summary_short").equals(null)) {
                            summArr[i] = objArr[i].getString("summary_short");
                        } else {
                            summArr[i] = " ";
                        }
                        linkArr[i] = objArr[i].getJSONObject("link");
                        linkURLArr[i] = linkArr[i].getString("url");
                        linkDispArr[i] = linkArr[i].getString("suggested_link_text");
                    }

                    String returnStr = "";


                    returnStr += "\n\n\tYOU SEARCHED:\t" + enterSearchTitleHereTextField.getText() + "\n\n" + "\tNUMBER OF RESULTS:\t" + numRes + "\n\n\n";


                    for (int i = 0; i < numRes; i++) {
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n";
                        returnStr += "\tTitle:\t\t" + titleArr[i] + "\n";
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n";
                        returnStr += "\tRating:\t\t" + ratingArr[i] + "\n\n";
                        returnStr += "\tReview by:\t\t" + bylineArr[i] + "\n\n";
                        returnStr += "\tReview Title:\t\t" + headlineArr[i] + "\n\n";
                        returnStr += "\tReview Published Date:\t" + pubDateArr[i] + "\n\n";
                        returnStr += "\tFilm Opening Date:\t" + openDateArr[i] + "\n\n";
                        returnStr += "\tURL of review:\t\t" + linkURLArr[i] + "\n";
                        returnStr += "\n";
                    }

                    returnArea.setText(returnStr);
                    scroll.setWheelScrollingEnabled(true);
                    returnArea.setCaretPosition(0);

                } else {
                    returnArea.setText("Error: you must enter a movie title to search.");
                }
            }
        });
        previous.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                offset -= 20;

                if (offset == 0) {
                    previous.setEnabled(false);
                }

                String title = null;
                String urlStr = null;

                if (!enterSearchTitleHereTextField.getText().equals("")) {
                    title = enterSearchTitleHereTextField.getText();

                    urlStr = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?offset=" + offset + "&query=" + title + "&api-key=jjLhMLHHp43pEGBw0HaJEqcehYpMiiCA";

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    URL myUrl = null;
                    try {
                        myUrl = new URL(urlStr);
                    } catch (MalformedURLException malformedURLException) {
                        malformedURLException.printStackTrace();
                    }

                    URLConnection myUrlConnection = null;
                    try {
                        myUrlConnection = myUrl.openConnection();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStream myInputStream = null;
                    try {
                        myInputStream = myUrlConnection.getInputStream();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    InputStreamReader myInputStreamReader;
                    myInputStreamReader = new InputStreamReader(myInputStream, StandardCharsets.UTF_8);

                    BufferedReader in = new BufferedReader(myInputStreamReader);

                    try {
                        str2 = readJSON(line, in, str);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    JSONObject returnJSON;
                    returnJSON = new JSONObject(str2.substring(4));

                    int numRes = returnJSON.getInt("num_results");

                    if (returnJSON.getInt("num_results") == 0)
                        returnArea.setText("No results found");

                    JSONArray resArr = returnJSON.getJSONArray("results");

                    String[] titleArr = new String[numRes];
                    String[] ratingArr = new String[numRes];
                    String[] bylineArr = new String[numRes];
                    String[] headlineArr = new String[numRes];
                    String[] summArr = new String[numRes];
                    String[] pubDateArr = new String[numRes];
                    String[] openDateArr = new String[numRes];
                    JSONObject[] linkArr = new JSONObject[numRes];
                    String[] linkURLArr = new String[numRes];
                    String[] linkDispArr = new String[numRes];
                    JSONObject[] imgArr = new JSONObject[numRes];
                    String[] imgURLArr = new String[numRes];


                    JSONObject[] objArr = new JSONObject[resArr.length()];

                    for (int i = 0; i < resArr.length(); i++) {
                        objArr[i] = resArr.getJSONObject(i);
                        titleArr[i] = objArr[i].getString("display_title");
                        ratingArr[i] = objArr[i].getString("mpaa_rating");
                        bylineArr[i] = objArr[i].getString("byline");
                        headlineArr[i] = objArr[i].getString("headline");
                        pubDateArr[i] = objArr[i].getString("publication_date");
                        if (!objArr[i].get("opening_date").equals(null)) {
                            openDateArr[i] = objArr[i].getString("opening_date");
                        } else {
                            openDateArr[i] = " ";
                        }
                        if (!objArr[i].get("summary_short").equals(null)) {
                            summArr[i] = objArr[i].getString("summary_short");
                        } else {
                            summArr[i] = " ";
                        }
                        linkArr[i] = objArr[i].getJSONObject("link");
                        linkURLArr[i] = linkArr[i].getString("url");
                        linkDispArr[i] = linkArr[i].getString("suggested_link_text");
                    }


                    String returnStr = "";

                    //                   returnStr += "\n\n\tYOU SEARCHED:\t" + enterSearchTitleHereTextField.getText() + "\n\n" + "\tNUMBER OF RESULTS:\t" + numRes + "\n\n\n";


                    for (int i = 0; i < numRes; i++) {
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n";
                        returnStr += "\tTitle:\t\t" + titleArr[i] + "\n";
                        returnStr += "**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************\n\n";
                        returnStr += "\tRating:\t\t" + ratingArr[i] + "\n\n";
                        returnStr += "\tReview by:\t\t" + bylineArr[i] + "\n\n";
                        returnStr += "\tReview Title:\t\t" + headlineArr[i] + "\n\n";
                        returnStr += "\tReview Published Date:\t" + pubDateArr[i] + "\n\n";
                        returnStr += "\tFilm Opening Date:\t" + openDateArr[i] + "\n\n";
                        returnStr += "\tURL of review:\t\t" + linkURLArr[i] + "\n";
                        returnStr += "\n";
                    }


                    returnArea.setText(returnStr);
                    scroll.setWheelScrollingEnabled(true);
                    returnArea.setCaretPosition(0);

                } else {
                    returnArea.setText("Error: you must enter a movie title to search.");
                }
            }
        });
    }

    @Override
    public void run() {
        JFrame myFrame = new JFrame("NY Times Movie Reviews");
        myFrame.setContentPane(new GUI().mainPanel);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(1800, 1000));
        search.setDefaultCapable(true);
        myFrame.getRootPane().setDefaultButton(search);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null); // Will center frame in screen
        myFrame.setVisible(true);
        myFrame.setMinimumSize(new Dimension(1800, 1000));
        //myFrame.setResizable(false);

        myFrame.getRootPane().setDefaultButton(search);

        returnArea.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        returnArea.setEditable(false);
    }

    public String readJSON(String line, BufferedReader in, String str) throws IOException {
        while ((line = in.readLine()) != null)
            str += line;

        return str;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(25, 10, 10, 10), 1, 1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        p3 = new JPanel();
        p3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(p3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(1900, 700), null, 0, false));
        scroll = new JScrollPane();
        p3.add(scroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(1900, 700), null, 0, false));
        returnArea = new JEditorPane();
        returnArea.setEditable(false);
        returnArea.setText("");
        scroll.setViewportView(returnArea);
        p1 = new JPanel();
        p1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(p1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(1900, 80), null, 1, false));
        TitleLabel = new JLabel();
        Font TitleLabelFont = this.$$$getFont$$$("Britannic Bold", Font.BOLD, 48, TitleLabel.getFont());
        if (TitleLabelFont != null) TitleLabel.setFont(TitleLabelFont);
        TitleLabel.setText("NEW YORK TIMES MOVIE REVIEWS");
        p1.add(TitleLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 40), new Dimension(-1, 40), 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        p1.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        titleLabel = new JLabel();
        titleLabel.setText("    Search Title    ");
        panel1.add(titleLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        enterSearchTitleHereTextField = new JTextField();
        enterSearchTitleHereTextField.setText("");
        panel1.add(enterSearchTitleHereTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        p4 = new JPanel();
        p4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(p4, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, 1, 1, null, new Dimension(1900, 50), new Dimension(-1, 50), 0, false));
        search = new JButton();
        search.setText("Search");
        p4.add(search, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
        save = new JButton();
        save.setText("Save");
        p4.add(save, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
        close = new JButton();
        close.setText("Close");
        p4.add(close, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
        next = new JButton();
        next.setText("Next Page");
        p4.add(next, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
        previous = new JButton();
        previous.setEnabled(false);
        previous.setText("Previous Page");
        p4.add(previous, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
