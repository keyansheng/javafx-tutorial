import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {
    private MainWindow mainWindow = new MainWindow();
    private Scene scene;

    @Override
    public void start(Stage stage) {
        mainWindow.getScrollPane().setContent(mainWindow.getDialogContainer());

        mainWindow.getSendButton().setOnMouseClicked(event -> {
            mainWindow.getHandleUserInput();
        });
        mainWindow.getUserInput().setOnAction(event -> {
            mainWindow.getHandleUserInput();
        });

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(mainWindow.getScrollPane(), mainWindow.getUserInput(), mainWindow.getSendButton());

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        mainWindow.getScrollPane().setPrefSize(385, 535);
        mainWindow.getScrollPane().setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainWindow.getScrollPane().setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        mainWindow.getScrollPane().setVvalue(1.0);
        mainWindow.getScrollPane().setFitToWidth(true);

        mainWindow.getDialogContainer().setPrefHeight(Region.USE_COMPUTED_SIZE);

        mainWindow.getUserInput().setPrefWidth(325.0);

        mainWindow.getSendButton().setPrefWidth(55.0);

        AnchorPane.setTopAnchor(mainWindow.getScrollPane(), 1.0);

        AnchorPane.setBottomAnchor(mainWindow.getSendButton(), 1.0);
        AnchorPane.setRightAnchor(mainWindow.getSendButton(), 1.0);

        AnchorPane.setLeftAnchor(mainWindow.getUserInput(), 1.0);
        AnchorPane.setBottomAnchor(mainWindow.getUserInput(), 1.0);

        mainWindow.getDialogContainer().heightProperty().addListener(observable -> mainWindow.getScrollPane().setVvalue(1.0));
    }
}
