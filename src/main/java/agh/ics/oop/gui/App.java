package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.System.out;

public class App extends Application {
    GrassField map;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        System.out.println(map.toString());
        System.out.println(map.objectAt(new Vector2d(2, 2)).toString());

        // Oznaczenia kolumn i wierszy,
        // z jakiegoś powodu getStart i getEnd nie zawsze działają poprawnie, ale nie mam pojęcia dlaczego :(
        Vector2d start = map.boundary.getStart();
        Vector2d end = map.boundary.getEnd();

        int sx = start.getX();
        int sy = start.getY();
        int dx = end.getX() - sx + 1;
        int dy = end.getY() - sy + 1;

        gridPane.add(new Label("y/x"), 0, 0, 1, 1);

        ColumnConstraints cc = new ColumnConstraints(20);
        RowConstraints rc = new RowConstraints(20);

        gridPane.getColumnConstraints().add(cc);
        gridPane.getRowConstraints().add(rc);

        Label label;
        for (int i = 1; i <= dx; i++) {
            label = new Label(((Integer) (sx + i - 1)).toString());
            gridPane.add(label, i, 0, 1, 1);
            gridPane.getColumnConstraints().add(cc);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 1; i <= dy; i++) {
            label = new Label(((Integer) (dy + sy - i)).toString());
            gridPane.add(label, 0, i, 1, 1);
            gridPane.getRowConstraints().add(rc);
            GridPane.setHalignment(label, HPos.CENTER);
        }


        for (int i = 1; i <= dx ; i++) {
            for (int j = 1; j <= dy; j++) {
                Vector2d position = new Vector2d(sx + i - 1, dy + sy - j);
                if (map.isOccupied(position)) {
                    label = new Label(map.objectAt(position).toString());
                    gridPane.add(label, i, j, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(gridPane, 20 * (dx + 1), 20 * (dy + 1));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        map = new GrassField(100);

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            out.println(exception);
        }

        super.init();
    }
}
