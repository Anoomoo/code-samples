import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Main extends Application {
    int lower;
    int higher;
    int guess;
    private VBox pane;
    private Text intro;
    private HBox guessingControls;
    private Button okButton;
    private Button lowerButton;
    private Button higherButton;
    private Button correctButton;
    private TextField lowerInput;
    private TextField higherInput;

    @Override
    public void start(Stage applicationStage) {

        // Initialize Nodes
        Text intro = new Text("Enter the range of numbers you will choose from.");
        this.lowerInput = new TextField("low number");
        this.higherInput = new TextField("high number");
        this.okButton = new Button("OK");
        this.lowerButton = new Button("Lower");
        this.correctButton = new Button("Correct");
        this.higherButton = new Button("Higher");

        // Create HBox child panes to insert into top level VBox
        HBox inputs = new HBox(this.lowerInput, this.higherInput, this.okButton);
        inputs.setSpacing(5);
        inputs.setPadding(new Insets(10, 10, 10, 10));
        this.guessingControls = new HBox(this.lowerButton, this.correctButton, this.higherButton);
        guessingControls.setSpacing(5);
        guessingControls.setPadding(new Insets(10, 0, 10, 10));
        guessingControls.setAlignment(Pos.CENTER);

        // Add Intro, Lower & Higher input fields, and OK button to initialized top level VBox
        this.pane = new VBox(intro, inputs);
        this.pane.setPadding(new Insets(20, 20, 20, 20));
        this.pane.setSpacing(15);
        this.pane.setAlignment(Pos.TOP_LEFT);

        // Display initial scene on the stage
        Scene scene = new Scene(this.pane, 400, 300);
        applicationStage.setTitle("The Guessing Game");
        applicationStage.setScene(scene);
        applicationStage.show();

        // Set button behavior by method referencing corresponding functions
        this.okButton.setOnAction(this::startGame);
        this.correctButton.setOnAction(this::endGame);
        this.lowerButton.setOnAction(this::lowerBound);
        this.higherButton.setOnAction(this::higherBound);
    }

    private void startGame(ActionEvent event) {
        /* Guessing game behavior that executes upon user interaction with 'OK' Button **/

        // Start game with initial guess
        this.lower = Integer.parseInt(this.lowerInput.getText());
        this.higher = Integer.parseInt(this.higherInput.getText());
        this.guess = (this.higher + this.lower) / 2;

        // Display additional text and buttons
        this.intro = new Text("My guess is " + this.guess);
        Text instructions = new Text("""
                Click 'Lower' if your number is lower,
                'Higher' if it is higher
                'Correct' if it is correct.""");
        this.pane.getChildren().addAll(this.intro, instructions);
        this.pane.getChildren().add(this.guessingControls);
    }

    private void endGame(ActionEvent event) {
        /* Terminate game upon user interaction with 'Correct' button. **/

        this.okButton.setDisable(true);
        this.lowerButton.setDisable(true);
        this.higherButton.setDisable(true);
        this.correctButton.setDisable(true);
        this.intro.setText("Your number was " + this.guess + "!!");
    }

    private void lowerBound(ActionEvent event) {
        /* Guess random int from new lower bound to original upper bound. **/
        this.higher = this.guess - 1;
        this.guess = (this.lower + this.higher) / 2;
        this.intro.setText("My guess is " + this.guess);
    }

    private void higherBound(ActionEvent event) {
        /* Guess random int from original lower bound to new upper bound. **/
        this.lower = this.guess + 1;
        this.guess = (this.lower + this.higher) / 2;
        this.intro.setText("My guess is " + this.guess);
    }

    public static void main(String[] args) {
        launch(args);
    }
}