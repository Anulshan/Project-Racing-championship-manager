package main;


import racingleague.comparator.CustomComparator;
import racingleague.comparator.CustomComparator2;
import racingleague.model.Formula1Driver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends Formula1Driver {
    static LinkedList<Formula1Driver> formula1DriverList = new <Formula1Driver>LinkedList();
    static LinkedList<Race> raceList = new <Race>LinkedList();
    static Date date = new Date();
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GUI(String driverName, String driverCode, String driverLocation, String driverTeam,
               String matchPlayedDate, Integer noOfParticipatedRaces, Integer seasonPoints, Integer position) {
        super(driverName, driverCode, driverLocation, driverTeam,
                matchPlayedDate, noOfParticipatedRaces, seasonPoints, position);
    }

    static class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Closing window");
            System.exit(0);
        }

    }


    @SuppressWarnings("unchecked")
    public static void main(String[] argv) {

        try {
            Scanner sc2 = new Scanner(new FileInputStream("driverDetails.txt"));
            while (sc2.hasNextLine()) {
                Formula1Driver formula1Driver = new Formula1Driver();
                String line = sc2.nextLine();

                String[] result = line.split("[=,}]");

                formula1Driver.setDriverName(result[1]);
                formula1Driver.setDriverCode(result[3]);
                formula1Driver.setDriverLocation(result[5]);
                formula1Driver.setDriverTeam(result[7]);
                formula1Driver.setRaceDate(result[9]);
                formula1Driver.setNoOfParticipatedRaces(Integer.parseInt(result[11]));
                formula1Driver.setSeasonPoints(Integer.parseInt(result[13]));
                formula1Driver.setPosition(Integer.parseInt(result[15]));

                formula1DriverList.add(formula1Driver);

            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
        Collections.sort(formula1DriverList, new CustomComparator());

        start();

    }


    public static void start() {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Name");
        tableModel.addColumn("Code");
        tableModel.addColumn("Location");
        tableModel.addColumn("Team");
        tableModel.addColumn("Date");
        tableModel.addColumn("No of Participated Races");
        tableModel.addColumn("Season points");
        tableModel.addColumn("Position");

        for (Formula1Driver formula1Driver : formula1DriverList) {
            tableModel.addRow(new Object[]{formula1Driver.getDriverName(), formula1Driver.getDriverCode(),
                    formula1Driver.getDriverLocation(), formula1Driver.getDriverTeam(), formula1Driver.getRaceDate(),
                    formula1Driver.getNoOfParticipatedRaces(), formula1Driver.getSeasonPoints(), formula1Driver.getPosition()});
        }


        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        jFrame.setContentPane(jPanel);
        jFrame.addWindowListener(new MyWindowListener());


        JButton positionAscending = new JButton(new AbstractAction("Position ascending") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(formula1DriverList, new CustomComparator());
                start();

            }
        });
        JButton pointAscending = new JButton(new AbstractAction("season point ascending") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(formula1DriverList, new CustomComparator2());
                start();
            }
        });

        JButton addRace = new JButton(new AbstractAction("add race") {
            @Override
            public void actionPerformed(ActionEvent e) {
                List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                Collections.shuffle(list);
                Collections.shuffle(formula1DriverList);
                for (int x = 0; x < list.size(); x++) {
                    int place = Integer.parseInt(list.get(x).toString());
                    addPoints(place, x);
                    for (Formula1Driver formula1Driver : formula1DriverList) {
                        if (formula1DriverList.indexOf(formula1Driver) == x) {
                            Race races = new Race();
                            races.setDate(date);
                            races.setCode(x);
                            races.setLocation(place);
                            raceList.add(races);
                        }
                    }
                }

                DefaultTableModel tableModel3 = new DefaultTableModel();
                JTable table2 = new JTable(tableModel3);
                tableModel3.addColumn("dates");
                tableModel3.addColumn("driver code");
                tableModel3.addColumn("location");
                jFrame.getContentPane().add(new JScrollPane(table2));
                raceList.sort(Comparator.comparing(Race::getDate));

                for (Race races : raceList) {

                    tableModel3.addRow(new Object[]{simpleDateFormat.format(races.getDate()), races.getCode(), races.getLocation()});

                }
                Collections.sort(formula1DriverList, new CustomComparator());
                start();


            }

        });

        JButton searchDriver = new JButton(new AbstractAction("search driver") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jFrame.getContentPane().add(positionAscending);
        jFrame.getContentPane().add(pointAscending);
        jFrame.getContentPane().add(addRace);
        jFrame.getContentPane().add(searchDriver);
        jFrame.getContentPane().add(new JScrollPane(table));
        jFrame.setSize(1000, 1000);
        jFrame.setVisible(true);

    }
    public static void addPoints(int position, int index) {
        flag:
        for (Formula1Driver f1Driver : formula1DriverList) {
            if (formula1DriverList.indexOf(f1Driver) == index) {
                if (position == 1) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(25);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);


                    break flag;

                }
                if (position == 2) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(18);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 3) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(15);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 4) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(12);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 5) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(10);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 6) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(8);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 7) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(6);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 8) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(4);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 9) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(2);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }

                if (position == 10) {
                    f1Driver.setPosition(position);
                    f1Driver.setSeasonPoints(1);
                    f1Driver.setNoOfParticipatedRaces(f1Driver.getNoOfParticipatedRaces() + 1);
                    break flag;
                }
            }
        }
    }
}