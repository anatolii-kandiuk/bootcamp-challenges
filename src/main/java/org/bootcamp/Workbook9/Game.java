package org.bootcamp.Workbook9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.bootcamp.Workbook10.Regulation.*;

public class Game {

    private String arena;

    private LocalDate date;

    public Game(String arena) {
        this.arena = arena;
        this.date = LocalDate.now();
    }

    public void begin(Team home, Team away) {
        String formattedDate = this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(
                "\n - This matchup takes place at the " + this.arena + " arena on " + formattedDate + "."
        );
    }

    public String details() {
        return (
                "\nCourt length (feet): " + COURT_LENGTH +
                        "\nRim height (feet): " + RIM_HEIGHT +
                        "\nDistance from three-point arc: " + THREE_POINT_DISTANCE +
                        "\nPoints awarded beyond the three-point arc: " + BEYOND_THREE_POINT_ARC +
                        "\nPoints awarded inside the three-point arc: " + INSIDE_THREE_POINT_ARC +
                        "\nPoints awarded from a free throw: " + FREE_THROW +
                        "\nLength of each quarter (minutes): " + QUARTER_LENGTH +
                        "\nSeconds to attempt shot after gaining possession: " + POSSESSION_TIME
        );
    }
}
