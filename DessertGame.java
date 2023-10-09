import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
  private int score;

  @Override
  public void start(final Stage stage) {
    // Step 1 & 2
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane, 640, 480);
    stage.setTitle("Dessert in the Desert JavaFX Game");

    // Step 3
    Label scoreLabel = new Label("Score: 0");
    borderPane.setTop(scoreLabel);
    BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(event -> {
      Platform.exit();
    });
    borderPane.setBottom(exitButton);
    BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);

    // Step 4
    Pane pane = new Pane();
    borderPane.setCenter(pane);
    BorderPane.setAlignment(pane, Pos.CENTER);

    // TODO: Step 5-8
    String[] labels = new String[] {"Dessert", "Desert", "Desert", "Desert", "Desert", "Desert",
        "Desert", "Desert", "Desert"};
    Button[] buttonList = new Button[labels.length];

    // two possible events, one for when "dessert" button is clicked and one for when a "desert"
    // button is clicked
    @SuppressWarnings("unchecked")
    EventHandler<ActionEvent>[] events = (EventHandler<ActionEvent>[]) new EventHandler[] {e -> {
      score++;
      borderPane.setTop(new Label("Score: " + score));
      exitButton.requestFocus();
      randomizeButtonPositions(new java.util.Random(), buttonList);
    }, e -> {
      score--;
      borderPane.setTop(new Label("Score: " + score));
      exitButton.requestFocus();
      randomizeButtonPositions(new java.util.Random(), buttonList);
    }};

    // going through the buttons and adding them to the array
    for (int i = 0; i < labels.length; i++) {
      Button button = new Button(labels[i]);
      if (labels[i].equals("Dessert")) {
        button.setOnAction(events[0]);
      } else {
        button.setOnAction(events[1]);
      }
      pane.getChildren().add(button);
      buttonList[i] = button;
    }


    exitButton.requestFocus();
    randomizeButtonPositions(new java.util.Random(), buttonList);
    stage.setScene(scene);
    stage.show();
  }

  private void randomizeButtonPositions(java.util.Random random, Button[] buttonArray) {
    for (int i = 0; i < buttonArray.length; i++) {
      Button button = buttonArray[i];
      button.setLayoutX(random.nextInt(601));
      button.setLayoutY(random.nextInt(401));
    }
  }

  public static void main(String[] args) {
    Application.launch();
  }
}
