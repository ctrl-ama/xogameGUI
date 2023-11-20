import java.awt.*;

public class TicTacToe extends Main {

    private char currentPlayer = 'X';
    private Button[][] buttons = new Button[3][3];

    }

    private static void launch(String[] args) {
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        initializeButtons(gridPane);

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeButtons(GridPane gridPane) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setStyle("-fx-font-size: 2em;");
                button.setOnAction(e -> handleButtonClick(button));
                buttons[i][j] = button;
                gridPane.add(button, i, j);
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (button.getText().equals("")) {
            button.setText(Character.toString(currentPlayer));
            if (checkForWin()) {
                System.out.println(currentPlayer + " wins!");
                resetGame();
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return checkDiagonals();
    }

    private boolean checkRow(int row) {
        return buttons[row][0].getText().equals(Character.toString(currentPlayer)) &&
                buttons[row][1].getText().equals(Character.toString(currentPlayer)) &&
                buttons[row][2].getText().equals(Character.toString(currentPlayer));
    }

    private boolean checkColumn(int col) {
        return buttons[0][col].getText().equals(Character.toString(currentPlayer)) &&
                buttons[1][col].getText().equals(Character.toString(currentPlayer)) &&
                buttons[2][col].getText().equals(Character.toString(currentPlayer));
    }

    private boolean checkDiagonals() {
        return (buttons[0][0].getText().equals(Character.toString(currentPlayer)) &&
                buttons[1][1].getText().equals(Character.toString(currentPlayer)) &&
                buttons[2][2].getText().equals(Character.toString(currentPlayer))) ||
                (buttons[0][2].getText().equals(Character.toString(currentPlayer)) &&
                        buttons[1][1].getText().equals(Character.toString(currentPlayer)) &&
                        buttons[2][0].getText().equals(Character.toString(currentPlayer)));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }
}
